package global;

public class GlobalSurface {
    private Node[] nodes;

    public GlobalSurface(Node node1, Node node2) {
        nodes = new Node[2];
        nodes[0] = node1;
        nodes[1] = node2;
    }

    public Node[] getNodes() {
        return nodes;
    }
}
