package week2;

import edu.duke.FileResource;

import java.util.ArrayList;

public class WordFrequencies {
    public ArrayList<String> myWords;
    public ArrayList<Integer> myFreqs;

    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    public void findUnique(){
        myWords.clear();
        myFreqs.clear();

        FileResource fr = new FileResource();

        for(String word : fr.words()){
            word = word.toLowerCase();
            int index = myWords.indexOf(word);
            if (index == -1){
                myWords.add(word);
                myFreqs.add(1);
            } else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);
            }
        }
    }

    public int findIndexOfMax(){
        int maxIndex = 0;
        int maxFreq = 0;

        for (int i=0; i<myFreqs.size(); i++){
            int freq = myFreqs.get(i);
            if (freq > maxFreq){
                maxFreq = freq;
                maxIndex = i;
            }
        }

        return maxIndex;
    }


}
