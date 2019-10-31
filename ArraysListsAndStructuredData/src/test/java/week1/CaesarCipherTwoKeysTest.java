package week1;

import edu.duke.FileResource;
import org.junit.Assert;
import org.junit.Test;

public class CaesarCipherTwoKeysTest {
    @Test
    public void testEncryptAndDecrypt(){
        FileResource resource = new FileResource();
        String originalMessage = resource.asString().toLowerCase();
        int key1 = 17;
        int key2 = 3;
        CaesarCipherTwoKeys cc2 = new CaesarCipherTwoKeys(key1, key2);
        String encryptedMessage = cc2.encrypt(originalMessage);
        String decryptedMessage = cc2.decrypt(encryptedMessage);

        Assert.assertEquals(originalMessage, decryptedMessage);
    }

    @Test
    public void testEncryptForQuiz(){
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        int key1 = 21;
        int key2 = 8;
        CaesarCipherTwoKeys cc2 = new CaesarCipherTwoKeys(key1, key2);
        String encryptedMessage = cc2.encrypt(message);
        System.out.println("encryptedMessage: "+encryptedMessage);
    }

    @Test
    public void testDecryptForQuiz(){
        int key1 = 14;
        int key2 = 24;
        CaesarCipherTwoKeys cc2 = new CaesarCipherTwoKeys(key1, key2);
        String encryptedMessage = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        String decryptedMessage = cc2.decrypt(encryptedMessage);
        System.out.println("decryptedMessage: "+decryptedMessage);
    }

    @Test
    public void testbreakCaesarCipher(){
        String encrypted = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        String decryptedMessage = CaesarCipherTwoKeys.breakCaesarCipher(encrypted);
    }

    @Test
    public void testbreakCaesarCipherWithFile(){
        FileResource resource = new FileResource();
        String encryptedMessage = resource.asString();
        String decryptedMessage = CaesarCipherTwoKeys.breakCaesarCipher(encryptedMessage);
    }
}
