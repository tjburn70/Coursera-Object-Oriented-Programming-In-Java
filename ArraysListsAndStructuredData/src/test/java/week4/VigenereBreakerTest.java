package week4;

import edu.duke.FileResource;
import org.junit.Assert;
import org.junit.Test;

public class VigenereBreakerTest {

    @Test
    public void testSliceString() {
        String message = "abcdefghijklm";
        int whichSlice = 0;
        int totalSlices = 3;

        String expectedSlice = "adgjm";
        String actualSlice = "";

        VigenereBreaker breaker = new VigenereBreaker();
        actualSlice = breaker.sliceString(message, whichSlice, totalSlices);

        Assert.assertEquals(
                expectedSlice,
                actualSlice
        );
    }

    @Test
    public void testTryKeyLength() {
        String filename = "secretmessage1.txt";
        FileResource fr = new FileResource(filename);

        String encryptedMessage = fr.asString();
        VigenereBreaker breaker = new VigenereBreaker();
        int[] key = breaker.tryKeyLength(encryptedMessage,4, 'e');
        for (int element : key) {
            System.out.println(element);
        }
    }

    @Test
    public void testBreakVigenere() {
        String filename = "secretmessage4.txt";
        VigenereBreaker breaker = new VigenereBreaker();
        breaker.breakVigenere(filename);
    }

}
