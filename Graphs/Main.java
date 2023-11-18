package Graphs;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        var a = graph.createNode("A");
        var b = graph.createNode("B");
        var c = graph.createNode("C");
        var d = graph.createNode("D");
        var e = graph.createNode("E");
        var f = graph.createNode("F");
        var g = graph.createNode("G");

        graph.createConnection(a, b, GRAPH_DIRECTION.DIRECTED);
        graph.createConnection(b, c, GRAPH_DIRECTION.DIRECTED);
        graph.createConnection(c, d, GRAPH_DIRECTION.DIRECTED);
        graph.createConnection(d, a, GRAPH_DIRECTION.DIRECTED);
//        graph.createConnection(c, f, GRAPH_DIRECTION.DIRECTED);
//        graph.createConnection(e, f, GRAPH_DIRECTION.DIRECTED);
//        graph.createConnection(d, g, GRAPH_DIRECTION.DIRECTED);
//        graph.createConnection(f, g, GRAPH_DIRECTION.DIRECTED);

        System.out.println(graph);

        System.out.println("BFS: " + graph.getBFS(a));
        System.out.println("DFS: " + graph.getDFS(a));
        System.out.println("Has Cycle? : " + graph.hasCycle(a));
    }
}
