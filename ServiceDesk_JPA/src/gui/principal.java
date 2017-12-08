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
        MenuAnalista = new javax.swing.JMenuItem();
        MenuCliente = new javax.swing.JMenuItem();
        MenuTransporte = new javax.swing.JMenuItem();
        MenuProposta = new javax.swing.JMenuItem();
        MenuSair = new javax.swing.JMenuItem();

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

        categoriaMenu.setText("Categoria");
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

        MenuAnalista.setText("Analista");
        MenuAnalista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAnalistaActionPerformed(evt);
            }
        });
        jMenu2.add(MenuAnalista);

        MenuCliente.setText("Cliente");
        MenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuClienteActionPerformed(evt);
            }
        });
        jMenu2.add(MenuCliente);

        MenuTransporte.setText("Transporte");
        MenuTransporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTransporteActionPerformed(evt);
            }
        });
        jMenu2.add(MenuTransporte);

        MenuProposta.setText("Proposta");
        MenuProposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPropostaActionPerformed(evt);
            }
        });
        jMenu2.add(MenuProposta);

        MenuSair.setText("Sair do Sistema");
        MenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSairActionPerformed(evt);
            }
        });
        jMenu2.add(MenuSair);

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

    private void MenuTransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTransporteActionPerformed
        GuiTransporte guiTransporte = new GuiTransporte();
        guiTransporte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiTransporte.setVisible(true);
        painelPrincipal.add(guiTransporte);
    }//GEN-LAST:event_MenuTransporteActionPerformed

    private void MenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSairActionPerformed
        dispose();
    }//GEN-LAST:event_MenuSairActionPerformed

    private void MenuAnalistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAnalistaActionPerformed
        GuiAnalista guiAnalista = new GuiAnalista();
        guiAnalista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiAnalista.setVisible(true);
        painelPrincipal.add(guiAnalista);
    }//GEN-LAST:event_MenuAnalistaActionPerformed

    private void MenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClienteActionPerformed
        GuiCliente guiCliente = new GuiCliente();
        guiCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiCliente.setVisible(true);
        painelPrincipal.add(guiCliente);
    }//GEN-LAST:event_MenuClienteActionPerformed

    private void MenuPropostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPropostaActionPerformed
        GuiProposta guiProposta = new GuiProposta();
        guiProposta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiProposta.setVisible(true);
        painelPrincipal.add(guiProposta);
    }//GEN-LAST:event_MenuPropostaActionPerformed

  
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
    private javax.swing.JMenuItem MenuAnalista;
    private javax.swing.JMenuItem MenuCliente;
    private javax.swing.JMenuItem MenuProposta;
    private javax.swing.JMenuItem MenuSair;
    private javax.swing.JMenuItem MenuTransporte;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem categoriaMenu;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem menuReceita;
    private javax.swing.JDesktopPane painelPrincipal;
    // End of variables declaration//GEN-END:variables
}
