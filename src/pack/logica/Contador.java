/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.logica;

import javax.swing.JTextField;

/**
 *
 * @author daniel
 */
public class Contador {
    private final int id;
    private final JTextField monitor;
    private double registro;

    public Contador(int id, JTextField monitor, double registro) {
        this.id = id;
        this.monitor = monitor;
        this.registro = registro;
    }

    public void actualizar(Sensor sujeto) {
        registro += sujeto.getFlujo();
        monitor.setText(Decimal.getDecimal().format(registro));
    }

    public int getId() {
        return id;
    }

    public double getRegistro() {
        return registro;
    }
    
}
