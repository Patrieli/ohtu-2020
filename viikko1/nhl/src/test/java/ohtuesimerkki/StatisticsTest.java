package ohtuesimerkki;

import java.util.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void playerSearch() {
        Player p = stats.search("Yzerman");
        
        assertEquals("Yzerman", p.getName());
    }

    @Test
    public void nonPlayerSearch() {
        Player p = stats.search("Rinne");

        assertEquals(null, p);
    }

    @Test
    public void topScorer() {
        List<Player> l = stats.topScorers(1);

        assertEquals("Gretzky", l.get(0).getName());
    }

    @Test
    public void topScorersNull() {
        List<Player> l = stats.topScorers(-1);

        assertEquals(true, l.isEmpty());
    }

    @Test
    public void searchByTeam() {
        List<Player> team = stats.team("EDM");

        assertEquals(3, team.size());
    }
    

}