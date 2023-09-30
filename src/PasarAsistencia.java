
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */

/**
 *
 * @author lzamo
 */
public class PasarAsistencia extends javax.swing.JFrame {

    private static asistenciaColegio asistenciaColegioAux;
    /**
     * Creates new form PasarAsistencia
     */
    public PasarAsistencia(asistenciaColegio asistenciaColegioAux) {
        this.asistenciaColegioAux = asistenciaColegioAux;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background3 = new javax.swing.JPanel();
        asistencia3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        volver = new javax.swing.JButton();
        textoNombreCurso = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        textoFecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pasarAsistencia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background3.setBackground(new java.awt.Color(255, 255, 255));
        background3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        asistencia3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        asistencia3.setText("Pasar asistencia");
        background3.add(asistencia3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 210, 40));

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        volver.setText("Volver");
        volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volverMouseClicked(evt);
            }
        });
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(volver)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(371, Short.MAX_VALUE)
                .addComponent(volver)
                .addGap(76, 76, 76))
        );

        background3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 470));
        background3.add(textoNombreCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 140, 30));

        jLabel1.setText("Nombre Curso");
        background3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 90, -1));

        textoFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoFechaActionPerformed(evt);
            }
        });
        background3.add(textoFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 140, 30));

        jLabel2.setText("Fecha (dd/mm)");
        background3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 100, -1));

        pasarAsistencia.setText("Pasar Asistencia");
        pasarAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pasarAsistenciaMouseClicked(evt);
            }
        });
        background3.add(pasarAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background3, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_volverActionPerformed

    private void volverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverMouseClicked
        Menu irMenu = null;
        try {
            irMenu = new Menu();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MostrarCursos.class.getName()).log(Level.SEVERE, null, ex);
        }
        irMenu.setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_volverMouseClicked

    private void textoFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoFechaActionPerformed

    private void pasarAsistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pasarAsistenciaMouseClicked
    // Paso 1: Obtener el nombre del curso y la fecha ingresados por el usuario
    String nombreCurso = textoNombreCurso.getText();
    String fecha = textoFecha.getText();

    // Paso 2: Buscar el curso correspondiente
    Cursos curso = null;
    for (Cursos c : asistenciaColegioAux.obtenerCopiaCursos()) {
        if (c.getNombre().equalsIgnoreCase(nombreCurso)) {
            curso = c;
            break;
        }
    }

    if (curso != null) {
            // Paso 3: Verificar si el curso tiene alumnos
            if (curso.obtenerCopiaAlumnos().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El curso no tiene alumnos registrados.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Paso 4: Mostrar ventana emergente para cada alumno
            HashMap<String, Alumnos> alumnos = curso.obtenerCopiaAlumnos();
            for (Alumnos alumno : alumnos.values()) {
                String[] opciones = { "Presente", "Ausente", "Justificado" };
                int seleccion = JOptionPane.showOptionDialog(this,
                        "¿Asistencia para " + alumno.getNombre() + " " + alumno.getApellido() + "?", "Pasar Asistencia",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

                // Paso 5: Registrar la asistencia
                Asistencia asistencia = new Asistencia(fecha);
                switch (seleccion) {
                    case 0: // Presente
                        asistencia.setEstaPresente(true);
                        break;
                    case 1: // Ausente
                        asistencia.setEstaPresente(false);
                        break;
                    case 2: // Justificado
                        asistencia.setEstaJustificado(true);
                        break;
                    default:
                        break;
                }

                alumno.agregarAsistencia(asistencia);
            }

            // Paso 6: Mostrar ventana emergente de éxito
            JOptionPane.showMessageDialog(this, "Asistencia registrada correctamente", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Mostrar un mensaje si no se encontró el curso
            JOptionPane.showMessageDialog(this, "Curso no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pasarAsistenciaMouseClicked

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
            java.util.logging.Logger.getLogger(PasarAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasarAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasarAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasarAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasarAsistencia(asistenciaColegioAux).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel asistencia3;
    private javax.swing.JPanel background3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton pasarAsistencia;
    private javax.swing.JTextField textoFecha;
    private javax.swing.JTextField textoNombreCurso;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables

}