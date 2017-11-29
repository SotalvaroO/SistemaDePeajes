/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
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
    private final DoubleProperty pagoPeaje;
    private final IntegerProperty tipoPago;
    
    public Conductor() {
        this(null, null, 0.0, 0);
    }
    
    public Conductor(String nombre, String cedula, Double pagoPeaje, int tipoPago){
        this.nombre = new SimpleStringProperty(nombre);
        this.cedula = new SimpleStringProperty(cedula);
        this.fechaEntrada = new SimpleStringProperty(LocalDate.now().toString());
        this.HoraEntrada = new SimpleStringProperty(LocalTime.now().getHour()+":"+LocalTime.now().getMinute()
            + ":"+ LocalTime.now().getSecond());
        this.pagoPeaje = new SimpleDoubleProperty(pagoPeaje);
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

    public DoubleProperty getPagoPeajeProperty() {
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

    public void setPagoPeaje(double pagoPeaje) {
        this.pagoPeaje.set(pagoPeaje);
    }

    public void setTipoPago(int tipoPago) {
        this.tipoPago.set(tipoPago);
    }

    public String getFechaEntrada() {
        return fechaEntrada.get();
    }

    public String getHoraEntrada() {
        return HoraEntrada.get();
    }

    public double getPagoPeaje() {
        return pagoPeaje.get();
    }

    public Integer getTipoPago() {
        return tipoPago.get();
    }
    
}
