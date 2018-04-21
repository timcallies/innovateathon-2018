

import java.io.File;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class RecyclingLog implements Serializable
{
    public static final int ADMIN_ID=0;
    
    private File logFile;
    private static final long serialVersionUID = 1;
    private LinkedList<LogEntry> logData;
    /*
    logFile: The file where all of the information will be stored
    */
    public RecyclingLog(String logAddress)
    {
        logData = new LinkedList();
        logFile = new File(logAddress);
    }

    public LogEntry addEntry(LogEntry thisEntry)
    {

        logData.add(thisEntry);
        return thisEntry;
    }

    public LogEntry addEntry(double currentWeight, int userID)
    {
        return addEntry(new LogEntry(currentWeight, userID));
    }
    
    public String toString()
    {
        StringBuilder str= new StringBuilder("User----Weight----Time\n");
        for (LogEntry thisEntry : logData)
        {
            str.append(String.format("%05d--", thisEntry.getUserID()));
            str.append(String.format("%05g--", thisEntry.getCurrentWeight()));
            str.append(thisEntry.getDateOfEntry().toString());
            str.append("\n");
        }
        return str.toString();
    }
    
    public Iterator<LogEntry> getIterator()
    {return logData.iterator();}
    
    public File getLogFile()
    {return logFile;}
}