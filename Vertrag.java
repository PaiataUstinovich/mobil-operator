//Autorin: Paiata Ustinovich,
//Version: IntelliJ IDEA 2021.1.2 (Community Edition)
//Build #IC-211.7442.40, built on June 1, 2021
//Runtime version: 11.0.11+9-b1341.57 amd64
//VM: Dynamic Code Evolution 64-Bit Server VM by JetBrains s.r.o.

package mobileOperator;

import java.time.LocalDateTime;
import java.util.Objects;

//Öffentliche KLasse Vertrag
public class Vertrag {

    //Konstruktor mit this überladen
    public Vertrag(int id, LocalDateTime startDate, LocalDateTime endDate, Tarif tarif, Kunde kunde, String rufnemmer, long kartennummer) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tarif = tarif;
        this.kunde = kunde;
        this.rufnemmer = rufnemmer;
        this.kartennummer = kartennummer;
    }

    //Attribute der Klasse Tarif
    private int id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Tarif tarif;
    private Kunde kunde;
    private String rufnemmer;
    private long kartennummer;


    //getter Methoden für Attributen id, startDate,  endDate, tarif und kunde
    // Wer setzen diese Attribute später mit anderen Methoden
    public int getId() {
        return id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Tarif getTarif() {
        return tarif;
    }


    public Kunde getKunde() {
        return kunde;
    }


    public String getRufnemmer() {
        return rufnemmer;
    }

    public void setRufnemmer(String rufnemmer) {
        this.rufnemmer = rufnemmer;
    }

    public long getKartennummer() {
        return kartennummer;
    }

    public void setKartennummer(long kartennummer) {
        this.kartennummer = kartennummer;
    }

}
