//Autorin: Paiata Ustinovich,
//Version: IntelliJ IDEA 2021.1.2 (Community Edition)
//Build #IC-211.7442.40, built on June 1, 2021
//Runtime version: 11.0.11+9-b1341.57 amd64
//VM: Dynamic Code Evolution 64-Bit Server VM by JetBrains s.r.o.

package mobileOperator;

import java.time.LocalDateTime;
import java.util.Scanner;

//Öffentliche KLasse Application, wo wir mit dem Benutzer inerreagieren
public class Application {

    //Aufruf vom MobilManager
    MobilManager manager = new MobilManager();

    //Setzen den Scanner
    Scanner sc = new Scanner(System.in);

    //Methode mit dem Hauptmenü
    public void mainMenu() {
        boolean flag = true;

        //Drück die Menü aus, bis boolische flag true bleibt
        while (flag) {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("1-Wenn Sie eine neue Kunde anliegen wollen");
            System.out.println("2-Wenn Sie eine neue Kunde bearbeiten wollen");
            System.out.println("3-Wenn Sie einen Vertrag abschließen wollen");
            System.out.println("4-Wenn Sie einen Vertrag kündigen wollen");
            System.out.println("5-Wenn Sie SIM-Karte oder Rufnummer verändern wollen");
            System.out.println("--------------------------------------------------------------------------------------");

            //Ausgewählte Menüpunkt wird mit dem Scanner gelesen und gespeichert
            int menuNumber = sc.nextInt();

            //Switch case zwische ausgewählen Menüpunkten, die entsprechende Methoden enthalten
            switch (menuNumber) {
                case (1):
                    createKundeMenu();
                    break;

                case (2):
                    //Man kann eine Kunde nur dann bearbeiten, wenn der Kundelist nicht leer ist
                    if(!manager.kundeListIsEmpty()){
                    updateKunde();
                    break;
                    }
                    System.out.println("Zuerst müssen Sie eine Kunde anliegen!");
                    break;

                case (3):
                    createVertragMenu();
                    break;

                case (4):
                    //Man kann eine Kunde nur dann bearbeiten, wenn der Vertraglist nicht leer ist
                    if(!manager.vertragListIsEmpty()) {
                        deleteVertrag();
                        break;
                    }
                    System.out.println("Zuerst müssen Sie einen Vertrag anliegen!");
                    break;

                case (5):
                    if(!manager.vertragListIsEmpty()) {
                        updateVertrag();
                        break;
                    }
                    System.out.println("Zuerst müssen Sie einen Vertrag anliegen!");
                    break;
            }
        }
    }

    //Methode mit einem Menü wo wir auswählen, ob wir eine  privat oder Firmenkunde anliegen wollen
    private Kunde createKundeMenu() {
        System.out.println("1-Wenn Sie eine Privatkunde anliegen wollen");
        System.out.println("2-Wenn Sie eine Firmenkunde anliegen wollen");
        int menuNUmber = sc.nextInt();

        //Ausgewählte Menünummer wird in switch case (mit create Methoden) benutzt
        switch (menuNUmber) {
            case (1):
                return createPrivateKunde();


            case (2):
                return createFirmenKunde();

            default:
                return null;
        }

    }

    //Methode die eien Privatkunde mithilfe von Methoden create... erzeugt
    private Kunde createPrivateKunde() {
        Adresse adresse = createAdresse();
        String anreade = createAnrede();
        String vorname = createVorname();
        String nachname = createNachname();
        LocalDateTime thisGeburtsdatum = createGeburtsdatum();

        //Prüfen mit der Methode aus Manager isDateOk, ob der Kunde minderjährig ist
        if (!manager.isDateOk(thisGeburtsdatum)) {
            System.out.println("Es ist unmöglich eine minderjährige Kunde zu erzeugen");
            return null;
        }

        return manager.createKunde(adresse, anreade, vorname, nachname, thisGeburtsdatum);
    }

    //Methode die eien Privatkunde mithilfe von Methoden create... erzeugt
    private Kunde createFirmenKunde() {
        Adresse adresse = createAdresse();
        String firmenname = createFirmenname();
        String umsatzsteuernummer = createUmsatzsteuernummer();
        return manager.createKunde(adresse, firmenname, umsatzsteuernummer);
    }

