package util;

import local.LocalElement;

public class Jacoby {

    private double[][] matrix;
    private double[][] invertedMatrix;
    private double det;
    private int integrationPoint;

    public static final LocalElement localElement = LocalElement.getLocalElement();

    public Jacoby(double[] x, double[] y, int integrationPoint){
        this.integrationPoint = integrationPoint;
        matrix = new double[2][2];
        invertedMatrix = new double[2][2];

        //calculating transition of jacoby
        matrix[0][0] = localElement.getdN_Ksi()[integrationPoint][0]*x[0] + localElement.getdN_Ksi()[integrationPoint][1]*x[1] +
                localElement.getdN_Ksi()[integrationPoint][2] * x[2] + localElement.getdN_Ksi()[integrationPoint][3] * x[3];
        matrix[0][1] = localElement.getdN_Ksi()[integrationPoint][0]*y[0] + localElement.getdN_Ksi()[integrationPoint][1]*y[1] +
                localElement.getdN_Ksi()[integrationPoint][2] * y[2] + localElement.getdN_Ksi()[integrationPoint][3] * y[3];
        matrix[1][0] = localElement.getdN_Ksi()[integrationPoint][0]*x[0] + localElement.getdN_Ksi()[integrationPoint][1]*x[1] +
                localElement.getdN_Ksi()[integrationPoint][2] * x[2] + localElement.getdN_Ksi()[integrationPoint][3] * x[3];
        matrix[1][1] = localElement.getdN_Ksi()[integrationPoint][0]*y[0] + localElement.getdN_Ksi()[integrationPoint][1]*y[1] +
                localElement.getdN_Ksi()[integrationPoint][2] * y[2] + localElement.getdN_Ksi()[integrationPoint][3] * y[3];

        det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        // inverted matrix
        invertedMatrix[0][0] = matrix[1][1];
        invertedMatrix[0][1] = -matrix[0][1];
        invertedMatrix[1][0] = -matrix[1][0];
        invertedMatrix[1][1] = matrix[0][0];

    }

    public double[][] getInvertedMatrix() {
        return invertedMatrix;
    }

    public double getDet() {
        return det;
    }
}
