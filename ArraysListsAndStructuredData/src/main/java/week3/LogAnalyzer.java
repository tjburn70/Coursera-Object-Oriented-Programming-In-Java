package week3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import edu.duke.FileResource;


public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        this.records = new ArrayList<>();
    }

    public void readFile(String filename) {
        FileResource fr = new FileResource(filename);
        for (String line : fr.lines()) {
            LogEntry logEntry = WebLogParser.parseEntry(line);
            records.add(logEntry);
        }
    }

    public void printAll() {
        for (LogEntry logEntry : records) {
            System.out.println(logEntry);
        }
    }

    public int countUniqueIPs() {
        ArrayList<String> uniqueIPs = new ArrayList<>();
        for (LogEntry logEntry : records) {
            String ipAddress = logEntry.getIpAddress();
            if (!uniqueIPs.contains(ipAddress)) {
                uniqueIPs.add(ipAddress);
            }
        }

        return uniqueIPs.size();
    }

    public void printAllHigherThanNum(int num) {
        for (LogEntry logEntry : records) {
            int statusCode = logEntry.getStatusCode();
            if (statusCode > num) {
                System.out.println(logEntry);
            }
        }
    }

    public ArrayList<String> uniqueIpVisitsOnDay(String targetDate) {
        ArrayList<String> uniqueIPs = new ArrayList<>();
        for (LogEntry logEntry : records) {
            String visitedOn = logEntry.getAccessDate().toString();
            String ipAddress = logEntry.getIpAddress();
            if (visitedOn.contains(targetDate) && !uniqueIPs.contains(ipAddress)) {
                uniqueIPs.add(ipAddress);
            }
        }

        return uniqueIPs;
    }

    public int countUniqueIPsInRange(int low, int high) {
        ArrayList<String> uniqueIPsWithinRange = new ArrayList<>();
        for (LogEntry logEntry : records) {
            int statusCode = logEntry.getStatusCode();
            String ipAddress = logEntry.getIpAddress();
            if (statusCode >= low && statusCode <= high && !uniqueIPsWithinRange.contains(ipAddress)) {
                uniqueIPsWithinRange.add(ipAddress);
            }
        }

        return uniqueIPsWithinRange.size();
    }

    public HashMap<String, Integer> countVisitsPerIP() {
        HashMap<String, Integer> ipToVisits = new HashMap<String, Integer>();
        for (LogEntry logEntry : records) {
            String ipAddress = logEntry.getIpAddress();
            Integer visits = ipToVisits.get(ipAddress);
            if (visits == null) {
                ipToVisits.put(ipAddress, 1);
            } else {
                ipToVisits.put(ipAddress, visits+1);
            }
        }

        return ipToVisits;
    }

    public int mostNumberVisitsByIP(HashMap<String, Integer> ipToVisits) {
        int maxVisits = 0;
        for (Map.Entry<String, Integer> entry : ipToVisits.entrySet()) {
            int numVisits = entry.getValue();
            if (numVisits >= maxVisits) {
                maxVisits = numVisits;
            }
        }

        return maxVisits;
    }

    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> ipToVisits) {
        int maxVisits = mostNumberVisitsByIP(ipToVisits);
        ArrayList<String> iPsWithMaxVisits = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : ipToVisits.entrySet()) {
            int numVisits = entry.getValue();
            if (numVisits == maxVisits) {
                iPsWithMaxVisits.add(entry.getKey());
            }
        }

        return iPsWithMaxVisits;
    }

    private String formatAccessDate(Date accessDate) {
        String targetDateString = accessDate.toString();
        return targetDateString.substring(4, 10);
    }

    public HashMap<String, ArrayList<String>> iPsForDays() {
        HashMap<String, ArrayList<String>> dateToIps = new HashMap<>();

        for (LogEntry logEntry : records) {
            Date accessDate = logEntry.getAccessDate();
            String accessDateSting = this.formatAccessDate(accessDate);
            String ipAddress = logEntry.getIpAddress();

            if (!dateToIps.containsKey(accessDateSting)) {
                ArrayList<String> ips = new ArrayList<>();
                ips.add(ipAddress);
                dateToIps.put(accessDateSting, ips);
            } else {
                dateToIps.get(accessDateSting).add(ipAddress);
            }
        }

        return dateToIps;
    }

    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> dateToIps) {
        int mostIpVisits = 0;
        String day = "";
        for (Map.Entry<String, ArrayList<String>> entry : dateToIps.entrySet()) {
            String dateKey = entry.getKey();
            ArrayList<String> ips = entry.getValue();
            int numIps = ips.size();
            if (numIps >= mostIpVisits) {
                mostIpVisits = numIps;
                day = dateKey;
            }
        }

        return day;
    }

    private HashMap<String, Integer> mapIpToVisits(ArrayList<String> ips) {
        HashMap<String, Integer> ipToVisits = new HashMap<String, Integer>();
        for (String ip : ips) {
            Integer visits = ipToVisits.get(ip);
            if (visits == null) {
                ipToVisits.put(ip, 1);
            } else {
                ipToVisits.put(ip, visits+1);
            }
        }
        return ipToVisits;
    }

    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> dateToIps, String day) {
        ArrayList<String> ips = dateToIps.get(day);
        HashMap<String, Integer> ipToVisits = this.mapIpToVisits(ips);

        return this.iPsMostVisits(ipToVisits);
    }



}
