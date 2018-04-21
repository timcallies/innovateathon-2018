import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class ClientDriver
{
    public static void main(String[] args) throws IOException
    {
        boolean doLoop=true;
        
        RecyclingLog log=new RecyclingLog("C:/Users/timca/Desktop/testlog.log");
        while(doLoop)
        {
            try
            {
                double thisWeight=Double.parseDouble(JOptionPane.showInputDialog(
                        "Type in the weight in the recycling bin"));
                int thisUserID=Integer.parseInt(JOptionPane.showInputDialog(
                        "Type in the ID of the user"));

                if(thisUserID==RecyclingLog.ADMIN_ID)
                {
                    doLoop=false;
                }
                else
                {
                    log.addEntry(thisWeight, thisUserID);
                }
            }
            catch(NumberFormatException nfe){}
        }
        System.out.println(log);
        
        //Write the log to a file
        FileOutputStream fout = new FileOutputStream(log.getLogFile());
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(log);
    }
}
