package gui;

import javax.swing.JFrame;

public class principal extends javax.swing.JFrame {

    public principal() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JDesktopPane();
        barraMenu = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        categoriaMenu = new javax.swing.JMenuItem();
        menuReceita = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setState(1);

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 786, Short.MAX_VALUE)
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );

        jMenu2.setText("Menu");

        categoriaMenu.setText("Categoria Registro");
        categoriaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaMenuActionPerformed(evt);
            }
        });
        jMenu2.add(categoriaMenu);

        menuReceita.setText("Registro");
        menuReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReceitaActionPerformed(evt);
            }
        });
        jMenu2.add(menuReceita);

        jMenuItem1.setText("Analista");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Cliente");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Transporte");
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Financeiro");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Sair");
        jMenu2.add(jMenuItem5);

        barraMenu.add(jMenu2);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoriaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaMenuActionPerformed
        GuiCategoria guiCategoria = new GuiCategoria();
        guiCategoria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiCategoria.setVisible(true);
        painelPrincipal.add(guiCategoria);
    }//GEN-LAST:event_categoriaMenuActionPerformed

    private void menuReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReceitaActionPerformed
        GuiRegistro guiRegistro = new GuiRegistro();
        guiRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiRegistro.setVisible(true);
        painelPrincipal.add(guiRegistro);
    }//GEN-LAST:event_menuReceitaActionPerformed

  
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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem categoriaMenu;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem menuReceita;
    private javax.swing.JDesktopPane painelPrincipal;
    // End of variables declaration//GEN-END:variables
}
