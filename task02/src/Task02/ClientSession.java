package Task02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ClientSession {
    private final Map<String, Item> mapItems = new HashMap<>();
    private final Socket socket;
    private String start;
    private Item currItem;
    public Stack<Item> RankItem = new Stack<>();
    Item item = new Item();
    List<Integer> itemsPurchased = new ArrayList<>();
    
    public Map<String, Item> getMapItems() {
        return mapItems;
    }

    public ItemDescription start() {
		currItem = mapItems.get(start);
		return new ItemDescription(currItem);
	}

    public ClientSession(Socket socket) {
        this.socket = socket;
    }

    public void evaluate() throws Exception {
        
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        
        while (true) {
         
            String result = br.readLine();
            result = result.trim();
            //System.out.println(">>> " + result);
            if (result.length()==0){
                continue;
            }
            //break;
            System.out.printf(">INPUT: %s\n", result);

            String[] terms = result.split(":");

            switch (terms[0]) {
                case Constants.REQUEST_ID:
                    /* room = new Room(terms[1]);
                    saveRoom(room); */
                    break;

                case Constants.ITEM_COUNT:
                    /* room.setName(terms[1]); */
                    break;

                case Constants.BUDGET:
                    item.setBudget(Double.parseDouble(terms[1].trim()));
                    break;

                case Constants.PROD_LIST:
                    /* start = terms[1]; */
                    break;

                case Constants.PROD_START:
                    break;

                case Constants.PROD_ID:
                    item.setPROD_ID(Integer.parseInt(terms[1].trim()));
                    break;

                case Constants.TITLE:
                    item.setTITLE(terms[1]);
                    break;

                case Constants.PRICE:
                    item.setPRICE(terms[1]);
                    break;

                case Constants.RATING:
                    item.setRATING(Double.parseDouble(terms[1].trim()));
                    break;

                case Constants.PROD_END:
                    saveItem(item);
                    break;

                default:
                break;
            }
        }   
    }

    public void order() throws Exception{
        for (String title: mapItems.keySet()){
            Item item = mapItems.get(title);
            for (int i =0; i<mapItems.size(); i++){
                if(item.getRATING() < mapItems.get(i).getRATING()){
                    if (Double.parseDouble(item.getPRICE()) < Double.parseDouble(mapItems.get(i).getPRICE())){
                        RankItem.push(item);
                    }
                }
            } 
        }
    }

    public void purchase(){
        double purchaseBudget = item.getBudget();
        if (purchaseBudget > RankItem.peek().getBudget()){
            Item popItem = RankItem.pop();
            itemsPurchased.add(popItem.getPROD_ID());
        } else {
            System.out.println("END");
        }
    }

    public void send()throws Exception{
        OutputStream os = socket.getOutputStream();
        OutputStreamWriter ows = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(ows);
        boolean stop = false;

        while (!stop) {
            purchase();
            for(int ItemID : itemsPurchased){
                bw.write(ItemID +",");
            }
            bw.flush();
        }
            
        stop = true;
    }
    

    private void saveItem(Item item){
        mapItems.put(item.getTITLE(),item);
    }  
}

