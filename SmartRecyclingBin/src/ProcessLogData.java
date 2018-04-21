
import java.util.Iterator;

public class ProcessLogData
{
    public static void processData(UserList userList, RecyclingLog recyclingLog)
    {
        //Processes all of the data in the machine's log and adds it into the
        //userList
        Iterator<LogEntry> logIterator = recyclingLog.getIterator();
        
        LogEntry thisLog;
        LogEntry prevLog=null;
        
        while(logIterator.hasNext())
        {
            thisLog=logIterator.next();
            try
            {
                if (prevLog==null)
                {
                    //First entry in the array, contains admin's swipe
                    thisLog=prevLog;
                }
                else
                {
                    if(thisLog.getCurrentWeight()<prevLog.getCurrentWeight())
                    {
                        //Checks if the current weight is valid
                        throw new InvalidWeightException(
                                "Weight of one log is less than weight of previous log");
                    }
                    
                    //Add the weight into the userList
                    userList.addWeightToUser(
                            thisLog.getUserID(),
                            thisLog.getCurrentWeight()-prevLog.getCurrentWeight()
                    );
                    prevLog=thisLog;
                }
            }
            catch(InvalidWeightException iwe)
            {
                thisLog=logIterator.next();
            }
        }
    }    
}