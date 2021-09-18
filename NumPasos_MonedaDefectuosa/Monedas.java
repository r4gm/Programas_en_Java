/**
 * Esta clase define los atributos y metodos de un conjunto de monedas,
 * en donde puede haber monedas no defectuosas y defectusas
 * Una moneda no defectuosa se representa con 1
 * mientras que una moneda defectuosa con -1
 */
public class Monedas {
    private int num_monedas; // Es el numero total de monedas del conjunto
    private int num_monedas_defectuosas; // Es el numero de monedas defectuosas
    private Moneda arr_monedas[]; // Es el arreglo que contiene monedas no defectuosas y defectuosas
    private Moneda moneda_referencia; // Es la moneda considerada como referencia
    private double tolerancia; // Es una cantidad en gramos que define si una moneda es no defectuosa o defectuosa

    /**
     * El constructor para el arreglo de monedas. 
     * @param num_monedas Es el numero de monedas totales del arreglo
     * @param num_monedas_defectuosas Es el numero de monedas defectuosas que hay en el arreglo
     */
    public Monedas(int num_monedas, int num_monedas_defectuosas, Moneda moneda_referencia, double tolerancia){
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
        
        this.moneda_referencia = new Moneda(moneda_referencia.getPeso());
        this.arr_monedas = new Moneda[num_monedas];
        this.tolerancia = tolerancia;

        this.generar_arreglo_aleatorio();
    }

    public int getNum_monedas(){
        return this.num_monedas;
    }

    public int getNum_monedas_defectuosas(){
        return this.num_monedas_defectuosas;
    }

    public Moneda[] getArr_monedas(){
        return this.arr_monedas;
    }

    public Moneda getMoneda_referencia(){
        return this.moneda_referencia;
    }

    public double getTolerancia(){
        return this.tolerancia;
    }

    /**
     * Genera un arreglo aleatorio que mezcla monedas no defectuosas y defectuosas
     */
    public void generar_arreglo_aleatorio(){
        // Genera un arreglo de monedas no defectuosas
        for(int i = 0; i < this.arr_monedas.length; i++)
        {
            arr_monedas[i] = new Moneda(this.getMoneda_referencia().getPeso());
        }

        // Modifica una moneda al azar para que sea defectuosa
        int i = 0;
        while(i < this.num_monedas_defectuosas)
        {
            int ind_md = (int) (Math.random()*this.arr_monedas.length);
            if(this.arr_monedas[ind_md].getPeso() == this.getMoneda_referencia().getPeso())
            {
                //System.out.println("Moneda "+ind_md+" modificada");
                double p = (Math.random()-0.5);
                //System.out.println("(Math.random()-0.5): "+p);
                if(p > 0)
                {
                    //System.out.println("Agrega peso");
                    this.arr_monedas[ind_md].setPeso(this.getMoneda_referencia().getPeso()+(this.tolerancia*3/2)+((Math.random()-0.5)*this.tolerancia));
                    //System.out.println("Nuevo peso: "+this.arr_monedas[ind_md].getPeso());
                    i++;
                }
                else
                {
                    //System.out.println("Disminuye peso");
                    this.arr_monedas[ind_md].setPeso(this.getMoneda_referencia().getPeso()-(this.tolerancia*3/2)+((Math.random()-0.5)*this.tolerancia));
                    //System.out.println("Nuevo peso: "+this.arr_monedas[ind_md].getPeso());
                    i++;
                }
                
            }
        }
    }

    @Override
    public String toString()
    {
        String str = "";
        for(int i = 0; i < this.arr_monedas.length; i++)
        {
            str += i+": "+this.arr_monedas[i].toString() + ", ";
        }
        str += "\n";
        return str;
    }

}
