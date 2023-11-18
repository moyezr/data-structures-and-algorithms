package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
}
