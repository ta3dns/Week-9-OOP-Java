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

        ChampionshipManager cm = ChampionshipManager.getInstance();

    RallyCar asphalt1 = new AsphaltCar("Make 1", "Asphalt Model 1", 350);
    RallyCar asphalt2 = new AsphaltCar("Make 2", "Asphalt Model 2", 750);
    RallyCar gravel1 = new GravelCar("Make 1", "Gravel Model 1", 400);
    RallyCar gravel2 = new GravelCar("Make 2", "Gravel Model 2", 800);
    

    Driver driver1 = new Driver("John Doe", "USA", asphalt1);
    Driver driver2 = new Driver("Jane Smith", "UK", asphalt2);
    Driver driver3 = new Driver("Carlos Ruiz", "Spain", gravel1);
    Driver driver4 = new Driver("Emma Jhonson", "Austuralia", gravel2);
    
    cm.registerDriver(driver1);
    cm.registerDriver(driver2);
    cm.registerDriver(driver3);
    cm.registerDriver(driver4);

    RallyRaceResult race1 = new RallyRaceResult("Finland Rally", "Lappeenranta");
    race1.recordResult(driver1, 1, 10);
    race1.recordResult(driver2, 1, 8);
    race1.recordResult(driver3, 3, 6);
    race1.recordResult(driver4, 4, 4);

    cm.addRaceResult(race1);

    RallyRaceResult race2 = new RallyRaceResult("UK Rally", "London");
    race1.recordResult(driver1, 2, 8);
    race1.recordResult(driver2, 1, 10);
    race1.recordResult(driver3, 3, 6);
    race1.recordResult(driver4, 4, 4);

    cm.addRaceResult(race2);


    System.out.println("Statistics:");
    System.out.println("Total Drivers: " + cm.getTotalDrivers());
    System.out.println("Total Races Hels: " +ChampionshipManager.getTotalRaces());
    System.out.println("Average Races Per Driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(cm.getDriverStandings()));
    System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(cm.getDriverStandings()));
    System.out.println("Total Championship Points: " + ChampionshipManager.getTotalChampionshipPoints());
}

    
}
