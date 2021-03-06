package local;

public class LocalSurface {

    private LocalNode[] nodes;
    private double[][] shapeFunctions;

    public LocalSurface(LocalNode node1, LocalNode node2) {
        nodes = new LocalNode[2];
        nodes[0] = node1;
        nodes[1] = node2;
        shapeFunctions = new double[2][4];
    }

    public LocalNode[] getNodes() {
        return nodes;
    }
    public double[][] getShapesFunc() {
        return shapeFunctions;
    }

}