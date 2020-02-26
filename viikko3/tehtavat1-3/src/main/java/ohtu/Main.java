package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Timestamp;

import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        // System.out.println("json-muotoinen data:");
        // System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        System.out.println("\nPlayers from FIN " + timestamp + "\n" );
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                System.out.println(player);
            } 
        }   
    }
  
}