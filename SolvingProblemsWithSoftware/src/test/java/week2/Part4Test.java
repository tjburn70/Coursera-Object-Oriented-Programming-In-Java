package week2;
import org.junit.Test;

public class Part4Test {
    @Test
    public void testPrintYoutubeLinksFromUrl(){
        String url = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
        String domainName = "youtube.com";
        Part4.printDomainNameLinksFromUrl(url, domainName);
    }
}
