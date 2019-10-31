package week3;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.List;

public class WhichCountriesExportWhat {
    public static String countryInfo(CSVParser parser, String country) {
        String countryInfo = null;
        String countryName;
        String countryExports;
        String countryExportsValue;

        for (CSVRecord record : parser) {
            countryName = record.get("Country");
            if (countryName.contains(country)) {
                countryExports = record.get("Exports");
                countryExportsValue = record.get("Value (dollars)");
                countryInfo = countryName + ": " + countryExports + ": " + countryExportsValue;
            }
        }
        return countryInfo;
    }

    public static List<String> listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        List<String> countriesWithBothExports = new ArrayList<>();
        for(CSVRecord record : parser){
            String exports = record.get("Exports");
            if(exports.contains(exportItem1) && exports.contains(exportItem2)){
                String country = record.get("Country");
                countriesWithBothExports.add(country);
            }
        }
        return countriesWithBothExports;
    }

    public static Integer numberOfExporters(CSVParser parser, String exportItem){
        Integer numberOfExporters = 0;
        for(CSVRecord record : parser){
            String exports = record.get("Exports");
            if(exports.contains(exportItem)){
                numberOfExporters = numberOfExporters +1;
            }
        }
        return numberOfExporters;
    }

    public static void bigExporters(CSVParser parser, String amount){
        for(CSVRecord record : parser){
            String valueOfExports = record.get("Value (dollars)");
            if(valueOfExports.length() > amount.length()){
                String country = record.get("Country");
                System.out.println(country + " " + valueOfExports);
            }
        }
    }

}
