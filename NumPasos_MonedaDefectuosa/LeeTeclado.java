
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Esta clase se puede utilizar para leer datos de consola. Realiza lectura con 
 * buffer. 
 * 
 * @author Fernando Daniel Ramírez Cruz
 * @version 3.0
 * 
 */

public class LeeTeclado 
{
        /**
         * Lee un String. 
         * 
         * @return Regresa un tipo de dato Sting. 
         * @throws IOException Si el tipo de dato es erroneo. 
         */
        
	public String LeeunString() throws IOException
	{
            BufferedReader teclado= new BufferedReader(new InputStreamReader(System.in));
            String Lectura= teclado.readLine();
            return Lectura;
	}
        
        /**
         * Lee un int. 
         * 
         * @return Regresa un tipo de dato int. 
         * @throws IOException Si el tipo de dato es erroneo. 
         * @throws NumberFormatException Si el tipo de dato no es un numero. 
         */
        
	public int LeeunInteger() throws IOException,NumberFormatException
	{
            int num=0;
                try
                {
                         num=Integer.parseInt(LeeunString());
                }
                catch(NumberFormatException e)
                {
                        System.out.println("No es un número entero. Intente nuevamente");
                }
            return num;
	}
        
        /**
         * Lee un double. 
         * 
         * @return Regresa un tipo de dato double. 
         * @throws IOException Si el tipo de dato es erroneo. 
         * @throws NumberFormatException Si el tipo de dato no es un numero. 
         */
        
	public double LeeunDouble() throws IOException,NumberFormatException
	{
            double num=0;
                try
                {
                         num=Double.parseDouble(LeeunString());
                }
                catch(NumberFormatException e)
                {
                        System.out.println("No es un número. Intente nuevamente");
                }
            return num;
	}
        
        /**
         * Lee un booleano
         * 
         * @return Regresa un tipo de dato boolean (Si/No). 
         * @throws IOException Si el tipo de dato es erroneo. 
         */
        
	public boolean LeeSiNo() throws IOException
	{
            String sn="";
            do
            {
                System.out.print("Su opción[S/N]: ");
                sn=LeeunString().toUpperCase();
                switch(sn)
                {
                case "S":
                        return true;
                case "N":
                        return false;
                default:
                        System.out.println("Opción incorrecta");
                        break;
                }

            }while(!sn.equals("S") || !sn.equals("N"));
            return false;
	}
        
        /**
         * Determina si es un int. 
         * 
         * @param str Es un cadena de caracteres de tipo String. 
         * @return Regresa verdadero si el tipo de dato ingresado es un numero. De lo contrario regresa falso. 
         */
        
	public boolean esunNumero(String str) 
        { 
            try 
            {  
                Integer.parseInt(str); 
                return true;
            }
            catch(NumberFormatException e){  
                return false;  
            }  
        }
}