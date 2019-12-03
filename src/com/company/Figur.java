package com.company;

public abstract class Figur {
    public abstract double umfang();
    public abstract double flaeche();
    public abstract String toString();

    public abstract double getSeite();
    public abstract void   setSeite(double seite);

    public double gewicht() { //Gewicht=Fläche, wenn nichts ausgesägt
        return flaeche();
    }
    public double kante() {
        return umfang(); //Kantenlänge=Umfang, wenn nichts ausgesägt
    }
    public int vergleichGewicht( Figur andere ) {
        if(this.gewicht()>andere.gewicht()){
            return 1;
        }
        else if (this.gewicht() == andere.gewicht()){
            return 0;
        }
        else{
            return -1;
        }

    }


}
class GlDreieck extends Figur { //Gleichseitiges Dreieck
    private double seite;
    public GlDreieck( double seite ) {
        this.seite=seite;
    }
    public double umfang() {
        return 3 * seite;
    }
    public double flaeche() { // gemäss Formel
        return seite * seite * Math.sqrt(3) / 4.0;
    }
    public String toString() {
        return "Gl. Dreieck: Seitenlänge=" + seite + " Umfang=" +
                umfang() + " Fläche=" + flaeche();
    }

    public double getSeite(){
        return this.seite;
    }
    public void setSeite(double NewSeite){
        this.seite = NewSeite;
    }
}
class Quadrat extends Figur{
    private double seite;

    @Override
    public double umfang() {
        return 4*seite;
    }

    @Override
    public double flaeche() {
        return seite*seite;
    }

    @Override
    public String toString() {
        return "Quadrat: Seitenlänge=" + seite + " Umfang=" +
                umfang() + " Fläche=" + flaeche();
    }

    public double getSeite(){
        return this.seite;
    }
    public void setSeite(double NewSeite){
        this.seite = NewSeite;
    }
}
class Kreis extends Figur{
    private double radius;

    @Override
    public double umfang() {
        return 2*radius*Math.PI;
    }

    @Override
    public double flaeche() {
        return radius*radius*Math.PI;
    }

    @Override
    public String toString() {
        return "Kreis: Radius=" + radius + " Umfang=" +
                umfang() + " Fläche=" + flaeche();
    }

    public double getSeite(){
        return this.radius;
    }
    public void setSeite(double NewRadius){
        this.radius = NewRadius;
    }
}

class FertigeFigur extends  Figur{
    private Figur grosseFigur;
    private Quadrat KleinesQuadrat;
    private GlDreieck KleinesGlDreieck;
    private Kreis KleinerKreis;
    public FertigeFigur(Figur grosseFigur, Quadrat KleinesQuadrat, GlDreieck KleinesGlDreieck, Kreis KleinerKreis){
        this.grosseFigur = grosseFigur;
        this.KleinesQuadrat = KleinesQuadrat;
        this.KleinesGlDreieck = KleinesGlDreieck;
        this.KleinerKreis = KleinerKreis;
    }
    @Override
    public double umfang() {
       return grosseFigur.umfang();
    }

    @Override
    public double flaeche() {
        return grosseFigur.flaeche();
    }

    @Override
    public double gewicht(){
        return grosseFigur.flaeche() - KleinerKreis.flaeche() - KleinesGlDreieck.flaeche() - KleinesQuadrat.flaeche();
    }
    @Override
    public double kante(){
        return grosseFigur.umfang() + KleinesQuadrat.umfang() + KleinesGlDreieck.umfang() + KleinerKreis.flaeche();
    }
    public double getSeite(){
        return grosseFigur.getSeite();
    }

    @Override
    public void setSeite(double Seite) {
         grosseFigur.setSeite(Seite);
    }

    @Override
    public String toString() {
        return grosseFigur.toString();
    }
}