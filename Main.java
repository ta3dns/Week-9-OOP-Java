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

    RallyCar asphalt1 = new AsphaltCar("Make 1", "Asphalt Model 1", 400);
    RallyCar gravel1 = new GravelCar("Make 1", "Gravel Model 1", 400);
    

    Driver driver1 = new Driver("Sébastien Ogier", "France", asphalt1);
    Driver driver2 = new Driver("Kalle Rovanperä", "Finland", asphalt1);
    Driver driver3 = new Driver("Ott Tänak", "Estonia", gravel1);
    Driver driver4 = new Driver("Thierry Neuville", "Belgium", gravel1);
    
    cm.registerDriver(driver1);
    cm.registerDriver(driver2);
    cm.registerDriver(driver3);
    cm.registerDriver(driver4);

    RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyväskylä");
    race1.recordResult(driver1, 1, 25);
    race1.recordResult(driver3, 2, 18);
    race1.recordResult(driver2, 3, 15);
    race1.recordResult(driver4, 4, 12);

    cm.addRaceResult(race1);

    RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");
    race2.recordResult(driver1, 3, 15);
    race2.recordResult(driver2, 1, 25);
    race2.recordResult(driver3, 4, 12);
    race2.recordResult(driver4, 2, 18);

    cm.addRaceResult(race2);


    int counter = 1;
    for (Driver driver : cm.getDriverStandings()){
        System.out.println(counter + ". " + driver);
        counter++;
    }

    System.out.println("\n===== CHAMPIONSHIP LEADER =====");
    Driver champion = cm.getLeadingDriver();
    System.out.println(champion.getName() + " with " + champion.getPoints() + " points");

    System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
    System.out.println("Total Drivers: " + cm.getTotalDrivers());
    System.out.println("Total Races: " + cm.getTotalRaces());
    System.out.println("Average Points Per Driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(cm.getDriverStandings()));
    System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(cm.getDriverStandings()));
    System.out.println("Total Championship Points: " + cm.getTotalChampionshipPoints());

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

    System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
    System.out.println("Gravel Car Performance: " + gravel1.calculatePerformance());
    System.out.println("Asphalt Car Performance: " + asphalt1.calculatePerformance());
    







}

    
}
