package local;

import util.ShapeFunctions;

public class LocalElement {
    private final int BORDER = 4;

    private double[][] dN_Ksi;
    private double[][] dN_Eta;
    private double[][] shapesFunction;

    private static LocalElement localElement = new LocalElement();

    private LocalElement(){
        dN_Eta = new double[BORDER][BORDER];
        dN_Ksi = new double[BORDER][BORDER];
        shapesFunction = new double[BORDER][BORDER];

        for(int i=0; i<BORDER; ++i){
            shapesFunction[i][0] = ShapeFunctions.N1(IntegralCoords.gaussNodesCoords[i].getKsi(), IntegralCoords.gaussNodesCoords[i].getEta());
            shapesFunction[i][1] = ShapeFunctions.N2(IntegralCoords.gaussNodesCoords[i].getKsi(), IntegralCoords.gaussNodesCoords[i].getEta());
            shapesFunction[i][2] = ShapeFunctions.N3(IntegralCoords.gaussNodesCoords[i].getKsi(), IntegralCoords.gaussNodesCoords[i].getEta());
            shapesFunction[i][3] = ShapeFunctions.N4(IntegralCoords.gaussNodesCoords[i].getKsi(), IntegralCoords.gaussNodesCoords[i].getEta());

            dN_Ksi[i][0] = ShapeFunctions.dN1_Ksi(IntegralCoords.gaussNodesCoords[i].getEta(), IntegralCoords.gaussNodesCoords[i].getEta());
            dN_Ksi[i][1] = ShapeFunctions.dN2_Ksi(IntegralCoords.gaussNodesCoords[i].getEta(), IntegralCoords.gaussNodesCoords[i].getEta());
            dN_Ksi[i][2] = ShapeFunctions.dN3_Ksi(IntegralCoords.gaussNodesCoords[i].getEta(), IntegralCoords.gaussNodesCoords[i].getEta());
            dN_Ksi[i][3] = ShapeFunctions.dN4_Ksi(IntegralCoords.gaussNodesCoords[i].getEta(), IntegralCoords.gaussNodesCoords[i].getEta());

            dN_Eta[i][0] = ShapeFunctions.dN1_Eta(IntegralCoords.gaussNodesCoords[i].getKsi(), IntegralCoords.gaussNodesCoords[i].getEta());
            dN_Eta[i][1] = ShapeFunctions.dN2_Eta(IntegralCoords.gaussNodesCoords[i].getKsi(), IntegralCoords.gaussNodesCoords[i].getEta());
            dN_Eta[i][2] = ShapeFunctions.dN3_Eta(IntegralCoords.gaussNodesCoords[i].getKsi(), IntegralCoords.gaussNodesCoords[i].getEta());
            dN_Eta[i][3] = ShapeFunctions.dN4_Eta(IntegralCoords.gaussNodesCoords[i].getKsi(), IntegralCoords.gaussNodesCoords[i].getEta());
        }

        //TODO
        for(int i=0; i<BORDER; ++i){
            for(int j=0; j<2; ++j){
                IntegralCoords.gaussSurfaceCoords[i].getShapesFunc()[j][0] = ShapeFunctions.N1(
                        IntegralCoords.gaussSurfaceCoords[i].getNodes()[j].getKsi(),
                        IntegralCoords.gaussSurfaceCoords[i].getNodes()[j].getEta());
                IntegralCoords.gaussSurfaceCoords[i].getShapesFunc()[j][1] = ShapeFunctions.N2(
                        IntegralCoords.gaussSurfaceCoords[i].getNodes()[j].getKsi(),
                        IntegralCoords.gaussSurfaceCoords[i].getNodes()[j].getEta());
                IntegralCoords.gaussSurfaceCoords[i].getShapesFunc()[j][2] = ShapeFunctions.N3(
                        IntegralCoords.gaussSurfaceCoords[i].getNodes()[j].getKsi(),
                        IntegralCoords.gaussSurfaceCoords[i].getNodes()[j].getEta());
                IntegralCoords.gaussSurfaceCoords[i].getShapesFunc()[j][3] = ShapeFunctions.N4(
                        IntegralCoords.gaussSurfaceCoords[i].getNodes()[j].getKsi(),
                        IntegralCoords.gaussSurfaceCoords[i].getNodes()[j].getEta());
                }
        }
    }


    public int getBORDER() {
        return BORDER;
    }

    public double[][] getdN_Ksi() {
        return dN_Ksi;
    }

    public double[][] getdN_Eta() {
        return dN_Eta;
    }

    public double[][] getShapesFunction() {
        return shapesFunction;
    }

    public static LocalElement getLocalElement() {
        return localElement;
    }

}
