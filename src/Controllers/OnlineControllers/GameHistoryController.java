package Controllers.OnlineControllers;


public class GameHistoryController implements Controllers{
    
    
    
    public GameHistoryController(){
    getHistory();
    
    }
    
    private void getHistory(){
        ClientThreadHandler.queryQueue.add("gethistory,"+LoginController.getUsername());
        ClientThreadHandler.controllersMap.put("history", this);
    }
    public void setHistory(String history ){
        System.out.println("TEST: "+ history);
    }
    
    
}
