package week2;

import edu.duke.FileResource;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CodonCounterTest {

    @Test
    public void testFrameWithMostUniqueCodons(){
        String path = "./ArraysListsAndStructuredData/src/test/resources/dnaMystery1";
        FileResource fr = new FileResource(path);
        String dna = fr.asString().trim();
        CodonCounter codonCounter = new CodonCounter();

        int maxNumberOfUniqueCodons = 0;
        int startIndexWithMaxUniqueCodons = 0;
        ArrayList<Integer> startIndexes = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        for(Integer startIndex : startIndexes){
            codonCounter.buildCodonMap(dna, startIndex);
            int numUniqueCodons = codonCounter.codonToFreq.keySet().size();
            if (numUniqueCodons >= maxNumberOfUniqueCodons){
                maxNumberOfUniqueCodons = numUniqueCodons;
                startIndexWithMaxUniqueCodons = startIndex;
            }
        }

        System.out.println("Max Number of Unique Codons: "+maxNumberOfUniqueCodons);
        System.out.println("Start Index with Max Unique Codons: "+startIndexWithMaxUniqueCodons);

        int expected = 2;
        int actual = startIndexWithMaxUniqueCodons;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testBuildCodonMapFromFrame2CodonAppears4Times(){
        String path = "./ArraysListsAndStructuredData/src/test/resources/dnaMystery1";
        FileResource fr = new FileResource(path);
        String dna = fr.asString().trim();
        CodonCounter codonCounter = new CodonCounter();
        Integer startIndex = 2;
        codonCounter.buildCodonMap(dna, startIndex);
        String mostCommonCodon = codonCounter.getMostCommonCodon();
        System.out.println("Most Common Codon: "+mostCommonCodon);

        String firstCodonFoundThatAppears4Times = "";
        for(String codon : codonCounter.codonToFreq.keySet()){
            int count = codonCounter.codonToFreq.get(codon);
            if (count == 4){
                firstCodonFoundThatAppears4Times = codon;
                break;
            }
        }

        System.out.println("Codon that appears 4 times: "+firstCodonFoundThatAppears4Times);

        String expected = "TTA";
        String actual = firstCodonFoundThatAppears4Times;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testBuildCodonMapFromFrame1CodonAppears6Times(){
        String path = "./ArraysListsAndStructuredData/src/test/resources/dnaMystery1";
        FileResource fr = new FileResource(path);
        String dna = fr.asString().trim();
        CodonCounter codonCounter = new CodonCounter();
        Integer startIndex = 1;
        codonCounter.buildCodonMap(dna, startIndex);

        String firstCodonFoundThatAppears6Times = "";
        for(String codon : codonCounter.codonToFreq.keySet()){
            int count = codonCounter.codonToFreq.get(codon);
            if (count == 6){
                firstCodonFoundThatAppears6Times = codon;
                break;
            }
        }

        System.out.println("Codon that appears 6 times: "+firstCodonFoundThatAppears6Times);

        String expected = "TTA";
        String actual = firstCodonFoundThatAppears6Times;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUniqueCodonsFrame1(){
        String path = "./ArraysListsAndStructuredData/src/test/resources/dnaMystery2";
        FileResource fr = new FileResource(path);
        String dna = fr.asString().trim();
        CodonCounter codonCounter = new CodonCounter();

        int startIndex = 1;
        codonCounter.buildCodonMap(dna, startIndex);
        int numUniqueCodons = codonCounter.codonToFreq.keySet().size();

        System.out.println("Number of Unique Codons: "+numUniqueCodons);
    }

    @Test
    public void testMostFrequentCodonFrame2(){
        String path = "./ArraysListsAndStructuredData/src/test/resources/dnaMystery2";
        FileResource fr = new FileResource(path);
        String dna = fr.asString().trim();
        CodonCounter codonCounter = new CodonCounter();

        int startIndex = 2;
        codonCounter.buildCodonMap(dna, startIndex);
        String mostCommonCodon = codonCounter.getMostCommonCodon();

        System.out.println("Most Common Codon: "+mostCommonCodon);
    }

    @Test
    public void testFindCodonThatOccurs7TimesFrame0(){
        String path = "./ArraysListsAndStructuredData/src/test/resources/dnaMystery2";
        FileResource fr = new FileResource(path);
        String dna = fr.asString().trim();
        CodonCounter codonCounter = new CodonCounter();

        int startIndex = 0;
        codonCounter.buildCodonMap(dna, startIndex);

        String firstCodonFoundThatAppears7Times = "";
        for(String codon : codonCounter.codonToFreq.keySet()){
            int count = codonCounter.codonToFreq.get(codon);
            if (count == 7){
                firstCodonFoundThatAppears7Times = codon;
                break;
            }
        }

        System.out.println("Codon that appears 7 times: "+firstCodonFoundThatAppears7Times);
    }

}
