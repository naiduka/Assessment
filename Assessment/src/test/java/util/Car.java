package util;

public record  Car(String regNum, String make, String model,String bodyStyle,String fuelType,String transmission,String year)
{
        public static Car maptoCar(String carData)
    {
        String[] fields = carData.split(",");
        return new Car(fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6]);
    }
}

