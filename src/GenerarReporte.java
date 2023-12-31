
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
public class GenerarReporte extends javax.swing.JFrame {
    private static asistenciaColegio asistenciaColegioAux;
    /**
     * Creates new form GenerarReporte
     */
    public GenerarReporte(asistenciaColegio asistenciaColegioAux) {
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

        background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        generarReporte = new javax.swing.JButton();
        textoFecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        volver.setText("Volver");
        volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(volver)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(372, Short.MAX_VALUE)
                .addComponent(volver)
                .addGap(95, 95, 95))
        );

        background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 490));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Generar reporte");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 150, 50));

        generarReporte.setText("Generar");
        generarReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generarReporteMouseClicked(evt);
            }
        });
        background.add(generarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 90, 30));

        textoFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoFechaActionPerformed(evt);
            }
        });
        background.add(textoFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 130, -1));

        jLabel2.setText("Fecha (dd/mm)");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    
    public void generarInforme(String fecha) throws IOException {
        String userDir = System.getProperty("user.dir");
        String carpetaReportes = userDir + "/Reportes"; // Carpeta para los informes

        // Verificar si la carpeta de informes existe, si no, crearla
        File carpeta = new File(carpetaReportes);
        if (!carpeta.exists()) {
        carpeta.mkdirs();
        }

        String nombreInforme = "Reporte " + fecha.replace("/", "-") + ".txt"; // Cambiar el nombre del informe para incluir la fecha
        String rutaInforme = carpetaReportes + "/" + nombreInforme; // Ruta completa del informe
        // Crear el archivo de informe en la carpeta de informes
        File archivoInforme = new File(rutaInforme);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoInforme))) {
            // Encabezado del informe
            writer.write("Nombre del Curso / Porcentaje presentes / Porcentaje ausentes");
            writer.newLine();

            // Generar informe para cada curso
            for (Cursos curso : asistenciaColegioAux.obtenerCopiaCursos()) {
                double porcentajeAsistencia = curso.calcularPorcentajeAsistencia(fecha);
                double porcentajeInasistencia = 100.0 - porcentajeAsistencia;

                // Escribir datos en el informe
                writer.write(curso.getNombre() + " / " + porcentajeAsistencia + "% / " + porcentajeInasistencia + "%");
                writer.newLine();
            }

            System.out.println("Informe generado y guardado en la carpeta 'Reportes'.");
        }
    }

    private void textoFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoFechaActionPerformed

    private void generarReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generarReporteMouseClicked
        String fecha = textoFecha.getText(); // Obtener la fecha ingresada por el usuario

        if (!fecha.isEmpty()) {
            try {
                generarInforme(fecha); // Generar el informe con la fecha ingresada
                JOptionPane.showMessageDialog(this, "Informe generado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                System.out.println("Error al generar el informe: " + e.getMessage());
            }
        } else {
            System.out.println("Por favor, ingrese una fecha válida.");
        }
    }//GEN-LAST:event_generarReporteMouseClicked

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
            java.util.logging.Logger.getLogger(GenerarReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerarReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerarReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerarReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerarReporte(asistenciaColegioAux).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton generarReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textoFecha;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables

}
