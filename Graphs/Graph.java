package Graphs;

import java.util.*;


enum GRAPH_DIRECTION {
    DIRECTED,
    UNDIRECTED
}

public class Graph {
    private class Node {
        public String value;

        public Node(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }

    private Map<Node, List<Node>> adjacencyList;

    private Map<String, Node> nodes;

    public Graph() {
        this.adjacencyList = new HashMap<Node, List<Node>>();
        this.nodes = new HashMap<>();
    }

    public Node createNode(String value) {
        if (!nodes.containsKey(value)) {
            nodes.put(value, new Node(value));
        }

        return nodes.get(value);
    }

    public void createConnection(Node from, Node to, GRAPH_DIRECTION direction) {
        if (!adjacencyList.containsKey(from)) {
            adjacencyList.put(from, new ArrayList<>());
        }
        if (!adjacencyList.containsKey(to)) {
            adjacencyList.put(to, new ArrayList<>());
        }

        adjacencyList.get(from).add(to);

        if (direction == GRAPH_DIRECTION.UNDIRECTED) {
            adjacencyList.get(to).add(from);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var entry : adjacencyList.entrySet()) {
            sb.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    public List<Node> getBFS(Node startingNode) {
        List<Node> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        q.offer(startingNode);
        while (!q.isEmpty()) {
            Node current = q.poll();
            visited.add(current);
            result.add(current);
            for (Node child : adjacencyList.get(current)) {
                if (!visited.contains(child)) {
                    q.offer(child);
                    visited.add(child);
                }
            }
        }

        return result;
    }

    private void getDFSRec(Node node, Set<Node> visited, List<Node> result) {
        if (node == null || visited.contains(node)) {
            return;
        }

        result.add(node);
        visited.add(node);

        for (Node child : adjacencyList.get(node)) {
            getDFSRec(child, visited, result);
        }
    }

    public List<Node> getDFS(Node initialNode) {
        List<Node> result = new ArrayList<>();
        getDFSRec(initialNode, new HashSet<>(), result);

        return result;
    }

    private boolean hasCycle(Node node, HashSet<Node> visiting, HashSet<Node> visited) {
        visiting.add(node);
        if(!adjacencyList.containsKey(node)) return false;
        for (Node child : adjacencyList.get(node)) {
            if (visiting.contains(child)) {
                return true;
            }
            if (hasCycle(child, visiting, visited)) return true;
        }

        visiting.remove(node);
        visited.add(node);

        return false;
    }

    public boolean hasCycle(Node node) {
        List<Node> all = new ArrayList<>();
        HashSet<Node> visiting = new HashSet<>();
        HashSet<Node> visited = new HashSet<>();
        for (var entry : nodes.entrySet()) {
            all.add(entry.getValue());
        }

        for (Node n : all) {
            if(!visited.contains(n)) {
                if(hasCycle(n, visiting, visited)) return true;
            }
        }

        return false;

    }
}