package util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadCarDetails {

    private static final Logger logger = LoggerFactory.getLogger(ReadCarDetails.class);

    public List<Car> readActualCarDetails() {
        try {
            Path filePath = Path.of(Constants.outputFile);
            List<String> data = Files.readAllLines(filePath);
            return data.stream().skip(1).map(Car::maptoCar).collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("Exception while reading expected car details");
        }
        return null;

    }

    public List<String> readInputData() {
        List<String> listofRegNum = new ArrayList<>();
        try {
            String regex = Constants.regex;
            Path folderName = Path.of(Constants.inputFolder);

            Pattern pattern = Pattern.compile(regex);
            try(Stream<Path> files = Files.walk(folderName)){
                files.filter(Files :: isRegularFile).forEach(file ->{
                    List<String> inputData = null;
                    try {
                        inputData = Files.readAllLines(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    for(String input : inputData){
                        Matcher matcher = pattern.matcher(input);
                        while(matcher.find()){
                            listofRegNum.add(matcher.group().replace(" ",""));
                        }
                    }
                });
            }

        } catch (Exception e) {
            logger.error("\u001B[31m" + "Exception while reading input car details" + "\u001B[0m");
        }
        return listofRegNum;

    }


}
