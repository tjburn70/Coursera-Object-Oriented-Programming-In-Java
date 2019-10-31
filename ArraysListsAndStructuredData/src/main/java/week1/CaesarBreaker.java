package week1;

public class CaesarBreaker {

    public static int[] countLetters(String message){
        int[] counter = new int[26];
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for(int i =0; i<message.length(); i++){
            char currentChar = message.charAt(i);
            int alphabetIndex = alphabet.indexOf(Character.toLowerCase(currentChar));
            if(alphabetIndex != -1){
                counter[alphabetIndex] += 1;
            }
        }
        return counter;
    }

    public static int maxIndex(int[] counter){
        int maxValue = 0;
        int maxIndex = 0;
        for(int i=0; i<counter.length; i++){
            int currentValue = counter[i];
            if(currentValue > maxValue){
                maxIndex = i;
                maxValue = currentValue;
            }
        }
        return maxIndex;
    }

    public static String decrypt(String encryptedMessage){
        int[] characterCount = countLetters(encryptedMessage);
        int maxDex = maxIndex(characterCount);
        int dkey;
        if(maxDex < 4){
            dkey = 26 - (4-maxDex);
        } else {
            dkey = maxDex - 4;
        }

        CaesarCipher cc = new CaesarCipher(dkey);
        String message = cc.decrypt(encryptedMessage);
        return message;
    }

    public static String halfOfString(String message, int start){
        StringBuilder halfOfString = new StringBuilder();
        for(int i=start; i<message.length(); i+=2){
            char currentChar = message.charAt(i);
            halfOfString.append(currentChar);
        }
        return halfOfString.toString();
    }

    public static int getKey(String s){
        int[] characterCount = countLetters(s);
        System.out.println("characterCount: "+characterCount);
        int maxDex = maxIndex(characterCount);
        System.out.println("maxDex: "+maxDex);
        int key;
        if(maxDex < 4){
            key = 26 - (4-maxDex);
        } else {
            key = maxDex - 4;
        }
        return key;
    }

    public static String decryptTwoKeys(String encryptedMessage){
        int firstIndex = 0;
        String message1 = halfOfString(encryptedMessage, firstIndex);
        int secondIndex = 1;
        String message2 = halfOfString(encryptedMessage, secondIndex);

        int key1 = getKey(message1);
        System.out.println("key1: "+key1);
        int key2 = getKey(message2);
        System.out.println("key2: "+key2);

        CaesarCipher cc1 = new CaesarCipher(key1);
        CaesarCipher cc2 = new CaesarCipher(key2);
        String decryptedMessage1 = cc1.decrypt(message1);
        String decryptedMessage2 = cc2.decrypt(message2);

        StringBuilder decryptedMessage = new StringBuilder(encryptedMessage);
        for (int k=0; k<decryptedMessage1.length();k++){
            decryptedMessage.setCharAt((2*k), decryptedMessage1.charAt(k));
        }

        for (int k=0; k<decryptedMessage2.length();k++){
            decryptedMessage.setCharAt((2*k)+1, decryptedMessage2.charAt(k));
        }

        return decryptedMessage.toString();
    }
}
