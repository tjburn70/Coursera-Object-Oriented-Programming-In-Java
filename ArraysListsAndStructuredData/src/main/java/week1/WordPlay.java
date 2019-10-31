package week1;

public class WordPlay {
    public static Boolean isVowel(char ch){
        Boolean isVowel = false;
        char[] charArray ={ 'a', 'e', 'i', 'o', 'u' };
        for(char c : charArray){
            c = Character.toLowerCase(c);
            if(c == ch){
                isVowel = true;
                break;
            }
        }
        return isVowel;
    }

    public static String replaceVowel(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);

        for(Integer i=0; i<sb.length(); i++){
            char currChar = sb.charAt(i);
            Boolean isVowel = isVowel(currChar);
            if(isVowel){
                sb.setCharAt(i, ch);
            }
        }
        String transformedString = sb.toString();
        return transformedString;
    }

    public static String emphasize(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
        char replacementChar;

        for(Integer i=0; i<sb.length(); i++){
            char currChar = sb.charAt(i);
            if(currChar == ch && i%2 == 0){
                replacementChar = '*';
                sb.setCharAt(i, replacementChar);
            } else if(currChar == ch && i%2 == 1){
                replacementChar = '+';
                sb.setCharAt(i, replacementChar);
            }
        }
        String transformedString = sb.toString();
        return transformedString;
    }

}
