package global;

public class GlobalElement {

    private final int BORDER_AMOUNT = 4;

    private Node[] node;
    private GlobalSurface[] surface; //nodes on surface

    private int borderCounter = 0;
    private int[] boundaries; //surfaces having contact with environment
    private int[] globalNodeId; //id of nodes in each element

    public GlobalElement(int i, int j, Node[] nodes, GlobalData globalData) {
        this.node = new Node[BORDER_AMOUNT];
        this.surface = new GlobalSurface[BORDER_AMOUNT];
        this.globalNodeId = new int[BORDER_AMOUNT];

        this.node[0] = node[0];
        this.node[1] = node[1];
        this.node[2] = node[2];
        this.node[3] = node[3];

        surface[0] = new GlobalSurface(this.node[3], this.node[0]);
        surface[1] = new GlobalSurface(this.node[0], this.node[1]);
        surface[2] = new GlobalSurface(this.node[1], this.node[2]);
        surface[3] = new GlobalSurface(this.node[2], this.node[3]);


        for (int k = 0; k < BORDER_AMOUNT; ++k) {
            if (surface[k].getNodes()[0].getStatus() == 1 && surface[k].getNodes()[1].getStatus() == 1) {
                borderCounter++;
            }
        }
        boundaries = new int[borderCounter];

        int counter = 0;
        for (int k = 0; k < BORDER_AMOUNT; ++k) {
            if(surface[k].getNodes()[0].getStatus() == 1 && surface[k].getNodes()[1].getStatus() == 1) {
                boundaries[counter] = k;
                counter++;
            }
        }
    }


    public Node[] getNode() {
        return node;
    }

    public int getBorderCounter() {
        return borderCounter;
    }

    public int[] getBoundaries() {
        return boundaries;
    }

    public int[] getGlobalNodeId() {
        return globalNodeId;
    }
}
