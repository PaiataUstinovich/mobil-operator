//Autorin: Paiata Ustinovich,
//Version: IntelliJ IDEA 2021.1.2 (Community Edition)
//Build #IC-211.7442.40, built on June 1, 2021
//Runtime version: 11.0.11+9-b1341.57 amd64
//VM: Dynamic Code Evolution 64-Bit Server VM by JetBrains s.r.o.

package mobileOperator;

import java.util.Objects;

//Abstrakte Klasse Tarif mit diesen Übergabeparametern (es ist unmöglich einen Objekt tarif zu erstellen)
abstract class Tarif {
    private String name;
    private String  preis;
    private String laufzeit;

    //Konstruktor mit this überladen
    public Tarif(String name, String preis, String laufzeit) {
        this.name = name;
        this.preis = preis;
        this.laufzeit = laufzeit;
    }

    //Attribute der Klasse Tarif
    public String getName() {
        return name;
    }

    public String getPreis() {
        return preis;
    }

    public String getLaufzeit() {
        return laufzeit;
    }

    //Methodenüberschreibung,  liefert Kennung eines Objekts
    @Override
    public String toString() {
        return "Tarif{" +
                "name='" + name + '\'' +
                ", preis='" + preis + '\'' +
                ", laufzeit='" + laufzeit + '\'' +
                '}';
    }
}
