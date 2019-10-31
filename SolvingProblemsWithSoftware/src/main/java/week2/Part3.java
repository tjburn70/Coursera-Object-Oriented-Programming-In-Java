package week2;

public class Part3 {
    public static Boolean twoOccurences(String stringa, String stringb){
        String lowerStringA = stringa.toLowerCase();
        String lowerStringB = stringb.toLowerCase();

        Integer startIndex = lowerStringB.indexOf(lowerStringA);
        if(startIndex == -1){
            return false;
        }
        Integer lowerStringALength = lowerStringA.length();
        Integer lowerStringBLength = lowerStringB.length();
        String lowerStringBSubstring = lowerStringB.substring(startIndex+lowerStringALength, lowerStringBLength);

        Boolean stringAInBTwice = lowerStringBSubstring.contains(lowerStringA);
        return stringAInBTwice;
    }

    public static String lastPart(String stringa, String stringb){
        String lowerStringA = stringa.toLowerCase();
        String lowerStringB = stringb.toLowerCase();

        Integer startIndex = lowerStringB.indexOf(lowerStringA);
        if(startIndex == -1){
            return stringb;
        }
        Integer lowerStringALength = lowerStringA.length();
        Integer lowerStringBLength = lowerStringB.length();
        String lowerStringBSubstring = lowerStringB.substring(startIndex+lowerStringALength, lowerStringBLength);
        return lowerStringBSubstring;
    }

}
