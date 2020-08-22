

import java.util.ArrayList;

public class Container 
{
    private String id;
    private String size;
    private ArrayList<Item> list;
    
    public Container()
    {
        id = null;
        size = null;
        list = new ArrayList<>();
    }
    
    public void setId(String i)
    {
        id = i;
    }
    
    public void setSize(String s)
    {
        size = s;
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getSize()
    {
        return size;
    }
    
    public ArrayList<Item> getList()
    {
        return list;
    }
    
    public void addItem(Item i)
    {
        list.add(i);
    }
    
    @Override
    public String toString()
    {
        String str = "";
        str += "Container Details\n";
        str += "ID : " + id + "\n";
        str += "Size : " + size + "\n";
        str += "Item List : \n";
        for(int i=0; i<list.size(); i++)
        {
            str += list.get(i);
        }
        str+="\n";
        return str;
    }
    
    public double calculation()
    {
        double sum = 0.0;
        for(int i=0; i<list.size(); i++)
        {
            sum += list.get(i).calculation();
        }
        return sum;
    }
}
