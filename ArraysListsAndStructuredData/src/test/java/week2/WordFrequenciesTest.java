package week2;
import org.junit.Test;

public class WordFrequenciesTest {
    @Test
    public void testFindUnique(){
        WordFrequencies wf = new WordFrequencies();
        wf.findUnique();
        System.out.println(
           "Number of unique words: " + wf.myWords.size()
        );
        for(int k=0; k < wf.myWords.size(); k++){
            int frequency = wf.myFreqs.get(k);
            String word = wf.myWords.get(k);
            System.out.println(frequency + "\t" + word);
        }

        int maxIndex = wf.findIndexOfMax();
        String mostFrequentWord = wf.myWords.get(maxIndex);
        int maxFreq = wf.myFreqs.get(maxIndex);
        System.out.println(
            "The word that occurs most often and its frequency: " + mostFrequentWord + " | " + maxFreq
        );
    }
}
