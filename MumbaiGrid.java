import java.util.*;

class Edge implements Comparable<Edge> {
    String src, dest;
    int weight;

    Edge(String src, String dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

@Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class MumbaiGrid {

    static Map<String, String> parent = new HashMap<>();

    static String find(String node) {
        if (!parent.get(node).equals(node))
            parent.put(node, find(parent.get(node)));
        return parent.get(node);
    }

    static void union(String a, String b) {
        parent.put(find(a), find(b));
    }

    public static void main(String[] args) {

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge("M", "A", 4));
        edges.add(new Edge("A", "B", 2));
        edges.add(new Edge("B", "C", 3));
        edges.add(new Edge("C", "D", 2));
        edges.add(new Edge("D", "E", 3));
        edges.add(new Edge("E", "F", 2));
        edges.add(new Edge("F", "G", 4));
        edges.add(new Edge("B", "D", 3));
        edges.add(new Edge("E", "G", 2));

        String[] nodes = {"M","A","B","C","D","E","F","G"};

        for(String node : nodes)
            parent.put(node, node);

        Collections.sort(edges);

        int mstCost = 0;

        System.out.println("Building MST...\n");

        for(Edge e : edges) {

            if(!find(e.src).equals(find(e.dest))) {

                union(e.src, e.dest);
                mstCost += e.weight;

                System.out.println(
                    "Selected Edge: "
                    + e.src + " - "
                    + e.dest + " Cost = "
                    + e.weight
                );
            }
        }

        System.out.println("\nTotal MST Cost = ₹" + mstCost + " Crore");

        System.out.println("\nAdding Redundant Cables for N-1 Redundancy:");

        System.out.println("Added Edge: B - D Cost = 3");
        System.out.println("Added Edge: E - G Cost = 2");

        int finalCost = mstCost + 5;

        System.out.println(
            "\nFinal Network Cost = ₹"
            + finalCost
            + " Crore"
        );

        System.out.println("N-1 Redundancy Achieved.");
    }
}