package week2;

public class Part2 {
    public static String findSimpleGene(String dna, String startCodon, String stopCodon){
        String lowerCaseDna = dna.toLowerCase();
        String lowerCaseStartCodon = startCodon.toLowerCase();
        String lowerCaseStopCodon = stopCodon.toLowerCase();
        Integer startIndex = lowerCaseDna.indexOf(lowerCaseStartCodon);
        if(startIndex == -1){
            return "";
        }
        Integer stopIndex = lowerCaseDna.indexOf(lowerCaseStopCodon, startIndex);
        if (stopIndex == -1){
            return "";
        }
        String simpleGene = lowerCaseDna.substring(startIndex, stopIndex+3);
        Boolean validGene = validateGene(simpleGene);
        if(!validGene){
            return "";
        }
        Boolean isUpperCase = checkDnaCase(dna);
        if(isUpperCase){
            return simpleGene.toUpperCase();
        } else {
            return simpleGene;
        }
    }

    public static Boolean checkDnaCase(String dna){
        boolean isUpperCase = dna.equals(dna.toUpperCase());
        return isUpperCase;
    }

    public static Boolean validateGene(String simpleGene){
        Integer potentialGeneLength = simpleGene.length();
        Integer codonLength = 3;
        if(potentialGeneLength % codonLength == 0){
            return true;
        } else {
            return false;
        }
    }
}
