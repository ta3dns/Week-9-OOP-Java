/*********************************************
 * Deniz Özmalkoc 
 * OOP-Week 9 Assignment
 * 12.03.2025 Lappeenranta
 * 
 * * MAIN **
 * 
 *********************************************/

public class Main {

    public static void main(String[] args){

        RallyCar gravel1 = new GravelCar("test", "Test", 500);
        RallyCar asphalt1 = new AsphaltCar("T.A. Make", "T.A Model", 200);

        System.out.println("Gravel Car");
        System.out.println(gravel1.getMake());
        System.out.println(gravel1.getModel());
        System.out.println(gravel1.calculatePerformance());

        System.out.println("Asphalt Car");
        System.out.println(asphalt1.getMake());
        System.out.println(asphalt1.getModel());
        System.out.println(asphalt1.calculatePerformance());

        Driver driver1 = new Driver("John Doe", "UK", gravel1);
        Driver driver2 = new Driver("Jane Doe", "USA", asphalt1);
        
        System.out.println("Driver 1");
        System.out.println(driver1);
        System.out.println(driver1.getCar().calculatePerformance());
        
        System.out.println("Driver 2");
        System.out.println(driver2);
        System.out.println(driver2.getCar().calculatePerformance());
        


    }

    
}
