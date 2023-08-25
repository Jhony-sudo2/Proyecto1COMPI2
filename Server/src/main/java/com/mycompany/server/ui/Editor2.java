/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.server.ui;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author jhony
 */
public class Editor2 extends javax.swing.JPanel {

    /**
     * Creates new form Editor2
     */
    
    private javax.swing.JTextArea Lineas;
    public Editor2() {
        initComponents();
        Lineas = new javax.swing.JTextArea("1");
        Lineas.setFont(new Font("Monospaced", Font.PLAIN, 14));
        Lineas.setBackground(Color.GRAY);
        Lineas.setEditable(false);
        //Lineas.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.DARK_GRAY));
        Input.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> {
                    if(Input.getText().length() > 5)setColor();
                });
                actualizarNumerosDeLinea();
            }

            public void removeUpdate(DocumentEvent e) {
                actualizarNumerosDeLinea();
            }

            public void changedUpdate(DocumentEvent e) {
                actualizarNumerosDeLinea();
            }
        });
        Scroll.setRowHeaderView(Lineas);
        //Location();
        
    }
    
    
    private void actualizarNumerosDeLinea() {
        String texto = Input.getText();
        int lineas = texto.isEmpty() ? 1 : texto.split("\n", -1).length;
        StringBuilder numerosDeLinea = new StringBuilder();
        for (int i = 1; i <= lineas; i++) {
            numerosDeLinea.append(i).append("\n");
        }
        Lineas.setText(numerosDeLinea.toString());
    }
    
    /*public void Location(){
        Input.addCaretListener( new CaretListener() {
            public void caretUpdate( CaretEvent e ) {
                int pos = e.getDot();
                   try {
                     
                      int row = Input.getLineOfOffset( pos ) + 1;
                      int col = pos - Input.getLineStartOffset( row - 1 ) + 1;
                      Position.setText("Línea: " + row + " Columna: " + col );
                  }
                   catch(BadLocationException exc){
                      System.out.println(exc);
                  }
           }
       });
    }*/
    
    public void setColor(){
        DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
        Highlighter h = Input.getHighlighter();
        h.removeAllHighlights();
        StyledDocument doc = Input.getStyledDocument();
        Style style = Input.addStyle("highlight", null);
        StyleConstants.setForeground(style, Color.RED);
        doc.setCharacterAttributes(0, 3, style, false);
        /*
        try {
            h.addHighlight(0,3, highlightPainter);
        } catch (BadLocationException ex) {
            Logger.getLogger(Color.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        Salida = new javax.swing.JTextArea();
        Compile = new javax.swing.JButton();
        Position = new javax.swing.JLabel();
        Scroll = new javax.swing.JScrollPane();
        Input = new javax.swing.JTextPane();

        Salida.setEditable(false);
        Salida.setColumns(20);
        Salida.setRows(5);
        jScrollPane2.setViewportView(Salida);

        Compile.setText("Ejecutar");
        Compile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompileActionPerformed(evt);
            }
        });

        Input.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Scroll.setViewportView(Input);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(Compile, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(290, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Scroll)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Position, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Position, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Compile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CompileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompileActionPerformed
        
    }//GEN-LAST:event_CompileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Compile;
    private javax.swing.JTextPane Input;
    private javax.swing.JLabel Position;
    private javax.swing.JTextArea Salida;
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
