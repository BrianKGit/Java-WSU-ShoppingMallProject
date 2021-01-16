/**
 * @author Brian Klein
 * Date: 8/30/17
 * Program: ShoppingMall.java
 * Description: Client program
 */
import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

public class ShoppingMall {
    
    public static void main(String [] args) throws IOException {
            
        //declare an array of objects
        ArrayList<Tenant> list = new ArrayList<Tenant>();
        
        String fileName;
        
        while(true) {
            
            //create a JFileChooser object
            JFileChooser openChooser = new JFileChooser("./"); //current folder
            
            int status = openChooser.showOpenDialog(null);
            
            if( status == JFileChooser.APPROVE_OPTION) { //open button
                
                fileName = openChooser.getSelectedFile().getAbsolutePath();
                break;
                
            }//end if
            
        }//end while
        
        //read data file
        Scanner inFile = new Scanner( new FileReader( fileName));
        
        //remove the data file heading
        for(int i=0; i<3; i++) {
            inFile.next();
        }
        
        //read data
        int count = 0;
        while( inFile.hasNext()) {
            String tenantName = inFile.next();
            int leaseTerm = inFile.nextInt();
            double sqrFeet = inFile.nextDouble();
            
            //create an object and place it into the array
            list.add(new Tenant( tenantName, leaseTerm, sqrFeet));
            
            count++;
        }//end while
        
        boolean flag = true;
        int userCommand;
        Scanner console = new Scanner(System.in);
        
        while(flag){
            
            displayMenu();
            
            userCommand = console.nextInt();
            
            switch(userCommand) {
                case 1:
                    System.out.println("Tenant:              " + 
                            "Lease Term:          " + 
                            "Square Feet:         " +
                            "Price/Square Foot:    " + 
                            "Annual Rent:          " + 
                            "Monthly Rent:");
                    for(int i=0; i<list.size(); i++) {
                        System.out.println(list.get(i).toString());
                    }
                    break;
                case 2:
                    double sum = 0.0;
                    
                    for(int i=0; i<list.size(); i++) {
                        sum += list.get(i).getAnnualRent();
                    }
                    double averageAnnual = sum / list.size();
                    System.out.printf("%nAverage annual rent: $%,.2f %n", averageAnnual);
                    break;
                    
                case 3:
                    //find the highest monthly rent
                    int maxIndex = 0;
                    
                    for(int i=1; i<list.size(); i++) {
                        if(list.get(maxIndex).getMonthlyRent() < list.get(i).getMonthlyRent()) {
                            maxIndex = i;
                        }
                    }
                    
                    System.out.println("Tenant:              " + 
                            "Lease Term:          " + 
                            "Square Feet:         " +
                            "Price/Square Foot:    " + 
                            "Annual Rent:          " + 
                            "Monthly Rent:");
                    System.out.println(list.get(maxIndex));
                    
                    break;
                    
                case 4:
                    System.out.print("\nEnter a tenant to search: ");
                    String name = console.next();
                    
                    int foundIndex = -1;
                    for(int i=0; i<list.size(); i++) {
                        if(list.get(i).getTenantName().equalsIgnoreCase(name)) {
                            foundIndex = i;
                            break;
                        }
                    }
                    if(foundIndex == -1) {
                        System.out.println(name + " is not found.");
                    }
                    else{
                        System.out.println("Tenant:              " + 
                            "Lease Term:          " + 
                            "Square Feet:         " +
                            "Price/Square Foot:    " + 
                            "Annual Rent:          " + 
                            "Monthly Rent:");
                        System.out.println(list.get(foundIndex));
                    }
                    break;
                    
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid command, try again.");
            }//end switch
            
        }//end while
        
    }//end main
    
    private static void displayMenu() {
        
        System.out.print("\n\n"
               + "1 -- Output the Shopping Mall information.\n"
               + "2 -- Output the average annual rent.\n"
               + "3 -- Find the highest monthly rent.\n"
               + "4 -- Search a tenant.\n"
               + "0 -- Exit\n\n"
               + "Enter command:");
        
    }
    
}//end class
