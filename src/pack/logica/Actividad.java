/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.logica;

/**
 *
 * @author daniel
 */
public class Actividad {
    private final int id, idSensor;
    private final String nombre;
    private final double limite;

    public Actividad(int id, int idSensor, String nombre, double limite) {
        this.id = id;
        this.idSensor = idSensor;
        this.nombre = nombre;
        this.limite = limite;
    }

    @Override
    public String toString() {
        return getNombre();
    }

    public int getId() {
        return id;
    }

    public int getIdSensor() {
        return idSensor;
    }

    public String getNombre() {
        return nombre;
    }

    public double getLimite() {
        return limite;
    }
}
