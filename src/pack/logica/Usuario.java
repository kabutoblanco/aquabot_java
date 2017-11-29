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
public class Usuario {
    private static Usuario instancia;
    private final int id, identidad, telefono;
    private final String nombres, apellido1, apellido2;

    private Usuario(int id, int identidad, int telefono, String nombres, String apellido1, String apellido2) {
        this.id = id;
        this.identidad = identidad;
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }
    
    public static Usuario getInstancia(int id, int identidad, int telefono, String nombres, String apellido1, String apellido2) {
        if (instancia == null) {
            instancia = new Usuario(id, identidad, telefono, nombres, apellido1, apellido2);
            return instancia;
        }
        return getInstancia();
    }

    public static Usuario getInstancia() {
        return instancia;
    }
    
    public static void purgar() {
        instancia = null;
    }

    public int getId() {
        return id;
    }

    public int getIdentidad() {
        return identidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }
}
