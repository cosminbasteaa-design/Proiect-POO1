public class Main {
    public static void main(String[] args) {

        // obiecte 2 clase
        Polizor p = new Polizor("Bosch", "GWS 7-115", 0.72, 1.9, 250, 115, 11000, true);
        Slefuitor s = new Slefuitor("Makita", "BO3710", 0.3, 1.2, 320, 90, 12000, true);

        
        System.out.println(p);
        System.out.println(s);
    }
}
