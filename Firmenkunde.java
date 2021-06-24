//Autorin: Paiata Ustinovich,
//Version: IntelliJ IDEA 2021.1.2 (Community Edition)
//Build #IC-211.7442.40, built on June 1, 2021
//Runtime version: 11.0.11+9-b1341.57 amd64
//VM: Dynamic Code Evolution 64-Bit Server VM by JetBrains s.r.o.

package mobileOperator;

import java.util.Objects;

//Öffentkiche Klasse Firmenkunde die Attributen der Mutterklasse Kunde vererbt
public class Firmenkunde extends Kunde{

    //Konstruktor wird mit this überladet
    public Firmenkunde(int id, Adresse adresse, String firmennamen, String umsatzsteuernummer) {
        super(id, adresse);
        this.firmennamen = firmennamen;
        this.umsatzsteuernummer = umsatzsteuernummer;
    }

    //Attribute der Klasse Privatkunde
    private String  firmennamen;
    private String umsatzsteuernummer;

    public String getFirmennamen() {
        return firmennamen;
    }

    public void setFirmennamen(String firmennamen) {
        this.firmennamen = firmennamen;
    }

    public String getUmsatzsteuernummer() {
        return umsatzsteuernummer;
    }

    public void setUmsatzsteuernummer(String umsatzsteuernummer) {
        this.umsatzsteuernummer = umsatzsteuernummer;
    }

    //Methodenüberschreibung,  liefert Kennung eines Objekts
    @Override
    public String toString() {
        return "Firmenkunde: " +"\n" +
                "Firmennamen: "+ firmennamen + " Umsatzsteuernummer:" + umsatzsteuernummer + "\n"+
                "Strße: " + super.getAdresse().getStraße()+ " Hausnummer: "+super.getAdresse().getHausnummer()+
                " PLZ: "+super.getAdresse().getPlz()+ " Ort: "+super.getAdresse().getOrt();
    }
}
