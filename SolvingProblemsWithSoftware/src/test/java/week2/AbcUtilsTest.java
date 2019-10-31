package week2;

import org.junit.Test;

public class AbcUtilsTest {
    @Test
    public void testFindAbc(){
        String input = "abcabcabcabca";
        AbcUtils.findAbc(input);
    }
}
