package Graphs;

import java.util.*;


public class UndirectedWeightedGraph {
    public class Node {
        private String label;

        private List<WeightedEdge> edges;

        public Node(String label) {
            this.label = label;
            this.edges = new ArrayList<WeightedEdge>();
        }

        public void addEdge(Node to, int weight) {
            this.edges.add(new WeightedEdge(to, weight));
            to.edges.add(new WeightedEdge(this, weight));
        }

        public String toString() {
            return this.label;
        }
    }

    private class WeightedEdge {
        public Node to;
        public int weight;

        public WeightedEdge(Node to, int weight) {
            this.weight = weight;
            this.to = to;
        }

        public String toString() {
            return "{ Node= " + to + ", Weight=" + this.weight + "}";
        }
    }

    public Map<String, Node> nodes;

    public UndirectedWeightedGraph() {
        nodes = new HashMap<>();
    }

    public Node createNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
        return nodes.get(label);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (var entry : nodes.entrySet()) {
            for (var child : entry.getValue().edges) {
                sb.append(entry.getValue()).append(" -- (").append(child.weight).append(") --> ").append(child.to).append("\n");
            }
        }

        return sb.toString();
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
        if (visited.contains(node)) return false;
        visited.add(node);

        for (var child : node.edges) {
            if (child.to == parent) continue;
            if (visited.contains(child.to) || hasCycle(child.to, node, visited)) return true;
        }

        return false;
    }

    public boolean hasCycle() {
        Set<Node> visited = new HashSet<>();
        for (var node : nodes.values()) {
            if (hasCycle(node, null, visited)) {
                return true;
            }
        }

        return false;
    }


}
