package javafxarduino;

import com.fazecast.jSerialComm.SerialPort;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ComboBox cbPortas;
    
    @FXML
    private Button btnConectar;
    
    private SerialPort porta;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarPortas();
    }    
    private void carregarPortas(){
        SerialPort[] portNames = SerialPort.getCommPorts();
        
        for(SerialPort portName: portNames){
            cbPortas.getItems().add(portName.getSystemPortName());
        }
    }
    
    @FXML
    private void btnConectarAction (){
        if(btnConectar.getText().equals("Conectar")){
            porta = SerialPort.getCommPort(cbPortas.getSelectionModel().getSelectedItem().toString());
            if(porta.openPort()){
                btnConectar.setText("Desconectar");
                cbPortas.setDisable(true);
            }
        }else{
            porta.closePort();
            cbPortas.setDisable(false);
            btnConectar.setText("Conectar");
        }
        System.out.println("Teste");
    }
    
    
}
