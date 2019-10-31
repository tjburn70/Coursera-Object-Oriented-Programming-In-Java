package week2;

public class Part1 {
    public static String findSimpleGene(String dna){
        String validGene = "";
        Integer startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return "";
        }
        Integer stopIndex = dna.indexOf("TAA", startIndex);
        if (stopIndex == -1){
            return "";
        }
        String simpleGene = dna.substring(startIndex, stopIndex+3);
        Integer potentialGeneLength = simpleGene.length();
        Integer codonLength = 3;
        if(potentialGeneLength % codonLength == 0){
            validGene = simpleGene;
            return validGene;
        } else {
            return "";
        }

    }
}
