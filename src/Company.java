

public class Company 
{
    private String name;
    private String address;
    private String contactNo;
    
    public Company()
    {
        name = null;
        address = null;
        contactNo = null;
    }
    
    public Company(String n, String a, String c)
    {
        name = n;
        address = a;
        contactNo = c;
    }
    
    @Override
    public String toString()
    {
        String str = "";
        str += "Company Details\n";
        str += "Name : " + name + "\n";
        str += "Address : " + address + "\n";
        str += "Contact Number : " + contactNo + "\n\n";
        return str;
    }
}
