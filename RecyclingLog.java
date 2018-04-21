public class RecyclingLog
{
  private File logFile;
  /*
  logFile: The file where all of the information will be stored
  */
}

public RecyclingLog(String logFile)
{
  this.logFile=new File(logFile);
}

public LogEntry addEntry(LogEntry thisEntry)
{

}

public LogEntry addEntry(double currentWeight, int userID)
{
  return this.addEntry(new LogEntry(double currentWeight, int userID));
}
