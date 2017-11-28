/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author juan.jaramillo62
 */
public class ConductorEditDialogController implements Initializable {

    @FXML
    private TextField propietarioField;
    @FXML
    private TextField matriculaField;
    @FXML
    private TextField cedulaField;
    @FXML
    private RadioButton efectivoBtn;
    @FXML
    private ToggleGroup tipoPago;
    @FXML
    private RadioButton flyPassBtn;
    @FXML
    private ChoiceBox<?> claseVehiculoBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleOk(ActionEvent event) {
    }

    @FXML
    private void handleCancel(ActionEvent event) {
    }
    
}
