import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ProiectGui extends JFrame {

    private ArrayList<Object> polizoare = new ArrayList<>();
    private ArrayList<Object> slefuitoare = new ArrayList<>();

    private JComboBox<String> getterBox1 = new JComboBox<>();
    private JComboBox<String> opBox1 = new JComboBox<>(new String[]{">", "<", ">=", "<=", "=", "contains"});
    private JTextField valueField1 = new JTextField(10);

    private JComboBox<String> getterBox2 = new JComboBox<>();
    private JComboBox<String> opBox2 = new JComboBox<>(new String[]{">", "<", ">=", "<=", "=", "contains"});
    private JTextField valueField2 = new JTextField(10);

    private JTextArea resultArea = new JTextArea(20, 60);
    private JButton searchBtn = new JButton("Cauta");
    private JButton saveBtn = new JButton("Salveaza");
    private JButton loadBtn = new JButton("Încarca");

    private final File filePolizoare = new File("polizoare.dat");
    private final File fileSlefuitoare = new File("slefuitoare.dat");

    public ProiectGUI() {
        super("Proiect Scule Electrice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JPanel condPanel = new JPanel(new GridLayout(3, 1));

        JPanel c1 = new JPanel();
        c1.add(new JLabel("Proprietate:"));
        c1.add(getterBox1);
        c1.add(opBox1);
        c1.add(new JLabel("Valoare:"));
        c1.add(valueField1);

        JPanel c2 = new JPanel();
        c2.add(new JLabel("Proprietate:"));
        c2.add(getterBox2);
        c2.add(opBox2);
        c2.add(new JLabel("Valoare:"));
        c2.add(valueField2);

        JPanel buttons = new JPanel();
        buttons.add(searchBtn);
        buttons.add(loadBtn);
        buttons.add(saveBtn);

        condPanel.add(c1);
        condPanel.add(c2);
        condPanel.add(buttons);

        add(condPanel, BorderLayout.NORTH);

        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        searchBtn.addActionListener(e -> onSearch());
        saveBtn.addActionListener(e -> {
            try { saveVectors(); } catch (Exception ignored) {}
        });
        loadBtn.addActionListener(e -> {
            try { loadVectors(); populateGetterBoxes(); } catch (Exception ignored) {}
        });

        loadVectorsIfExists();
        populateGetterBoxes();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadVectorsIfExists() {
        try {
            if (filePolizoare.exists() || fileSlefuitoare.exists()) loadVectors();
        } catch (Exception ignored) {}
    }

    private void saveVectors() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePolizoare))) {
            oos.writeObject(polizoare);
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileSlefuitoare))) {
            oos.writeObject(slefuitoare);
        }
    }

    private void loadVectors() throws IOException, ClassNotFoundException {
        if (filePolizoare.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePolizoare))) {
                polizoare = (ArrayList<Object>) ois.readObject();
            }
        }
        if (fileSlefuitoare.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileSlefuitoare))) {
                slefuitoare = (ArrayList<Object>) ois.readObject();
            }
        }
    }

    private void populateGetterBoxes() {
        Set<String> getters = new TreeSet<>();
        List<Object> sampleList = !polizoare.isEmpty() ? polizoare : (!slefuitoare.isEmpty() ? slefuitoare : Collections.emptyList());

        if (!sampleList.isEmpty()) {
            Object sample = sampleList.get(0);
            for (Method m : sample.getClass().getMethods()) {
                if (isGetter(m)) getters.add(m.getName());
            }
        }

        getterBox1.removeAllItems();
        getterBox2.removeAllItems();

        for (String g : getters) {
            getterBox1.addItem(g);
            getterBox2.addItem(g);
        }
    }

    private boolean isGetter(Method m) {
        return Modifier.isPublic(m.getModifiers())
                && m.getParameterCount() == 0
                && m.getName().startsWith("get")
                && !m.getReturnType().equals(void.class);
    }

    private void onSearch() {
        String g1 = (String) getterBox1.getSelectedItem();
        String op1 = (String) opBox1.getSelectedItem();
        String v1 = valueField1.getText().trim();

        String g2 = (String) getterBox2.getSelectedItem();
        String op2 = (String) opBox2.getSelectedItem();
        String v2 = valueField2.getText().trim();

        List<Object> all = new ArrayList<>();
        all.addAll(polizoare);
        all.addAll(slefuitoare);

        List<Object> results = all.stream()
                .filter(o -> matchesCondition(o, g1, op1, v1))
                .filter(o -> matchesCondition(o, g2, op2, v2))
                .collect(Collectors.toList());

        resultArea.setText("");
        if (results.isEmpty()) resultArea.append("Nimic gasit.\n");
        else results.forEach(r -> resultArea.append(r + "\n"));
    }

    private boolean matchesCondition(Object obj, String getterName, String op, String valueStr) {
        try {
            Method m = obj.getClass().getMethod(getterName);
            Object val = m.invoke(obj);

            if (val instanceof Number) {
                double x = ((Number) val).doubleValue();
                double y = Double.parseDouble(valueStr);

                return switch (op) {
                    case ">" -> x > y;
                    case "<" -> x < y;
                    case ">=" -> x >= y;
                    case "<=" -> x <= y;
                    case "=" -> x == y;
                    default -> false;
                };
            } else {
                String s = val.toString();
                return switch (op) {
                    case "=" -> s.equalsIgnoreCase(valueStr);
                    case "contains" -> s.toLowerCase().contains(valueStr.toLowerCase());
                    default -> false;
                };
            }
        } catch (Exception e) {
            return false;
        }
    }

    public void setPolizoare(List<Object> list) {
        polizoare = new ArrayList<>(list);
    }

    public void setSlefuitoare(List<Object> list) {
        slefuitoare = new ArrayList<>(list);
    }
}
