

public class Item 
{
    private String id;
    private String desc;
    private double price;
    private int quantity;
    private Company supplier;
    
    public Item()
    {
        id = null;
        desc = null;
        price = 0.0;
        quantity = 0;
        supplier = null;
    }
    
    public void setId(String i)
    {
        id = i;
    }
    
    public void setDesc(String d)
    {
        desc = d;
    }
    
    public void setPrice(double p)
    {
        price = p;
    }
    
    public void setQuantity(int q)
    {
        quantity = q;
    }
    
    public void setSupplier(Company s)
    {
        supplier = s;
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getDesc()
    {
        return desc;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public Company getSupplier()
    {
        return supplier;
    }
    
    @Override
    public String toString()
    {
        String str = "";
        str += "Item Details\n";
        str += "ID : " + id + "\n";
        str += "Description : " + desc + "\n";
        str += "Price : " + price + "\n";
        str += "Quantity : " + quantity + "\n";
        return str;
    }
    
    public double calculation()
    {
        return price * quantity;
    }
}
