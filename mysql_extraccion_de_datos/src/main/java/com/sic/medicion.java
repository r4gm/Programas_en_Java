package com.sic;

public class medicion implements Comparable<medicion>{
    private int id;
    private String fecha;
    private String hora;
    private double medicion;
    private String[] str_mdn;

    public medicion(){
        this.id = 0;
        this.fecha = "";
        this.hora = "";
        this.medicion = 0;

        this.str_mdn = new String[4];
        for(int i = 0; i < this.str_mdn.length; i++)
        {
            str_mdn[i] = "";
        }
    }

    public medicion(int id, String fecha, String hora, double medicion){
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.medicion = medicion;
        
        this.str_mdn = new String[4];
        this.str_mdn[0] = Integer.toString(id);
        this.str_mdn[1] = fecha;
        this.str_mdn[2] = hora;
        this.str_mdn[3] = Double.toString(medicion);
    }

    public medicion(String[] datos)
    {
        try{
            this.id = Integer.parseInt(datos[0]);
            
            this.str_mdn = new String[4];
            this.str_mdn[0] = datos[0];

            if(datos.length == 4)
            {
                this.fecha = datos[1].substring(0,8);
                this.hora = datos[2];
                this.medicion = Double.parseDouble(datos[3]);

                this.str_mdn[1] = datos[1];
                this.str_mdn[2] = datos[2];
                this.str_mdn[3] = datos[3];
            }
            else
            {
                this.fecha = datos[1].substring(0,8);
                this.hora = datos[1].substring(8);
                this.medicion = Double.parseDouble(datos[2]);
                
                this.str_mdn[1] = datos[1].substring(0,8);
                this.str_mdn[2] = datos[1].substring(8);
                this.str_mdn[3] = datos[2];
            }

        }catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }


    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
        this.str_mdn[0] = Integer.toString(id);
    }

    public String getFecha(){
        return this.fecha;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
        this.str_mdn[1] = fecha;
    }

    public String getHora(){
        return this.hora;
    }

    public void setHora(String hora){
        this.hora = hora;
        this.str_mdn[2] = hora;
    }

    public double getMedicion(){
        return this.medicion;
    }

    public void setMedicion(double medicion){
        this.medicion = medicion;
        this.str_mdn[3] = Double.toString(medicion);
    }

    public String[] getStr_mdn(){
        return this.str_mdn;
    }

    @Override
    public int compareTo(medicion mdn) {
        return Double.compare(this.getMedicion(), mdn.getMedicion());
    }

    @Override
    public String toString(){
        String str = "";
        str += this.id + ", " + this.fecha + ", " + this.hora + ", " + this.medicion;
        return str;
    }
}