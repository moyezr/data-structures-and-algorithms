package Graphs;

import com.sun.security.jgss.GSSUtil;

public class TestingUndirectedWeightedGraph {
    public static void main(String[] args) {
        UndirectedWeightedGraph graph = new UndirectedWeightedGraph();

        var a = graph.createNode("A");
        var b = graph.createNode("B");
        var c = graph.createNode("C");
        var d = graph.createNode("D");

        a.addEdge(b, 5);
        b.addEdge(c, 10);
        c.addEdge(d, 8);
        d.addEdge(a, 8);

        System.out.println(graph);
        System.out.println("Has Cycle? -> " + graph.hasCycle());
    }
}
