package week2;
import org.junit.Assert;
import org.junit.Test;

public class Part1Test {
    @Test
    public void testSimpleGeneWithNoAtg(){
        String dna = "CGTTGATTAAA";
        String actualResponse = Part1.findSimpleGene(dna);
        String expectedResponse = "";
        Assert.assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testSimpleGeneWithNoTaa(){
        String dna = "ATGTTTGGGAAA";
        String actualResponse = Part1.findSimpleGene(dna);
        String expectedResponse = "";
        Assert.assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testSimpleGeneWithNoAtgNoTaa(){
        String dna = "NOAAAGGGTTTNOTTTAAAAAAA";
        String actualResponse = Part1.findSimpleGene(dna);
        String expectedResponse = "";
        Assert.assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testSimpleGeneWithAtgAndTaaAndMultipleOf3(){
        String dna = "GCTATGACTTAACTA";
        String actualResponse = Part1.findSimpleGene(dna);
        String expectedResponse = "ATGACTTAA";
        Assert.assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testSimpleGeneWithAtgAndTaaAndNotMultipleOf3(){
        String dna = "ATGCTAA";
        String actualResponse = Part1.findSimpleGene(dna);
        String expectedResponse = "";
        Assert.assertEquals(expectedResponse, actualResponse);
    }

}
