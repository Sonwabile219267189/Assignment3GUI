package za.ac.cput.GUI;

import javax.swing.*;
public class ReceiptGUI {
    ReceiptGUI() {
        JFrame f = new JFrame();
        JTextArea area = new JTextArea("Your Receipt: ");
        area.setBounds(10, 30, 200, 200);
        f.add(area);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new ReceiptGUI();
    }
}

