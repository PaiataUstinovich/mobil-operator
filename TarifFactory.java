//Autorin: Paiata Ustinovich,
//Version: IntelliJ IDEA 2021.1.2 (Community Edition)
//Build #IC-211.7442.40, built on June 1, 2021
//Runtime version: 11.0.11+9-b1341.57 amd64
//VM: Dynamic Code Evolution 64-Bit Server VM by JetBrains s.r.o.

package mobileOperator;

import java.util.ArrayList;
import java.util.List;

//Öffentkiche Klasse  TarifFactory mit dem ArrayList von Tarifen
public class TarifFactory {
    List<Tarif> tarifList=new ArrayList<>();

    //Konstruktor, der 4 Tarifen mit diese Parametern erstellt umd die in der Liste hinfügt
    public List getTarifList (){
        AllnetFlatt allnetFlatt1=new AllnetFlatt("Allnet-Flat","5","10",
                true,false,false );
        AllnetFlatt allnetFlatt2=new AllnetFlatt("Allnet-Flat mit SMS-Flat","6","12",
                false,true,false );
        AllnetFlatt allnetFlatt3=new AllnetFlatt("Allnet-Flat mit Daten-Flat","7","12",
                false,false,true);
        AllnetFlatt allnetFlatt4=new AllnetFlatt("Allnet-Flat mit SMS-Flat und Datenflat","10","6",
                true,true,true);

        tarifList.add(allnetFlatt1);
        tarifList.add(allnetFlatt2);
        tarifList.add(allnetFlatt3);
        tarifList.add(allnetFlatt4);

        return tarifList;
    }
}
