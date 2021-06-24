//Autorin: Paiata Ustinovich,
//Version: IntelliJ IDEA 2021.1.2 (Community Edition)
//Build #IC-211.7442.40, built on June 1, 2021
//Runtime version: 11.0.11+9-b1341.57 amd64
//VM: Dynamic Code Evolution 64-Bit Server VM by JetBrains s.r.o.

package mobileOperator;

import java.time.LocalDateTime;
import java.util.Objects;

//Öffentkiche Klasse Privatkunde die Attributen der Mutterklasse Kunde vererbt
public class Privatkunde extends Kunde  {

    //Konstruktor wird mit this überladet
    public Privatkunde(int id, Adresse adresse,
                       String anrede, String vorname, String nachname, LocalDateTime geburtsdatum) {
        super(id, adresse );
        this.anrede = anrede;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
    }


    //Attribute der Klasse Privatkunde
    private String anrede;
    private String vorname;
    private String nachname;
    private LocalDateTime geburtsdatum;

    public String getAnrede() {
        return anrede;
    }


    public String getVorname() {
        return vorname;
    }


    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public LocalDateTime getGeburtsdatum() {
        return geburtsdatum;
    }

    //Methodenüberschreibung,  liefert Kennung eines Objekts
    @Override
    public String toString() {
        return "Privatkunde: " +"\n"+
                "Anrede: " + anrede + " Vorname: " + vorname + " Nachname: " + nachname + " Geburtsdatum=" + geburtsdatum +"\n"+
                "Strße: " + super.getAdresse().getStraße()+ " Hausnummer: "+super.getAdresse().getHausnummer()+
                " PLZ: "+super.getAdresse().getPlz()+ " Ort: "+super.getAdresse().getOrt();
    }
}

