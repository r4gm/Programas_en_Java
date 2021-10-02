import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Esta clase define los atributos y metodos para una Moneda
 * Esta moneda tiene peso especificada en gramos. 
 */
public class Moneda {
    private int valor; // Es el valor de la moneda
    private double peso; // Es una cantidad en gramos. 

    /**
     * El constructor asigna un peso a una nueva moneda
     * @param peso Indica los gramos que pesa una moneda
     */
    public Moneda(int valor, double peso)
    {
        this.valor = valor;
        this.peso = peso;
    }

    public int getValor()
    {
        return this.valor;
    }

    public void setValor(int valor)
    {
        this.peso = valor;
    }

    public double getPeso()
    {
        return this.peso;
    }

    public void setPeso(double peso)
    {
        this.peso = peso;
    }
    
    @Override
    public String toString(){
        NumberFormat formatter = new DecimalFormat("#0.000");     
        String str = "";
        str += "m: "+this.getValor()+"$ - "+formatter.format(this.peso)+"g";
        return str;
    }
}