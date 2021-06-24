//Autorin: Paiata Ustinovich,
//Version: IntelliJ IDEA 2021.1.2 (Community Edition)
//Build #IC-211.7442.40, built on June 1, 2021
//Runtime version: 11.0.11+9-b1341.57 amd64
//VM: Dynamic Code Evolution 64-Bit Server VM by JetBrains s.r.o.

package mobileOperator;

//Öffentkiche Klasse mit Attributen: straße, hausnummer, plz, ort
public class Adresse {


    private String straße;
    private String hausnummer;
    private String plz;
    private String ort;

    //Konstruktor wird mit this überladet
    public Adresse(String straße, String hausnummer, String plz, String ort) {

        this.straße = straße;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
    }


//Attribute der KLasse Adresse
    public String getStraße() {
        return straße;
    }

    public void setStraße(String straße) {
        this.straße = straße;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}
