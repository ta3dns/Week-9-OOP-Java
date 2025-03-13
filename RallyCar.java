/*********************************************
 * Deniz Özmalkoc 
 * OOP-Week 9 Assignment
 * 12.03.2025 Lappeenranta
 * 
 * * RALLY CAR **
 * 
 *********************************************/

abstract class RallyCar {
    protected String make;
    protected String model;
    protected int horsepower;

    public RallyCar(String make, String model, int horsepower){
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    public abstract double calculatePerformance();

    // Getters
    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public int getHorsepower(){
        return horsepower;
    }
}

class GravelCar extends RallyCar{
    public GravelCar(String make, String model, int horsepower){
        super(make, model, horsepower);
    }

        @Override
        public double calculatePerformance(){
            return horsepower * 0.9; // Algorithm to be implemented
        }
}


class AsphaltCar extends RallyCar{
    public AsphaltCar(String make, String model, int horsepower){
        super(make, model, horsepower);
    }

    @Override
    public double calculatePerformance(){
        return horsepower * 1.1; // Algorithm to be implemented. 
    }

}

