/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrouser;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.util.Formatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSpinner;
/**
 *
 * @author Rodriguez
 */
public class registros extends javax.swing.JFrame {
    
    //ubicacion de donde se guardaran los archivos
    String barra = File.separator;
    String ubicacion = System.getProperty("user.dir")+barra+"Registros"+barra;
    
    
    /**
     * Creates new form registros
     */
    public registros() {
        initComponents();
    }
    
    public void crear(){
        //como se va a llamar el archivo
        String archivo = CI.getText()+ ".txt";
        //creando como guardar el archivo 
        File crearInfo = new File(ubicacion);
        File crearArchivo = new File(ubicacion+archivo);
        
        
       
        if(CI.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar su Cedula de identidad");
        }
        else{
            try{
                //conviertiendo el campo de cedula en entero
                int cantidad = Integer.parseInt(CI.getText());
                int semestre = (int)SemestreS.getValue();
                if(crearArchivo.exists()){
                    JOptionPane.showMessageDialog(null, "El numero de cedula ya se encuentra registrado");
                }
                else if((cantidad > 35000000) || (cantidad < 500000)){
                        JOptionPane.showMessageDialog(null, "Debe ingresar una cedula de identidad valida");
                }
                else if((semestre < 1) || (semestre > 12)){
                    JOptionPane.showMessageDialog(null, "Debe ingresar un semestre del 1 al 12");
                }
                else{
                    crearInfo.mkdirs();
                    //creando como se va a guardar los datos
                    Formatter crearformato = new Formatter(ubicacion+archivo);
                    crearformato.format("%s\r\n%s\r\n%s\r\n%s\r\n",
                    "CI:    "+ CI.getText(),
                    "Nombre:    "+ Name.getText() ,
                    "Carrera:   "+ CarreraB.getSelectedItem(),
                    "Semestre:  "+ SemestreS.getValue() );
                    
                    crearformato.close();
                    JOptionPane.showMessageDialog(null, "Registro exitosos");
                }
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "Registro incorrecto");  
                }
        }
    }
    
    private void mostrar(){
        //como se va a llamar el archivo
        File direccion = new File(ubicacion + CI.getText()+".txt");
        if(CI.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar su Cedula de identidad");
        }
        else{
            if(direccion.exists()){
               try{
                   FileInputStream aMostrar = new FileInputStream(direccion);
                   Properties mostrar = new Properties();
                   mostrar.load(aMostrar);
                   
                   //recoge la informacion del archivo de texto
                   Name.setText(mostrar.getProperty("Nombre"));
                   CarreraB.setSelectedItem(mostrar.getProperty("Carrera"));
                   SemestreS.setValue(mostrar.getProperty("Semestre"));
                 
                   
               } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar una cedula de identidad valida");
                }
            }
            else{
                   JOptionPane.showMessageDialog(null, "Debe ingresar una cedula de identidad valida");
                }
        }
        
    }
    
    private void editar(){
        //como se va a llamar el archivo
        File direccion = new File(ubicacion + CI.getText()+".txt");
         int semestreA = (int)SemestreS.getValue();
        if(CI.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar su Cedula de identidad");
        }
        else{
            if(direccion.exists()){
                FileWriter escribir;
                try {
                    
                    if((semestreA >= 1) && (semestreA >= 12)){
                    escribir = new FileWriter(ubicacion + CI.getText()+".txt");
                    //accede a los datos para sobreescribirlos
                    String cedula = "CI:";
                    String name = "Nombre:";
                    String carrera = "Carrera:";
                    String semestre = "Semestre:";

                    PrintWriter guardado = new PrintWriter(escribir);
                    guardado.println(cedula+CI.getText());
                    guardado.println(name+Name.getText());
                    guardado.println(carrera+CarreraB.getSelectedItem());         
                    guardado.println(semestre+SemestreS.getValue());
                    
                    escribir.close();
                    
                     JOptionPane.showMessageDialog(null, "Editado correctamente");
                    }
                     else{
                           JOptionPane.showMessageDialog(null, "Debe ingresar un semestre del 1 al 12");
                         }
                
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar una cedula de identidad valida");
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Debe ingresar una cedula de identidad valida");
            }}
    
    }
    
    private void eliminar(){
        //como se va a llamar el archivo
        File direccion = new File(ubicacion + CI.getText()+".txt");
        String botones [] = {"eliminar","cancelar"};
        
         if(CI.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar su Cedula de identidad");
        }
          if(direccion.exists()){
                
                try {
                   FileInputStream cerrararchivo = new FileInputStream(direccion);
                   cerrararchivo.close();
                   
                   //muestra en opcion de eliminar
                   int opc = JOptionPane.showOptionDialog(rootPane, "¿deseas eliminarlo?" + CI.getText(), "eliminacion",
                            0, 0, null, botones, null);
                                      
                    if(opc == JOptionPane.YES_OPTION){
                       direccion.delete();
                       JOptionPane.showMessageDialog(null, "Usuario eliminado");
                   }    
                } catch (IOException ex) {
                Logger.getLogger(registros.class.getName()).log(Level.SEVERE, null, ex);
            }}else{
                JOptionPane.showMessageDialog(null, "Debe ingresar una cedula de identidad valida");
            }
               
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
        jLabel2 = new javax.swing.JLabel();
        CI = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CarreraB = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        SemestreS = new javax.swing.JSpinner();
        ButtonRegistrarse = new javax.swing.JButton();
        ButtonEditar = new javax.swing.JButton();
        ButtonMostrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ButtonEliminar = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("C.I.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        CI.setBackground(new java.awt.Color(255, 255, 255));
        CI.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        CI.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(CI, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 190, 30));

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Carrera");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        Name.setBackground(new java.awt.Color(255, 255, 255));
        Name.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        Name.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 190, 30));

        jLabel4.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Semestre");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 70, -1));

        CarreraB.setBackground(new java.awt.Color(255, 255, 255));
        CarreraB.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        CarreraB.setForeground(new java.awt.Color(0, 0, 0));
        CarreraB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria de sistemas", "Idiomas", "Derecho", "Contaduria", "Diseño", "Comunicacion", "Psicologia", "" }));
        CarreraB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarreraBActionPerformed(evt);
            }
        });
        getContentPane().add(CarreraB, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 190, -1));

        jLabel5.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        SemestreS.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        SemestreS.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        SemestreS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SemestreSMouseClicked(evt);
            }
        });
        getContentPane().add(SemestreS, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 70, 40));

        ButtonRegistrarse.setBackground(new java.awt.Color(0, 102, 0));
        ButtonRegistrarse.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        ButtonRegistrarse.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRegistrarse.setText("Registrarse");
        ButtonRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 210, -1));

        ButtonEditar.setBackground(new java.awt.Color(0, 102, 0));
        ButtonEditar.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        ButtonEditar.setForeground(new java.awt.Color(255, 255, 255));
        ButtonEditar.setText("Editar");
        ButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditarActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 210, -1));

        ButtonMostrar.setBackground(new java.awt.Color(0, 102, 0));
        ButtonMostrar.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        ButtonMostrar.setForeground(new java.awt.Color(255, 255, 255));
        ButtonMostrar.setText("Mostrar");
        ButtonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMostrarActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 210, -1));

        jButton1.setBackground(new java.awt.Color(0, 102, 0));
        jButton1.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 102, 0));
        jButton2.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, -1));

        ButtonEliminar.setBackground(new java.awt.Color(121, 0, 0));
        ButtonEliminar.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        ButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        ButtonEliminar.setText("Eliminar");
        ButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 210, -1));

        jLabel_Wallpaper.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrouser/IMG/Tecnología Digital De Fondo Red Globe.jpg"))); // NOI18N
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRegistrarseActionPerformed
        // TODO add your handling code here:
        crear();
        
       
    }//GEN-LAST:event_ButtonRegistrarseActionPerformed

    private void ButtonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMostrarActionPerformed
        // TODO add your handling code here:
        mostrar();
    }//GEN-LAST:event_ButtonMostrarActionPerformed

    private void ButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditarActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_ButtonEditarActionPerformed

    private void ButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEliminarActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_ButtonEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //limpia los valores
        CI.setText("");
       Name.setText("");
       SemestreS.setValue(1);
       CarreraB.setSelectedItem("Ingenieria de sistemas");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CarreraBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarreraBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CarreraBActionPerformed

    private void SemestreSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SemestreSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SemestreSMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonEditar;
    private javax.swing.JButton ButtonEliminar;
    private javax.swing.JButton ButtonMostrar;
    private javax.swing.JButton ButtonRegistrarse;
    private javax.swing.JTextField CI;
    private javax.swing.JComboBox<String> CarreraB;
    public javax.swing.JTextField Name;
    private javax.swing.JSpinner SemestreS;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_Wallpaper;
    // End of variables declaration//GEN-END:variables
}
