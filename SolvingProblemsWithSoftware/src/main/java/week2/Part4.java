package week2;

import edu.duke.URLResource;

public class Part4 {
    public static void printDomainNameLinksFromUrl(String url, String domainName){
        URLResource manyComputerScienceArticles = new URLResource(url);
        for(String word : manyComputerScienceArticles.words()){
            Integer domainNameLength = domainName.length();
            String lowerCaseWord = word.toLowerCase();
            Integer domainIndex = lowerCaseWord.indexOf(domainName);
            if(domainIndex != -1){
                String rawDomainName = word.substring(domainIndex, domainIndex+domainNameLength);
                String protocolAndSubdomain = getProtocolAndSubdomain(word, domainIndex);
                String path = getPath(word, domainIndex, domainNameLength);
                String link = protocolAndSubdomain + rawDomainName + path;
                System.out.println(link);
            }
        }
    }

    private static String getProtocolAndSubdomain(String word, Integer domainIndex){
        String quoteString = "\"";
        Integer firstQuoteIndex = word.indexOf(quoteString);
        String protocolAndSubdomain = word.substring(firstQuoteIndex+1, domainIndex);
        return protocolAndSubdomain;
    }

    private static String getPath(String word, Integer domainIndex, Integer domainNameLength){
        String quoteString = "\"";
        Integer lastQuoteIndex = word.lastIndexOf(quoteString);
        String path = word.substring(domainIndex+domainNameLength, lastQuoteIndex-1);
        return path;
    }

}
