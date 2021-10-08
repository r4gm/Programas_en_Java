package com.sic;

import java.io.*;
import java.util.ArrayList;

public class ManejoCSV {
    public static ArrayList<String[]> leercsv(String nombre_archivo){
        String line = "", splitBy = ",";
        ArrayList<String[]> str= new ArrayList<String[]>();
        try
        {
            //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader(nombre_archivo));
            while ((line = br.readLine()) != null)   //returns a Boolean value  
            {
                String[] datos = line.split(splitBy);    // use comma as separator 
                 
                /*for(int i = 0; i < datos.length; i++)
                {
                    System.out.print(datos[i]+", ");
                }
                System.out.println(); */ 
                str.add(datos.clone());
            }
            br.close();
        }
        catch (IOException e)   
        {
            e.printStackTrace();  
        }
        return str;
    }

    public static void escribirCSV(ArrayList<String[]> datos, String nombre_archivo)
    {
        try {
            FileWriter csvWriter = new FileWriter("new.csv");
            for(int i = 0; i < datos.size(); i++)
            {
                for(int j = 0; j < datos.get(i).length; i++)
                {
                    csvWriter.append(datos.get(i)[j]+",");
                }
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
