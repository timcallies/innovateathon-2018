import java.io.Serializable;
import java.util.Date;

public class LogEntry implements Serializable
{
  private double currentWeight;
  private int userID;
  private Date dateOfEntry;
  private static final long serialVersionUID = 1;
  /*
  currentWeight: The weight of the machine when the user swipes their card.
  userID: The value on the user's identification card.
  dateOfEntry: The date when an entry was made.
  */
  public LogEntry(double currentWeight, int userID)
  {
    this.userID=userID;
    this.currentWeight=currentWeight;
    dateOfEntry=new Date();
  }

  public int getUserID()
  {
    return userID;
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
