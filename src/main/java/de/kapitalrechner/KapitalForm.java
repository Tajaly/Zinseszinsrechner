package de.kapitalrechner;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import static java.lang.Math.round;

public class KapitalForm {

    @PositiveOrZero(message = "das Feld muss eine positive Zahl enthalten!")
    private double kapital;

    @PositiveOrZero(message = "das Feld muss eine positive Zahl enthalten!")
    private double laufzeit;

    @PositiveOrZero(message = "das Feld muss eine positive Zahl enthalten!")
    private double zinssatz;




    public KapitalForm(double kapital, double laufzeit, double zinssatz) {
        this.kapital = kapital;
        this.laufzeit = laufzeit;
        this.zinssatz = zinssatz;
    }

    //ohne zinsesZins
    public double berechneZinsertrag() {
        return this.kapital * (this.zinssatz/100) * this.laufzeit;
    }

    //ohne zinseszins
    //Kn = K0 * ((p / 100) * n + 1)
    public double berechneEndkapital() {
        double endkapital = this.kapital * (((this.zinssatz/100) * this.laufzeit) + 1);
        return round(endkapital);
    }

    //mit zinseszins

    public double berechneEndkapitalMitZinseszins() {
        double endkapital = this.kapital * Math.pow(((this.zinssatz/100) + 1) , this.laufzeit);
        endkapital = round(endkapital);
        return endkapital;
    }


    public double getKapital() {
        return kapital;
    }

    public double getLaufzeit() {
        return laufzeit;
    }

    public double getZinssatz() {
        return zinssatz;
    }
}
