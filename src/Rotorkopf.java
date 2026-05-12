public class Rotorkopf {
    private int anzahlRotorblaetter;
    private double winkel;
    private double kollektiv;
    private double zyklisch_nick;
    private double zyklisch_roll;
    private double[] zyklisch = {0, 1};
    private Rotorblatt[] rotorblatt;

    public Rotorkopf(int anzahlRotorblaetter, double winkel, double kollektiv, double zyklisch_nick, double zyklisch_roll) {
        this.anzahlRotorblaetter = anzahlRotorblaetter;
        this.winkel = Math.clamp(winkel, 0.0, 360.0);
        this.kollektiv = Math.clamp(kollektiv, -100.0, 100.0);
        this.zyklisch_nick = Math.clamp(zyklisch_nick, -100.0, 100.0);
        this.zyklisch_roll = Math.clamp(zyklisch_roll, -100.0, 100.0);

        this.rotorblatt = new Rotorblatt[anzahlRotorblaetter];

        aktualisiereRotorblaetter();
    }

    public void aktualisiereRotorblaetter() {
        double neuerWinkel = 2*Math.PI*winkel/360;

        double winkelSchritt = 2*Math.PI/anzahlRotorblaetter;

        for(int i = 0; i < rotorblatt.length; i++) {
            double versatz = neuerWinkel + (i * winkelSchritt);

            double anstellwinkel = kollektiv
                    + (zyklisch_nick * Math.cos(versatz))
                    + (zyklisch_roll * Math.sin(versatz));

            rotorblatt[i] = new Rotorblatt(anstellwinkel);
        }
    }

    public double berechneKollektiv() {
        return kollektiv * 0.13;
    }

    public void berechneZyklisch() {
        zyklisch[0] = zyklisch_nick * 0.10;
        zyklisch[1] = zyklisch_roll * 0.10;
    }

    public double getWinkel() {
        return winkel;
    }

    public void setWinkel(double winkel) {
        this.winkel = winkel;
    }

    public double getKollektiv() {
        return kollektiv;
    }

    public void setKollektiv(double kollektiv) {
        this.kollektiv = kollektiv;
    }

    public double getZyklisch_nick() {
        return zyklisch_nick;
    }

    public void setZyklisch_nick(double zyklisch_nick) {
        this.zyklisch_nick = zyklisch_nick;
    }

    public double getZyklisch_roll() {
        return zyklisch_roll;
    }

    public void setZyklisch_roll(double zyklisch_roll) {
        this.zyklisch_roll = zyklisch_roll;
    }

    public int getAnzahlRotorblaetter() {
        return anzahlRotorblaetter;
    }

    public void zeigeRotorblaetter() {
        String ausgabe = "";

        for (int i = 0; i < rotorblatt.length; i++) {
            ausgabe = "Anstellwinkel Rotorblatt " + i +": Anstellwinkel=" + rotorblatt[i].getAnstellwinkel();
            System.out.println(ausgabe);
        }
    }

    @Override
    public String toString() {
        return "Rotorkopf:\n" +
                "Anzahl Rotorblaetter = " + anzahlRotorblaetter + "\n" +
                "Winkel = " + winkel + "\n" +
                "Kollektiv = " + kollektiv + "\n" +
                "Zyklisch Nick = " + zyklisch_nick + "\n" +
                "Zyklisch Roll = " + zyklisch_roll;
    }
}