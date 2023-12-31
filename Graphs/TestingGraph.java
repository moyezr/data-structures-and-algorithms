package Graphs;

public class TestingGraph {
    public static void main(String[] args) {
        Graph graph = new Graph();
        var a = graph.createNode("A");
        var b = graph.createNode("B");
        var c = graph.createNode("C");
        var d = graph.createNode("D");
        var e = graph.createNode("E");
//        var f = graph.createNode("F");
//        var g = graph.createNode("G");

        graph.createConnection(a, b, GRAPH_DIRECTION.DIRECTED);
        graph.createConnection(a, c, GRAPH_DIRECTION.DIRECTED);
        graph.createConnection(c, b, GRAPH_DIRECTION.DIRECTED);
        graph.createConnection(b, d, GRAPH_DIRECTION.DIRECTED);
        graph.createConnection(c, d, GRAPH_DIRECTION.DIRECTED);
        graph.createConnection(d, e, GRAPH_DIRECTION.DIRECTED);


        System.out.println(graph);

        System.out.println(graph.getBFS(a));
        System.out.println(graph.topoSort(a));
    }
}
