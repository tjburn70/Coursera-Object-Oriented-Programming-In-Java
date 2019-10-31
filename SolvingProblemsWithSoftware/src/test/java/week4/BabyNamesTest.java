package week4;

import edu.duke.DirectoryResource;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class BabyNamesTest {
    @Test
    public void testPrintTotalBirthsByGender(){
        BabyNames.printTotalBirthsByGender();
    }

    @Test
    public void testGetRank(){
        Integer year = 1971;
        String name = "Frank";
        String gender = "M";
        Integer expectedRank = 54;
        Integer actualRank = BabyNames.getRank(year, name, gender);
        Assert.assertEquals(expectedRank, actualRank);
    }

    @Test
    public void testGetName(){
        Integer year = 1980;
        Integer rank = 350;
        String gender = "F";
        String expectedName = "Mia";
        String actualName = BabyNames.getName(year, rank, gender);
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testWhatIsNameInYear(){
        Integer birthYear = 1974;
        String name = "Owen";
        String gender = "M";
        Integer newYear = 2014;
        BabyNames.whatIsNameInYear(birthYear, name, gender, newYear);
    }

    @Test
    public void testGetYearFromUsBabyFiles(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            Integer year = BabyNames.getYearFromUsBabyFiles(f);
            System.out.println("year: "+year);
        }
    }

    @Test
    public void testYearOfHighestRankCanFindName(){
        String name = "Mich";
        String gender = "M";
        Integer expectedYearOfHighestRank = 1960;
        Integer actualYearOfHighestRank = BabyNames.yearOfHighestRank(name, gender);
        Assert.assertEquals(expectedYearOfHighestRank, actualYearOfHighestRank);
    }

    @Test
    public void testYearOfHighestRankCannotFindName(){
        String name = "NameDoesntExist";
        String gender = "F";
        Integer expectedYearOfHighestRank = -1;
        Integer actualYearOfHighestRank = BabyNames.yearOfHighestRank(name, gender);
        Assert.assertEquals(expectedYearOfHighestRank, actualYearOfHighestRank);

    }

    @Test
    public void testYearOfHighestRankInvalidGenderCode(){
        String name = "Mason";
        String gender = "U";
        Integer expectedYearOfHighestRank = -1;
        Integer actualYearOfHighestRank = BabyNames.yearOfHighestRank(name, gender);
        Assert.assertEquals(expectedYearOfHighestRank, actualYearOfHighestRank);

    }

    @Test
    public void testGetAverageRank(){
        String name = "Robert";
        String gender = "M";
        Double averageRank = BabyNames.getAverageRank(name, gender);
        System.out.println("averageRank: "+averageRank);
    }

    @Test
    public void testGetTotalBirthsRankedHigher(){
        Integer year = 1990;
        String name = "Drew";
        String gender = "M";
        Integer totalBirthsRankedHigher = BabyNames.getTotalBirthsRankedHigher(year, name, gender);
        System.out.println(totalBirthsRankedHigher);
    }
}
