import java.io.*;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class ServerDriver
{
    public static void main(String[] args)
    {
        RecyclingLog log;
        UserList list;
        
        File logFile = new File("C:/Users/timca/Desktop/testlog.log");
        File listFile = new File("C:/Users/timca/Desktop/testlist.log");
        
        //Loads in the database, if it exists
        list=null;
        if (listFile.exists())
        {
            try
            {
                FileInputStream fin = new FileInputStream(listFile);
                ObjectInputStream oin = new ObjectInputStream(fin);
                list=(UserList)oin.readObject();
            }
            catch(IOException ioe){list = new UserList();}
            catch(ClassNotFoundException cnfe){list = new UserList();}
        }
        
        //Creates a new database if one does not exist
        else
        {
            list = new UserList();
        }
        
        //Loads in the log data, adds it to the list, and prints it
        try
        {
            FileInputStream fin = new FileInputStream(logFile);
            ObjectInputStream oin = new ObjectInputStream(fin);
            log=(RecyclingLog)oin.readObject();
            
            
            ProcessLogData.processData(list, log);
            JOptionPane.showMessageDialog(null,list.toString());  
            System.out.println(list);
            
            //Writes the database to a file
            FileOutputStream fout = new FileOutputStream(listFile);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(list);
        }
        catch(IOException ioe){}
        catch(ClassNotFoundException cnfe){}
    }
}