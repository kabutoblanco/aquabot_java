/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.logica;

import java.util.Calendar;


/**
 *
 * @author daniel
 */
public class Fecha {
    public static String getFecha() {
        Calendar fecha = Calendar.getInstance();
        return fecha.get(Calendar.YEAR) + "-" + (fecha.get(Calendar.MONTH) + 1) + "-" + fecha.get(Calendar.DATE);
    }
    
    public static boolean comparar(Calendar fecha1, Calendar fecha2) {
        long dif = fecha1.getTimeInMillis() - fecha2.getTimeInMillis();
        System.out.println((dif / (1000 * 60 * 60 * 24)));
        return (dif / (1000 * 60 * 60 * 24)) >= 28;
    }
}
