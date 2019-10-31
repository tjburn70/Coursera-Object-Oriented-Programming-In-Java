package week1;

import edu.duke.FileResource;
import org.junit.Assert;
import org.junit.Test;

public class CaesarBreakerTest {
    @Test
    public void testDecrypt(){
        String encryptedMessage = "jroi";
        String decryptedMessage = "golf";

        String actualDecryptedMessage = CaesarBreaker.decrypt(encryptedMessage);
        System.out.println(actualDecryptedMessage);
    }

    @Test
    public void testHalfOfString(){
        String message = "Qbkm Zgis";
        int startInt = 0;
        String expectedHalfOfString = "Qk gs";
        String actualHalfOfString = CaesarBreaker.halfOfString(message, startInt);

        Assert.assertEquals(expectedHalfOfString, actualHalfOfString);
    }

    @Test
    public void testHalfOfStringPart2(){
        String message = "Qbkm Zgis";
        int startInt = 1;
        String expectedHalfOfString = "bmZi";
        String actualHalfOfString = CaesarBreaker.halfOfString(message, startInt);

        Assert.assertEquals(expectedHalfOfString, actualHalfOfString);
    }

    @Test
    public void testDecryptTwoKeys(){
        String encryptedMessage = "Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";
        String decryptedMessage = CaesarBreaker.decryptTwoKeys(encryptedMessage);
        System.out.println("decryptedMessage: "+decryptedMessage);

        String encryptedMessage2 = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
        String decryptedMessage2 = CaesarBreaker.decryptTwoKeys(encryptedMessage2);
        System.out.println("decryptedMessage2: "+decryptedMessage2);

    }

    @Test
    public void testDecryptTwoKeysWithFile(){
        FileResource resource = new FileResource();
        String encryptedContents = resource.asString();

        String decryptedMessage = CaesarBreaker.decryptTwoKeys(encryptedContents);
        System.out.println("decryptedMessage: "+decryptedMessage);
    }


}
