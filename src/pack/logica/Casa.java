/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.logica;

import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class Casa {
    private static Casa instancia;
    private final int id;
    private final String ciudad, barrio, direccion;
    private final Contador contador;
    private final ArrayList<Usuario> usuarios;
    private final ArrayList<Sensor> sensores;
    private final ArrayList<Actividad> actividades;

    private Casa(int id, String ciudad, String barrio, String direccion, Contador contador, ArrayList<Usuario> usuarios, ArrayList<Sensor> sensores, ArrayList<Actividad> actividades) {
        this.id = id;
        this.ciudad = ciudad;
        this.barrio = barrio;
        this.direccion = direccion;
        this.contador = contador;
        this.usuarios = usuarios;
        this.sensores = sensores;
        this.actividades = actividades;
    }

    public static Casa getInstancia(int id, String ciudad, String barrio, String direccion, Contador contador, ArrayList<Usuario> usuarios, ArrayList<Sensor> sensores, ArrayList<Actividad> actividades) {
        if (instancia == null) {
            instancia = new Casa(id, ciudad, barrio, direccion, contador, usuarios, sensores, actividades);
            return instancia;
        }
        return getInstancia();
    }
    
    public static void purgar() {
        instancia = null;
    }

    public static Casa getInstancia() {
        return instancia;
    }

    public int getId() {
        return id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getBarrio() {
        return barrio;
    }

    public String getDireccion() {
        return direccion;
    }

    public Contador getContador() {
        return contador;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Sensor> getSensores() {
        return sensores;
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }
}
