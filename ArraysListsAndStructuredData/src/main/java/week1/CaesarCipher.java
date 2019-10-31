package week1;

public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;

    public CaesarCipher(int key){
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.shiftedAlphabet = shiftAlphabet(alphabet, key);
        this.mainKey = key;
    }

    private static String shiftAlphabet(String alphabet, int key){
        String firstPart = alphabet.substring(0, key);
        String secondPart = alphabet.substring(key);
        return secondPart + firstPart;
    }

    private int[] countLetters(String message){
        int[] counter = new int[26];

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

    public int getKey(String message){
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

    public String encrypt(String input){
        Boolean isUpperCase = input.equals(input.toUpperCase());
        input = input.toLowerCase();
        StringBuilder sb = new StringBuilder(input);
        for(int i=0; i<sb.length(); i++){
            char currentChar = sb.charAt(i);
            int alphabetIndex = alphabet.indexOf(currentChar);
            if(alphabetIndex == -1){
                continue;
            }
            char encryptedChar = shiftedAlphabet.charAt(alphabetIndex);
            sb.setCharAt(i, encryptedChar);
        }
        String encryptedMessage = sb.toString();
        if(isUpperCase){
            encryptedMessage = encryptedMessage.toUpperCase();
        }
        return encryptedMessage;
    }

    public String encryptUpperAndLower(String input){
        StringBuilder message = new StringBuilder(input);
        for(int i=0; i<message.length(); i++){
            char currentChar = message.charAt(i);
            char currentCharUpperCase = Character.toUpperCase(currentChar);
            int alphabetIndex;
            char encryptedChar;

            if(currentChar == currentCharUpperCase){
                String alphabetUpperCase = alphabet.toUpperCase();
                String shiftedAlphabetUpperCase = shiftedAlphabet.toUpperCase();
                alphabetIndex = alphabetUpperCase.indexOf(currentChar);
                if(alphabetIndex == -1){
                    continue;
                }
                encryptedChar = shiftedAlphabetUpperCase.charAt(alphabetIndex);
            } else{
                alphabetIndex = alphabet.indexOf(currentChar);
                if(alphabetIndex == -1){
                    continue;
                }
                encryptedChar = shiftedAlphabet.charAt(alphabetIndex);
            }
            message.setCharAt(i, encryptedChar);
        }

        return message.toString();
    }

    public static String encryptTwoKeys(String input, int key1, int key2){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabetKey1 = shiftAlphabet(alphabet, key1);
        String shiftedAlphabetKey2 = shiftAlphabet(alphabet, key2);
        StringBuilder sb = new StringBuilder(input);
        for(int i=0; i<sb.length(); i++) {
            char currentChar = sb.charAt(i);
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
                sb.setCharAt(i, encryptedChar);
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
                sb.setCharAt(i, encryptedChar);
            }
        }
        String encryptedMessage = sb.toString();
        return encryptedMessage;
    }

    public String decrypt(String input){
        CaesarCipher cc = new CaesarCipher(26-mainKey);
        return cc.encrypt(input);
    }

    public String breakCaesarCipher(String encryptedMessage){
        int dkey = getKey(encryptedMessage);
        CaesarCipher cc = new CaesarCipher(26-dkey);
        return cc.encrypt(encryptedMessage);
    }
}
