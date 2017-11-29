/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import aplicacion.modelo.Vehiculo;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    private TableView<Vehiculo> conductorTable;
    @FXML
    private TableColumn<Vehiculo, String> nameColumn;
    @FXML
    private TableColumn<Vehiculo, String> matriculaColumn;
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
    
    private SistemaDePeajes mainApp;
    
    public void setMainApp(SistemaDePeajes mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        conductorTable.setItems(mainApp.getVehiculoData());
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameColumn.setCellValueFactory(
            cellData -> cellData.getValue().getNombreProperty());
        matriculaColumn.setCellValueFactory(
                cellData -> cellData.getValue().getMatriculaProperty());

        // Clear person details.
        showVehiculoDetails(null);

        // Listen for selection changes and show the person details when changed.
        conductorTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showVehiculoDetails(newValue));
    }    

    @FXML
    private void handleNewConductor() {
        Vehiculo tempVehiculo = new Vehiculo();
        boolean okClicked = mainApp.showVehiculoEditDialog(tempVehiculo);
        if (okClicked) {
            tempVehiculo.setPagoPeaje(mainApp.getPeajeData().getPrecio(tempVehiculo));
            mainApp.getVehiculoData().add(tempVehiculo);
        }
    }

    @FXML
    private void handleDeleteConductor() {
        int selectedIndex = conductorTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            conductorTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No vehicle Selected.");
            alert.setContentText("Please select a vehicle in the table.");
            alert.show();
        }
    }

    @FXML
    private void exportarInformePDF() {
        try {
            String informe = "";
            List<Vehiculo> showing = conductorTable.getItems();
            for (Vehiculo j : showing) {
                informe += "Fecha: " + j.getFechaEntrada() + " Nombre: " + j.getNombre() + " Cédula: " +
                        j.getCedula() + " Matrícula: " + j.getMatricula() + " Clase de vehículo: " +
                        j.getClaseVehiculo() + " Monto cancelado: " + j.getPagoPeaje() + "$" + "\n";

            }
            FileOutputStream archivo = new FileOutputStream("PDF/informe.pdf");
            Document doc = new Document();

            PdfWriter.getInstance(doc, archivo);
            doc.open();
            doc.add(new Paragraph(informe));
            doc.close();
            PdfWriter.getInstance(doc, archivo);
        } catch (Exception a) {

        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fichero PDF creado con exito!");
        alert.setHeaderText(null);
        alert.setContentText("El archivo fue generado en la Ruta PDFS/Informes");
        alert.show();
    }
    
    private void showVehiculoDetails(Vehiculo vehiculo) {
        if (vehiculo != null) {
            // Fill the labels with info from the person object.

            propietarioLabel.setText(vehiculo.getNombre());
            matriculaLabel.setText(vehiculo.getMatricula());
            cedulaLabel.setText(vehiculo.getMatricula());
            claseVehiculoLabel.setText(vehiculo.getClaseVehiculo());
            valorPagoLabel.setText(String.valueOf(vehiculo.getPagoPeaje()));
            tipoPagoLabel.setText(String.valueOf(vehiculo.getTipoPago()));
            fechaLabel.setText(vehiculo.getFechaEntrada());
            horaLabel.setText(vehiculo.getHoraEntrada());

            // TODO: We need a way to convert the birthday into a String! 
            // birthdayLabel.setText(...);
        } else {
            // Person is null, remove all the text.
            propietarioLabel.setText("");
            matriculaLabel.setText("");
            cedulaLabel.setText("");
            claseVehiculoLabel.setText("");
            valorPagoLabel.setText("");
            tipoPagoLabel.setText("");
            fechaLabel.setText("");
            horaLabel.setText("");
        }
    }
    
}
