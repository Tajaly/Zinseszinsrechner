package de.kapitalrechner;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static java.lang.Math.round;

@Service
public class Rechner {

    //ohne zinsesZins
    public double berechneZinsertrag(KapitalForm kapitalForm) {
        return kapitalForm.getKapital() * (kapitalForm.getZinssatz()/100) * kapitalForm.getLaufzeit();
    }

    //ohne zinseszins
    //Kn = K0 * ((p / 100) * n + 1)
    public double berechneEndkapital(KapitalForm kapitalForm) {
        double endkapital = kapitalForm.getKapital() *
            (((kapitalForm.getZinssatz()/100) * kapitalForm.getLaufzeit()) + 1);
        return round(endkapital);
    }

    //mit zinseszins

    public double berechneEndkapitalMitZinseszins(KapitalForm kapitalForm) {
        double endkapital = kapitalForm.getKapital() *
            Math.pow(((kapitalForm.getZinssatz()/100) + 1) , kapitalForm.getLaufzeit());
        endkapital = round(endkapital);
        return endkapital;
    }
}
