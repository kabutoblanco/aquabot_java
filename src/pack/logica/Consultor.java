/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.logica;

import java.util.ArrayList;
import pack.persistencia.Conexion;

/**
 *
 * @author daniel
 */
public class Consultor {
    private static Consultor instancia;
    
    public static Consultor getInstancia() {
        if (instancia == null)
            return new Consultor();
        return instancia;
    }
    
    public ArrayList<Object[]> getCasa(int casaId) {
        return Conexion.ejecutarDDL("select CASAS.casaId, ciudNombre, barrNombre, casaDireccion from (CASAS INNER JOIN BARRIOS ON CASAS.barrId = BARRIOS.barrId) INNER JOIN CIUDADES ON BARRIOS.ciudId = CIUDADES.ciudId  where CASAS.casaId = " + casaId);
    }
    
    public ArrayList<Object[]> getUsuario(int usuaIdentidad, String usuaClave) {
        return Conexion.ejecutarDDL("select * from USUARIOS where usuaIdentidad = " + usuaIdentidad + " and usuaClave = '" + usuaClave + "'");
    }
    
    public ArrayList<Object[]> getContador(int casaId) {
        return Conexion.ejecutarDDL("select * from CONTADORES where casaId = " + casaId);
    }
    
    public ArrayList<Object[]> getLocaciones(int contId) {
        return Conexion.ejecutarDDL("select LOCACIONES.locaId from (LOCACIONES INNER JOIN SENSORES ON LOCACIONES.locaId = SENSORES.locaId) WHERE contId = " + contId);
    }
    
    public ArrayList<Object[]> getSensores(int contId) {
        return Conexion.ejecutarDDL("select * from SENSORES inner join LOCACIONES on SENSORES.locaId = LOCACIONES.locaId where contId = " + contId);
    }
    
    public ArrayList<Object[]> getUsuarios(int casaId) {
        return Conexion.ejecutarDDL("select * from USUARIOS where casaId = " + casaId);
    }
    
    public ArrayList<Object[]> getActividades(int contId, int usuaId) {
        return Conexion.ejecutarDDL("select * from (DETALLE_ACTIVIDADES inner join ACTIVIDADES ON DETALLE_ACTIVIDADES.actiId = ACTIVIDADES.actiId) inner join SENSORES on DETALLE_ACTIVIDADES.sensId = SENSORES.sensId where contId = " + contId + " and DETALLE_ACTIVIDADES.usuaId = " + usuaId);
    }
}
