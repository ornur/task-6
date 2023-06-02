package org.example;

        import java.util.LinkedList;
        import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(MyGraph<V> graph, V source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(MyGraph<V> graph, V source) {
        Queue<V> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            marked.add(current);

            for (V vertex : graph.adjacencyList(current)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, current);
                    queue.add(vertex);
                }
            }
        }
    }
    }

