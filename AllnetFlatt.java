//Autorin: Paiata Ustinovich,
//Version: IntelliJ IDEA 2021.1.2 (Community Edition)
//Build #IC-211.7442.40, built on June 1, 2021
//Runtime version: 11.0.11+9-b1341.57 amd64
//VM: Dynamic Code Evolution 64-Bit Server VM by JetBrains s.r.o.

package mobileOperator;

import java.util.Objects;

//Öffentkiche Klasse AllnetFlatt die Attributen der Mutterklasse Tarif vererbt
public class AllnetFlatt extends Tarif {

    //Konstruktor wird mit this überladet
    public AllnetFlatt(String name, String preis, String laufzeit, boolean minuten, boolean sms, boolean datenvolumen) {
        super(name, preis, laufzeit);
        this.minuten = minuten;
        this.sms = sms;
        this.datenvolumen = datenvolumen;
    }

    //Attribute der Klasse AllnetFlatt
    private boolean minuten;
    private boolean sms;
    private boolean datenvolumen;


//Methodenüberschreibung,  liefert Kennung eines Objekts
    @Override
    public String toString() {
        return super.getName() +
                "Minuten: " + getField(minuten) +
                " Sms: " + getField(sms) +
                " Datenvolumen: " + getField(datenvolumen);
    }

    private String getField(boolean b){
        if(b){
            return "unbegrenzt";
        }return "begrenzt";
    }
}
