package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> graph = createWeightedGraph();
        MyGraph<String> myGraph = createGraph();

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(myGraph, "Almaty");
        outputPath(dfs, "Kyzylorda");

        System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(myGraph, "Almaty");
        outputPath(bfs, "Kyzylorda");

        System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(graph, "Almaty");
        outputPath(djk, "Kyzylorda");
    }

    public static void outputPath(Search<String> search, String key) {
        List<String> path = (List<String>) search.pathTo(key);
        System.out.println(String.join(" -> ", path));
    }

    public static WeightedGraph<String> createWeightedGraph() {
        WeightedGraph<String> graph = new WeightedGraph<>(true);

        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);

        return graph;
    }

    public static MyGraph<String> createGraph() {
        MyGraph<String> graph = new MyGraph<>(true);

        graph.addEdge("Almaty", "Astana");
        graph.addEdge("Almaty", "Shymkent");
        graph.addEdge("Shymkent", "Astana");
        graph.addEdge("Astana", "Kostanay");
        graph.addEdge("Shymkent", "Kyzylorda");

        return graph;
    }
}
