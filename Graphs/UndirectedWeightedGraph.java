package Graphs;

import javax.xml.stream.events.ProcessingInstruction;
import java.util.*;


public class UndirectedWeightedGraph {

    private class EdgeEntry {
        public Node node;
        public int weight;
        public Node parent;

        public EdgeEntry(Node node, int weight, Node parent) {
            this.node = node;
            this.weight = weight;
            this.parent = parent;
        }


    }

    public class Node {
        private String label;

        private List<WeightedEdge> edges;

        public Node(String label) {
            this.label = label;
            this.edges = new ArrayList<WeightedEdge>();
        }

        public void addEdge(Node to, int weight) {
            this.edges.add(new WeightedEdge(this, weight, to));
            to.edges.add(new WeightedEdge(to, weight, this));
        }

        public String toString() {
            return this.label;
        }
    }

    private class WeightedEdge {
        public Node to;
        public int weight;

        public Node from;
        public WeightedEdge(Node from, int weight, Node to) {
            this.weight = weight;
            this.from = from;
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

    public String dijkstrasAlgorithm(Node initialNode, Node toNode) {
        Set<Node> visited = new HashSet<>();
        Map<Node, EdgeEntry>  map = new HashMap<>();
        PriorityQueue<EdgeEntry> queue = new PriorityQueue<>(new Comparator<EdgeEntry>() {
        public int compare (EdgeEntry o1, EdgeEntry o2){
                return o1.weight - o2.weight;
        }
        });

        var entry = new EdgeEntry(initialNode, 0, null);
        map.put(initialNode, entry);
        queue.offer(entry);

        while(!queue.isEmpty()) {
            var top = queue.poll();
            if(visited.contains(top.node)) continue;
            for(var child: top.node.edges) {
                int newDistance = top.weight + child.weight;
                if(!map.containsKey(child.to) || newDistance < map.get(child.to).weight) {
                    var newEntry =new EdgeEntry(child.to, newDistance, top.node);
                    map.put(child.to, newEntry);
                    queue.offer(newEntry);
                }
            }

            visited.add(top.node);
        }

        StringBuilder sb = new StringBuilder();
        var tempEntry = map.get(toNode);

        while(tempEntry != null) {
            sb.append(tempEntry.node).append(" ");
            tempEntry = map.get(tempEntry.parent);
        }

        return sb.reverse().toString();
    }
    public UndirectedWeightedGraph getMinimumSpanningTree(Node initialNode) { // Using Prim's Algorithm
        UndirectedWeightedGraph result = new UndirectedWeightedGraph();

        PriorityQueue<WeightedEdge> queue = new PriorityQueue<>(Comparator.comparing(e -> e.weight));

        result.createNode(initialNode.label);

        for(var edge: initialNode.edges) {
            queue.offer(edge);
        }

        while(result.nodes.size() < nodes.size()) {
            WeightedEdge currentEdge = queue.poll();
            Node nextNode = currentEdge.to;
            if(result.nodes.containsKey(nextNode.label)) continue;

            result.createNode(nextNode.label);
            result.nodes.get(currentEdge.from.label).addEdge(nextNode, currentEdge.weight);

            for(var edge: nextNode.edges) {
                if(!result.nodes.containsKey(edge.to.label)) {
                    queue.offer(edge);
                }
            }
        }

        return result;

    }

}
