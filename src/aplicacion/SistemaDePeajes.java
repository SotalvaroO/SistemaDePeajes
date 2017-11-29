/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import aplicacion.modelo.Peaje;
import aplicacion.modelo.Vehiculo;
import aplicacion.modelo.VehiculoListWrapper;
import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author juan.jaramillo62
 */
public class SistemaDePeajes extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Vehiculo> vehiculoData = FXCollections.observableArrayList();
    private Peaje peajeData;

    public ObservableList<Vehiculo> getVehiculoData() {
        return vehiculoData;
    }
    
    public Peaje getPeajeData() {
        return peajeData;
    }

    public SistemaDePeajes() {
        peajeData = new Peaje();
    }
    
    

    @Override
    public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
        this.primaryStage.setTitle("SistemaDePeajes");

        initRootLayout();

        showMenuPeajes();
    }    

    public void showMenuPeajes() {
        try {
        // Load person overview.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SistemaDePeajes.class.getResource("vista/MenuPeajes.fxml"));
        AnchorPane personOverview = (AnchorPane) loader.load();

        // Set person overview into the center of root layout.
        rootLayout.setCenter(personOverview);

        // Give the controller access to the main app.
        MenuPeajesController controller = loader.getController();
        controller.setMainApp(this);

    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SistemaDePeajes.class.getResource("vista/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public boolean showVehiculoEditDialog(Vehiculo vehiculo) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SistemaDePeajes.class.getResource("vista/ConductorEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            ConductorEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setVehiculo(vehiculo);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public File getVehiculoFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(SistemaDePeajes.class);
        String filePath = prefs.get("vehiculoFilePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }
    
    public void setVehiculoFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(SistemaDePeajes.class);
        if (file != null) {
            prefs.put("vehiculoFilePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle("Sistema de peajes - " + file.getName());
        } else {
            prefs.remove("vehiculoFilePath");

            // Update the stage title.
            primaryStage.setTitle("Sistema de peajes");
        }
    }
    
    public void loadVehiculoDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(VehiculoListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            VehiculoListWrapper wrapper = (VehiculoListWrapper) um.unmarshal(file);

            vehiculoData.clear();
            vehiculoData.addAll(wrapper.getVehiculos());

            // Save the file path to the registry.
            setVehiculoFilePath(file);

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos invalidos!");
            alert.setHeaderText("Could not load data from file:\n" + file.getPath());
            alert.show();
        }
    }
    
    public void saveVehiculoDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(VehiculoListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            VehiculoListWrapper wrapper = new VehiculoListWrapper();
            wrapper.setVehiculos(vehiculoData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setVehiculoFilePath(file);
        } catch (Exception e) { // catches ANY exception

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos invalidos!");
            alert.setHeaderText("Could not save data to file:\n" + file.getPath());
            alert.show();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
