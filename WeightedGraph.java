package org.example;

import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private final boolean undirected;
    private Map<V, Vertex<V>> map = new HashMap<>();

    public WeightedGraph() {
        this.undirected = true;
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V v) {
        map.put(v, new Vertex<>(v));
    }

    public Vertex<V> getVertex(V v) {
        return map.get(v);
    }

    public void addEdge(V source, V dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest))
            return;

        map.get(source).addAdjacentVertices(map.get(dest), weight);

        if (undirected)
            map.get(dest).addAdjacentVertices(map.get(source), weight);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex<V> vertex : map.values()) {
            count += vertex.countOfAdjacent();
        }

        if (undirected)
            count /= 2;

        return count;
    }

    public boolean hasVertex(V v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(V source, V dest) {
        if (!hasVertex(source))
            return false;

        return map.get(source).containsDest(map.get(dest));
    }

    public Iterable<V> adjacencyList(V v) {
        if (!hasVertex(v))
            return null;

        return map.get(v).getAdjacent();
    }
}
