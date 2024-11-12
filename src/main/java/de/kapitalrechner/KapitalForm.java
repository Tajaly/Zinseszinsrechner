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
