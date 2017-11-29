/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo;

/**
 *
 * @author juan.jaramillo62
 */
public class Peaje {
    private int tipoPago;
    private double precio;
    private double precio1;
    private double precio2;
    private double precio3;
    private double precio4;
    private double precio5;
    private double precio6;
    private double precio7;

    public Peaje() {
        this.precio1 = 8384;
        this.precio2 = 10535;
        this.precio3 = 17927;
        this.precio4 = 22993;
        this.precio5 = 29961;
        this.precio6 = 37592;
        this.precio7 = 40268;
        tipoPago = 1;
    }

    public Peaje(double precio1, double precio2, double precio3, double precio4, double precio5, double precio6, double precio7, int tipoPago) {
        this.precio1 = precio1;
        this.precio2 = precio2;
        this.precio3 = precio3;
        this.precio4 = precio4;
        this.precio5 = precio5;
        this.precio6 = precio6;
        this.precio7 = precio7;
        this.tipoPago = tipoPago;
    }

    public double getPrecio(Vehiculo vehiculo) {
        int clase = Integer.parseInt(vehiculo.getClaseVehiculo());
        switch (clase) {
            case 1:
                return precio1;
            case 2:
                return precio2;
            case 3:
                return precio3;
            case 4:
                return precio4;
            case 5:
                return precio5;
            case 6:
                return precio6;
            default:
                return precio7;
        }

    }
    public String getTipoPago() {
        if(tipoPago == 1){
            return "Efectivo";
        }else{
            return "FlyPass";
        }
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }
}
