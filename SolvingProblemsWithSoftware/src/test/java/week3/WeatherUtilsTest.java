package week3;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

import java.io.File;

public class WeatherUtilsTest {
    @Test
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord record = WeatherUtils.coldestHourInFile(parser);
        Double coldestTemp = Double.parseDouble(record.get("TemperatureF"));
        System.out.println("coldestTemp: "+coldestTemp);
    }

    @Test
    public void testFileWithColdestTemperature(){
        File f = WeatherUtils.fileWithColdestTemparature();
        WeatherUtils.printFileDetails(f);

    }

    @Test
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestHumidityRecord = WeatherUtils.lowestHumidityInFile(parser);
        Integer humidityValue = Integer.parseInt(lowestHumidityRecord.get("Humidity"));
        String dateTimeUtc = lowestHumidityRecord.get("DateUTC");
        System.out.println("Lowest Humidity was "+humidityValue+" at "+dateTimeUtc);
    }

    @Test
    public void testLowestHumidityInManyFiles(){
        CSVRecord record = WeatherUtils.lowestHumidityInManyFiles();
        Integer humidity = Integer.parseInt(record.get("Humidity"));
        String dateTimeUtc = record.get("DateUTC");
        System.out.println("Lowest Humidity was "+humidity+" at "+dateTimeUtc);
    }

    @Test
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        Double averageTemp = WeatherUtils.averageTemperatureInFile(parser);
        System.out.println("averageTemp: " +averageTemp);
    }

    @Test
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        Integer humidityValue = 80;
        Double averageTemp = WeatherUtils.averageTemperatureWithHighHumidityInFile(parser, humidityValue);
        if(averageTemp != 0.0){
            System.out.println("Average temp when humidity >= "+humidityValue+" is "+averageTemp);
        } else{
            System.out.println("No temperatures with humidity >= "+humidityValue);
        }
    }

}
