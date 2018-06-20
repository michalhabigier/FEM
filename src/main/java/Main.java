import global.Data;
import global.GlobalData;
import global.Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        GlobalData data = readConfiguration();
        Grid grid = new Grid(data);
        for(double i=0; i<= data.getSimulationTime(); i+=data.getSimulationStepTime()){
            //TODO liczenie siatki
            //TODO eliminacja gaussa
            for(int j=0; j<data.getNw(); ++j){
                //grid.getNodes()[j].setT();
            }
        }
    }

    private static GlobalData readConfiguration(){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(GlobalData.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            GlobalData data = (GlobalData) jaxbUnmarshaller.unmarshal(new File("./resources/globalData.xml"));
            data.setNe((data.getnH() - 1) * (data.getnB() - 1)); //l elemen tow
            data.setNw(data.getnH() * data.getnB()); //l wezlow
            Data global = new Data(4, data.getNw());
            data.setData(global);
            return data;
        } catch (JAXBException e) {
            log.debug("COuldn't load data configuration from \"globalData.xml\" file ");
        }
        return null;
    }

}
