package org.example;

public class DepthFirstSearch<Vertex> extends Search<Vertex> {
    public DepthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(MyGraph<Vertex> graph, Vertex current) {
        marked.add(current);
        count++;

        for (Vertex vertex : graph.adjacencyList(current)) {
            if (!marked.contains(vertex)) {
                edgeTo.put(vertex, current);
                dfs(graph, vertex);
            }
        }
    }
}
