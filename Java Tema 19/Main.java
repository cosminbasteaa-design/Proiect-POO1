import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

       //3. vectorii

        ArrayList<Object> polizoare = new ArrayList<>();
        ArrayList<Object> slefuitoare = new ArrayList<>();

        //polizoare 10
        polizoare.add(new Polizor("Bosch", "GWS 7-115", 0.72, 1.9, 250, 115, 11000, true));
        polizoare.add(new Polizor("Makita", "GA4530R", 0.72, 2.0, 280, 115, 11000, true));
        polizoare.add(new Polizor("DeWalt", "DWE4057", 0.8, 2.1, 350, 125, 11800, true));
        polizoare.add(new Polizor("Einhell", "TC-AG 115", 0.5, 1.7, 140, 115, 12000, false));
        polizoare.add(new Polizor("Stanley", "FMEG210", 0.85, 2.3, 300, 125, 11000, true));
        polizoare.add(new Polizor("Black&Decker", "BEG110", 0.75, 2.0, 230, 115, 12000, false));
        polizoare.add(new Polizor("Makita", "GA5030", 0.7, 1.8, 290, 125, 11000, true));
        polizoare.add(new Polizor("Bosch", "GWS 9-125", 0.9, 2.2, 420, 125, 12000, true));
        polizoare.add(new Polizor("Einhell", "Axxio 18V", 0.6, 1.6, 360, 125, 8500, true));
        polizoare.add(new Polizor("DeWalt", "DCG405", 0.7, 1.9, 500, 125, 9000, true));


        //slefuitoare 10
        slefuitoare.add(new Slefuitor("Makita", "BO3710", 0.3, 1.2, 320, 90, 12000, true));
        slefuitoare.add(new Slefuitor("Bosch", "GSS 140", 0.25, 1.1, 290, 92, 12000, true));
        slefuitoare.add(new Slefuitor("Einhell", "TC-OS 1520", 0.15, 1.0, 150, 100, 15000, false));
        slefuitoare.add(new Slefuitor("DeWalt", "DWE6411", 0.23, 1.3, 330, 90, 14000, true));
        slefuitoare.add(new Slefuitor("Black&Decker", "KA450", 0.14, 1.0, 160, 100, 16000, false));
        slefuitoare.add(new Slefuitor("Stanley", "SS24", 0.2, 1.25, 270, 92, 12000, true));
        slefuitoare.add(new Slefuitor("Makita", "BO4565", 0.2, 1.1, 310, 100, 14000, true));
        slefuitoare.add(new Slefuitor("Bosch", "GSS 23 AE", 0.35, 1.4, 360, 92, 12000, true));
        slefuitoare.add(new Slefuitor("Einhell", "TE-OS 1320", 0.13, 0.9, 140, 100, 15000, false));
        slefuitoare.add(new Slefuitor("DeWalt", "DWE6423", 0.28, 1.2, 350, 100, 12000, true));


    //4.metode de filtrare

        System.out.println("Polizoare cu disc >=125mm si turatie >=11000:");
        filtrarePolizoare(polizoare, 125, 11000);

        System.out.println("\nSlefuitoare cu suprafata >=100 si vibratii >=14000:");
        filtrareSlefuitoare(slefuitoare, 100, 14000);
    }




    public static void filtrarePolizoare(ArrayList<Object> lista, double diametruMin, int turatieMin) {
        for (Object obj : lista) {
            if (obj instanceof Polizor) {
                Polizor p = (Polizor) obj;
                if (p.getDiametruDisc() >= diametruMin && p.getTuratie() >= turatieMin) {
                    System.out.println(p);
                }
            }
        }
    }

    public static void filtrareSlefuitoare(ArrayList<Object> lista, double suprafataMin, int vibratiiMin) {
        for (Object obj : lista) {
            if (obj instanceof Slefuitor) {
                Slefuitor s = (Slefuitor) obj;
                if (s.getSuprafata() >= suprafataMin && s.getVibratii() >= vibratiiMin) {
                    System.out.println(s);
                }
            }
        }
    }
}
