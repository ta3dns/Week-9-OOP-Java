/*********************************************
 * Deniz Özmalkoc 
 * OOP-Week 9 Assignment
 * 16.03.2025 Lappeenranta
 * 
 * * Championship Statistics **
 * 
 *********************************************/


import java.util.List;


public class ChampionshipStatistics{

    // Calculating average points for the drivers in the race. 
    public static double calculateAveragePointsPerDriver(List<Driver> drivers){
        if (drivers.isEmpty()) return 0;
        int totalPoints = 0;
        
        for (Driver driver : drivers){
            totalPoints += driver.getPoints();
        }

        return(double) totalPoints/drivers.size();
    }


    // Finding the most successfull country.
    public static String findMostSuccessfulCountry(List<Driver> drivers){
        
        // Iterates through every driver in the race, adds the countries' points 
        // together and if it encounters a country with larger points updates the 
        // mostSuccessfullCountry

        if (drivers.isEmpty()) return "No Drivers Available.";

        String mostSuccessfullCountry = null;
        int maxPoints = Integer.MIN_VALUE;

        for (Driver driver : drivers){
            String country = driver.getCountry();

            int totalPoints = driver.getPoints();
            for (Driver thatDriver : drivers){
                if (driver != thatDriver && country.equals(thatDriver.getCountry())){
                    totalPoints += thatDriver.getPoints();
                }
            }

            if (totalPoints > maxPoints){
                maxPoints = totalPoints;
                mostSuccessfullCountry = country;
            }
        }

        return mostSuccessfullCountry;
    }



    // Getters.
    public static int getTotalRacesHeld(){
        return ChampionshipManager.getTotalRaces();
    }
}