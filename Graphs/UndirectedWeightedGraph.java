package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UndirectedWeightedGraph {
    private class Node {
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


}
