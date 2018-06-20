package local;

public class IntegralCoords {

    //local points to integral
    public static final LocalNode[] gaussNodesCoords = {
            new LocalNode(-1 / Math.sqrt(3), -1 / Math.sqrt(3)),
            new LocalNode(1 / Math.sqrt(3), -1 / Math.sqrt(3)),
            new LocalNode(1 / Math.sqrt(3), 1 / Math.sqrt(3)),
            new LocalNode(-1 / Math.sqrt(3), 1 / Math.sqrt(3))
    }; //1/sqrt(3) = 0.577

    //local points (to nodes) for surface
    public static final LocalSurface[] gaussSurfaceCoords = {
            new LocalSurface(new LocalNode(-1, 1 / Math.sqrt(3)), new LocalNode(-1, -1 / Math.sqrt(3))),
            new LocalSurface(new LocalNode(-1 / Math.sqrt(3), -1), new LocalNode(1 / Math.sqrt(3), -1)),
            new LocalSurface(new LocalNode(1, -1 / Math.sqrt(3)), new LocalNode(1, 1 / Math.sqrt(3))),
            new LocalSurface(new LocalNode(1 / Math.sqrt(3), 1), new LocalNode(-1 / Math.sqrt(3), 1))
    };

}
