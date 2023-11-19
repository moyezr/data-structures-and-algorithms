package Graphs;

public class TestingWeightedDirectedGraph {
    public static void main(String[] args) {

        /* Testing Weighted Graphs */

        WeightedDirectedGraph graph = new WeightedDirectedGraph();
        var a = graph.createNode("A");
        var b = graph.createNode("B");
        var c = graph.createNode("C");
        var d = graph.createNode("D");

        a.addEdge(b, 5);
        b.addEdge(c, 2);
        a.addEdge(c, 10);
        d.addEdge(a, 9);

        System.out.println(graph);
    }
}
