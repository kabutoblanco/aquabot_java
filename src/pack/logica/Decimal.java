/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.logica;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author daniel
 */
public class Decimal {
    public static DecimalFormat getDecimal() {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        return new DecimalFormat("#.00", simbolos);
    }
}
