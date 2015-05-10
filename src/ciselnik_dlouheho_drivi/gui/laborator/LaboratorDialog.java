package ciselnik_dlouheho_drivi.gui.laborator;

import ciselnik_dlouheho_drivi.ciselnik.Ciselnik;
import ciselnik_dlouheho_drivi.gui.img.Resource;
import ciselnik_dlouheho_drivi.structures.DruhDreviny;
import ciselnik_dlouheho_drivi.structures.TypStromu;
import java.awt.Window;
import java.io.File;
import java.math.BigDecimal;
import unidataz.laf.UniLookAndFeel;
import unidataz.unipos.client.components.window.UniDialog;

/**
 *
 * @author Michal
 */
public class LaboratorDialog extends UniDialog {

    /**
     * Creates new form LaboratorDialog
     */
    public LaboratorDialog(Window parent, Ciselnik ciselnik) {
        super(parent);

        initComponents();
        
        setTitle("Laboratoř");
        setIconImage(Resource.getImg(Resource.ImgKey.laboratory));
        
        int oddenkovych  = ciselnik.getSouhrnna_OddenkovychKusu(TypStromu.JEHLICNAN);
        int ostatnich    = ciselnik.getSouhrnna_OstatnichKusu(TypStromu.JEHLICNAN);
        BigDecimal objem = ciselnik.getSouhrnna_Objem(TypStromu.JEHLICNAN);
        
        if(objem.compareTo(BigDecimal.ZERO)!=0){
            LaboratPanel laboratPanel = new LaboratPanel("Jehličnany", objem, oddenkovych, ostatnich);
            jPanel2.add(laboratPanel);            
        }
        
        oddenkovych = ciselnik.getSouhrnna_OddenkovychKusu(TypStromu.LISTNAC);
        ostatnich   = ciselnik.getSouhrnna_OstatnichKusu(TypStromu.LISTNAC);
        objem       = ciselnik.getSouhrnna_Objem(TypStromu.LISTNAC);        
        
        if(objem.compareTo(BigDecimal.ZERO)!=0){
            LaboratPanel laboratPanel = new LaboratPanel("Listnáče", objem, oddenkovych, ostatnich);
            jPanel2.add(laboratPanel);
        }
        for (DruhDreviny dd : ciselnik.getSouhrnna_DruhyDrevin()) {
            int odd  = ciselnik.getSouhrnna_OddenkovychKusu(dd);
            int ost  = ciselnik.getSouhrnna_OstatnichKusu(dd);
            BigDecimal obj = ciselnik.getSouhrnna_Objem(dd);
            LaboratPanel labPanel = new LaboratPanel(dd.toString(), obj, odd, ost);
            jPanel2.add(labPanel);            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        jScrollPane1.setMinimumSize(new java.awt.Dimension(300, 280));

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(jPanel2);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        UniLookAndFeel.setUniLaF();

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ciselnik c = Ciselnik.load(new File("c:\\Users\\Michal\\Documents\\NetBeansProjects\\UniPOS.NBp\\run\\ciselniky\\Číselník Dešov listopad.cdd"));
                LaboratorDialog dialog = new LaboratorDialog(null,c);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}