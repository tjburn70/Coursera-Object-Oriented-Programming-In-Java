package week2;

import edu.duke.FileResource;
import edu.duke.StorageResource;
import org.junit.Assert;
import org.junit.Test;

public class GeneUtilsTest {

    @Test
    public void testGetGeneWithNoAtg() {
        String dna = "CGTTGATTAAA";
        Integer startIndex = 0;
        String actualResponse = GeneUtils.getGene(dna, startIndex);
        String expectedResponse = "";
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testGetGeneNoValidStopCodons(){
        String dna = "TTTATGAAAAAAAA";
        Integer startIndex = 0;
        String actualResponse = GeneUtils.getGene(dna, startIndex);
        String expectedResponse = "";
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testGetGeneWithValidStopCodonInvalidGene(){
        String dna = "ATGAAAGGTAA";
        Integer startIndex = 0;
        String actualResponse = GeneUtils.getGene(dna, startIndex);
        String expectedResponse = "";
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testGetGeneWithOneValidStopCodonAndValidGene() {
        String dna = "nonCodingDNAxxxMyGeneATGmyGenexTAAxxGeneATGTAACATGTAAATGCendTAATAAnonCodingDNAxTAGxTGA";
        Integer startIndex = 0;
        String actualResponse = GeneUtils.getGene(dna, startIndex);
        String expectedResponse = "atgmygenextaaxxgeneatgtaacatgtaaatgcendtaa";
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testGetGeneWithMultipleValidStopCodonsAndValidGene() {
        String dna = "TATATGAAATTTCCCTAATCTATATAG";
        Integer startIndex = 0;
        String actualResponse = GeneUtils.getGene(dna, startIndex);
        String expectedResponse = "atgaaatttccctaa";
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testGetAllGenes() {
        String dna = "TATATGAAATTTCCCTAATCATGTCTATATAG";
        String gene1 = "ATGAAATTTCCCTAA";
        String gene1Lower = gene1.toLowerCase();
        String gene2 = "ATGTCTATATAG";
        String gene2Lower = gene2.toLowerCase();
        Boolean expectedResponse = true;
        StorageResource allGenes = GeneUtils.getAllGenes(dna);
        Assert.assertEquals(expectedResponse, allGenes.contains(gene1Lower));
        Assert.assertEquals(expectedResponse, allGenes.contains(gene2Lower));
    }

    @Test
    public void testGetAllGenesNoValidGene() {
        String dna = "AAAAAATTTTTTGGGGGG";
        Integer expectedGeneSize = 0;
        StorageResource genes = GeneUtils.getAllGenes(dna);
        Integer actualGeneSize = genes.size();
        Assert.assertEquals(expectedGeneSize, actualGeneSize);
    }

    @Test
    public void testCgRatio() {
        String dna = "ATGCCCCCCCGGGGGGGTAA";
        Float cgRatio = GeneUtils.cgRatio(dna);
        Boolean expectedCgRatioIsGreaterThan35 = true;
        Boolean actualCgRatio = false;
        if(cgRatio > 0.35){
            actualCgRatio = true;
        }
        Assert.assertEquals(expectedCgRatioIsGreaterThan35, actualCgRatio);
    }

    @Test
    public void testCountCodon() {
        String dna = "ATGCCCCTTTTATGGGGATGGGGGTAA";
        String codon = "ATG";
        Integer expectedNumCodon = 3;
        Integer actualNumCodon = GeneUtils.countCodon(dna, codon);
        Assert.assertEquals(expectedNumCodon, actualNumCodon);
    }

    @Test
    public void testProcessGenesDnaWithGeneLongerThan60Char(){
        String dna = "atgcccgcaaggtctgtgctgatcaggacgcagctctgccttcggggtgcccctggactgcccgcccgcccgggtctgtgctga";

        Integer dnaLength =dna.length();
        System.out.println(dnaLength);
        StorageResource genes = GeneUtils.getAllGenes(dna);
        GeneUtils.processGenes(genes);
    }

    @Test
    public void testProcessGenesDnaWithGeneNotLongerThan60Char(){
        String dna = "nonCodingDNAxxxMyGeneATGmyGenexTAAxxGeneATGTAACATGTAAATGCendTAATAAnonCodingDNAxTAGxTGA";
        StorageResource genes = GeneUtils.getAllGenes(dna);
        GeneUtils.processGenes(genes);
    }

    @Test
    public void testProcessGenesDebug(){
        String dna = "atgaccgcaaggtcttgagctgatcaggacgcagctctgccttcggggtgcccctggactgcccgcccgcccgggtctgtgctga";
        StorageResource genes = GeneUtils.getAllGenes(dna);
        for(String gene : genes.data()){
            System.out.println("gene: " + gene);
        }
        GeneUtils.processGenes(genes);
    }

    @Test
    public void testProcessGenesDnaWithGeneWithCgRatioHigherThan35(){
        String dna = "ATGAAATTTCCCGGGTAG";
        StorageResource genes = GeneUtils.getAllGenes(dna);
        GeneUtils.processGenes(genes);
    }

    @Test
    public void testProcessGenesDnaWithGeneWithCgRatioLowerThan35(){
        String dna = "ATGAAAAAAAAAAATTTACTTTTCTAG";
        StorageResource genes = GeneUtils.getAllGenes(dna);
        GeneUtils.processGenes(genes);
    }

    @Test
    public void testProcessGenes(){
        FileResource fr = new FileResource();
        String dna = fr.asString();
        System.out.println(dna);
        StorageResource genes = GeneUtils.getAllGenes(dna);
        GeneUtils.processGenes(genes);
    }

    @Test
    public void debug(){
        FileResource fr = new FileResource();
        String dna = fr.asString();
        System.out.println(dna);
        String codonToCount = "CTG";
        Integer numCodon = GeneUtils.countCodon(dna, codonToCount);
        System.out.println(numCodon);
    }

}
