package utd.database;

public class Holding {
    
    public Stock stock;
    protected int ammount;

    public Holding(Stock stock, int ammount){
        this.stock = stock;
        this.ammount = ammount;
    }
}
