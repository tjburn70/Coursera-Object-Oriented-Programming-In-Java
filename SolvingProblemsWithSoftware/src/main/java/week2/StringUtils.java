package week2;

public class StringUtils {
    public static Integer howMany(String stringKey, String stringBody){
        Integer countOfStringKeyInStringBody = 0;
        Integer startIndex = stringBody.indexOf(stringKey);
        while(startIndex != -1){
            countOfStringKeyInStringBody++;
            Integer lengthStringKey = stringKey.length();
            startIndex = stringBody.indexOf(stringKey, startIndex+lengthStringKey);
        }
        return countOfStringKeyInStringBody;
    }
}
