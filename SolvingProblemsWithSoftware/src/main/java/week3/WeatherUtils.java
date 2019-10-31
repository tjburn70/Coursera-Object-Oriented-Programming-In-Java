package week3;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WeatherUtils {

    public static CSVRecord getColdestTempBetweenTwoCsvRecords(CSVRecord currentRecord, CSVRecord coldestRecordSoFar){
        Double currentTemp = Double.parseDouble(currentRecord.get("TemperatureF"));
        Double coldestTempSoFar = Double.parseDouble(coldestRecordSoFar.get("TemperatureF"));
        if(coldestTempSoFar > currentTemp && (coldestTempSoFar != -9999) && (currentTemp != -9999)){
            coldestRecordSoFar=currentRecord;
        }
        return coldestRecordSoFar;
    }

    public static CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestSoFar = null;
        for(CSVRecord currentRecord : parser){
            if(coldestSoFar == null){
                coldestSoFar = currentRecord;
            }
            coldestSoFar = getColdestTempBetweenTwoCsvRecords(currentRecord, coldestSoFar);
        }
        return coldestSoFar;
    }

    public static void printFileDetails(File file){
        String fileName = file.getName();
        System.out.println("File of interest: "+fileName);
        FileResource fr = new FileResource(file);
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldestRecord = coldestHourInFile(parser);
        Double coldestTempInFile = Double.parseDouble(coldestRecord.get("TemperatureF"));
        String dateTime = coldestRecord.get("DateUTC");
        System.out.println("Coldest temperature on that day was: "+coldestTempInFile+" at: "+dateTime);
    }

    public static File fileWithColdestTemparature(){
        CSVRecord lowestSoFar = null;
        File lowestTempFile = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord currentLowest = coldestHourInFile(parser);
            if(lowestSoFar == null){
                lowestSoFar = currentLowest;
            }
            Double currentLowestTemp = Double.parseDouble(currentLowest.get("TemperatureF"));
            Double lowestSoFarTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
            if(lowestSoFarTemp > currentLowestTemp){
                lowestSoFar = currentLowest;
                lowestTempFile = f;
            }
        }

        return lowestTempFile;
    }

    public static CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestHumiditySoFar = null;
        for(CSVRecord currentRecord : parser){
            String humidityString = currentRecord.get("Humidity");
            if(humidityString.equals("N/A")){
                continue;
            }
            if(lowestHumiditySoFar == null){
                lowestHumiditySoFar = currentRecord;
            }
            Integer currentHumidityValue = Integer.parseInt(humidityString);
            Integer lowestHumidityValue = Integer.parseInt(lowestHumiditySoFar.get("Humidity"));
            if(lowestHumidityValue > currentHumidityValue){
                lowestHumiditySoFar = currentRecord;
            }
        }
        return lowestHumiditySoFar;

    }

    public static CSVRecord lowestHumidityInManyFiles(){
        CSVRecord lowestHumiditySoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord currentLowestHumidity = lowestHumidityInFile(parser);
            if(lowestHumiditySoFar == null){
                lowestHumiditySoFar=currentLowestHumidity;
            }
            Integer currentLowestHumidityValue = Integer.parseInt(currentLowestHumidity.get("Humidity"));
            Integer lowestHumidityValueSoFar = Integer.parseInt(lowestHumiditySoFar.get("Humidity"));
            if(lowestHumidityValueSoFar > currentLowestHumidityValue){
                lowestHumiditySoFar = currentLowestHumidity;
            }
        }
        return lowestHumiditySoFar;

    }

    public static Double averageTemperatureInFile(CSVParser parser){
        Integer numDataPoints = 0;
        Double aggTempInFile = 0.0;
        for(CSVRecord record : parser){
            numDataPoints = numDataPoints +1;
            Double temp = Double.parseDouble(record.get("TemperatureF"));
            if(temp != -9999){
                aggTempInFile = aggTempInFile + temp;
            }
        }
        Double avgTempInFile = aggTempInFile/numDataPoints;
        return avgTempInFile;

    }

    public static Double averageTemperatureWithHighHumidityInFile(CSVParser parser, Integer value){
        List<Double> tempsWithHighHumidity = new ArrayList<>();
        for(CSVRecord record : parser){
            String humidityString = record.get("Humidity");
            if(humidityString == "N/A"){
                continue;
            }
            Integer humidity = Integer.parseInt(humidityString);
            Double temp = Double.parseDouble(record.get("TemperatureF"));
            if(humidity >= value && temp != -9999){
                tempsWithHighHumidity.add(temp);
            }
        }
        if(tempsWithHighHumidity.size()==0){
            return 0.0;
        }
        Integer numDataPoints = 0;
        Double aggHighHumidityTemp = 0.0;
        for(Double highHumidityTemp : tempsWithHighHumidity){
            numDataPoints = numDataPoints +1;
            aggHighHumidityTemp = aggHighHumidityTemp + highHumidityTemp;
        }
        Double averageTemp = aggHighHumidityTemp/numDataPoints;
        return averageTemp;

    }

}
