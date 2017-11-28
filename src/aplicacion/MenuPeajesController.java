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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author juan.jaramillo62
 */
public class MenuPeajesController implements Initializable {

    @FXML
    private TableView<?> conductorTable;
    @FXML
    private TableColumn<?, ?> nameColumn;
    @FXML
    private TableColumn<?, ?> matriculaColumn;
    @FXML
    private Label propietarioLabel;
    @FXML
    private Label matriculaLabel;
    @FXML
    private Label valorPagoLabel;
    @FXML
    private Label fechaLabel;
    @FXML
    private Label horaLabel;
    @FXML
    private Label tipoPagoLabel;
    @FXML
    private Label claseVehiculoLabel;
    @FXML
    private Label cedulaLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleNewConductor(ActionEvent event) {
    }

    @FXML
    private void handleDeleteConductor(ActionEvent event) {
    }

    @FXML
    private void exportarInformePDF(ActionEvent event) {
    }
    
}
