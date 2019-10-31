package week2;
import java.util.HashMap;

public class CodonCounter {

    public HashMap<String, Integer> codonToFreq;

    public CodonCounter(){
        codonToFreq = new HashMap<String, Integer>();
    }

    public void buildCodonMap(String dna, Integer start){
        dna = dna.toUpperCase();
        String currCodon = new String();
        for(int i=start; i<dna.length(); i+=3){
            if(i+3 < dna.length()){
                currCodon = dna.substring(i, i+3);
                if (codonToFreq.keySet().contains(currCodon)){
                    Integer freq = codonToFreq.get(currCodon);
                    codonToFreq.put(currCodon, freq+1);
                } else {
                    codonToFreq.put(currCodon, 1);
                }
            }
        }

    }

    public String getMostCommonCodon(){
        String mostCommonCodon = new String();
        Integer maxCount = 0;
        for(String codon : codonToFreq.keySet()){
            Integer value = codonToFreq.get(codon);
            if (value >= maxCount){
                maxCount = value;
                mostCommonCodon = codon;
            }
        }

        return mostCommonCodon;
    }

    public void printCodonCounts(Integer start, Integer end){
        for(String codon : codonToFreq.keySet()){
            Integer value = codonToFreq.get(codon);
            if (value >= start && value <= end){
                System.out.println(codon + " : " + value);
            }
        }
    }

}
