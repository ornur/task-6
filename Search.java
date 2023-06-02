package org.example;

import java.util.*;

public class Search<Vertex> {
    protected int count;
    protected Set<Vertex> marked;
    protected Map<Vertex, Vertex> edgeTo;
    protected final Vertex source;

    public Search(Vertex source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex v) {
        return marked.contains(v);
    }

    public Iterable<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Vertex> path = new LinkedList<>();
        Vertex current = v;
        while (current != source) {
            path.addFirst(current);
            current = edgeTo.get(current);
        }
        path.addFirst(source);
        return path;
    }

    public int getCount() {
        return count;
    }
}
