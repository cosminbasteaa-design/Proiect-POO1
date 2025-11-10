public class Polizor extends SculaElectrica {

    private double diametruDisc;
    private int turatie;
    private boolean protectie;

    public Polizor() {
        super();
        diametruDisc = 0;
        turatie = 0;
        protectie = false;
    }

    public Polizor(String brand, String model, double putere, double greutate, double pret,
                double diametruDisc, int turatie, boolean protectie) {
        super(brand, model, putere, greutate, pret);
        this.diametruDisc = diametruDisc;
        this.turatie = turatie;
        this.protectie = protectie;
    }

    public Polizor(Polizor alt) {
        super(alt);
        this.diametruDisc = alt.diametruDisc;
        this.turatie = alt.turatie;
        this.protectie = alt.protectie;
    }

    public double getDiametruDisc() { return diametruDisc; }
    public void setDiametruDisc(double diametruDisc) { this.diametruDisc = diametruDisc; }

    public int getTuratie() { return turatie; }
    public void setTuratie(int turatie) { this.turatie = turatie; }

    public boolean getProtectie() { return protectie; }
    public void setProtectie(boolean protectie) { this.protectie = protectie; }

    public String toString() {
        return "Polizor: " + super.toString() +
                " | diametru: " + diametruDisc + " mm | turatie: " + turatie + " rpm | protectie: " +
                (protectie ? "da" : "nu");
    }
}
