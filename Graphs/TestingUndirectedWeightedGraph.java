package Graphs;

public class TestingUndirectedWeightedGraph {
    public static void main(String[] args) {
        UndirectedWeightedGraph graph = new UndirectedWeightedGraph();

        var a = graph.createNode("A");
        var b = graph.createNode("B");
        var c = graph.createNode("C");
        var d = graph.createNode("D");

        a.addEdge(b, 5);

        System.out.println(graph);
    }
}
