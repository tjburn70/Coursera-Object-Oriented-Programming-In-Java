package week2;

import edu.duke.StorageResource;

import java.util.ArrayList;
import java.util.List;

public class GeneUtils {

    public static Integer countCodon(String dna, String codonToCount){
        Integer countCodon = 0;
        dna = dna.toLowerCase();
        codonToCount = codonToCount.toLowerCase();
        Integer currIndex = dna.indexOf(codonToCount);
        while(currIndex != -1){
            countCodon++;
            currIndex = dna.indexOf(codonToCount, currIndex+3);
        }
        return countCodon;
    }

    public static Float cgRatio(String dna){
        Integer numC = 0;
        Integer numG = 0;
        Integer dnaLength = dna.length();
        dna = dna.toLowerCase();

        for(int i=0; i<dnaLength; i++){
            if(dna.charAt(i) == 'c'){
                numC = numC + 1;
            }
            if(dna.charAt(i) == 'g'){
                numG = numG + 1;
            }
        }
        Integer numCAndG = numC + numG;
        Float cgRatio = (float) numCAndG/dnaLength;
        return cgRatio;
    }

    public static Integer findStopIndex(String dna, Integer startIndex){
        String[] stopCodonTags = {"tag", "taa", "tga"};
        List<Integer> stopCodonIndices = new ArrayList<>();
        for(String stopCodon : stopCodonTags){
            Integer stopIndex = dna.indexOf(stopCodon, startIndex);

            while(stopIndex != -1){
                Integer diff = stopIndex - startIndex;
                if(diff %3 == 0){
                    stopCodonIndices.add(stopIndex);
                }
                stopIndex = dna.indexOf(stopCodon, stopIndex+3);
            }
        }

        if(stopCodonIndices.isEmpty()){
            return -1;
        }
        Integer minStopCodonIndex = MathUtils.getMinValue(stopCodonIndices);
        return minStopCodonIndex;
    }

    public static String getGene(String dna, Integer fromIndex){
        dna = dna.toLowerCase();
        String startCodon = "atg";
        Integer startIndex = dna.indexOf(startCodon, fromIndex);
        if(startIndex == -1){
            return "";
        }

        Integer stopIndex = findStopIndex(dna, startIndex);
        if(stopIndex == -1){
            return "";
        }

        String gene = dna.substring(startIndex, stopIndex+3);
        return gene;
    }

    public static StorageResource getAllGenes(String dna){
        StorageResource geneList = new StorageResource();
        dna = dna.toLowerCase();
        Integer startIndex = 0;
        while (true){
            String gene = getGene(dna, startIndex);
            if(gene.isEmpty()){
                break;
            }
            geneList.add(gene);
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        return geneList;
    }

    public static void processGenes(StorageResource geneList){
        Integer numGenesLongerThan60Characters = 0;
        Integer numGenesCgRatioHigherThan35 = 0;
        Integer maxGeneLength = 0;
        Integer numberOfGenes = 0;

        for(String gene : geneList.data()){
            System.out.println("Gene: " + gene);
            if(gene.length() > 60){
                System.out.println("Gene longer than 60 characters: "+gene);
                numGenesLongerThan60Characters++;
            }
            Float geneCgRatio = cgRatio(gene);
            if(geneCgRatio > 0.35){
                System.out.println("Gene with CG Ratio > 0.35: "+gene);
                numGenesCgRatioHigherThan35++;
            }
            if(gene.length() > maxGeneLength){
                maxGeneLength = gene.length();
            }
            numberOfGenes++;
        }
        System.out.println("Num Genes longer than 60 characters: " +numGenesLongerThan60Characters);
        System.out.println("Num Genes CG Ratio > 0.35: "+numGenesCgRatioHigherThan35);
        System.out.println("Max Gene Length: "+maxGeneLength);
        System.out.println("Number of Genes: "+numberOfGenes);
    }

}
