/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aquabot_java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author daniel
 */
public class Panel_Casa extends javax.swing.JPanel {
    private final Image imagen = new ImageIcon("casa.jpg").getImage();
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }
    
    public void agregarGrifo(Boton_Grifo boton_grifo, int x, int y, int top, int left, int bottom, int right) {
        boton_grifo.setPreferredSize(new Dimension(35, 30));
        GridBagConstraints gb = new GridBagConstraints();
        gb.gridx = x;
        gb.gridy = y;
        gb.insets = new Insets(top, left, bottom, right);
        add(boton_grifo, gb);
    }
    
    public void agregarMonitor(JTextField boton_grifo, int x, int y, int top, int left, int bottom, int right) {
        boton_grifo.setPreferredSize(new Dimension(35, 30));
        GridBagConstraints gb = new GridBagConstraints();
        gb.gridx = x;
        gb.gridy = y;
        gb.insets = new Insets(top, left, bottom, right);
        add(boton_grifo, gb);
    }

    /**
     * Creates new form Panel_Casa
     */
    public Panel_Casa() {
        initComponents();
        construir();
    }
    
    private void construir() {
        setBorder(new LineBorder(Color.black));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridBagLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}