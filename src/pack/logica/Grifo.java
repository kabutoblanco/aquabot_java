/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.logica;

import java.util.concurrent.Semaphore;

/**
 *
 * @author daniel
 */
public class Grifo implements Runnable {
    private final Sensor sensor;
    private double flujo;
    private boolean estado = false;
    private final Semaphore mutex = new Semaphore(1);

    public Grifo(Sensor sensor, double flujo, boolean estado) {
        this.sensor = sensor;
        this.flujo = flujo;
        this.estado = estado;
    }

    @Override
    public void run() {
        while (true) {
            if (estado) {
                fluir();
                Tiempo.esperar(1000);
            }
            try {
                mutex.acquire();
                sensor.actualizar(this);
            } catch (InterruptedException ex) {
                System.err.println("semaforo fail " + ex.getMessage());
            }
            mutex.release();
        }
    }
    
    private void fluir() {
        flujo = (Math.random() * 3) + 1;
    }
    
    public void abrir() {
        estado = true;
    }
    
    public void cerrar() {
        sensor.registrarConsumo();
        flujo = 0;
        estado = false;
    }

    public double getFlujo() {
        return flujo;
    }

    public boolean isEstado() {
        return estado;
    }
    
}
