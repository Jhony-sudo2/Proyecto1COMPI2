/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.server.ui;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class HighlightTextAtPosition {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Highlight Text Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTextPane textPane = new JTextPane();
            textPane.setEditable(true);

            String content = "This is an example of highlighting specific text in a JTextPane.";
            textPane.setText(content);

            highlightText(textPane, 10, 17, Color.RED); // Highlighting "example"

            JScrollPane scrollPane = new JScrollPane(textPane);
            frame.add(scrollPane);

            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    // Function to highlight text between start and end positions
    private static void highlightText(JTextPane textPane, int start, int end, Color color) {
        StyledDocument doc = textPane.getStyledDocument();
        Style style = textPane.addStyle("highlight", null);
        StyleConstants.setForeground(style, color);
        doc.setCharacterAttributes(start, end - start, style, false);
    }
}



