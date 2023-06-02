package org.example;

import java.util.*;

public class MyGraph<V> {
    private final boolean undirected;
    private Map<V, Set<V>> adjacencyMap;

    public MyGraph() {
        this.undirected = true;
        this.adjacencyMap = new HashMap<>();
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
        this.adjacencyMap = new HashMap<>();
    }

    public void addVertex(V v) {
        adjacencyMap.put(v, new HashSet<>());
    }

    public void addEdge(V source, V dest) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest))
            return;

        adjacencyMap.get(source).add(dest);

        if (undirected)
            adjacencyMap.get(dest).add(source);
    }

    public int getVerticesCount() {
        return adjacencyMap.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Set<V> neighbors : adjacencyMap.values()) {
            count += neighbors.size();
        }

        if (undirected)
            count /= 2;

        return count;
    }

    public boolean hasVertex(V v) {
        return adjacencyMap.containsKey(v);
    }

    public boolean hasEdge(V source, V dest) {
        if (!hasVertex(source)) return false;
        return adjacencyMap.get(source).contains(dest);
    }

    public Iterable<V> adjacencyList(V v) {
        if (!hasVertex(v)) return null;
        return adjacencyMap.get(v);
    }
}