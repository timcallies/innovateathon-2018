import java.util.HashMap;

public class UserList
{
    private HashMap<Integer,UserData> userMap;
    
    private UserList()
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
    
    private class UserData
    {
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