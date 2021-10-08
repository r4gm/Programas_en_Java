package com.sic;

import java.sql.*;
import java.util.ArrayList;

public class ManejoDB {

    public static Connection nueva_conexion(String db_path, String usuario, String passwd){
        try{
            //Llamada a la libreria mysql conector
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Nueva conexión                           conexión a localhost |   nombre de bd | ususario mysql | contraseña  
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datos", "usuariotabla", "pass1234");
            Connection con = DriverManager.getConnection(db_path, usuario, passwd);
            return con;
        } catch (Exception e) {
            //Imprimir errores 
            System.out.println(e);
        }
        return null;
    }

    public static void agregar_datos(String db_path,String nombre_tabla, String usuario, String passwd, ArrayList<medicion> datos)
    {
        //Try-Catch para manejo de errores
        try {
            Connection con = nueva_conexion(db_path,usuario,passwd);
            for(int i = 0; i < datos.size(); i++ )
            {
                //Nuevo statement para crear datos
                Statement stmt = con.createStatement();
                //Creación de Query | Insertar valores 
                //Estos valores deben coincidir con los valores que se asignaron durante la creación de la tabla
                String str="";
                for(int j = 0; j < datos.get(i).getStr_mdn().length; j++)
                {
                    if(datos.get(i).getStr_mdn()[j].length() > 10)
                    {
                        str += datos.get(i).getStr_mdn()[j].substring(0,9);
                    }
                    else
                    {
                        str += datos.get(i).getStr_mdn()[j];
                    }
                    if(j != datos.get(i).getStr_mdn().length-1)
                    {
                        str += ",";
                    }
                }
                stmt.executeUpdate("INSERT INTO "+nombre_tabla+" VALUES("+str+")");
                //Se cierra la conexión 
            }

            con.close();
        } catch (Exception e) {
            //Imprimir errores 
            System.out.println(e);
        }
    }

    public static void eliminar_datos_por_id(String db_path,String nombre_tabla, String usuario, String passwd,int[] id){
        //Try-Catch para manejo de errores
        try {
            Connection con = nueva_conexion(db_path,usuario,passwd);

            for(int i = 0; i < id.length; i++)
            {
                //Nuevo statement para eliminar datos
                PreparedStatement st = con.prepareStatement("DELETE FROM "+nombre_tabla+" WHERE id = "+id[i]+";");
                //Ejecutar statement
                st.executeUpdate();
            }

            //Se cierra la conexión 
            con.close();

        } catch (Exception e) {
            //Imprimir errores 
            System.out.println(e);
        }
    }

    /*public static void extraccion_datos(){
        // Try-Catch para manejo de errores
        try {
            // Generar un nuevo archivo csv
            FileWriter csvWriter = new FileWriter("archivo.csv");
            //Se crea la cabecera que contiene los nombres de las columnas
            //Que se establecieron al crear la tabla
            csvWriter.append("Id,Nombre,Apellido,Matricula\n");

            // Llamada a la libreria mysql conector
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Nueva conexión conexión a localhost | nombre de bd | ususario mysql |
            // contraseña
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datos", "usuariotabla",
                    "pass1234");
            // Nuevo statement para llamada de datos
            Statement stmt = con.createStatement();
            // Creación de Query | llamada a todos los datos de la tabla alumnos
            ResultSet rs = stmt.executeQuery("select * from alumnos");
            // Ciclo de todos los elementos obtenidos por el query
            while (rs.next()){
                //Se guardan los valores obtenidos por el query en una línea nueva del archivo
                csvWriter.append(String.valueOf(rs.getInt(1))+","+String.valueOf(rs.getString(2))+","+String.valueOf(rs.getString(3))+","+String.valueOf(rs.getString(4))+'\n');
                // Impresión de los valores
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " " + rs.getString(4));
            } 
            //Cerrar conexión de sql
            con.close();
            //Cerrar archivo csv
            csvWriter.flush();
            csvWriter.close();

            // Se cierra la conexión

        } catch (Exception e) {
            // Imprimir errores
            System.out.println(e);
        }
    }*/
}
