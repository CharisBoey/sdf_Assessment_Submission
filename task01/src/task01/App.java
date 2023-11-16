package task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {
    private String appName;
    private String appCategory;
    //should be double
    private String appRating;
    private String appRate;
    //private boolean nullRating = false;
    //private int discarded;

    public App(String appName, String appCategory, String appRating){
        this.appName = appName;
        this.appCategory = appCategory;
        /* while (!appRating.matches("[0-9]+")){
            nullRating = true;
        } */
        this.appRating = appRating;
        //Double.parseDouble(appRating);
        //this.discarded = discarded;
    }
    /* public App(String appName, String appCategory, Double appRate){
        this.appName = appName;
        this.appCategory = appCategory;
        this.appRating = appRating;
    } */
        

    


    public String getAppName() {
        return appName;
    }
    public void setAppName(String appName) {
        this.appName = appName;
    }
    public String getAppCategory() {
        return appCategory;
    }
    public void setAppCategory(String appCategory) {
        this.appCategory = appCategory;
    }
    public String getAppRating() {
        return appRating;
    }
    public void setAppRating(String appRating) {
        this.appRating = appRating;
    }
    /* public int getDiscarded() {
        return discarded;
    }
    public void setDiscarded(int discarded) {
        this.discarded = discarded;
    } */

    /* public boolean isNullRating() {
        return nullRating;
    } */
    
   /*  public void discardedCount() {
        setDiscarded(getDiscarded() + 1);
    } */


    //public void Highest(App application){
      //  Stack<App> Highest = new Stack<>();
        //App[] appHighestRank = new App[1];
        //App app = new App(appName, appCategory, appRating);
        //appHighestRank[0] = app;
        /* for(App ap : appHighestRank){
            if (Double.parseDouble(appRating)> Double.parseDouble(ap.getAppRating())){
                appHighestRank[0] = ap;
            }
        } */

       /*  if (Highest.size()<=0){
            Highest.push(application);
        } else if (Double.parseDouble(appRating)> Double.parseDouble(Highest.peek().getAppRating())){
            Highest.push(application);
        }
    } */

   /*  public App determineHighest(List<App> App){
        Stack<App> detHighest = new Stack<>();
        App theHighest;
        for (int i = 0; i<App.size(); i++){
            if(detHighest.size() <=0 ){
                detHighest.push(App.get(i));
            } else {
                double ratingCurr = Double.parseDouble(App.get(i).getAppRating());
                double ratingHighest = Double.parseDouble(detHighest.peek().getAppRating());
                if (ratingCurr > ratingHighest){
                    detHighest.push(App.get(i));
                } else {
                    continue;
                }
            }
            if (det)

        }
        theHighest = detHighest.pop();
        return theHighest;
        
    }
 */
    
}
