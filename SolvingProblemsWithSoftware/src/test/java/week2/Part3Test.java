package week2;
import org.junit.Assert;
import org.junit.Test;

public class Part3Test {
    @Test
    public void testTwoOccurences(){
        String stringa = "by";
        String stringb = "A story by Abby Long";
        Boolean expectedResponse = true;
        Boolean actualResponse = Part3.twoOccurences(stringa, stringb);
        Assert.assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testTwoOccurencesBanana(){
        String stringa = "na";
        String stringb = "banana";
        Boolean expectedResponse = true;
        Boolean actualResponse = Part3.twoOccurences(stringa, stringb);
        Assert.assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testTwoOccurencesWithNoMatch(){
        String stringa = "houston";
        String stringb = "best city In the World";
        Boolean expectedResponse = false;
        Boolean actualResponse = Part3.twoOccurences(stringa, stringb);
        Assert.assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testTwoOccurencesWithOnlyOneMatch(){
        String stringa = "bob";
        String stringb = "Bob OLink Golf Course";
        Boolean expectedResponse = false;
        Boolean actualResponse = Part3.twoOccurences(stringa, stringb);
        Assert.assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testLastPartStringAInStringB(){
        String stringa = "an";
        String stringb = "banana";
        String expectedResponse = "ana";
        String actualResponse = Part3.lastPart(stringa, stringb);
        Assert.assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testLastPartStringANotInStringB(){
        String stringa = "zoo";
        String stringb = "forest";
        String expectedResponse = "forest";
        String actualResponse = Part3.lastPart(stringa, stringb);
        Assert.assertEquals(expectedResponse, actualResponse);
    }

}
