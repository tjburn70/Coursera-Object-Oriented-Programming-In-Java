package week1;

import edu.duke.FileResource;
import org.junit.Test;

public class WordLengthCCTest{
    @Test
    public void testCountWordLengths(){
        String filePath = "./ArraysListsAndStructuredData/src/test/resources/romeo.txt";
        FileResource resource = new FileResource(filePath);
        int counts[] = new int[30];

        WordLengthCC.countWordLengths(resource, counts);
    }

}