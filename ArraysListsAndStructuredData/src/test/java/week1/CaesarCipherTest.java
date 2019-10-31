package week1;

import edu.duke.FileResource;
import org.junit.Assert;
import org.junit.Test;

public class CaesarCipherTest {
    @Test
    public void testEncrypt(){
        String message = "FIRST LEGION ATTACK EAST FLANK!";
        String expectedEncyrptedMessage = "CFOPQ IBDFLK XQQXZH BXPQ CIXKH!";
        int key = 23;
        CaesarCipher cc = new CaesarCipher(key);
        String encryptedMessage = cc.encrypt(message);
        Assert.assertEquals(expectedEncyrptedMessage, encryptedMessage);
    }

    @Test
    public void testEncryptAndDecrypt(){
        FileResource resource = new FileResource();
        String originalMessage = resource.asString().toLowerCase();
        int key = 15;
        CaesarCipher cc = new CaesarCipher(key);
        String encryptedMessage = cc.encrypt(originalMessage);
        String decryptedMessage = cc.decrypt(encryptedMessage);

        Assert.assertEquals(originalMessage, decryptedMessage);
    }


    @Test
    public void testEncryptUpperAndLower(){
        String message = "First Legion";
        String expectedEncyrptedMessage = "Wzijk Cvxzfe";
        int key = 17;
        CaesarCipher cc = new CaesarCipher(key);
        String encryptedMessage = cc.encryptUpperAndLower(message);
        Assert.assertEquals(expectedEncyrptedMessage, encryptedMessage);
    }

    @Test
    public void testEncryptUpperAndLowerForQuiz1(){
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        String expectedEncyrptedMessage = "Pi cddc qt xc iwt rdcutgtcrt gddb lxiw " +
                "ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!";
        int key = 15;
        CaesarCipher cc = new CaesarCipher(key);
        String encryptedMessage = cc.encryptUpperAndLower(message);
        Assert.assertEquals(expectedEncyrptedMessage, encryptedMessage);
    }

    @Test
    public void testEncryptUpperAndLowerForQuiz2(){
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        int key = 15;
        CaesarCipher cc = new CaesarCipher(key);
        String encryptedMessage = cc.encryptUpperAndLower(message);
        System.out.println("encryptedMessage: "+encryptedMessage);
    }

    @Test
    public void testEncryptTwoKeys(){
        String message = "First Legion";
        int key1 = 23;
        int key2 = 17;
        String expectedEncyrptedMessage = "Czojq Ivdzle";
        String encryptedMessage = CaesarCipher.encryptTwoKeys(message, key1, key2);
        Assert.assertEquals(expectedEncyrptedMessage, encryptedMessage);

    }

    @Test
    public void testEncryptTwoKeysForQuiz(){
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        int key1 = 8;
        int key2 = 21;
        String expectedEncyrptedMessage = "Io iwjv jz dv bcm kjvammmikz mwju edbc twpz " +
                "pvb wi awm v ncmxmqnm xvzog. TMGT TJCY!";
        String encryptedMessage = CaesarCipher.encryptTwoKeys(message, key1, key2);
        Assert.assertEquals(expectedEncyrptedMessage, encryptedMessage);

    }


}
