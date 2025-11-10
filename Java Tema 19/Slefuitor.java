public class Slefuitor extends SculaElectrica {

    private double suprafata;
    private int vibratii;
    private boolean aspiratiePraf;

    public Slefuitor() {
        super();
        suprafata = 0;
        vibratii = 0;
        aspiratiePraf = false;
    }

    public Slefuitor(String brand, String model, double putere, double greutate, double pret,
                     double suprafata, int vibratii, boolean aspiratiePraf) {
        super(brand, model, putere, greutate, pret);
        this.suprafata = suprafata;
        this.vibratii = vibratii;
        this.aspiratiePraf = aspiratiePraf;
    }

    public Slefuitor(Slefuitor alt) {
        super(alt);
        this.suprafata = alt.suprafata;
        this.vibratii = alt.vibratii;
        this.aspiratiePraf = alt.aspiratiePraf;
    }

    public double getSuprafata() { return suprafata; }
    public void setSuprafata(double suprafata) { this.suprafata = suprafata; }

    public int getVibratii() { return vibratii; }
    public void setVibratii(int vibratii) { this.vibratii = vibratii; }

    public boolean getAspiratiePraf() { return aspiratiePraf; }
    public void setAspiratiePraf(boolean aspiratiePraf) { this.aspiratiePraf = aspiratiePraf; }

    public String toString() {
        return "Slefuitor: " + super.toString() +
                " | suprafata: " + suprafata + " cm2 | vibratii: " + vibratii + " /min | aspiratie praf: " +
                (aspiratiePraf ? "da" : "nu");
    }
}
