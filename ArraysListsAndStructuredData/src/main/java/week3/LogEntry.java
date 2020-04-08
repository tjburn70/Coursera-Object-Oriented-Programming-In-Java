package week3;

import java.util.Date;

public class LogEntry {

    private String ipAddress;
    private Date accessDate;
    private String request;
    private int statusCode;
    private int bytesReturned;

    public LogEntry(String ipAddress, Date accessDate,
                    String request, int statusCode, int bytesReturned) {
        this.ipAddress = ipAddress;
        this.accessDate = accessDate;
        this.request = request;
        this.statusCode = statusCode;
        this.bytesReturned = bytesReturned;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Date getAccessDate() {
        return accessDate;
    }

    public String getRequest() {
        return request;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public int getBytesReturned() {
        return bytesReturned;
    }

    public String toString() {
        return ipAddress + " " + accessDate + " " +
                request + " " + statusCode + " " + bytesReturned;
    }




}
