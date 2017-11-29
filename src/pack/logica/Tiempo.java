/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.logica;

import static java.lang.Thread.sleep;

/**
 *
 * @author daniel
 */
public class Tiempo {
    public static void esperar(int escala) {
        try {
            sleep(escala);
        } catch (InterruptedException ex) {
            System.err.println("espera fallida - " + ex.getMessage());
        }
    }
}
