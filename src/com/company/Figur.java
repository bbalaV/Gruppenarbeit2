package com.company;

public abstract class Figur {
    public abstract double umfang();

    public abstract double flaeche();
    public abstract String toString();
    public double gewicht() { //Gewicht=Fläche, wenn nichts ausgesägt
        return flaeche();
    }

    public double kante() {
        return umfang(); //Kantenlänge=Umfang, wenn nichts ausgesägt
    }

    public int vergleichGewicht(Figur andere) {
        return 1;
    }
}

class GlDreieck extends Figur { //Gleichseitiges Dreieck
    private double seite;

    public GlDreieck(double seite) {
        this.seite = seite;
    }

    @Override
    public double umfang() {
        return 3 * seite;
    }

    @Override
    public double flaeche() { // gemäss Formel
        return seite * seite * Math.sqrt(3) / 4.0;
    }
    @Override
    public String toString() {
        return "Gl. Dreieck: Seitenlänge=" + seite + " Umfang=" +
                umfang() + " Fläche=" + flaeche();
    }
}

class Quadrat extends Figur {
    private double seite;

    public Quadrat(double seite) {
        this.seite = seite;
    }

    @Override
    public double umfang() {
        return 4 * seite;
    }

    @Override
    public double flaeche() {
        return seite * seite;
    }
    @Override
    public String toString() {
        return "Quadrat: Seitenlänge=" + seite + " Umfang=" +
                umfang() + " Fläche=" + flaeche();
    }
}

class Kreis extends Figur {
    private double radius;

    public Kreis(double radius) {
        this.radius = radius;
    }

    @Override
    public double umfang() {
        return 2 * radius * Math.PI;
    }

    @Override
    public double flaeche() {
        return radius * radius * Math.PI;
    }
    @Override
    public String toString() {
        return "Quadrat: Seitenlänge=" + radius + " Umfang=" +
                umfang() + " Fläche=" + flaeche();
    }

}

class FertigeFigur extends Figur {
    private Figur Hauptfigur;
    private Quadrat Quadrat;
    private Kreis Kreis;
    private GlDreieck GlDreieck;

    public FertigeFigur (Figur Hauptfigur, Quadrat Quadrat, Kreis Kreis,  GlDreieck GlDreieck){
        this.Hauptfigur = Hauptfigur;
        this.Quadrat = Quadrat;
        this.Kreis = Kreis;
        this.GlDreieck = GlDreieck;
    }
    @Override
    public double umfang() {
        return 0;
    }

    @Override
    public double flaeche() {
        return 0;
    }
    @Override
    public String toString(){
        return "Hallo";
    }
}