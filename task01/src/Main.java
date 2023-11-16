package task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main{
    //securing the index of required columns
        public static final int COL_APPNAME = 0;
        public static final int COL_APPCATEGORY = 1;
        public static final int COL_APPRATING = 2;

    public static void main(String[] args) throws Exception {
        int count;
        int discardedCount = 0;
        List<String> rank = new ArrayList<>();
        Stack<App> Highest = new Stack<>();
        App High = new App(null, null, null);
    
        //pointer 1 - if no file provided, print error message & stop
        if (args.length<=0){
            System.err.println("Missing CSV file");
            System.exit(1);
        }

        System.out.printf("Processing %s\n", args[0]);

        //reading file
        try (FileReader fr = new FileReader(args[0])){
            BufferedReader br = new BufferedReader(fr);
            
            //Map to access App by appName
            Map<String, List<App>> appMap = br.lines()
            //skip header 
            .skip(1)
            //clean + split -> converts to array (String -> String[])
            .map(row -> row.trim().split(","))
            //filter
            .filter(line -> line.length>0)
            //String[] -> App(String AppName, String AppCategory, String AppRating)
            //pointer 2 - App category to lowercase *****
            .map(fields -> new App(fields[COL_APPNAME], fields[COL_APPCATEGORY].toUpperCase(), fields[COL_APPRATING]))
            //groupingBy 
            .collect(Collectors.groupingBy(app -> app.getAppCategory()));


            //normal accessing of the appMap 
            /* for(String appCategory : appMap.keySet()){
                List<App> apps = appMap.get(appCategory);
                System.out.println(">>>"+appCategory);
                for(App app: apps){
                    System.out.println("***"+ app.getAppName() +"***"+app.getAppRating());
                }
            } */
            
            for(String appCategory : appMap.keySet()){ 
                List<App> apps = appMap.get(appCategory);
                System.out.printf("Category: %s\n", appCategory);
                count = apps.size();

                for (App app: apps){
                    
                    rank.add(app.getAppRating());
                    //EDITTT 
                    //discarded = apps.size() - 1;
                   
                    //System.out.printf("Name: %s, Rating: %s\n", app.getAppName(), app.getAppRating());
                    //delete all that contains NaN
                    System.out.printf(">>> Name: %s, Rating: %s\n", app.getAppName(), app.getAppRating());

                    if (app.getAppRating().contains("NaN")){
                        apps.remove(app);
                        discardedCount++;
                        break;
                    }

                    /* for (int i = 0; i<rank.size(); i++){
                        if (Double.parseDouble(app.getAppRating()) > Double.parseDouble(rank.get(i))){
                            Highest.remove(i);
                            Highest.add(app);
                            System.out.printf("Highest: %s, %d\n", app.getAppName(), app.getAppRating());
                        }
                    } */

                    /* for (int i = 0; i< rank.size(); i++){
                        if (Double.parseDouble(app.getAppRating())> Double.parseDouble(rank.get(i)));
                        
                        System.out.println(Highest);
                    } */
                    if (Highest.size()<=0){
                        Highest.push(app);
                    } else if (Double.parseDouble(app.getAppRating())> Double.parseDouble(Highest.peek().getAppRating())){
                        Highest.push(app);
                    }  
                    High = Highest.pop();
                    System.out.printf(">>>>>> %s,%s\n", High.getAppName(), High.getAppRating());
                    //app.Highest(app);

                    
                    //System.out.printf(">>> Name: %s, Rating: %s\n", app.getAppName(), app.getAppRating());

                    //print out Count & Discarded Count
                }
                //System.out.println(Highest(apps));
                System.out.printf("Count: %d\n", count);
                System.out.printf("Discarded: %d\n", discardedCount);
                
            }
        }


    }

    private static char[] Highest(List<App> apps) {
        return null;
    }
}