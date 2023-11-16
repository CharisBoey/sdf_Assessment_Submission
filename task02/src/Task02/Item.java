package Task02;

public class Item {
    private int PROD_ID;
	private String TITLE;
	private String PRICE;
	private double RATING;
    private double budget;

    public Item(String PROD_ID, String TITLE, String PRICE, String RATING){
        this.PROD_ID = Integer.parseInt(PROD_ID);
        this.TITLE = TITLE;
        this.PRICE = PRICE;
        this.RATING = Double.parseDouble(RATING);
    }
    
    public Item() {
    }

    public int getPROD_ID() {
        return PROD_ID;
    }

    public void setPROD_ID(int PROD_ID) {
        this.PROD_ID = PROD_ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public Double getRATING() {
        return RATING;
    }

    public void setRATING(Double RATING) {
        this.RATING = RATING;
    }

    

    public double getBudget() {
        return budget;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }

}
