package global;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private final int borders = 4;

    private Node[] nodes;
    private GlobalElement[] elements;
    private GlobalData globalData;

    public Grid(GlobalData globalData) {
        this.globalData = globalData;

        nodes = new Node[globalData.getNe()];
        elements = new GlobalElement[globalData.getNw()];

        int counter = 0;
        for (int i = 0; i < globalData.getnB() - 1; ++i) {
            for (int j = 0; j < globalData.getnH() - 1; ++j) {
                List<Node> nodeList = new ArrayList<>();
                nodeList.add(nodes[globalData.getnH() * i + j]);
                nodeList.add(nodes[globalData.getnH() * (i + 1) + j]);
                nodeList.add(nodes[globalData.getnH() * (i+1) + (j + 1)]);
                nodeList.add(nodes[globalData.getnH() * i + (j + 1)]);

                elements[counter] = new GlobalElement(i, j, nodeList.toArray(new Node[nodeList.size()]), globalData);
                ++counter;
            }
        }
    }

    public Node[] getNodes() {
        return nodes;
    }

    public GlobalElement[] getElements() {
        return elements;
    }

    public void printAllNodes(){
        for(int i=0; i<globalData.getnH(); ++i){
            System.out.println("i: " + i + "\nStatus: " + nodes[i].getStatus()
                    + "\n [ " + nodes[i].getX() + ", " + nodes[i].getY() + " ]");
        }
    }

    public void printElements(int i) {
        System.out.println("Global Element " + i);
        for (int j = 0; j < borders; ++j) {
            System.out.println("{\nId: " + j + "\nGlobal id: " + elements[i].getGlobalNodeId()[i] + "\nStatus: "
                    + elements[i].getNode()[j].getStatus() + "\n[ " + elements[i].getNode()[j].getX() + ", "
                    + elements[i].getNode()[j].getY() + " ]\n}");
        }
    }

}

