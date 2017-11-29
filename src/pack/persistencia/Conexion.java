/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class Conexion {
    private static Connection conexion;
    private static Statement st;
    private static ResultSet rs;
    
    private static void iniciar() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:1520/aquabot","root", "");
            st = conexion.createStatement();
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar" + e);
        }

    }
    
    private static void cerrar() {
        try {            
            if(conexion != null)
                conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al Ejecutar SELECT" + e.getMessage());
        }
    }
    
    public static int ejecutarDML(String sql) {
        int res;
        try {
            iniciar();
            res = st.executeUpdate(sql); 
            cerrar();
            return res;
        } catch (SQLException e) {
            System.out.println("Error al Ejecutar DML :" + e.getMessage());
            return 0;
        }
    }
    
    public static ArrayList<Object[]> ejecutarDDL(String sql) {
        int cabecera;
        Object[] columnas, registro;
        ArrayList<Object[]> registros = new ArrayList<>();
        try {
            iniciar();
            rs = st.executeQuery(sql);
            cabecera = rs.getMetaData().getColumnCount();
            columnas = new Object[cabecera];
            for (int i = 0; i < cabecera; i++)
                columnas[i] = rs.getMetaData().getColumnLabel(i + 1);
            registros.add(columnas);
            while (rs.next()) {
                registro = new Object[cabecera];
                for(int i = 0; i < cabecera; i++)
                    registro[i] = rs.getObject(i + 1);
                registros.add(registro);
            }
            cerrar();
            return registros;
        } catch (SQLException e) {
            System.out.println("Error al Ejecutar SELECT" + e.getMessage());
            return null;
        }
    }
}
