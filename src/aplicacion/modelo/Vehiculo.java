/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo;

import javafx.beans.property.StringProperty;

/**
 *
 * @author juan.jaramillo62
 */
public class Vehiculo extends Conductor {

    private final StringProperty matricula;
    private final StringProperty claseVehiculo;

    public Vehiculo(StringProperty matricula, StringProperty claseVehiculo) {
        this.matricula = matricula;
        this.claseVehiculo = claseVehiculo;
    }

    public Vehiculo(StringProperty matricula, StringProperty claseVehiculo, String nombre, String cedula, String fechaEntrada, String horaEntrada, String pagoPeaje, int tipoPago) {
        super(nombre, cedula, fechaEntrada, horaEntrada, pagoPeaje, tipoPago);
        this.matricula = matricula;
        this.claseVehiculo = claseVehiculo;
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

    public void getClaseVehiculo(String claseVehiculo) {
        this.claseVehiculo.set(claseVehiculo);
    }

    public StringProperty getMatriculaProperty() {
        return matricula;
    }

    public StringProperty getClaseVehiculoProperty() {
        return claseVehiculo;
    }
    

}
