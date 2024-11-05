package de.kapitalrechner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class kapitalFormTest {

    @Test
    @DisplayName("Lauzeit 30 Jahre, Startkapital 10000 Euro, bei einem Zinssatz von 6: " +
            " Zinsertrag sollte 18000 betragen")
    public void berechneZinsTest () {
        KapitalForm kapitalForm =  new KapitalForm(10000,30,6);
        double zinsertrag = kapitalForm.berechneZinsertrag();
        double erwarteterZinsertrag = 18000;
        assertEquals(erwarteterZinsertrag, zinsertrag);

    }

    @Test
    @DisplayName("Lauzeit 30 Jahre, Startkapital 10000 Euro, bei einem Zinssatz von 6: " +
        " Endkapital sollte 28000 betragen")
    public void berechneEndkapitalTest() {
        KapitalForm kapitalForm =  new KapitalForm(10000,30,6);
        double endkapital = kapitalForm.berechneEndkapital();
        double erwartetesEndkapital = 28000;
        assertEquals(erwartetesEndkapital, endkapital);
    }

    @Test
    @DisplayName("Lauzeit 30 Jahre, Startkapital 10000 Euro, bei einem Zinssatz von 6: " +
        " Endkapital sollte 28000 betragen")
    public void berechneEndkapitalMitZinseszinsTest() {
        KapitalForm kapitalForm =  new KapitalForm(10000,30,6);
        double endkapital = kapitalForm.berechneEndkapitalMitZinseszins();
        double erwartetesEndkapital =57435;
        assertEquals(erwartetesEndkapital, endkapital);
    }
}
