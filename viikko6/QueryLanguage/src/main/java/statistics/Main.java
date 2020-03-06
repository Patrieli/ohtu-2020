package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        // ajan tasalla olevat tilastot osoitteessa
        // "https://nhlstatisticsforohtu.herokuapp.com/players.txt"
        Statistics stats = new Statistics(new PlayerReaderImpl("https://nhl27112019.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();

        Matcher m = query.oneOf(query.playsIn("PHI").hasAtLeast(10, "assists").hasFewerThan(8, "goals").build(),
                query.playsIn("EDM").hasAtLeast(20, "points").build()).build();

        // Matcher m = query.playsIn("NYR").hasAtLeast(5, "goals").hasFewerThan(10,
        // "goals").build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
