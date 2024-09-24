package util;

public class Constants {
    public static final String inputFolder = "src/test/resources/inputfiles";
    public static final String outputFile = "src/test/resources/cars_confused_output.txt";
    public static final String url = "https://motor.confused.com/CarDetails?nt=1";
    public static final String regex = "\\b([A-Z]{2}[0-9]{2} [A-Z]{3})|"+"([A-Z]{1}[0-9]{1,3} [A-Z]{3})|"+"([A-Z]{2}[0-9]{2}[A-Z]{3})|"+"([A-Z]{3} [0-9]{1,3} [A-Z]{1})\\b";
}
