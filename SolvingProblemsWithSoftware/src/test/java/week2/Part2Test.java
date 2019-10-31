package week2;
import org.junit.Assert;
import org.junit.Test;

public class Part2Test {
    @Test
    public void testSimpleGeneWithNoAtg(){
        String dna = "CGTTGATTAAA";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String expectedResponse = "";
        String actualResponse = Part2.findSimpleGene(dna, startCodon, stopCodon);
        Assert.assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testSimpleGeneWithNoTaa(){
        String dna = "ATGTTTGGGAAA";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String expectedResponse = "";
        String actualResponse = Part2.findSimpleGene(dna, startCodon, stopCodon);
        Assert.assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testSimpleGeneWithNoAtgNoTaa(){
        String dna = "NOAAAGGGTTTNOTTTAAAAAAA";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String expectedResponse = "";
        String actualResponse = Part2.findSimpleGene(dna, startCodon, stopCodon);
        Assert.assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testSimpleGeneWithAtgAndTaaAndNotMultipleOf3(){
        String dna = "ATGCTAA";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String expectedResponse = "";
        String actualResponse = Part2.findSimpleGene(dna, startCodon, stopCodon);
        Assert.assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testSimpleGeneWithAtgAndTaaAndMultipleOf3UpperCaseDna(){
        String dna = "AAATGCCCTAACTAGATTAAGAAACC";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String expectedResponse = "ATGCCCTAA";
        String actualResponse = Part2.findSimpleGene(dna, startCodon, stopCodon);
        Assert.assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testSimpleGeneWithAtgAndTaaAndMultipleOf3LowerCaseDna(){
        String dna = "gctatgacttaacta";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String expectedResponse = "atgacttaa";
        String actualResponse = Part2.findSimpleGene(dna, startCodon, stopCodon);
        Assert.assertEquals(expectedResponse, actualResponse);
    }
}
