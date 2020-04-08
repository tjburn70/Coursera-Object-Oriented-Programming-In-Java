package week3;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class LogAnalyzerTest {

    @Test
    public void testReadFile() {
        String fileName = "weblog2_log.txt";
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile(fileName);
        logAnalyzer.printAll();
    }

    @Test
    public void testCountUniqueIps() {
        String fileName = "weblog2_log.txt";
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile(fileName);

        int expectedUniqueIps = 45;
        int actualUniqueIps = logAnalyzer.countUniqueIPs();

        Assert.assertEquals(
                expectedUniqueIps,
                actualUniqueIps
        );
    }

    @Test
    public void testPrintAllHigherThanNum() {
        String fileName = "weblog2_log.txt";
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile(fileName);

        int num = 400;
        logAnalyzer.printAllHigherThanNum(num);
    }

    @Test
    public void testUniqueIpVisitsOnDay() {
        String fileName = "weblog2_log.txt";
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile(fileName);

        String targetDateString = "Sep 27";
        ArrayList<String> uniqueIPs = logAnalyzer.uniqueIpVisitsOnDay(
                targetDateString
        );

        int expectedNumberOfIPs = 8;
        int actualNumberOfIPs = uniqueIPs.size();
        Assert.assertEquals(
                expectedNumberOfIPs,
                actualNumberOfIPs
        );
    }

    @Test
    public void testCountUniqueIPsInRange() {
        String fileName = "weblog2_log.txt";
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile(fileName);

        int low = 200;
        int high = 299;
        int expectedNumberOfIPs = 40;
        int actualNumberOfIPs = logAnalyzer.countUniqueIPsInRange(low, high);

        Assert.assertEquals(
                expectedNumberOfIPs,
                actualNumberOfIPs
        );
    }

    @Test
    public void testCountVisitsPerIP() {
        String fileName = "weblog2_log.txt";
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile(fileName);
        HashMap<String, Integer> ipToVisits = logAnalyzer.countVisitsPerIP();

        System.out.println(ipToVisits);
    }

    @Test
    public void testMostNumberVisitsByIP() {
        String fileName = "weblog2_log.txt";
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile(fileName);
        HashMap<String, Integer> ipToVisits = logAnalyzer.countVisitsPerIP();

        int expectedMaxVisits = 63;
        int actualMaxVisits = logAnalyzer.mostNumberVisitsByIP(ipToVisits);

        Assert.assertEquals(
                expectedMaxVisits,
                actualMaxVisits
        );
    }

    @Test
    public void testiPsMostVisits() {
        String fileName = "weblog2_log.txt";
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile(fileName);
        HashMap<String, Integer> ipToVisits = logAnalyzer.countVisitsPerIP();

        ArrayList<String> expectedIps = new ArrayList<>();
        expectedIps.add("188.162.84.63");
        ArrayList<String> iPsWithMaxVisits = logAnalyzer.iPsMostVisits(ipToVisits);

        Assert.assertEquals(
                expectedIps,
                iPsWithMaxVisits
        );
    }

    @Test
    public void testiPsForDays() {
        String fileName = "weblog1_log.txt";
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile(fileName);
        HashMap<String, ArrayList<String>> dateToIps = logAnalyzer.iPsForDays();
        System.out.println(dateToIps);
    }

    @Test
    public void testDayWithMostIPVisits() {
        String fileName = "weblog2_log.txt";
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile(fileName);
        HashMap<String, ArrayList<String>> dateToIps = logAnalyzer.iPsForDays();
        String dayWithMostVisits = logAnalyzer.dayWithMostIPVisits(dateToIps);

        String expectedDay = "Sep 24";
        Assert.assertEquals(
                expectedDay,
                dayWithMostVisits
        );
    }

    @Test
    public void testIPsWithMostVisitsOnDay() {
        String fileName = "weblog2_log.txt";
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile(fileName);
        HashMap<String, ArrayList<String>> dateToIps = logAnalyzer.iPsForDays();
        String accessDate = "Sep 29";

        ArrayList<String> expectedIps = new ArrayList<>();
        expectedIps.add("212.128.74.248");
        ArrayList<String> ips = logAnalyzer.iPsWithMostVisitsOnDay(dateToIps, accessDate);
        Assert.assertEquals(
                expectedIps,
                ips
        );
    }
}
