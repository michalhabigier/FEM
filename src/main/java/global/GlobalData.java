package global;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@JsonRootName(value = "globalData")
@XmlRootElement
public class GlobalData {
    private double H; //wysokość przekroju
    private double B; // szerokość przekroju,
    private int nH;
    private int nB;
    private double initialTemperature;
    private double simulationTime;
    private double simulationStepTime;
    private double ambientTemperature;
    private double alfa;
    private double specificHeat;
    private double conductivity;
    private double density;
    private int ne; //l. elementow
    private int nw; //l. wezlow
    private Data data;

    public void compute(Grid grid){

        for (int i = 0; i < data.getH_global().length; ++i)
            for (int j = 0; j < data.getH_global()[i].length; ++j)
                data.getH_global()[i][j] = 0;

            for (int i = 0; i < data.getP_global().length; ++i)
                data.getP_global()[i] = 0;

        //TODO Liczenie siatki
    }

    public double getH() {
        return H;
    }

    @XmlElement
    public void setH(double h) {
        H = h;
    }

    public double getB() {
        return B;
    }

    @XmlElement
    public void setB(double b) {
        B = b;
    }

    public int getnH() {
        return nH;
    }

    @XmlElement
    public void setnH(int nH) {
        this.nH = nH;
    }

    public int getnB() {
        return nB;
    }

    @XmlElement
    public void setnB(int nB) {
        this.nB = nB;
    }

    public double getInitialTemperature() {
        return initialTemperature;
    }

    @XmlElement
    public void setInitialTemperature(double initialTemperature) {
        this.initialTemperature = initialTemperature;
    }

    public double getSimulationTime() {
        return simulationTime;
    }

    @XmlElement
    public void setSimulationTime(double simulationTime) {
        this.simulationTime = simulationTime;
    }

    public double getSimulationStepTime() {
        return simulationStepTime;
    }

    @XmlElement
    public void setSimulationStepTime(double simulationStepTime) {
        this.simulationStepTime = simulationStepTime;
    }

    public double getAmbientTemperature() {
        return ambientTemperature;
    }

    @XmlElement
    public void setAmbientTemperature(double ambientTemperature) {
        this.ambientTemperature = ambientTemperature;
    }

    public double getAlfa() {
        return alfa;
    }

    @XmlElement
    public void setAlfa(double alfa) {
        this.alfa = alfa;
    }

    public double getSpecificHeat() {
        return specificHeat;
    }

    @XmlElement
    public void setSpecificHeat(double specificHeat) {
        this.specificHeat = specificHeat;
    }

    public double getConductivity() {
        return conductivity;
    }

    @XmlElement
    public void setConductivity(double conductivity) {
        this.conductivity = conductivity;
    }

    public double getDensity() {
        return density;
    }

    @XmlElement
    public void setDensity(double density) {
        this.density = density;
    }

    public int getNe() {
        return ne;
    }

    public void setNe(int ne) {
        this.ne = ne;
    }

    public int getNw() {
        return nw;
    }

    public void setNw(int nw) {
        this.nw = nw;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GlobalData{" +
                "H=" + H +
                ", B=" + B +
                ", nH=" + nH +
                ", nB=" + nB +
                ", initialTemperature=" + initialTemperature +
                ", simulationTime=" + simulationTime +
                ", simulationStepTime=" + simulationStepTime +
                ", ambientTemperature=" + ambientTemperature +
                ", alfa=" + alfa +
                ", specificHeat=" + specificHeat +
                ", conductivity=" + conductivity +
                ", density=" + density +
                '}';
    }
}