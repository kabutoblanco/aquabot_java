/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.logica;

import javax.swing.JTextField;
import pack.persistencia.Conexion;


/**
 *
 * @author daniel
 */
public class Sensor {
    private final int id, locaId;
    private final Contador contador;
    private double flujo, consumo, limite;
    private JTextField monitor;

    public Sensor(int id, double limite, int locaId, Contador contador, double flujo, JTextField monitor) {
        this.id = id;
        this.contador = contador;
        this.flujo = flujo;
        this.limite = limite;
        this.monitor = monitor;
        this.locaId = locaId;
    }

    public void actualizar(Grifo sujeto) {
        flujo = sujeto.getFlujo();
        consumo += flujo;
        if (consumo >= limite && consumo < limite + 2)
            cerrarGrifo(sujeto);
        monitor.setText(Decimal.getDecimal().format(flujo));
        contador.actualizar(this);
    }
    
    public void registrarConsumo() {
        Conexion.ejecutarDML("update CONTADORES set contRegistro = " + contador.getRegistro() + " where contId = " + contador.getId());
        Conexion.ejecutarDML("insert into HISTORIAL_CONSUMOS values (null, " + Usuario.getInstancia().getId() + ", " + getId() + ", " + Decimal.getDecimal().format(consumo) + ", '" + Fecha.getFecha() + "')");
        consumo = 0;
    }
    
    public void cerrarGrifo(Grifo sujeto) {
        sujeto.cerrar();
    }

    @Override
    public String toString() {
        return Integer.toString(getId());
    }

    public int getId() {
        return id;
    }

    public int getLocaId() {
        return locaId;
    }

    public double getFlujo() {
        return flujo;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setMonitor(JTextField monitor) {
        this.monitor = monitor;
    }
    
}
