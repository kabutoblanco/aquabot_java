/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aquabot_java;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pack.logica.Actividad;
import pack.logica.Casa;
import pack.logica.Consultor;
import pack.logica.Contador;
import pack.logica.Decimal;
import pack.logica.Fecha;
import pack.logica.Grifo;
import pack.logica.Sensor;
import pack.logica.Usuario;
import pack.persistencia.Conexion;

/**
 *
 * @author daniel
 */
public class Panel_Ingreso extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form Panel_Ingreso
     */
    public Panel_Ingreso() {
        initComponents();
        construir();
    }
    
    private void construir() {
        addKeyListener(this);
        setFocusable(true);
        getTextIdentidad().addKeyListener(this);
        getTextClave().addKeyListener(this);
        getButtEntrar().addKeyListener(this);
        getTextIdentidad().setFocusable(true);
        getTextClave().setFocusable(true);
        getButtEntrar().setFocusable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textIdentidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textClave = new javax.swing.JTextField();
        buttEntrar = new javax.swing.JButton();

        jLabel1.setText("Identidad");

        jLabel2.setText("Clave");

        buttEntrar.setText("ENTRAR");
        buttEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(textIdentidad)
                            .addComponent(textClave, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(buttEntrar)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttEntrar)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttEntrarActionPerformed
        // TODO add your handling code here:
        validarEntrada();
    }//GEN-LAST:event_buttEntrarActionPerformed

    private void validarEntrada() {
        try {
            Consultor consultor = Consultor.getInstancia();
            ArrayList<Object[]> resultado = consultor.getUsuario(Integer.parseInt(textIdentidad.getText()), textClave.getText());
            if (resultado.size() > 1) {
                Aquabot_Java.ventanaCasa = new JFrame("Aquabot");
                construirCasa(resultado);
                Aquabot_Java.ventanaIngreso.setVisible(false);
            }
            else
                JOptionPane.showMessageDialog(null, "Usuario incorrecto", "ERROR", JOptionPane.OK_OPTION);
            }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Usuario incorrecto", "ERROR", JOptionPane.OK_OPTION);
        }
    }
    
    private void construirCasa(ArrayList<Object[]> resultado) {
        Consultor consultor = Consultor.getInstancia();
        
        Usuario.purgar();
        Usuario.getInstancia((int) resultado.get(1)[0], (int) resultado.get(1)[2], (int) resultado.get(1)[7], resultado.get(1)[4].toString(), resultado.get(1)[5].toString(), resultado.get(1)[6].toString());
        
        ArrayList<Usuario> listUsuarios = new ArrayList<>();
        ArrayList<Sensor> listSensores = new ArrayList<>();
        ArrayList<Actividad> listActividades = new ArrayList<>();
        
        ArrayList<Object[]> casa = consultor.getCasa((int) resultado.get(1)[1]);
        ArrayList<Object[]> contador = consultor.getContador((int) resultado.get(1)[1]);
        ArrayList<Object[]> locaciones = consultor.getLocaciones((int) contador.get(1)[0]);
        ArrayList<Object[]> sensores = consultor.getSensores((int) contador.get(1)[0]);
        ArrayList<Object[]> actividades = consultor.getActividades((int) contador.get(1)[0], Usuario.getInstancia().getId());
        ArrayList<Object[]> usuarios = consultor.getUsuarios((int) resultado.get(1)[1]);
        
        Panel_Casa panelCasa = new Panel_Casa();        
        Panel_Informacion info = new Panel_Informacion();
        JPanel panel = new JPanel(new GridBagLayout());
        
        info.getTextIdentidad().setText(Integer.toString(Usuario.getInstancia().getIdentidad()));
        info.getTextNombres().setText(Usuario.getInstancia().getNombres());
        info.getTextApellidos().setText(Usuario.getInstancia().getApellido1() + " " + Usuario.getInstancia().getApellido2());
        info.getTextTelefono().setText(Integer.toString(Usuario.getInstancia().getTelefono()));
        
        Contador objContador = new Contador((int) contador.get(1)[0], info.getTextContador(), Double.parseDouble(contador.get(1)[3].toString()));
        
        ArrayList<Object[]> historial = Conexion.ejecutarDDL("select max(histFechaC) from HISTORIAL_CONTADORES where contId = " + objContador.getId());
        
        if (historial.get(1)[0] != null) {
            String[] fecha2 = historial.get(1)[0].toString().split("-");   
            Calendar fechaR = Calendar.getInstance();
            fechaR.set(Integer.parseInt(fecha2[0]), Integer.parseInt(fecha2[1]) - 1, Integer.parseInt(fecha2[2]));
            if (Fecha.comparar(Calendar.getInstance(), fechaR))
                Conexion.ejecutarDML("insert into HISTORIAL_CONTADORES values (null, " + objContador.getId() + ", " + Decimal.getDecimal().format(objContador.getRegistro()) + ", '" + Fecha.getFecha() + "')");
        }
        
        String[] vectUsuarios = new String[usuarios.size() - 1];
        for (int i = 1; i < usuarios.size(); i++) {
            Object[] usuario = usuarios.get(i);
            vectUsuarios[i - 1] = usuario[4].toString();
        }
        info.getListUsuarios().setListData(vectUsuarios);
        
        info.getCombSensores().removeAllItems();
        for (int i = 1; i < sensores.size(); i++) {
            Object[] sensor = sensores.get(i);
            listSensores.add(new Sensor((int) sensor[0], 50, (int) sensor[1], objContador, 0, new JTextField("0")));
            info.getCombSensores().addItem(listSensores.get(i - 1));
        }  
        
        int c = 0;
        info.getCombActividades().removeAllItems();
        for (int i = 1; i < actividades.size(); i++) {
            Object[] actividad = actividades.get(i);
            listActividades.add(new Actividad((int) actividad[0], (int) actividad[7], actividad[6].toString(), Double.parseDouble(actividad[4].toString())));
            if ((int) actividad[7] == listSensores.get(0).getId()) {
                info.getCombActividades().addItem(listActividades.get(i - 1));
                if (c == 0) {
                    listSensores.get(0).setLimite(Double.parseDouble(actividad[4].toString()));
                    c++;
                }
            }
        }       
        
        Casa.purgar();
        Casa objCasa = Casa.getInstancia((int) casa.get(1)[0], casa.get(1)[1].toString(), casa.get(1)[2].toString(), casa.get(1)[3].toString(), objContador, listUsuarios, listSensores, listActividades);
        
        for (int i = 1; i < locaciones.size(); i++) {
            Object[] locacion = locaciones.get(i);
            situarGrifo((int) locacion[0], panelCasa);
        } 
        
        info.getTextCiudad().setText(objCasa.getCiudad());
        info.getTextBarrio().setText(objCasa.getBarrio());
        info.getTextDireccion().setText(objCasa.getDireccion());
        
        GridBagConstraints gb0 = new GridBagConstraints();
        gb0.gridx = 0;
        gb0.gridy = 0;
        gb0.gridwidth = 2;
        gb0.insets = new Insets(0, 0, 0, 10);
        panel.add(panelCasa, gb0);
        GridBagConstraints gb1 = new GridBagConstraints();
        gb1.gridx = 2;
        gb1.gridy = 0;
        gb1.gridwidth = 1;
        gb0.insets = new Insets(0, 0, 10, 0);
        panel.add(info, gb1);

        panelCasa.setPreferredSize(new Dimension(800, 500));
        info.setPreferredSize(new Dimension(265, 500));
        
        Aquabot_Java.ventanaCasa.setDefaultCloseOperation(0);
        Aquabot_Java.ventanaCasa.add(panel);
        Aquabot_Java.ventanaCasa.setSize(1095, 535);
        Aquabot_Java.ventanaCasa.setResizable(false);
        Aquabot_Java.ventanaCasa.setVisible(true);
    }
    
    private void situarGrifo(int locaId, Panel_Casa casa) {
        switch (locaId) {
            case 1: 
                JTextField monitorTina = new JTextField("0");
                monitorTina.setEditable(false);
                Sensor sensorTina = null;
                for (Sensor sensor : Casa.getInstancia().getSensores()) {
                    if (sensor.getLocaId() == locaId) {
                        sensorTina = sensor;
                        sensorTina.setMonitor(monitorTina);
                        break;
                    }
                }
                Grifo grifoTina = new Grifo(sensorTina, 0, false);
                Thread hiloTina = new Thread(grifoTina);
                Boton_Grifo botonTina = new Boton_Grifo(grifoTina);
                botonTina.setCursor(new Cursor(Cursor.HAND_CURSOR));
                casa.agregarGrifo(botonTina, 0, 0, 0, 350, 410, 0);
                casa.agregarMonitor(monitorTina, 0, 0, 0, 350, 350, 0);
                hiloTina.start();
                break;
            case 2: 
                JTextField monitorCocina = new JTextField("0");
                monitorCocina.setEditable(false);
                Sensor sensorCocina = null;
                for (Sensor sensor : Casa.getInstancia().getSensores()) {
                    if (sensor.getLocaId() == locaId) {
                        sensorCocina = sensor;
                        sensorCocina.setMonitor(monitorCocina);
                        break;
                    }
                }
                Grifo grifoCocina = new Grifo(sensorCocina, 0, false);
                Thread hiloCocina = new Thread(grifoCocina);
                Boton_Grifo botonCocina = new Boton_Grifo(grifoCocina);
                botonCocina.setCursor(new Cursor(Cursor.HAND_CURSOR));
                casa.agregarGrifo(botonCocina, 0, 0, 445, 0, 0, 115);
                casa.agregarMonitor(monitorCocina, 0, 0, 385, 0, 0, 115);
                hiloCocina.start();
                break;
            case 3:
                JTextField monitorManos = new JTextField("0");
                monitorManos.setEditable(false);
                Sensor sensorManos = null;
                for (Sensor sensor : Casa.getInstancia().getSensores()) {
                    if (sensor.getLocaId() == locaId) {
                        sensorManos = sensor;
                        sensorManos.setMonitor(monitorManos);
                        break;
                    }
                }
                Grifo grifoManos = new Grifo(sensorManos, 0, false);
                Thread hiloManos = new Thread(grifoManos);
                Boton_Grifo botonManos = new Boton_Grifo(grifoManos);
                botonManos.setCursor(new Cursor(Cursor.HAND_CURSOR));
                casa.agregarGrifo(botonManos, 0, 0, 0, 435, 260, 0);
                casa.agregarMonitor(monitorManos, 0, 0, 0, 435, 200, 0);
                hiloManos.start();
                break;
            case 4:
                JTextField monitorInodoro = new JTextField("0");
                monitorInodoro.setEditable(false);
                Sensor sensorInodoro = null;
                for (Sensor sensor : Casa.getInstancia().getSensores()) {
                    if (sensor.getLocaId() == locaId) {
                        sensorInodoro = sensor;
                        sensorInodoro.setMonitor(monitorInodoro);
                        break;
                    }
                }
                Grifo grifoInodoro = new Grifo(sensorInodoro, 0, false);
                Thread hiloInodoro = new Thread(grifoInodoro);
                Boton_Grifo botonInodoro = new Boton_Grifo(grifoInodoro);
                botonInodoro.setCursor(new Cursor(Cursor.HAND_CURSOR));
                casa.agregarGrifo(botonInodoro, 0, 0, 0, 610, 410, 0);
                casa.agregarMonitor(monitorInodoro, 0, 0, 0, 610, 350, 0);
                hiloInodoro.start();
                break;
        } 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField textClave;
    private javax.swing.JTextField textIdentidad;
    // End of variables declaration//GEN-END:variables

    public JTextField getTextClave() {
        return textClave;
    }

    public JTextField getTextIdentidad() {
        return textIdentidad;
    }

    public JButton getButtEntrar() {
        return buttEntrar;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER)
            validarEntrada();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}

