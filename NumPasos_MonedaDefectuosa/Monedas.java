import java.util.ArrayList;

/**
 * Esta clase define los atributos y metodos de un conjunto de monedas,
 * en donde puede haber monedas no defectuosas y defectusas
 * Una moneda no defectuosa se representa con 1
 * mientras que una moneda defectuosa con -1
 */
public class Monedas {
    private int num_monedas; // Es el numero total de monedas del conjunto
    private int num_monedas_defectuosas; // Es el numero de monedas defectuosas
    private ArrayList<Moneda> arr_monedas; // Es el arreglo que contiene monedas no defectuosas y defectuosas
    private Moneda[] monedas_referencia; // Es la moneda considerada como referencia
    private double tolerancia; // Es una cantidad en gramos que define si una moneda es no defectuosa o defectuosa

    /**
     * El constructor para el arreglo de monedas. 
     * @param num_monedas Es el numero de monedas totales del arreglo
     * @param num_monedas_defectuosas Es el numero de monedas defectuosas que hay en el arreglo
     */
    public Monedas(int num_monedas, int num_monedas_defectuosas, Moneda[] monedas_referencia, double tolerancia){
        if(num_monedas > 0)
        {
            this.num_monedas = num_monedas;
        }
        else
        {
            System.out.println("Debe de haber al menos 1 moneda en el conjunto");
            this.num_monedas = 1;
        }
        
        if(num_monedas_defectuosas > 0)
        {
            this.num_monedas_defectuosas = num_monedas_defectuosas;
        }
        else if(num_monedas_defectuosas > num_monedas)
        {
            System.out.println("No pueden haber mas monedas defectuosas que monedas totales");
            this.num_monedas_defectuosas = num_monedas;
        }
        else
        {
            System.out.println("Debe de haber al menos 1 moneda defectuosa en el conjunto");
            this.num_monedas_defectuosas = 1;
        }
        
        this.monedas_referencia = new Moneda[monedas_referencia.length];

        for(int i = 0; i < this.monedas_referencia.length; i++)
        {
            this.monedas_referencia[i] = new Moneda(monedas_referencia[i].getValor(),monedas_referencia[i].getPeso());
        }

        this.arr_monedas = new ArrayList<Moneda>(num_monedas);
        this.tolerancia = tolerancia;

        this.generar_arreglo_aleatorio();
    }

    public int getNum_monedas(){
        return this.num_monedas;
    }

    public void setNum_monedas(int num_monedas){
        this.num_monedas = num_monedas;
    }

    public int getNum_monedas_defectuosas(){
        return this.num_monedas_defectuosas;
    }

    public void setNum_monedas_defectuosas(int num_monedas_defectuosas){
        this.num_monedas_defectuosas = num_monedas_defectuosas;
    }

    public ArrayList<Moneda> getArr_monedas(){
        return this.arr_monedas;
    }

    public Moneda[] getMonedas_referencia(){
        return this.monedas_referencia;
    }

    public double getTolerancia(){
        return this.tolerancia;
    }

    public void agregar_moneda(Moneda nueva_moneda, double probabilidad_moneda_defectuosa){
        int ind = (int) (Math.random()*this.arr_monedas.size());
        this.arr_monedas.add(ind,new Moneda(nueva_moneda.getValor(),nueva_moneda.getPeso()));
        this.setNum_monedas(this.getNum_monedas()+1);

        if(Math.random() < probabilidad_moneda_defectuosa/3)
        {
            System.out.println("La moneda "+ind+" ingresada es defectuosa");
            int ind_m_ref = this.obtener_ind_moneda_referencia(this.arr_monedas.get(ind));
            this.arr_monedas.get(ind).setPeso(calcular_peso_aleatorio(ind_m_ref));
            this.setNum_monedas_defectuosas(this.getNum_monedas_defectuosas()+1);
        }
    }
    
    /**
     * Genera un arreglo aleatorio que mezcla monedas no defectuosas y defectuosas
     */
    public void generar_arreglo_aleatorio(){
        // Genera un arreglo de monedas no defectuosas
        
        for(int i = 0; i < this.num_monedas; i++)
        {
            arr_monedas.add(new Moneda(this.getMonedas_referencia()[0].getValor(), this.getMonedas_referencia()[0].getPeso()));
        }

        // Modifica una moneda al azar para que sea defectuosa
        int i = 0;
        while(i < this.num_monedas_defectuosas)
        {
            int ind_md = (int) (Math.random()*this.arr_monedas.size());
            if(this.arr_monedas.get(ind_md).getPeso() == this.getMonedas_referencia()[0].getPeso())
            {
                //System.out.println("Moneda "+ind_md+" modificada");
                this.arr_monedas.get(ind_md).setPeso(this.calcular_peso_aleatorio(0));
                i++;
            }
        }
    }

    public double calcular_peso_aleatorio(int ind_moneda_ref){
        double p = (Math.random()-0.5);

        //System.out.println("(Math.random()-0.5): "+p);
        if(p > 0)
        {
            //System.out.println("Agrega peso");
            return this.getMonedas_referencia()[ind_moneda_ref].getPeso()+(this.tolerancia*3/2)+((Math.random()-0.5)*this.tolerancia);
            //System.out.println("Nuevo peso: "+this.arr_monedas[ind_md].getPeso());
        }
        else
        {
            //System.out.println("Disminuye peso");
            return this.getMonedas_referencia()[ind_moneda_ref].getPeso()-(this.tolerancia*3/2)+((Math.random()-0.5)*this.tolerancia);
            //System.out.println("Nuevo peso: "+this.arr_monedas[ind_md].getPeso());
        }
    }

    public int obtener_ind_moneda_referencia(Moneda moneda){
        for(int i = 0; i < this.getMonedas_referencia().length; i++)
        {
            if(moneda.getValor() == this.getMonedas_referencia()[i].getValor())
            {
                return i;
                //return this.getMonedas_referencia()[i];
            }
        }
        return -1;
    }

    @Override
    public String toString()
    {
        String str = "";
        for(int i = 0; i < this.arr_monedas.size(); i++)
        {
            str += i+": "+this.arr_monedas.get(i).toString() + ", ";
        }
        str += "\n";
        return str;
    }

}
