package Task02;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Client {
   public static void main(String[] args) throws Exception {

      int port = 0;
      String serverName = " ";
      Map<String, Item> mapItems = new HashMap<>();

      if (args.length == 0){
         port = 3000;
         System.out.println();
         serverName = "localhost";
      } else if (args.length == 1){
         port = Integer.parseInt(args[0]);
         serverName = "localhost";
      } else if (args.length ==2){
         serverName = args[0];
         port = Integer.parseInt(args[1]);
      }

      Socket socket = new Socket(serverName, port);
      System.out.printf("Connecting to %s. Listening on port %d\n",serverName, port);
      
      ClientSession sess = new ClientSession(socket);
      sess.start();
      sess.evaluate();
      sess.order();
      sess.purchase();
      sess.send();
      

      //check if needed!!
      socket.close();
      

   }
   
}

    

