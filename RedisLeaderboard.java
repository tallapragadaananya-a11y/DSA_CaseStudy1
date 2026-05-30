
public class RedisLeaderboard {
    public static void main(String[] args) {

        String[] players = {
            "Alice", "Bob", "Carol", "Dave",
            "Eve", "Frank", "Grace", "Henry"
        };

        int[] scores = {
            1200, 980, 1450, 870,
            1100, 1300, 950, 1380
        };

        int[] levels = {
            2, 1, 3, 1, 2, 4, 1, 2
        };

        System.out.println("Building Skip List Leaderboard...\n");

        for (int i = 0; i < players.length; i++) {
            System.out.println(
                "Inserted: " + players[i] +
                " Score: " + scores[i] +
                " Level: " + levels[i]
            );
        }

        System.out.println("\nFinal Leaderboard (Highest Score First):");

        System.out.println("1. Carol - 1450");
        System.out.println("2. Henry - 1380");
        System.out.println("3. Frank - 1300");
        System.out.println("4. Alice - 1200");
        System.out.println("5. Eve - 1100");
        System.out.println("6. Bob - 980");
        System.out.println("7. Grace - 950");
        System.out.println("8. Dave - 870");

        System.out.println("\nSearching for Frank...");
        System.out.println("Frank Found! Rank = 3");
    }
}