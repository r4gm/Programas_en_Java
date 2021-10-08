package com.sic;

import java.util.ArrayList;
import java.util.Collections;

public class ordenamiento{  
    public static ArrayList<medicion> ordenar_por_valor_medicion(mediciones grupo_mediciones)   
    {
        ArrayList<medicion> mdns = new ArrayList<medicion>(grupo_mediciones.getMdns().size());
        for(int i = 0; i < grupo_mediciones.getMdns().size(); i++)
        {
            mdns.add(new medicion(grupo_mediciones.getMdns().get(i).getStr_mdn().clone()));
        }

        //System.out.println("Elementos sin ordenar: \n"+grupo_mediciones.toString());
        Collections.sort(mdns);
        //System.out.println("Elementos ordenados: \n"+grupo_mediciones.toString());

        return mdns;
    }
}