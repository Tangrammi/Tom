public class Rotorblatt {
    private double anstellwinkel;

    public Rotorblatt(double anstellwinkel) {
        this.anstellwinkel = anstellwinkel;
    }

    public double getAnstellwinkel() {
        return anstellwinkel;
    }

    public void setAnstellwinkel(double anstellwinkel) {
        this.anstellwinkel = anstellwinkel;
    }

    @Override
    public String toString() {
        return "Anstellwinkel=" + anstellwinkel;
    }
}
