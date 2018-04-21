import java.util.Date;

public class LogEntry
{
  private double currentWeight;
  private int UserID;
  private Date dateOfEntry;
  /*
  currentWeight: The weight of the machine when the user swipes their card.
  UserID: The value on the user's identification card.
  dateOfEntry: The date when an entry was made.
  */
  public LogEntry(double currentWeight, int UserID)
  {
    this.UserID=UserID;
    this.currentWeight=currentWeight;
    dateOfEntry=new Date();
  }

  public int getUserID()
  {
    return UserID;
  }

  public double getCurrentWeight()
  {
    return currentWeight;
  }

  public Date getDateOfEntry()
  {
    return dateOfEntry;
  }
}
