package week1;

public class CaesarCipherTwoKeys {
    private String alphabet;
    private String shiftedAlphabetKey1;
    private String shiftedAlphabetKey2;
    private int key1;
    private int key2;

    public CaesarCipherTwoKeys(int key1, int key2){
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.shiftedAlphabetKey1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        this.shiftedAlphabetKey2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        this.key1 = key1;
        this.key2 = key2;
    }

    private static int[] countLetters(String message){
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

    private static int indexOfMax(int[] counter){
        int maxValue = 0;
        int indexOfMax = 0;
        for(int i=0; i<counter.length; i++){
            int currentValue = counter[i];
            if(currentValue > maxValue){
                indexOfMax = i;
                maxValue = currentValue;
            }
        }

        return indexOfMax;
    }

    private static int getKey(String message){
        int[] freqs = countLetters(message);
        int maxDex = indexOfMax(freqs);
        int key;
        if(maxDex < 4){
            key = 26 - (4-maxDex);
        } else {
            key = maxDex - 4;
        }
        return key;
    }

    private static String halfOfString(String message, int start){
        StringBuilder halfOfString = new StringBuilder();
        for(int i=start; i<message.length(); i+=2){
            char currentChar = message.charAt(i);
            halfOfString.append(currentChar);
        }
        return halfOfString.toString();
    }

    public String encrypt(String input){
        StringBuilder message = new StringBuilder(input);
        for(int i=0; i<message.length(); i++) {
            char currentChar = message.charAt(i);
            char currentCharUpperCase = Character.toUpperCase(currentChar);
            int alphabetIndex;
            char encryptedChar;

            if (i % 2 == 0) {
                if (currentChar == currentCharUpperCase) {
                    String alphabetUpperCase = alphabet.toUpperCase();
                    String shiftedAlphabetUpperCase = shiftedAlphabetKey1.toUpperCase();
                    alphabetIndex = alphabetUpperCase.indexOf(currentChar);
                    if (alphabetIndex == -1) {
                        continue;
                    }
                    encryptedChar = shiftedAlphabetUpperCase.charAt(alphabetIndex);
                } else {
                    alphabetIndex = alphabet.indexOf(currentChar);
                    if (alphabetIndex == -1) {
                        continue;
                    }
                    encryptedChar = shiftedAlphabetKey1.charAt(alphabetIndex);
                }
                message.setCharAt(i, encryptedChar);
            } else if (i % 2 == 1) {
                if (currentChar == currentCharUpperCase) {
                    String alphabetUpperCase = alphabet.toUpperCase();
                    String shiftedAlphabetUpperCase = shiftedAlphabetKey2.toUpperCase();
                    alphabetIndex = alphabetUpperCase.indexOf(currentChar);
                    if (alphabetIndex == -1) {
                        continue;
                    }
                    encryptedChar = shiftedAlphabetUpperCase.charAt(alphabetIndex);
                } else {
                    alphabetIndex = alphabet.indexOf(currentChar);
                    if (alphabetIndex == -1) {
                        continue;
                    }
                    encryptedChar = shiftedAlphabetKey2.charAt(alphabetIndex);
                }
                message.setCharAt(i, encryptedChar);
            }
        }
        return message.toString();
    }

    public String decrypt(String encryptedMessage){
        CaesarCipherTwoKeys cc2 = new CaesarCipherTwoKeys(26-key1, 26-key2);
        return cc2.encrypt(encryptedMessage);
    }

    public static String breakCaesarCipher(String encryptedMessage){

        String message1 = halfOfString(encryptedMessage,0);
        String message2 = halfOfString(encryptedMessage,1);

        int k1= getKey(message1);
        int k2= getKey(message2);

        System.out.println("Keys found are " + k1 + "  " + k2);

        CaesarCipherTwoKeys cc = new CaesarCipherTwoKeys(k1, k2);
        String decryptedMessage = cc.decrypt(encryptedMessage);
        System.out.println("decryptedMessage: "+decryptedMessage);
        return decryptedMessage;
    }
}
