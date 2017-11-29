/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author juan.jaramillo62
 */
public class Vehiculo extends Conductor {

    private final StringProperty matricula;
    private final StringProperty claseVehiculo;

    public Vehiculo() {
        this.matricula = new SimpleStringProperty("");
        this.claseVehiculo = new SimpleStringProperty("");
    }
    
    
    
    public Vehiculo(StringProperty matricula, StringProperty claseVehiculo) {
        this.matricula = matricula;
        this.claseVehiculo = claseVehiculo;
    }
    
    public Vehiculo(String matricula, String claseVehiculo, String nombre, String cedula, String fechaEntrada, String horaEntrada, double pagoPeaje, int tipoPago) {
        super(nombre, cedula, pagoPeaje, tipoPago);
        this.matricula = new SimpleStringProperty(matricula);
        this.claseVehiculo =  new SimpleStringProperty(claseVehiculo);
    }

    public String getMatricula() {
        return matricula.get();
    }

    public String getClaseVehiculo() {
        return claseVehiculo.get();
    }

    public void setMatricula(String matricula) {
        this.matricula.set(matricula);
    }

    public void setClaseVehiculo(String claseVehiculo) {
        this.claseVehiculo.set(claseVehiculo);
    }

    public StringProperty getMatriculaProperty() {
        return matricula;
    }

    public StringProperty getClaseVehiculoProperty() {
        return claseVehiculo;
    }
    

}
