/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author juan.jaramillo62
 */
public class Conductor {
    private final StringProperty nombre;
    private final StringProperty cedula;
    private final StringProperty fechaEntrada;
    private final StringProperty HoraEntrada;
    private final StringProperty pagoPeaje;
    private final IntegerProperty tipoPago;
    
    public Conductor() {
        this(null, null, null, null, null, 0);
    }
    
    public Conductor(String nombre, String cedula, String fechaEntrada, String horaEntrada, String pagoPeaje, int tipoPago){
        this.nombre = new SimpleStringProperty(nombre);
        this.cedula = new SimpleStringProperty(cedula);
        this.fechaEntrada = new SimpleStringProperty(fechaEntrada);
        this.HoraEntrada = new SimpleStringProperty(horaEntrada);
        this.pagoPeaje = new SimpleStringProperty(pagoPeaje);
        this.tipoPago = new SimpleIntegerProperty(tipoPago);
    }

    public StringProperty getNombreProperty() {
        return nombre;
    }

    public StringProperty getCedulaProperty() {
        return cedula;
    }

    public String getNombre() {
        return nombre.get();
    }

    public String getCedula() {
        return cedula.get();
    }
    
    
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public void setCedula(String cedula) {
        this.cedula.set(cedula);
    }

    public StringProperty getFechaEntradaProperty() {
        return fechaEntrada;
    }

    public StringProperty getHoraEntradaProperty() {
        return HoraEntrada;
    }

    public StringProperty getPagoPeajeProperty() {
        return pagoPeaje;
    }

    public IntegerProperty getTipoPagoProperty() {
        return tipoPago;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada.set(fechaEntrada);
    }

    public void setHoraEntrada(String horaEntrada) {
        this.HoraEntrada.set(horaEntrada);
    }

    public void setPagoPeaje(String pagoPeaje) {
        this.pagoPeaje.set(pagoPeaje);
    }

    public void getTipoPago(int tipoPago) {
        this.tipoPago.set(tipoPago);
    }

    public String getFechaEntrada() {
        return fechaEntrada.get();
    }

    public String getHoraEntrada() {
        return HoraEntrada.get();
    }

    public String getPagoPeaje() {
        return pagoPeaje.get();
    }

    public Integer getTipoPago() {
        return tipoPago.get();
    }
    
}