    //Methode die eien Vertrag für neuen oder bereits existirenden Kunde erzeugt
    private void createVertragMenu() {
        System.out.println("1-Kunde aus der Liste auswählen");
        System.out.println("2-Eine Kunde erstellen");
        int menuNumber = sc.nextInt();

        //switch case zwischen ausgewählten Menüpunkten
        switch (menuNumber) {
            case (1):
                //Auswählen und speichern der Kundenindex aus der ausgedrückten Kundenliste
                System.out.println("Wählen Sie die Kundennummer aus");
                manager.printAllKunde();
                int index = sc.nextInt();

                //Finden der entsprechende Kunde mit der Methode getKundeByIndex
                Kunde kunde = manager.getKundeByIndex(index);
                //Anwenden der Methode createvertrag
                createVertrag(kunde);
                break;

            case (2):
                //Anwenden der Methode createvertrag für neu angelegte Kunde
                Kunde kunde1 = createKundeMenu();
                createVertrag(kunde1);
                break;
        }

    }

    //Methode die eien Vertrag erzeugt
    private void createVertrag(Kunde kunde) {
        //Methode createTarif mit der wir einen Tarif aus der Tarifliste auswählen können
        Tarif tarif = createTarif();
        //Objekt newVertrag ist ein Ergebniss der Arbeit der Manager Methode createVertrag
        Vertrag newVertrag = manager.createVertrag(kunde, tarif);
        System.out.println("Neuen Vertrag war erzeugt");
        //Gib die Innformationen über neu erzeugte Vertrag aus
        manager.printVertrag(newVertrag);
    }

    //Methode die aus der ausgedrückte Vertragiste ausgewählten Vertrag löscht
    private void deleteVertrag() {
        System.out.println("Wählen Sie den Vertrag denen Sie löschen wollen");
        manager.printAllVertrag();
        int number = sc.nextInt();
        manager.deleteVertrag(number);
        System.out.println("Vertrag war gelöscht");
    }

    //Methode die nach einem Auswahl einweder Ruf oder Kartennummer ändert
    private void updateVertrag() {
       // Aus der ausgedrückte Vertragiste ausgewählten Vertragindex speichern
        System.out.println("Geben Sie den Vertragnummer ein, denen Sie bearbeiten wollen");
        manager.printAllVertrag();
        int index = sc.nextInt();
        System.out.println("1-Wenn Sie den Rufnummer ändern wollen");
        System.out.println("2-Wenn Sie den Kartennummer ändern wollen");
        int menuNummer = sc.nextInt();

        //switch case zwischen eingegebenen Menünummern
        switch (menuNummer) {
            case (1):
                //Boolische Methode updateVertrag aus Manager
                manager.updateVertrag(index, true, false);
                break;

            case (2):
                manager.updateVertrag(index, false, true);
                break;
        }
    }

    //Methode die ausgewählte Kunde ändert
    private void updateKunde() {
        //Der zu bearbeitende KundeIndex wird mit Scanner gelesen und gespeichert
        System.out.println("Wählen Sie zu bearbeitenden Kunde aus der Liste");
        manager.printAllKunde();
        int number = sc.nextInt();

        //Eingegebene KundeIndex wird mit der Manager Methode getKundeByIndex in der KundeListe gesucht
        Kunde kunde = manager.getKundeByIndex(number);

        //Wenn der Kunde eine Instanz der KLasse Privatkunde ist, dann benutz die Methode updatePrivateKunde
        // für einen Privatkunde (es gibt dann einen Auswahl zwischen Adresse und Nachnamänderung)
        if (kunde instanceof Privatkunde) {
            updatePrivateKunde(kunde);
        }
        //Wenn der Kunde eine Instanz der KLasse Firmenkunde ist, dann benutz die Methode updateFFirmenKunde
        //Nur Adresseänderung ist möglich
        if (kunde instanceof Firmenkunde) {
            updateFirmenKunde(kunde);
        }
        return;
    }

    //Methode die entweder eine Adresse oder die Nachname bei einem Privatenkunde ändert
    private void updatePrivateKunde(Kunde kunde) {

        //Alle Informationen über Kunde werden mithilfe der printKunde Methode ausgedrückt
        manager.printKunde(kunde);
        System.out.println("Sie können bei einem Privatkunde die Adresse und die Nachname ändern");
        System.out.println("1-Wenn Sie die Adresse ändern wollen");
        System.out.println("2-Wenn Sie die Nachname ändern wollen");

        //Ausgewählte Menünummer wird in switch case  benutzt
        int menuNumber = sc.nextInt();
        switch (menuNumber) {
            case (1):

                //Neue Adresse mithilfe der createAdresse Methode eingeben
                Adresse adresse = createAdresse();

                //Mit der Manager Methode updateKunde wird nur Adresse verändert, deswegen bei nachname null
                manager.updateKunde(kunde, adresse, null);

                //Ausdrüken alle Informationen über Privatkunde mit veränderte Adresse
                manager.printKunde(kunde);
                break;
            case (2):

                //Neue Nachnanme mithilfe der createNachname Methode eingeben
                String nachname = createNachname();

                //Mit der Manager Methode updateKunde wird nur Adie Nachnanme verändert, deswegen bei adresse null
                manager.updateKunde(kunde, null, nachname);

                //Ausdrüken alle Informationen über Privatkunde mit veränderter Nachname
                manager.printKunde(kunde);
                break;
        }
    }

