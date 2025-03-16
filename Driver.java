/*********************************************
 * Deniz Özmalkoc 
 * OOP-Week 9 Assignment
 * 12.03.2025 Lappeenranta
 * 
 * * DRIVER **
 * 
 *********************************************/

public class Driver {

    private String name;
    private String country;
    private int points;
    private RallyCar car;

    // Constructor
    public Driver(String name, String country, RallyCar car){
        this.name = name;
        this.country = country;
        this.car = car;
    }

    // Getters
    public String getName(){
        return name;
    }
    
    public String getCountry(){
        return country;
    }

    public RallyCar getCar(){
        return car;
    }

    public int getPoints(){
        return points;
    }

    // Setters
    public void setCar(RallyCar car){
        this.car = car;
    }

    // Method to add points
    public void addPoints(int points){
        this.points += points;
    }

    // toString override for displaying driver info
    @Override
    public String toString(){
        return driverFormatter.format(this);
    }  
}

class driverFormatter {
    public static String format(Driver driver){
        return driver.getName() +
        " (" + driver.getCountry() + 
        "): " + driver.getPoints() + " points";
    }
}