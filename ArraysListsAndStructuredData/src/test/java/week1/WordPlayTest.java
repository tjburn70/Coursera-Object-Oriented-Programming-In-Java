package week1;
import org.junit.Assert;
import org.junit.Test;

public class WordPlayTest {
    @Test
    public void testIsVowel(){
        char vowel = 'u';
        Boolean expectedResponse = true;
        Boolean actualResponse = WordPlay.isVowel(vowel);
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testReplaceVowel(){
        String testPhrase = "ghdixctabejklmonup";
        char replacementChar = '$';
        String expectedResponse = "ghd$xct$b$jklm$n$p";
        String actualResponse = WordPlay.replaceVowel(testPhrase, replacementChar);
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testEmphasize(){
        String testPhrase = "dna ctgaaactga";
        char charToReplace = 'a';
        String expectedResponse = "dn* ctg+*+ctg+";
        String actualResponse = WordPlay.emphasize(testPhrase, charToReplace);
        Assert.assertEquals(expectedResponse, actualResponse);

    }
}
