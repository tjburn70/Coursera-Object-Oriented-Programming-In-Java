package week1;

import edu.duke.FileResource;

public class WordLengthCC{

    private static Integer indexOfMax(int[] values){
        int maxValue = values[0];
        int maxIndex = 0;
        for(int k=0;k<values.length;k++){
            if(values[k] >= maxValue){
                maxValue = values[k];
                maxIndex = k;
            }
        }

        return maxIndex;
    }

    private static String removeNonLetters(String word){
        int startIndex = 0;
        int stopIndex = word.length();

        char firstChar = word.charAt(startIndex);
        char lastChar = word.charAt(stopIndex-1);

        if(!Character.isLetter(firstChar) && !Character.isLetter(lastChar)){
            word = word.substring(startIndex+1, stopIndex-1);
        } else if(!Character.isLetter(firstChar) && Character.isLetter(lastChar)){
            word = word.substring(startIndex+1, stopIndex);
        } else if(Character.isLetter(firstChar) && !Character.isLetter(lastChar)){
            word = word.substring(startIndex, stopIndex-1);
        }

        return word;
    }

    public static void countWordLengths(FileResource resource, int[] counts){
        int maxWordLength = counts.length;
        for(String word : resource.words()){
            word = removeNonLetters(word);
            int wordLength = word.length();
            if(wordLength >= maxWordLength){
                counts[maxWordLength-1] += 1;
            } else{

                counts[wordLength] += 1;
            }
        }
        for(int i=0;i<counts.length;i++){
            System.out.println(counts[i]);
        }

        Integer maxValue = indexOfMax(counts);
        System.out.println("maxIndex: "+maxValue);
    }

}