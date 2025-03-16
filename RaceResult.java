/*********************************************
 * Deniz Özmalkoc 
 * OOP-Week 9 Assignment
 * 16.03.2025 Lappeenranta
 * 
 * * RACE RESULT **
 * 
 *********************************************/

import java.util.List;
public interface RaceResult {

    public void recordResult(Driver driver, int position, int points);
    public int getDriverPoints(Driver driver);
    public List<Driver> getResults();

}
