/**
 * Esta clase define los atributos y metodos para una Moneda
 * Esta moneda tiene peso especificada en gramos. 
 */
public class Moneda {
    private double peso; // Es una cantidad en gramos. 

    /**
     * El constructor asigna un peso a una nueva moneda
     * @param peso Indica los gramos que pesa una moneda
     */
    public Moneda(double peso)
    {
        this.peso = peso;
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
        String str = "";
        str += "p: "+this.peso;
        return str;
    }
}