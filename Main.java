/*********************************************
 * Deniz Özmalkoc 
 * OOP-Week 9 Assignment
 * 12.03.2025 Lappeenranta
 * 
 * * MAIN **
 * 
 *********************************************/
import java.util.Map;
import java.util.HashMap;

public class Main {

    private static Map<Driver, Integer> raceMap;


    public static void main(String[] args){

        // creating a new Instance of championshipManager
        ChampionshipManager cm = ChampionshipManager.getInstance();

        // Defining the cars
        RallyCar asphalt1 = new AsphaltCar("Toyota", "Yaris GR", 500);
        RallyCar asphalt2 = new AsphaltCar("Hyundai", "i20 N", 490);
        RallyCar asphalt3 = new AsphaltCar("Honda", "Civic Type R", 475);
        RallyCar asphalt4 = new AsphaltCar("Volkswagen", "Golf GTI", 460);

        RallyCar gravel1 = new GravelCar("Subaru", "Impreza WRX", 510);
        RallyCar gravel2 = new GravelCar("Mitsubishi", "Lancer Evolution", 500);
        RallyCar gravel3 = new GravelCar("Peugeot", "208 T16", 495);
        RallyCar gravel4 = new GravelCar("Ford", "Fiesta RS", 480);

        
        // Defining Drivers
        Driver driver1 = new Driver("Sébastien Ogier", "France", asphalt1);
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland", asphalt2);
        Driver driver3 = new Driver("Ott Tänak", "Estonia", asphalt3);
        Driver driver4 = new Driver("Thierry Neuville", "Belgium", asphalt4);
        
        //Registering the drivers in the championship.
        cm.registerDriver(driver1);
        cm.registerDriver(driver2);
        cm.registerDriver(driver3);
        cm.registerDriver(driver4);



        // Creating Race 1 Results
        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyväskylä");

        for (Driver driver : cm.getDriverStandings()){
            int n = 1;
            race1.recordResult(driver, n, pointCalculator.calculatePoints(driver.getCar()));
            n++;
        }
        cm.addRaceResult(race1);

        // They change to gravel surface so the cars change.

        driver1.setCar(gravel1);
        driver2.setCar(gravel2);
        driver3.setCar(gravel3);
        driver4.setCar(gravel4);

        // Creating Race 2 Results
        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        
        for (Driver driver : cm.getDriverStandings()){
            int n = 1;
            race2.recordResult(driver, n, pointCalculator.calculatePoints(driver.getCar()));
            n++;
        }

        cm.addRaceResult(race2);



        // Listing The drivers in the championship
        int counter = 1;
        for (Driver driver : cm.getDriverStandings()){
            System.out.println(counter + ". " + driver);
            counter++;
        }

        // Printing the leader in the chempionship.
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        Driver champion = cm.getLeadingDriver();
        System.out.println(champion.getName() + " with " + champion.getPoints() + " points");

        // Printing the statistics of the championship
        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + cm.getTotalDrivers());
        System.out.println("Total Races: " + cm.getTotalRaces());
        System.out.println("Average Points Per Driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(cm.getDriverStandings()));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(cm.getDriverStandings()));
        System.out.println("Total Championship Points: " + cm.getTotalChampionshipPoints());

        // Printing the results of each race seperately.
        System.out.println("\n===== RACE RESULTS =====");

        int raceCounter = 1;
        for (RallyRaceResult race : cm.getRace()){
            System.out.println("Race: " + race.getRaceName() + " (" + race.getLocation() + ")");

            counter = 1;
            for (Driver driver : race.getResults()){
                System.out.println("    Position " + counter + ": " + driver.getName() + " - " + race.getDriverPoints(driver));
                counter++;
            }
            System.out.println();
            raceCounter++;
        }

        // Calculating and printing the performance of the cars
        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        
        System.out.println("\n===== Asphalt TYPE =====");
        System.out.println(asphalt1 + ": " + asphalt1.calculatePerformance());
        System.out.println(asphalt2 + ": " + asphalt2.calculatePerformance());
        System.out.println(asphalt3 + ": " + asphalt3.calculatePerformance());
        System.out.println(asphalt4 + ": " + asphalt4.calculatePerformance());

        System.out.println("\n===== GRAVEL TYPE =====");
        System.out.println(gravel1 + ": " + gravel1.calculatePerformance());
        System.out.println( gravel2 + ": " + gravel2.calculatePerformance());
        System.out.println( gravel3 + ": " + gravel3.calculatePerformance());
        System.out.println( gravel4 + ": " + gravel4.calculatePerformance());

        
}
 
}

class pointCalculator{
    public static int calculatePoints(RallyCar car){
        return (int) car.calculatePerformance() / 15;
    }
}

