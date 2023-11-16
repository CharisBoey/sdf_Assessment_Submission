package task01;

public class App {
    private String appName;
    private String appCategory;
    private String appRating;

    public App(String appName, String appCategory, String appRating){
        this.appName = appName;
        this.appCategory = appCategory;
        this.appRating = appRating;
    }


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
    
}
