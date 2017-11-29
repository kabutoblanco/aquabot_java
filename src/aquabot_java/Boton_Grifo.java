/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aquabot_java;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import pack.logica.Grifo;

/**
 *
 * @author daniel
 */
public class Boton_Grifo extends JButton implements MouseListener {
    private final Grifo grifo;

    public Boton_Grifo(Grifo grifo) {
        this.grifo = grifo;
        construir();
    }
    
    private void construir() {
        setIcon(new ImageIcon("grifo.png"));
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (grifo.isEstado())
            grifo.cerrar();
        else
            grifo.abrir();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
