package week3;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.junit.Test;

import java.util.List;

public class WhichCountrysExportWhatTest {
    @Test
    public void testCountryInfo(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        String country = "Nauru";
        String countryInfo = WhichCountriesExportWhat.countryInfo(parser, country);
        System.out.println(countryInfo);
    }
    @Test
    public void testListExportersTwoProducts(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        String exportItem1 = "cotton";
        String exportItem2 = "flowers";
        List<String> countriesBothItems = WhichCountriesExportWhat.listExportersTwoProducts(parser, exportItem1, exportItem2);
        for(String country : countriesBothItems){
            System.out.println(country);
        }
    }
    @Test
    public void testNumberOfExporters(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        String exportItem = "cocoa";
        Integer numberOfExporters = WhichCountriesExportWhat.numberOfExporters(parser, exportItem);
        System.out.println(numberOfExporters);
    }
    @Test
    public void testBigExporters(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        String exportValue = "$999,999,999,999";
        WhichCountriesExportWhat.bigExporters(parser, exportValue);
    }
}
