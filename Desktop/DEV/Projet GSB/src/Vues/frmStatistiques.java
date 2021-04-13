/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Entity.Region;
import Entity.Secteur;
import Entity.Visiteurs;
import Tools.FonctionsMetier;
import Model.ModelRegion;
import Model.ModelVisiteur;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

import javax.swing.UIManager;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author kayum
 */
public class frmStatistiques extends javax.swing.JFrame {

    FonctionsMetier fm;
    ModelRegion mdlRegion;
    ModelVisiteur mdlVisiteur;
    /**
     * Creates new form frmStatistiques
     */
    public frmStatistiques() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnStatVisiteur = new javax.swing.JButton();
        btnVisiteursNonResponsables = new javax.swing.JButton();
        cboLePlus = new javax.swing.JComboBox<>();
        cboLeMoins = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel1.setText("Nombre de secteurs par region");

        jLabel2.setText("La region où travaille le plus de visiteurs:");

        jLabel3.setText("La region où travaille le moins de visiteurs:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setText("Le pourcentage de visiteurs non responsables d'un secteur");

        btnStatVisiteur.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        btnStatVisiteur.setText(">> Nombre de secteurs par région");
        btnStatVisiteur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatVisiteurMouseClicked(evt);
            }
        });

        btnVisiteursNonResponsables.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        btnVisiteursNonResponsables.setText(">> Visiteurs non responsables");
        btnVisiteursNonResponsables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVisiteursNonResponsablesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnStatVisiteur))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(cboLePlus, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 34, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnVisiteursNonResponsables))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(cboLeMoins, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStatVisiteur)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(btnVisiteursNonResponsables)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboLePlus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboLeMoins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        FonctionsMetier fm = new FonctionsMetier();
        
        for (Region r : fm.getRegionAvecLePlusdeV())
        {
            cboLePlus.addItem(r.getNomRegion()); 
        }
        for (Region r : fm.getRegionAvecLeMoinsDeV())
        {
            cboLeMoins.addItem(r.getNomRegion());
        }
        //lblRegionPlus.setText(fm.getRegionAvecLePlusDeV());
        //lblRegionMoins.setText(fm.getRegionAvecLeMoinsDeV());
        
    }//GEN-LAST:event_formWindowOpened

    private void btnStatVisiteurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatVisiteurMouseClicked
        // TODO add your handling code here:
        // Camembert
        fm = new FonctionsMetier();
        ArrayList <Region> lesRegionsStats = new ArrayList<>();
        lesRegionsStats = fm.getAllRegionsParNbSecteur();
        
        DefaultPieDataset StatVisiteur = new DefaultPieDataset();
        for(Region statReg : lesRegionsStats)
        {
        StatVisiteur.setValue(statReg.getNomRegion(),statReg.getNbSecteurParRegion());
            //System.out.println(StatVisiteur);
        }
        JFreeChart chart1 = ChartFactory.createPieChart(
        "Nombre de secteurs par region",
        StatVisiteur,
        true, // légende
        true, // info bulle
        false // url
        );
        ChartFrame Cardinaliteframe = new ChartFrame("Statistiques", chart1);
        Cardinaliteframe.setSize(350, 350);
        Cardinaliteframe.setVisible(true);
        //Cardinaliteframe.pack();
        Cardinaliteframe.setVisible(true);
    }//GEN-LAST:event_btnStatVisiteurMouseClicked

    private void btnVisiteursNonResponsablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVisiteursNonResponsablesMouseClicked
        // TODO add your handling code here: 
        fm = new FonctionsMetier();
        
        DefaultPieDataset monGraph = new DefaultPieDataset();
         for (Visiteurs v : fm.getPourcentageVisiteurs())
        {
            monGraph.setValue(v.getSecteur().getNomSecteur(),v.getNbVisiteur());
        }
        JFreeChart chart1 = ChartFactory.createPieChart(
        "Nombre de visiteurs non responsables d'un secteur",
        monGraph,
        true, // légende
        true, // info bulle
        false // url
        );
        ChartFrame frame = new ChartFrame("First", chart1);
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_btnVisiteursNonResponsablesMouseClicked

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
            java.util.logging.Logger.getLogger(frmStatistiques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmStatistiques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmStatistiques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmStatistiques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmStatistiques().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStatVisiteur;
    private javax.swing.JButton btnVisiteursNonResponsables;
    private javax.swing.JComboBox<String> cboLeMoins;
    private javax.swing.JComboBox<String> cboLePlus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