    //Methode die nur Adresse bei einem Firmenkunde ändert
    private void updateFirmenKunde(Kunde kunde) {
        //Alle Informationen über Kunde werden mithilfe der printKunde Methode ausgedrückt
        manager.printKunde(kunde);
        System.out.println("Bei einem Firmenkunde können Sie nur die Adresse ändern");

        //Neue Adresse mithilfe der createAdresse Methode eingeben
        Adresse adresse = createAdresse();

        //Mit der Manager Methode updateKunde wird nur Adresse verändert, deswegen bei nachname null
        manager.updateKunde(kunde, adresse, null);

        //Ausdrüken alle Informationen über Firmenkunde mit veränderte Adresse
        manager.printKunde(kunde);
    }

    //Methode createAdresse die eine Adresse mithilfe von Methoden createStraße, createHausnummer... erzeugt
    private Adresse createAdresse() {
        String straße = createStraße();
        String hausnummer = createHausnummer();
        String plz = createPLZ();
        String ort = createOrt();

        //Neu eingegebene Adresse mit diesen Parametern
        Adresse adresse = new Adresse(straße, hausnummer, plz, ort);
        return adresse;
    }


    //create Methoden die gleich funktionieren: Wir geben die Informationen ein, es wird mit Scanner gelesen und gespeichert
    private String createStraße() {
        System.out.println("Geben Sie die Straße ein");
        String straße = sc.next();
        return straße;
    }

    private String createHausnummer() {
        System.out.println("Geben Sie den Hausnummer ein");
        String hausnummer = sc.next();
        return hausnummer;
    }

    private String createPLZ() {
        System.out.println("Geben Sie den PLZ ein");
        String plz = sc.next();
        return plz;
    }

    private String createOrt() {
        System.out.println("Geben Sie den Ort ein");
        String ort = sc.next();
        return ort;
    }

    private String createAnrede() {
        System.out.println("Geben Sie die Anrede ein");
        String anreade = sc.next();
        return anreade;
    }

    private String createVorname() {
        System.out.println("Geben Sie die Vorname ein");
        String vorname = sc.next();
        return vorname;
    }

    private String createNachname() {
        System.out.println("Geben Sie die Nachneme ein");
        String nachname = sc.next();
        return nachname;
    }

    private LocalDateTime createGeburtsdatum() {
        System.out.println("Geben Sie die Geburtsdatum ein");
        String geburtsdatum = sc.next();

        //Eingegebene Geburtsdatum wird
        LocalDateTime thisGeburtsdatum = parseDate(geburtsdatum);
        return thisGeburtsdatum;
    }

    private String createFirmenname() {
        System.out.println("Geben Sie die Firmenname ein");
        String firmenname = sc.next();
        return firmenname;
    }

    private String createUmsatzsteuernummer() {
        System.out.println("Geben Sie den Umsatzsteuernummer ein");
        String umsatzsteuernummer = sc.next();
        return umsatzsteuernummer;
    }

    private Tarif createTarif() {
        System.out.println("Wählen Sie die Tariffe aus der Liste");
        manager.printAllTarif();
        int index = sc.nextInt();

        //Eingegebene Tarifnummer aus der ausgedrückte Tarifliste wird gelesen und gespeichert
        return manager.getTarifByIndex(index);
    }

    //Methode die Geburtsdatum vom Kunde in Tage, Monate und Jahre trennt
    private LocalDateTime parseDate(String date) {

        //Datum trennen, da wo einen Punkt steht (trennt T, M, J) und dann als eine Liste speichern
        String[] dateArray = date.split("\\.");

        //Datum war in String wegen Punkten. Jetzt haben wir eine Liste ohen Punkten und deswegen machen wir T,M,J in Integer
        //Index 2-Jahr, 1-Monat, 0-Tag
        LocalDateTime thisDate = LocalDateTime.of(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]),
                Integer.parseInt(dateArray[0]), 0, 0, 0);
        return thisDate;
    }
}
