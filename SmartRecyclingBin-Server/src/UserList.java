

import java.io.Serializable;
import java.util.HashMap;

public class UserList implements Serializable
{
    private static final long serialVersionUID = 1;
    private HashMap<Integer,UserData> userMap;
    
    public UserList()
    {
        userMap = new HashMap<Integer,UserData>();
    }
    
    public void addWeightToUser(int userID, double weightToAdd)
    {
        if (userMap.get(userID) == null)
        {
            userMap.put(userID, new UserData());
            //Adds new user to the map if one does not exist
        }
        
        userMap.get(userID).addWeight(weightToAdd);
    }
    
    public void removeBalanceFromUser(int userID, double loss)
    {
        if (userMap.get(userID) == null)
        {
            userMap.put(userID, new UserData());
            //Adds new user to the map if one does not exist
        }
        
        userMap.get(userID).removeBalance(loss);
    }    
    
    public String toString()
    {
        StringBuilder str=new StringBuilder("User----Balance----Weight\n");
        for(int thisID : userMap.keySet())
        {
            str.append(String.format("%05d--", thisID));
            str.append(String.format("%05g--", userMap.get(thisID).currentBalance));
            str.append(String.format("%05g", userMap.get(thisID).totalWeight));
            str.append("\n");
        }
        return str.toString();
    }
    
    private class UserData implements Serializable
    {
        private static final long serialVersionUID = 1;
        public double totalWeight;
        public double currentBalance;
        
        public UserData()
        {
            totalWeight=0;
            currentBalance=0;
        }
        
        public void addWeight(double newWeight)
        {
            totalWeight+=newWeight;
            currentBalance+=newWeight;
        }
        
        public void removeBalance(double loss)
        {
            currentBalance-=loss;
        }
    }
}