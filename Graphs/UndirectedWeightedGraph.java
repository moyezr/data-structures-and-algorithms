package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UndirectedWeightedGraph {
    private class Node {
        private String label;

        private List<Graphs.WeightedEdge> edges;

        public Node(String label) {
            this.label = label;
            this.edges = new ArrayList<>();
        }
    }

    private class WeightedEdge {
        public Graphs.Node to;
        public int weight;

        public WeightedEdge(Graphs.Node to, int weight) {
            this.weight = weight;
            this.to = to;
        }
    }

    public Map<String, Node> nodes;

    public UndirectedWeightedGraph() {
        nodes = new HashMap<>();
    }
}
