

import java.util.ArrayList;

public class Warehouse 
{
    private String name;
    private String location;
    private Company owner;
    private ArrayList<Container> list;
    
    public Warehouse()
    {
        name = null;
        location = null;
        owner = null;
        list = new ArrayList<>();
    }
    
    public void setName(String n)
    {
        name = n;
    }
    
    public void setLocation(String l)
    {
        location = l;
    }
    
    public void setOwner(Company o)
    {
        owner = o;
    }
    
    public void setList(ArrayList<Container> c)
    {
        list = c;
    }
    
    public String getName()
    {
        return name;
    }
    
    public ArrayList<Container> getList()
    {
        return list;
    }
    
    @Override
    public String toString() 
    {
        String str = "";
        str += "Warehouse Information\n";
        str += "Name : " + name + "\n";
        str += "Location : " + location + "\n";
        str += "Owner : " + owner + "\n";
        str += "Container List : \n";
        for(int i=0; i<list.size(); i++)
        {
            str += list.get(i);
        }
        str += "\n";
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
