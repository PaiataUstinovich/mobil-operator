//Autorin: Paiata Ustinovich,
//Version: IntelliJ IDEA 2021.1.2 (Community Edition)
//Build #IC-211.7442.40, built on June 1, 2021
//Runtime version: 11.0.11+9-b1341.57 amd64
//VM: Dynamic Code Evolution 64-Bit Server VM by JetBrains s.r.o.

package mobileOperator;

import java.util.Objects;

//Abstrakte Klasse Kunde mit diesen Übergabeparametern (es ist unmöglich einen Objekt tarif zu erstellen)
abstract class Kunde {

    //Konstruktor mit this überladen
    public Kunde(int id,Adresse adresse) {
        this.id = id;
        this.adresse = adresse;
    }


    //Attribute der Klasse Tarif
    private int id;
    private Adresse adresse;


    public int getId() {
        return id;
    }


    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }


    //Methodenüberschreibung,  liefert Kennung eines Objekts
    @Override
    public String toString() {
        return "Kunde{" +
                "id=" + id +
                ", adresse=" + adresse +
                '}';
    }
}
