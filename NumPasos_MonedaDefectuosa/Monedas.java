/**
 * Esta clase define los atributos y metodos de un conjunto de monedas,
 * en donde puede haber monedas no defectuosas y defectusas
 * Una moneda no defectuosa se representa con 1
 * mientras que una moneda defectuosa con -1
 */
public class Monedas {
    private int num_monedas; // Es el numero total de monedas del conjunto
    private int num_monedas_defectuosas; // Es el numero de monedas defectuosas
    private int arr_monedas[]; // Es el arreglo que contiene monedas no defectuosas y defectuosas

    /**
     * El constructor para el arreglo de monedas. 
     * @param num_monedas Es el numero de monedas totales del arreglo
     * @param num_monedas_defectuosas Es el numero de monedas defectuosas que hay en el arreglo
     */
    public Monedas(int num_monedas, int num_monedas_defectuosas){
        this.num_monedas = num_monedas;
        if(num_monedas_defectuosas > 0)
        {
            this.num_monedas_defectuosas = num_monedas_defectuosas;
        }
        else
        {
            System.out.println("Debe de haber al menos 1 moneda defectuosa en el conjunto");
            this.num_monedas_defectuosas = num_monedas_defectuosas;
        }
        
        this.arr_monedas = new int[num_monedas];
        this.generar_arreglo_aleatorio();
    }

    public int getNum_monedas(){
        return this.num_monedas;
    }

    public int getNum_monedas_defectuosas(){
        return this.num_monedas_defectuosas;
    }

    public int[] getArr_monedas(){
        return this.arr_monedas;
    }

    /**
     * Genera un arreglo aleatorio que mezcla monedas no defectuosas y defectuosas
     */
    public void generar_arreglo_aleatorio(){
        for(int i = 0; i < this.arr_monedas.length; i++)
        {
            arr_monedas[i] = 1;
        }

        int i = 0;
        while(i < this.num_monedas_defectuosas)
        {
            int ind_md = (int) (Math.random()*this.arr_monedas.length);
            if(this.arr_monedas[ind_md] != -1)
            {
                this.arr_monedas[ind_md] = -1;
                i++;
            }
        }
    }

    @Override
    public String toString()
    {
        String str = "";
        for(int i = 0; i < this.arr_monedas.length; i++)
        {
            str += this.arr_monedas[i] + ", ";
        }
        str += "\n";
        return str;
    }

}
