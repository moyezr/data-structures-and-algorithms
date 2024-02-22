package Graphs;

import com.sun.security.jgss.GSSUtil;

public class TestingUndirectedWeightedGraph {
    public static void main(String[] args) {
        UndirectedWeightedGraph graph = new UndirectedWeightedGraph();

        /* -----------  Test Code For Dijkstra's Algorithm -------------*/
       /* var a = graph.createNode("A");
        var b = graph.createNode("B");
        var c = graph.createNode("C");
        var d = graph.createNode("D");
        var e = graph.createNode("E");

        a.addEdge(b, 1);
        a.addEdge(c, 3);
        c.addEdge(b, 10);
        b.addEdge(d, 4);
        b.addEdge(e, 4);
        d.addEdge(e, 6);


        System.out.println(graph);
        System.out.println("Has Cycle? -> " + graph.hasCycle());
        System.out.println(graph.dijkstrasAlgorithm(a, e)); */

        /* ---------------- X ---------------- X ----------------- X -------------- */

        /*  ----------- Test Code for Prim's Algorithm (Finding Minimum Spanning Tree) -------------- */

        var a = graph.createNode("A");
        var b = graph.createNode("B");
        var c = graph.createNode("C");
        var d = graph.createNode("D");

        a.addEdge(b, 3);
        a.addEdge(c, 1);
        b.addEdge(c, 2);
        b.addEdge(d, 4);
        c.addEdge(d, 10);

        System.out.println(graph);
        System.out.println(graph.getMinimumSpanningTree(a));
        /* ---------------- X ---------------- X ----------------- X -------------- */

    }
}
