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
        static Stack<App> Highest = new Stack<>();
        static Stack<App> Lowest = new Stack<>();

    
    private static Stack<App> determineHighest(List<App> apps) throws Exception {
        Highest = new Stack<>();
        for (int i = 0; i<apps.size(); i++){
            if(Highest.size() <=0 ){
                Highest.push(apps.get(i));
            } else {
                double ratingCurr = Double.parseDouble(apps.get(i).getAppRating());
                double ratingHighest = Double.parseDouble(Highest.peek().getAppRating());
                if (ratingCurr > ratingHighest){
                    Highest.push(apps.get(i));
                } else {
                    continue;
                }
            }
        }
        return Highest;  
    }

    private static Stack<App> determineLowest(List<App> apps) throws Exception {
        Lowest = new Stack<>();
        for (int i = 0; i<apps.size(); i++){
            if(Lowest.size() <=0 ){
                Lowest.push(apps.get(i));
            } else {
                double ratingCurr = Double.parseDouble(apps.get(i).getAppRating());
                double ratingLowest = Double.parseDouble(Highest.peek().getAppRating());
                if (ratingCurr < ratingLowest){
                    Lowest.push(apps.get(i));
                } else {
                    continue;
                }
            }
        }
        return Lowest;  
    }
/* 
    public static double aveRating (List<App> apps){
        for(App app : apps){

        }

    } */

    public static void main(String[] args) throws Exception {
        int count;
        int discardedCount = 0;
        List<String> rank = new ArrayList<>();
        int lineCount =0;
        App highestApp;
        App lowestApp;
        
        //App High = new App(null, null, null);
    
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
            .collect(Collectors.groupingBy(application -> application.getAppCategory()));


            //normal accessing of the appMap 
            for(String appCategory : appMap.keySet()){
                List<App> apps = appMap.get(appCategory);
                System.out.printf("Category: %s\n",appCategory);
                determineHighest(apps);
                determineLowest(apps);
                for(App app: apps){
                    lineCount ++;
                    //System.out.printf("Name %s, Rating %s\n",app.getAppName(), app.getAppRating());
                    /* if (Highest.size() == 0){
                        continue;
                    }   
                    if (Lowest.size() ==0){
                        continue;
                    } */
                }
                highestApp = Highest.pop();
                System.out.printf("Highest: %s, %s\n", highestApp.getAppName(), highestApp.getAppRating());
                lowestApp = Lowest.pop();
                System.out.printf("Lowest: %s, %s\n", lowestApp.getAppName(), lowestApp.getAppRating());
                System.out.printf("Count: %d\n",apps.size());
                System.out.println("\n");

            }

            //add one back for heading
            System.out.printf("Total lines in file: %d", lineCount+1);
            
            
            //mush.txt
        }


    }

    
}