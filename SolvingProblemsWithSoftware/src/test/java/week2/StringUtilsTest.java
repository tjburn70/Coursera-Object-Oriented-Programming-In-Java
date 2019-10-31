package week2;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {
    @Test
    public void testHowMany() {
        String stringKey = "pie";
        String stringBody = "keylimepiechocolatepierasberrypie";
        Integer expectedResponse = 3;
        Integer actualResponse = StringUtils.howMany(stringKey, stringBody);
        Assert.assertEquals(expectedResponse, actualResponse);
    }
}
