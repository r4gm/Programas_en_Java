/**
 * Calculo del numero de pasos para obtener una moneda defectuosa
 * por: Fernando Daniel Ramirez
 * Calcula de manera teorica y experimental el numero de pasos promedio 
 * para encontrar una moneda defectuosa dado un conjunto de monedas
 */

public class Main {
    /**
     * Este programa prueba la cantidad promedio de pasos para obtener un moneda defectousa de un
     * conjunto de monedas. De todas las monedas en este conjunto, solo algunas
     * tienen defectos. Teóricamente, el numero de pasos de obtener una moneda defectuosa
     * es: (numero de monedas totales) / (numero de monedas defectuosas)
     */
    public static void main(String args[]) {
        // Crea un conjunto de monedas con un determinado numero de monedas defectuosas
        Monedas conjunto1 = new Monedas(200,20);

        // Imprime el valor de pasos calculado teoricamente
        //System.out.println(conjunto1.toString());
        System.out.println("Para un conjunto de "+conjunto1.getNum_monedas()+" monedas con "+conjunto1.getNum_monedas_defectuosas()+" monedas defectuosas:");
        System.out.println("Se espera encontrar una moneda defectuosa cada "+(1.0*conjunto1.getNum_monedas()/conjunto1.getNum_monedas_defectuosas())+" pasos.");

        // Se define el numero ddddddde iteraciones para encontrar experimentalmente el numero de pasos
        int num_iteraciones = 10000000, sum_num_pasos = 0;

        // Suma el numero de pasos que le tomo por cada iteracion
        for(int i = 0; i < num_iteraciones; i++)
        {
            sum_num_pasos += encontrar_moneda_defectuosa(conjunto1);
        }

        // Divide la suma de pasos de todas las iteaciones entre el numero de iteraciones
        System.out.println("Se realizaron "+num_iteraciones+" pruebas");
        System.out.println("En promedio se encontró una pieza defectusa cada "+(1.0*sum_num_pasos/num_iteraciones)+" pasos.");

    }

    /**
     * Este metodo encuentra una moneda defectuosa dado un conjunto de monedas
     * @param conjunto Es el conjunto de monedas que contiene monedas no defectuosas y defectuosas
     * @return El numero de pasos que le tomo encontrar una moneda defectuosa
     */
    public static int encontrar_moneda_defectuosa(Monedas conjunto){
        int ind = 0, num_pasos = 0;
        boolean encontrado = false;

        while(!encontrado){
            // Elige una moneda al azar y prueba si es defectuosa.
            // Al terminar la revision, se devuelve la moneda al conjunto (no se excluye del conjunto)
            ind = (int)(Math.random()*conjunto.getArr_monedas().length);
            //System.out.println("ind: "+ind);
            num_pasos++;
            if(conjunto.getArr_monedas()[ind] == -1)
            {
                encontrado = true;
            }
        }
        return num_pasos;
    }
}
