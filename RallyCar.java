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

    // Constructor
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

    @Override
    public String toString(){
        return carFormatter.format(this);
    }
}

// Gravel Car class with its own performance algorithm.
class GravelCar extends RallyCar{
    public GravelCar(String make, String model, int horsepower){
        super(make, model, horsepower);
    }

        @Override
        public double calculatePerformance(){
            return horsepower * 0.9; // Algorithm to be implemented
        }
}

// Asphalt car class with its own performance algoritm
class AsphaltCar extends RallyCar{
    public AsphaltCar(String make, String model, int horsepower){
        super(make, model, horsepower);
    }

    @Override
    public double calculatePerformance(){
        return horsepower * 1.1; // Algorithm to be implemented. 
    }

}

// new class to comply with SOLID, formats the driver to be used in toString later.
class carFormatter {
    public static String format(RallyCar car){
        return car.getMake() +
        " " + car.getModel() + 
        " (" + car.getHorsepower() + ")";
    }
}

