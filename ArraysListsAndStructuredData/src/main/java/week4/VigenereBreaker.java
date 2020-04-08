package week4;

import java.io.File;
import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder slice = new StringBuilder();
        for (int i = whichSlice; i < message.length(); i+=totalSlices) {
            char letter = message.charAt(i);
            slice.append(letter);
        }
        return slice.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cracker = new CaesarCracker();
        for (int i = 0; i < klength; i+=1) {
            String encryptedSlice = sliceString(encrypted, i, klength);
            key[i] = cracker.getKey(encryptedSlice);
        }

        return key;
    }



    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> dictionary = new HashSet<>();
        for(String line : fr.lines()) {
            dictionary.add(line.toLowerCase());
        }

        return dictionary;
    }

    public int countWords(String message, HashSet<String> dictionary) {
        String[] words = message.split("\\W+");
        int numberOfWords = 0;
        for (String word : words) {
            if (dictionary.contains(word.toLowerCase())) {
                numberOfWords+=1;
            }
        }

        return numberOfWords;
    }

    public char findMostCommonChar(HashSet<String> dictionary) {
        HashMap<String, Integer> charToCount = new HashMap<>();
        for (String word : dictionary) {
            for (char c : word.toCharArray()) {
                String letterString = Character.toString(c);
                Integer count = charToCount.get(letterString);
                if (count == null) {
                    charToCount.put(letterString, 1);
                } else {
                    charToCount.put(letterString, count+1);
                }
            }
        }

        Integer maxCount = 0;
        char mostCommonChar = '\u0000';
        for (String key : charToCount.keySet()) {
            Integer count = charToCount.get(key);
            if (count >= maxCount) {
                maxCount = count;
                mostCommonChar = key.charAt(0);
            }
        }

        return mostCommonChar;
    }

    public HashMap<Integer, String> breakForLanguage(String encrypted, HashSet<String> dictionary) {
        int maxWordCount = 0;
        int keyLength = 0;
        int maxKeyLength = 100;
        HashMap<Integer, Integer> keyToWordCount = new HashMap<>();
        String decryptedMessage = "";

        char mostCommon = findMostCommonChar(dictionary);
        for (int i=1; i < maxKeyLength; i+=1) {
            int[] key = tryKeyLength(encrypted, i, mostCommon);
            VigenereCipher vigenereCipher = new VigenereCipher(key);
            String message = vigenereCipher.decrypt(encrypted);
            int wordCount = countWords(message, dictionary);
            keyToWordCount.put(i, wordCount);
            if (wordCount >= maxWordCount) {
                maxWordCount = wordCount;
                decryptedMessage = message;
                keyLength = i;
            }
        }
        System.out.println(keyToWordCount);
        System.out.println(keyLength);
        HashMap<Integer, String> wordCountToDecryptedMessage = new HashMap<>();
        wordCountToDecryptedMessage.put(maxWordCount, decryptedMessage);

        return wordCountToDecryptedMessage;
    }

    public void breakForAllLanguages(String encrypted, HashMap<String, HashSet<String>> languages) {
        String language = "";
        String decryptedMessage = "";
        int maxWordCount = 0;

        HashMap<String, HashMap<Integer, String>> languageToDecryptedMessageByWordCount = new HashMap<>();

        for (String languageKey : languages.keySet()) {
            HashSet<String> dictionary = languages.get(languageKey);
            languageToDecryptedMessageByWordCount.put(
                    languageKey,
                    breakForLanguage(encrypted, dictionary)
            );
        }

        for (Map.Entry<String, HashMap<Integer, String>> entry : languageToDecryptedMessageByWordCount.entrySet()) {
            String lang = entry.getKey();
            HashMap<Integer, String> wordCountToDecryptedMessage = entry.getValue();
            for (Integer key : wordCountToDecryptedMessage.keySet()) {
                if (key >= maxWordCount) {
                    language = lang;
                    decryptedMessage = wordCountToDecryptedMessage.get(key);
                    maxWordCount = key;
                }
            }
        }

        System.out.println(language);
        System.out.println(maxWordCount);
        System.out.println(decryptedMessage);
    }

    public void breakVigenere (String fileName) {
        FileResource fr = new FileResource(fileName);
        String encryptedMessage = fr.asString();

        HashMap<String, HashSet<String>> languages = new HashMap<>();
        DirectoryResource dictionaries = new DirectoryResource();
        for (File f : dictionaries.selectedFiles()) {
            FileResource dictionary = new FileResource(f);
            HashSet<String> words = readDictionary(dictionary);
            String language = f.getName();
            languages.put(language, words);
        }

        breakForAllLanguages(encryptedMessage, languages);
    }
    
}
