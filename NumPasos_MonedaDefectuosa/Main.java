
import java.io.IOException;

/**
 * Calculo del numero de pasos para obtener una moneda defectuosa
 * por: Fernando Daniel Ramirez
 * Calcula de manera teorica y experimental el numero de pasos promedio 
 * para encontrar una moneda defectuosa dado un conjunto de monedas segun su peso
 */
public class Main {

    public static void main(String args[]) throws IOException{

        Monedas conjunto1 = inicializacion();

        LeeTeclado entrada = new LeeTeclado();

        conjunto_encontrar_moneda_defectuosa(conjunto1);

        int opcion = 0;

        do{
            System.out.print("Ingresa una moneda de 5 pesos (escribe 5) o termina el programa (escribe lo que sea): ");
            opcion = entrada.LeeunInteger();

            if(opcion == 5)
            {
                System.out.println("Se agrega una nueva moneda de 5 pesos");
                conjunto1.agregar_moneda(conjunto1.getMonedas_referencia()[1], Math.random());
                System.out.println("Ahora hay "+conjunto1.getNum_monedas()+" monedas, de las cuales "+conjunto1.getNum_monedas_defectuosas()+" son defectuosas");
                System.out.println(conjunto1.toString());
                conjunto_encontrar_moneda_defectuosa(conjunto1);
            }
        }while(opcion == 5);
    }

    /**
     * Este metodo prueba la cantidad promedio de pasos para obtener un moneda defectousa de un
     * conjunto de monedas. De todas las monedas en este conjunto, solo algunas
     * tienen defectos. Teóricamente, el numero de pasos de obtener una moneda defectuosa
     * es: (numero de monedas totales) / (numero de monedas defectuosas)
     */
    public static void conjunto_encontrar_moneda_defectuosa(Monedas conjunto1) {
        //Monedas conjunto1 = inicializacion();

        // Imprime el valor de pasos calculado teoricamente
        System.out.println("Para un conjunto de "+conjunto1.getNum_monedas()+" monedas con "+conjunto1.getNum_monedas_defectuosas()+" monedas defectuosas:");
        System.out.println("Se espera encontrar una moneda defectuosa cada "+(1.0*conjunto1.getNum_monedas()/conjunto1.getNum_monedas_defectuosas())+" pasos.");

        // Se define el numero de iteraciones para encontrar experimentalmente el numero de pasos
        int num_iteraciones = 10, sum_num_pasos = 0;

        // Suma el numero de pasos que le tomo por cada iteracion
        for(int i = 0; i < num_iteraciones; i++)
        {
            sum_num_pasos += encontrar_moneda_defectuosa(conjunto1);
        }

        // Divide la suma de pasos de todas las iteaciones entre el numero de iteraciones
        System.out.println("Se realizaron "+num_iteraciones+" pruebas");
        System.out.println("En promedio se encontró una pieza defectusa cada "+(1.0*sum_num_pasos/num_iteraciones)+" pasos.");

    }

    public static Monedas inicializacion(){
        Moneda[] monedas_referencia = new Moneda[2]; // Crea un arreglo de monedas de referencia
        monedas_referencia[0] = new Moneda(10,10.329); // Se define la moneda de referencia de 10 pesos, primero su valor (10 pesos) y luego su peso
        monedas_referencia[1] = new Moneda(5,7.07); // Se define la moneda de referencia de 5 pesos, primero su valor (5 pesos) y luego su peso

        double tolerancia = 0.2; // Indica que la tolerancia es 50+2 gramos y 50-2 gramos para considerar una moneda no defectuosa

        //System.out.println("Moneda referencia creada");

        // Crea un conjunto de monedas con un determinado numero de monedas defectuosas. Se agrega la moneda de referencia y la tolerancia 
        Monedas conjunto1 = new Monedas(6,2, monedas_referencia,tolerancia);
        System.out.println("Conjunto de"+conjunto1.getNum_monedas()+" monedas creado con "+conjunto1.getNum_monedas_defectuosas()+" monedas defectuosas");
        System.out.println(conjunto1.toString());

        return conjunto1;
    }


    /**
     * Este metodo encuentra una moneda defectuosa dado un conjunto de monedas
     * @param conjunto Es el conjunto de monedas que contiene monedas no defectuosas y defectuosas
     * @return El numero de pasos que le tomo encontrar una moneda defectuosa
     */
    public static int encontrar_moneda_defectuosa(Monedas conjunto){
        int ind = 0, ind_ref = 0, num_pasos = 0;
        boolean encontrado = false;

        while(!encontrado){
            // Elige una moneda al azar y prueba si es defectuosa con base en la comparacion de su peso con respecto a una moneda de referencia.
            // Al terminar la revision, se devuelve la moneda al conjunto (no se excluye del conjunto)
            ind = (int)(Math.random()*conjunto.getArr_monedas().size());
            //System.out.println("ind: "+ind);
            num_pasos++;

            ind_ref = conjunto.obtener_ind_moneda_referencia(conjunto.getArr_monedas().get(ind));

            if(Math.abs(conjunto.getArr_monedas().get(ind).getPeso() - conjunto.getMonedas_referencia()[ind_ref].getPeso()) > conjunto.getTolerancia())
            {
                encontrado = true;
            }
        }
        System.out.println("En "+num_pasos+" paso(s) se encontró que la moneda "+ind+" es defectuosa con peso: "+conjunto.getArr_monedas().get(ind).getPeso());
        return num_pasos;
    }
}
