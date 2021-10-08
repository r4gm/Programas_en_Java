package com.sic;


public class App {
    public static void main(String[] args) {
        limpiar_db();
        mediciones mediciones_distancia = new mediciones(ManejoCSV.leercsv("mediciones2.csv"));
        
        System.out.println("mediciones no ordenadas: \n"+mediciones_distancia.toString());
        mediciones_distancia.setMdns(ordenamiento.ordenar_por_valor_medicion(mediciones_distancia));
        System.out.println("mediciones ordenadas: \n"+mediciones_distancia.toString());

        ManejoDB.agregar_datos("jdbc:mysql://localhost:3306/datos","datos_sensores", "fernando", "pass1234", mediciones_distancia.getMdns());
    }

    public static void limpiar_db(){
        int[] id_eliminar = new int[51];
        for(int i = 0; i < 51; i++)
        {
            id_eliminar[i] = i;
        }
        ManejoDB.eliminar_datos_por_id("jdbc:mysql://localhost:3306/datos","datos_sensores", "fernando", "pass1234",id_eliminar);
    }
}
