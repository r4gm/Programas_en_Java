package com.sic;

import java.util.ArrayList;

public class mediciones {
    private ArrayList<medicion> mdns;

    public mediciones(){
        this.mdns = new ArrayList<medicion>();
    }

    public mediciones(ArrayList<String[]> datos){
        mdns = new ArrayList<medicion>();
        for(int i = 0; i < datos.size(); i++)
        {
            /*System.out.print("La linea de String tiene "+datos.get(i).length+" dato(s): ");
            for(int j = 0; j < datos.get(i).length; j++)
            {
                System.out.print(datos.get(i)[j]+", ");
            }*/
            
            
            if(datos.get(i).length == 3)
            {
                //System.out.print("Se agrega el dato");
                this.mdns.add(new medicion(datos.get(i).clone()));
            }
            //System.out.println();
        }
    }

    public ArrayList<medicion> getMdns(){
        return this.mdns;
    }

    public void setMdns(ArrayList<medicion> mdns){
        for(int i = 0; i < this.mdns.size();i++)
        {
            //System.out.println("El dato a agregar tiene "+mdns.get(i).getStr_mdn().length+" campos");
            this.mdns.set(i, new medicion(mdns.get(i).getStr_mdn().clone()));
        }
        //this.mdns = mdns;
    }

    @Override
    public String toString(){
        String str = "";
        for(int i = 0; i < this.mdns.size(); i++)
        {
            str += this.mdns.get(i).toString() + "\n";
        }
        return str;
    }
}
