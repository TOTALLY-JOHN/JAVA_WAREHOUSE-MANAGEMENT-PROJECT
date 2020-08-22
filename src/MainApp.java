

import java.util.Scanner;
import java.util.ArrayList;

public class MainApp 
{
    public static void main(String[] args)
    {
        ArrayList<Warehouse> list = new ArrayList<>();
        Scanner read = new Scanner(System.in);
        int input;
        
        do
        {
            System.out.println("Please, choose a menu.");
            System.out.println("1) Create a new Warehouse object.");
            System.out.println("2) Add a Container to an existing Warehouse.");
            System.out.println("3) Show the total value of a warehouse.");
            System.out.println("4) Show the total value of a container in a warehouse.");
            System.out.println("5) Show the total value of an item in a container.");
            System.out.println("6) Display all Warehouse information.");
            System.out.println("7) Display all Containers in a Warehouse.");
            System.out.println("8) Display all Items in a Container.");
            System.out.println("9) Exit the program.");
            input = read.nextInt();
            read.nextLine();
            
            switch(input)
            {
                case 1: // 1) Create a new Warehouse object
                {
                    System.out.print("Input a warehouse name : ");
                    String warehouseName = read.nextLine();
                    
                    System.out.print("Input a warehouse location : ");
                    String warehouseLocation = read.nextLine();
                    
                    System.out.print("Input a company name : ");
                    String companyName = read.nextLine();
                    
                    System.out.print("Input a company address : ");
                    String companyAddress = read.nextLine();
                    
                    System.out.print("Input a company contact number : ");
                    String companyContactNo = read.nextLine();
                    
                    // CREATE A COMPANY OBJECT USING NON-DEFAULT CONSTRUCTOR
                    Company company = new Company(companyName, companyAddress, companyContactNo);
                    
                    // CREATE A WAREHOUSE OBJECT USING DEFAULT-CONSTRUCTOR AND SETTERS
                    Warehouse warehouse = new Warehouse();
                    warehouse.setName(warehouseName);
                    warehouse.setLocation(warehouseLocation);
                    warehouse.setOwner(company);
                    
                    list.add(warehouse); // INSERT INTO THE WAREHOUSE LIST
                    
                    break;
                }
                
                case 2: // 2) Add a Container to an existing Warehouse
                {
                    if(list.isEmpty())
                    {
                        System.out.println("List is empty! You should add a warehouse object first!");
                    }
                    else
                    {
                        System.out.print("Input a warehouse name : ");
                        String warehouseName = read.nextLine();
                        
                        for(int i=0; i<list.size(); i++)
                        {
                            if(warehouseName.equals(list.get(i).getName()))
                            {
                                ArrayList<Container> containerList = new ArrayList<>();
                                int containerInput, itemInput;
                                
                                do
                                {
                                    System.out.print("Input a container ID : ");
                                    String containerId = read.nextLine();

                                    System.out.print("Input a container size : ");
                                    String containerSize = read.nextLine();

                                    // MAKE A CONTAINER OBJECT USING DEFAULT-CONSTRUCTOR AND SETTERS
                                    Container container = new Container();
                                    container.setId(containerId);
                                    container.setSize(containerSize);
                                    
                                    do
                                    {
                                        System.out.print("Input an item ID : ");
                                        String itemId = read.nextLine();
                                        
                                        System.out.print("Input an item description : ");
                                        String itemDesc = read.nextLine();
                                        
                                        System.out.print("Input an item price : ");
                                        double itemPrice = read.nextDouble();
                                        while(itemPrice < 0)
                                        {
                                            System.out.println("Price cannot be below 0.");
                                            System.out.print("Input an item price again : ");
                                            itemPrice = read.nextDouble();
                                        }
                                        read.nextLine();
                                        
                                        System.out.print("Input an item quantity : ");
                                        int itemQuantity = read.nextInt();
                                        while(itemQuantity < 0)
                                        {
                                            System.out.println("Item Quantity cannot be below 0.");
                                            System.out.print("Input an item quantity again : ");
                                            itemQuantity = read.nextInt();
                                        }
                                        read.nextLine();
                                        
                                        System.out.print("Input a supplier's company name : ");
                                        String supplierName = read.nextLine();
                                        
                                        System.out.print("Input a supplier's company address : ");
                                        String supplierAddress = read.nextLine();
                                        
                                        System.out.print("Input a supplier's company contact number : ");
                                        String supplierContactNo = read.nextLine();
                                        
                                        Company supplier = new Company(supplierName, supplierAddress, supplierContactNo);
                                        Item item = new Item();
                                        item.setId(itemId);
                                        item.setDesc(itemDesc);
                                        item.setPrice(itemPrice);
                                        item.setQuantity(itemQuantity);
                                        item.setSupplier(supplier);
                                        container.addItem(item);
                                        System.out.print("Do you want to continue to create an item? If yes, input 1. If no, input 0 : ");
                                        itemInput = read.nextInt();
                                        read.nextLine();
                                    }
                                    while(itemInput != 0);

                                    containerList.add(container);
                                    System.out.print("Do you want to continue to create a container? If yes, input 1. If no, input 0 : ");
                                    containerInput = read.nextInt();
                                    read.nextLine();
                                } 
                                while(containerInput != 0);

                                // INSERT IT INTO THE WAREHOUSE OBJECT FOUND.
                                list.get(i).setList(containerList);
                                break;
                            }
                        }
                    }
                    
                    break;
                }
                
                case 3: // 3) Show the total value of a warehouse
                {
                    if(list.isEmpty())
                    {
                        System.out.println("List is empty! You should add a warehouse object first!");
                    }
                    else
                    {
                        System.out.print("Input a warehouse name to search : ");
                        String warehouseSearchName = read.nextLine();
                        for(int i=0; i<list.size(); i++)
                        {
                            if(warehouseSearchName.equals(list.get(i).getName()))
                            {
                                System.out.println("The total of value of this warehouse : " + list.get(i).calculation());
                                break;
                            }
                        }
                    }
                    
                    break;
                }
                
                case 4: // 4) Show the total value of a container in a warehouse
                {
                    if(list.isEmpty())
                    {
                        System.out.println("List is empty! You should add a warehouse object first!");
                    }
                    else
                    {
                        System.out.print("Input a warehouse name to search : ");
                        String warehouseSearchName = read.nextLine();
                        for(int i=0; i<list.size(); i++)
                        {
                            if(warehouseSearchName.equals(list.get(i).getName()))
                            {
                                System.out.print("Input a container ID to search : ");
                                String containerSearchId = read.nextLine();
                                for(int j=0; j<list.get(i).getList().size(); j++)
                                {
                                    if(containerSearchId.equals(list.get(i).getList().get(j).getId()))
                                    {
                                         System.out.println("The total of value of this container : " + list.get(i).getList().get(j).calculation());
                                    }
                                }
                                break;
                            }
                        }
                    }
                    
                    break;
                }
                
                case 5: // 5) Show the total value of an item in a container
                {
                    if(list.isEmpty())
                    {
                        System.out.println("List is empty! You should add a warehouse object first!");
                    }
                    else
                    {
                        System.out.print("Input a warehouse name to search : ");
                        String warehouseSearchName = read.nextLine();
                        for(int i=0; i<list.size(); i++)
                        {
                            if(warehouseSearchName.equals(list.get(i).getName()))
                            {
                                System.out.print("Input a container ID to search : ");
                                String containerSearchId = read.nextLine();
                                
                                for(int j=0; j<list.get(i).getList().size(); j++)
                                {
                                    if(containerSearchId.equals(list.get(i).getList().get(j).getId()))
                                    {
                                        System.out.print("Input a item ID to search : ");
                                        String itemSearchId = read.nextLine();
                                        
                                        for(int k=0; k<list.get(i).getList().get(j).getList().size(); k++)
                                        {
                                            if(itemSearchId.equals(list.get(i).getList().get(j).getList().get(k).getId()))
                                            {
                                                 System.out.println("The total of value of this item : " + list.get(i).getList().get(j).getList().get(k).calculation());
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                        }
                    }
                    
                    break;
                }
                
                case 6: // 6) Display all Warehouse information
                {
                    if(list.isEmpty())
                    {
                        System.out.println("List is empty! You should add a warehouse object first!");
                    }
                    else
                    {
                        for(int i=0; i<list.size(); i++)
                        {
                            System.out.println(list.get(i));
                        }
                    }
                    
                    break;
                }
                
                case 7: // 7) Display all Containers in a Warehouse
                {
                    if(list.isEmpty())
                    {
                        System.out.println("List is empty! You should add a warehouse object first!");
                    }
                    else
                    {
                        System.out.print("Input a warehouse name to search : ");
                        String warehouseSearchName = read.nextLine();
                        for(int i=0; i<list.size(); i++)
                        {
                            if(warehouseSearchName.equals(list.get(i).getName()))
                            {
                                for(int j=0; j<list.get(i).getList().size(); j++)
                                {
                                    System.out.println(list.get(i).getList().get(j));
                                }
                                break;
                            }
                        }
                    }
                    
                    break;
                }
                
                case 8: // 8) Display all Items in a Container.
                {
                    if(list.isEmpty())
                    {
                        System.out.println("List is empty! You should add a warehouse object first!");
                    }
                    else
                    {
                        System.out.print("Input a warehouse name to search : ");
                        String warehouseSearchName = read.nextLine();
                        for(int i=0; i<list.size(); i++)
                        {
                            if(warehouseSearchName.equals(list.get(i).getName()))
                            {
                                System.out.print("Input a container ID to search : ");
                                String containerSearchId = read.nextLine();
                                for(int j=0; j<list.get(i).getList().size(); j++)
                                {
                                    if(containerSearchId.equals(list.get(i).getList().get(j).getId()))
                                    {
                                        for(int k=0; k<list.get(i).getList().get(j).getList().size(); k++)
                                        {
                                            System.out.println(list.get(i).getList().get(j).getList().get(k));
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    
                    break;
                }
                
                case 9: // Exit the program
                {
                    System.out.println("Thank you for using the program.");
                    break;
                }
                
                default: // Validation of input
                {
                    System.out.println("Your input is wrong!");
                }
            }
        }
        while(input != 9);
    }
}
