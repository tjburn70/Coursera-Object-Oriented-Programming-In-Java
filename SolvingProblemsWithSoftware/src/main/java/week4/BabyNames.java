package week4;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BabyNames {
    public static void printTotalBirthsByGender(){
        Integer totalBirths = 0;
        Integer totalBoyBirths = 0;
        Integer totalGirlBirths = 0;
        Integer countBoyNames = 0;
        Integer countGirlNames = 0;
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record : parser){
            String gender = record.get(1).toLowerCase();
            Integer numBorn = Integer.parseInt(record.get(2));
            if(gender.equals("f")){
                totalGirlBirths += numBorn;
                countGirlNames++;
            } else{
                totalBoyBirths += numBorn;
                countBoyNames++;
            }
        }
        totalBirths = totalGirlBirths + totalBoyBirths;
        System.out.println("totalBirths: "+totalBirths);
        System.out.println("totalGirlBirths: "+totalGirlBirths);
        System.out.println("countGirlNames: "+countGirlNames);
        System.out.println("totalBoyBirths: "+totalBoyBirths);
        System.out.println("countBoyNames: "+countBoyNames);
    }

    public static Integer getRank(Integer year, String name, String gender){
        Integer countRecords = 0;
        Integer rank = 0;
        name = name.toLowerCase();
        gender = gender.toLowerCase();
        String path = "./Object-Oriented-Programming-in-Java/" +
                "src/main/SolvingProblemsWithSoftware/week4/resources/" +
                "us_babynames/us_babynames_by_year/yob"+year+".csv";
        FileResource fr = new FileResource(path);
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record : parser){
            String genderFromRecord = record.get(1).toLowerCase();
            if(!genderFromRecord.equals(gender)){
                continue;
            }
            countRecords = countRecords + 1;
            String nameFromRecord = record.get(0).toLowerCase();
            if(nameFromRecord.equals(name)){
                rank = countRecords;
                break;
            }
        }
        if(rank == 0){
            return -1;
        }

        return rank;
    }

    public static String getName(Integer year, Integer rank, String gender){
        Integer countRecords = 0;
        String babyName = "";
        gender = gender.toLowerCase();
        String path = "./Object-Oriented-Programming-in-Java/" +
                "src/main/SolvingProblemsWithSoftware/week4/resources/" +
                "us_babynames/us_babynames_by_year/yob"+year+".csv";
        FileResource fr = new FileResource(path);
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record : parser){
            String genderFromRecord = record.get(1).toLowerCase();
            if(!genderFromRecord.equals(gender)){
                continue;
            }
            countRecords = countRecords + 1;
            if(countRecords.equals(rank)){
                babyName = record.get(0);
                break;
            }
        }
        if(rank > countRecords){
            return "NO NAME";
        }

        return babyName;
    }

    public static void whatIsNameInYear(Integer birthYear, String name, String gender, Integer newYear){
        Integer rank = getRank(birthYear, name, gender);
        String newName = getName(newYear, rank, gender);

        String pronoun = "";
        if(gender.toLowerCase().equals("f")){
            pronoun = "she";
        } else{
            pronoun = "he";
        }

        System.out.println(name+" born in "+birthYear+" would be "+newName+" if "+pronoun+" was born in "+newYear);
    }

    public static Integer getYearFromUsBabyFiles(File f){
        String fileName = f.getName();
        Integer startIndex = fileName.indexOf("yob");
        if(startIndex == -1){
            return startIndex;
        }
        Integer stopIndex = fileName.indexOf(".");
        Integer fileYear = Integer.parseInt(fileName.substring(startIndex+3, stopIndex));
        return fileYear;
    }

    public static Integer yearOfHighestRank(String name, String gender){
        Integer highestRankSoFar = -1;
        Integer yearHighestRank = -1;
        name = name.toLowerCase();
        gender = gender.toLowerCase();

        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            Integer fileYear = getYearFromUsBabyFiles(f);
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            Integer recordCount = 0;
            Integer fileRank = -1;
            for(CSVRecord record : parser){
                String genderFromRecord = record.get(1).toLowerCase();
                if(!genderFromRecord.equals(gender)){
                    continue;
                }
                recordCount = recordCount + 1;
                String nameFromRecord = record.get(0).toLowerCase();
                if(nameFromRecord.equals(name)){
                    fileRank = recordCount;
                    break;
                }
            }
            if(fileRank == -1){
                continue;
            }
            if(highestRankSoFar == -1 || highestRankSoFar > fileRank){
                highestRankSoFar = fileRank;
                yearHighestRank = fileYear;
            }
        }

        return yearHighestRank;
    }

    public static Double getAverageRank(String name, String gender) {
        List<Integer> rankEachYear = new ArrayList<>();
        name = name.toLowerCase();
        gender = gender.toLowerCase();

        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            Integer recordCount = 0;
            Integer rank;
            for (CSVRecord record : parser) {
                String genderFromRecord = record.get(1).toLowerCase();
                if (!genderFromRecord.equals(gender)) {
                    continue;
                }
                recordCount = recordCount + 1;
                String nameFromRecord = record.get(0).toLowerCase();
                if (nameFromRecord.equals(name)) {
                    rank = recordCount;
                    rankEachYear.add(rank);
                    break;
                }
            }
        }

        Double aggRank = 0.0;
        for(Integer rank : rankEachYear){
            aggRank = aggRank + rank;
        }

        Double averageRank = -1.0;
        if(rankEachYear.size() > 0) {
            averageRank = aggRank / rankEachYear.size();
        }

        return averageRank;
    }

    public static Integer getTotalBirthsRankedHigher(Integer year, String name, String gender){
        name = name.toLowerCase();
        gender = gender.toLowerCase();
        Integer totalBirths = 0;
        String path = "./Object-Oriented-Programming-in-Java/" +
                "src/main/SolvingProblemsWithSoftware/week4/resources/" +
                "us_babynames/us_babynames_by_year/yob"+year+".csv";

        FileResource fr = new FileResource(path);
        CSVParser parser = fr.getCSVParser(false);
        for (CSVRecord record : parser) {
            String genderFromRecord = record.get(1).toLowerCase();
            if (!genderFromRecord.equals(gender)) {
                continue;
            }
            Integer births = Integer.parseInt(record.get(2));
            totalBirths = totalBirths + births;
            String nameFromRecord = record.get(0).toLowerCase();
            if (nameFromRecord.equals(name)) {
                break;
            }
        }

        return totalBirths;
    }

}
