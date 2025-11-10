public class SculaElectrica {

    private String brand;
    private String model;
    private double putere;
    private double greutate;
    private double pret;

    public SculaElectrica() {
        brand = "";
        model = "";
        putere = 0;
        greutate = 0;
        pret = 0;
    }

    public SculaElectrica(String brand, String model, double putere, double greutate, double pret) {
        this.brand = brand;
        this.model = model;
        this.putere = putere;
        this.greutate = greutate;
        this.pret = pret;
    }

    public SculaElectrica(SculaElectrica alta) {
        this.brand = alta.brand;
        this.model = alta.model;
        this.putere = alta.putere;
        this.greutate = alta.greutate;
        this.pret = alta.pret;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public double getPutere() { return putere; }
    public void setPutere(double putere) { this.putere = putere; }

    public double getGreutate() { return greutate; }
    public void setGreutate(double greutate) { this.greutate = greutate; }

    public double getPret() { return pret; }
    public void setPret(double pret) { this.pret = pret; }

    public String toString() {
        return brand + " " + model + " | putere: " + putere + " kW | greutate: " +
                greutate + " kg | pret: " + pret + " lei";
    }
}

