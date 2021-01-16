/**
 * @author Brian Klein
 * Date: 8/28/17
 * Program: Tenant.java
 * Description: User-defined class
 */
public class Tenant {
    //variables
    private String tenantName;
    private int leaseTerm;
    private double sqrFeet;

    //constructors
    public Tenant() {
    }
    

    public Tenant(String tenantName, int leaseTerm, double sqrFeet) {
        this.tenantName = tenantName;
        this.leaseTerm = leaseTerm;
        this.sqrFeet = sqrFeet;
    }

    //setters and getters
    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public int getLeaseTerm() {
        return leaseTerm;
    }

    public void setLeaseTerm(int leaseTerm) {
        this.leaseTerm = leaseTerm;
    }

    public double getSqrFeet() {
        return sqrFeet;
    }

    public void setSqrFeet(double sqrFeet) {
        this.sqrFeet = sqrFeet;
    }
    
    //method to calculate and return price per square feet
    public double getPricePerSF() {
        if(this.leaseTerm <= 3){
            return 20.5;
        }
        else if(this.leaseTerm <= 5)
            return 18.5;
        else {
            return 15.0;
        }
    }
    
    //method to calculate and return annual rent
    public double getAnnualRent() {
        return this.sqrFeet * getPricePerSF();
    }
    
    //method to calculate and return monthly rent
    public double getMonthlyRent() {
        return getAnnualRent() / 12;
    }

    //toString method
    @Override
    public String toString() {
        return String.format("%-20s %-20d %,-20.1f $%,-20.2f $%,-20.2f $%,-20.2f", tenantName, 
                leaseTerm, sqrFeet, getPricePerSF(), getAnnualRent(), getMonthlyRent());
    }

    
}
    
    


