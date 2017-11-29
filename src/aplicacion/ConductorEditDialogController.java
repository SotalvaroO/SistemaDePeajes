/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import aplicacion.modelo.Peaje;
import aplicacion.modelo.Vehiculo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

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
    private ChoiceBox claseVehiculoBox;
    
    private Stage dialogStage;
    private Vehiculo vehiculo;
    private Peaje peaje;
    private boolean okClicked = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        claseVehiculoBox.getItems().addAll("1","2","3","4","5","6","7");
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk(ActionEvent event) {
        if (isInputValid()) {
            vehiculo.setNombre(propietarioField.getText());
            vehiculo.setMatricula(matriculaField.getText());
            vehiculo.setClaseVehiculo(claseVehiculoBox.getValue().toString());
            vehiculo.setCedula(cedulaField.getText());
            if (efectivoBtn.isSelected()) {
                vehiculo.setTipoPago(1);
            } else if (flyPassBtn.isSelected()) {
                vehiculo.setTipoPago(2);
            }

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel(ActionEvent event) {
        dialogStage.close();
    }
    
    private boolean isInputValid() {
        String errorMessage = "";

        if (propietarioField.getText() == null || propietarioField.getText().length() == 0) {
            errorMessage += "Propietario no valido!\n";
        }
        if (matriculaField.getText() == null || matriculaField.getText().length() == 0) {
            errorMessage += "Matricula no valida!\n";
        }
        //if (claseVehiculoField.getText() == null || claseVehiculoField.getText().length() == 0 || Integer.parseInt(claseVehiculoField.getText()) > 7 || Integer.parseInt(claseVehiculoField.getText()) < 1) {
       //     errorMessage += "Clase de vehiculo no valida!!\n";
        //}

        if (cedulaField.getText() == null || cedulaField.getText().length() == 0) {
            errorMessage += "Cedula no valida!\n";
        }
        if(claseVehiculoBox.getValue() == null){
             errorMessage += "Clase de vehiculo no valida!\n";
        }
        if(!efectivoBtn.isSelected()&& !flyPassBtn.isSelected()){
             errorMessage += "Tipo de pago invalido!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos invalidos!");
            alert.setHeaderText("Porfavor corrija los campos invalidos.");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }
    
}
