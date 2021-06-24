//Autorin: Paiata Ustinovich,
//Version: IntelliJ IDEA 2021.1.2 (Community Edition)
//Build #IC-211.7442.40, built on June 1, 2021
//Runtime version: 11.0.11+9-b1341.57 amd64
//VM: Dynamic Code Evolution 64-Bit Server VM by JetBrains s.r.o.

package mobileOperator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MobilManager {

    //Öffentliche Klasse MobilManager ruft die Klasse TarifFactory auf
    TarifFactory tarifFactory = new TarifFactory();

    //Erstellen von Array Listen
    private List<Kunde> kundeList = new ArrayList<>();

    //KLasse TarifFactory hat in dich schon Liste von allen Tarifen und Methode getTarifList
    private List<Tarif> tarifList = tarifFactory.getTarifList();
    private List<Vertrag> vertragList = new ArrayList<>();


    //Die Methode isEmpty() gibt true zurück, wenn diese Vertragliste keine Elemente enthält
    public boolean vertragListIsEmpty(){
        return vertragList.isEmpty();
    }


    ////Die Methode isEmpty() gibt true zurück, wenn diese Kundenliste keine Elemente enthält
    public boolean kundeListIsEmpty(){
        return kundeList.isEmpty();
    }


    //Methode, die mit foreach-Schleife duch die mit number durchnummerierte Kundenliste geht und mit Methode printKunde nächsten Kunde ausdrückt
    public void printAllKunde() {
        int number = 1;
        for (Kunde kunde : kundeList) {
            System.out.print(number + ": ");
            printKunde(kunde);
            number++;
        }
    }

    //Methode braucht die für seine Arbeit Objekt kunde
    public void printKunde(Kunde kunde) {

        //Alle Informationen über privat/firmenKunde werden mithilfe der toString Methode ausgedrückt
        System.out.println(kunde.toString());
    }

    //Methode, die mit foreach-Schleife duch die mit number durchnummerierte Vertragliste geht und mit Methode printVertrag nächsten Vertrag ausdrückt
    public void printAllVertrag() {
        int count = 1;
        for (Vertrag vertrag : vertragList) {
            System.out.print(count + ". ");
            printVertrag(vertrag);
            count++;
        }
    }

    //Methode braucht die für seine Arbeit Objekt vertrag
    public void printVertrag(Vertrag vertrag) {
        //Alle Informationen über privat/firmenKunde aus diesem Vertrag werden mithilfe der toString Methode ausgedrückt
        System.out.println(vertrag.getKunde().toString());

        //Alle Informationen über den Tarif aus diesem Vertrag werden mithilfe der toString Methode ausgedrückt
        System.out.println(vertrag.getTarif().toString());

        //Alle Informationen über den Vertrag werden mithilfe der getter Methode aus der Klasse Vertrag ausgedrückt
        System.out.println("Anfangsdatum: " + vertrag.getStartDate());
        System.out.println("Enddatum: " + vertrag.getEndDate());
        System.out.println("Rufnummer: " + vertrag.getRufnemmer());
        System.out.println("Kartennummer: " + vertrag.getKartennummer());
    }


    //Methode, die einen Privatkunde mit diesen Übergabeparametern erzeugt
    public Kunde createKunde(Adresse adresse,
                             String anrede, String vorname, String nachname, LocalDateTime geburtsdatum) {


        //Id von neu erzeugte Kunde wird mit der Methode getNextKundeId bestimmt
        int id = getNextKundeId();

        //Erzeugen neue privatkunde mit diesen Attributen
        Privatkunde privatkunde = new Privatkunde(id, adresse, anrede, vorname, nachname, geburtsdatum);

        //Hinfügen der Kunde in die Kundenliste
        kundeList.add(privatkunde);
        return privatkunde;
    }


    //Methode, die einen Firmenkunde mit diesen Übergabeparametern erzeugt
    public Kunde createKunde(Adresse adresse, String firmennamen, String umsatzsteuernummer) {

        int id = getNextKundeId();
        Firmenkunde firmenkunde = new Firmenkunde(id, adresse, firmennamen, umsatzsteuernummer);

        kundeList.add(firmenkunde);
        return firmenkunde;
    }


    //Methode, die bei einem Privatkunde Adresse oder Nachnmae und bei Firmenkunde Adresse ändert
    public void updateKunde(Kunde kunde, Adresse adresse, String nachname) {

        //Wenn die Adresse nich leer ist, benutz die setter-Methode für die Adresse vom Objekt kunde der Klasse Kunde
        if (adresse != null) {
            kunde.setAdresse(adresse);
        }

        //Wenn Objekt kunde eine instanz der KLasse Privatkunde ist, dann wir kunde zu privatkunde
        if (kunde instanceof Privatkunde) {
            Privatkunde privatkunde = (Privatkunde) kunde;

            //Wenn die Nachname nicht leer ist,  benutz die setter-Methode für die Nachname vom Objekt kunde der Klasse Kunde
            if (nachname != null) {
                privatkunde.setNachname(nachname);
            }
        }
    }


    //Methode, die nach seiner Arbeit der Kunde (mit diesem Index in der Liste) findet
    public Kunde getKundeByIndex(int index) {
        return kundeList.get(index - 1);
    }


    //Methode,die mit foreach-Schleife durch die Kundenliste geht und nächsten Kunde (durch Vergleich mit maxId) findet
    private int getNextKundeId() {
        int maxId = 0;
        for (Kunde kunde : kundeList) {
            if (kunde.getId() > maxId) {
                maxId = kunde.getId();
            }
        }
        return maxId + 1;
    }

    //Methode, die einen Vertrag mit diesen Übergabeparametern erzeugt
    public Vertrag createVertrag(Kunde kunde, Tarif tarif) {

        //Setzen mit der Methode getNextVertragId id vom nächsten Vertrag
        int id = getNextVertragId();

        //Setzen mit der Klasse LocalDateTime jetzige Zeit und Datum
        LocalDateTime startDate = LocalDateTime.now();

        //Kündigungsdatum ergibt sich aus der Summe aus Monaten von Laufzeit und Anfangsdatum
        //Wir müssen Laufzeit die in String ist in Integer parsen, nur so können wir mathemetische Operationene durchführen
        LocalDateTime endDate = startDate.plusMonths(Integer.parseInt(tarif.getLaufzeit()));

        //Ruf und Kartennummer bekkommen wir nach der Arbei von generateKartennummer und generateRufnummer Methoden
        String rufnummer = generateRufnummer();
        long kartennumer = generateKartennummer();

        //Erstellen den Objekt vertrag mit diesen Attributen und fügen es in der Liste
        Vertrag vertrag = new Vertrag(id, startDate, endDate, tarif, kunde, rufnummer, kartennumer);
        vertragList.add(vertrag);
        return vertrag;
    }


    //Methode, die mit remove den ausgewählten Vertrag (mit diesem Index) löscht
    public void deleteVertrag(int index) {
        vertragList.remove(index - 1);
    }


    //Methode, die den Ruf oder Kartennummer bei dem Vertrag mit diesem Index löscht
    public void updateVertrag(int index, boolean rufnummer, boolean kartennumer){

        //Neuen Rufnummer ergibt sich aus der Methode setRufnummer
        //Wir liegen in der Methode setRufnemmer Ergebnis von der der Methode generateRufnummer
        if(rufnummer){
            vertragList.get(index-1).setRufnemmer(generateRufnummer());
            System.out.println("Ihres neues Rufnummer lautet: " + vertragList.get(index-1).getRufnemmer());
        }

        //Neuen Kartennummer ergibt sich aus der Methode setKartennummer
        //Wir liegen in der Methode setKartennummer Ergebnis von der der Methode getKartennummer
        if(kartennumer){
            vertragList.get(index-1).setKartennummer(generateKartennummer());
            System.out.println("Ihres neues Kartennummer: "+ vertragList.get(index-1).getKartennummer());
        }
    }

    //Methode, die den (13 stelligen mit +) Rufnummer mit Math.random generiert
    private String generateRufnummer() {
        long rufnummer = (long) (Math.random() * 8999999999999L) + 1000000000000L;
        String thisNummer = "+" + rufnummer;
        return thisNummer;
    }

    //Methode, die den 13 stelligen Kartenummer mit Math.random generiert
    private long generateKartennummer() {
        long kartennumer = (long) (Math.random() * 8999999999999L) + 1000000000000L;
        return kartennumer;
    }

    //Methode,die mit foreach-Schleife durch die Vertragliste geht und nächsten Vertrag (durch Vergleich mit maxId) findet
    public int getNextVertragId() {
        int maxId = 0;
        for (Vertrag vertrag : vertragList) {
            if (vertrag.getId() > maxId) {
                maxId = vertrag.getId();
            }
        }
        return maxId + 1;
    }

    //Methode, die nach seiner Arbeit einen Vertrag (mit diesem Index in der Liste) findet
    public Tarif getTarifByIndex(int index) {
        return tarifList.get(index - 1);
    }

    //Methode, die mit foreach-Schleife duch die mit number durchnummerierte Tarifliste geht und mit Methode toString nächsten Vertrag ausdrück
    public void printAllTarif() {
        int number = 1;
        for (Tarif tarif : tarifList) {
            System.out.println(number + ". " + tarif.toString());
            number++;
        }
    }

    //Methode, die überprüft,das der Kunde älter als 18 ist
    public boolean isDateOk(LocalDateTime date) {
        //jetzige Zeit und Datum
        LocalDateTime controlTime = LocalDateTime.now();
        //Geburtsjahr vom volljährige Kunde plus 18 Jahren muss kleiner als jetziges Jahr sein
        return (date.plusYears(18).isBefore(controlTime));
    }

}
