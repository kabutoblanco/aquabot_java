/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aquabot_java;

import javax.swing.JFrame;

/**
 *
 * @author daniel
 */
public class Aquabot_Java {
    public static JFrame ventanaIngreso = new JFrame("Aquabot");
    public static JFrame ventanaCasa;
    public static Panel_Ingreso panelIngreso = new Panel_Ingreso();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ventanaIngreso.setDefaultCloseOperation(3);
        ventanaIngreso.add(panelIngreso);
        ventanaIngreso.setSize(352, 209);
        ventanaIngreso.setResizable(false);
        ventanaIngreso.setVisible(true);
    }
    
}
