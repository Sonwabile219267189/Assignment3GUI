package za.ac.cput.GUI;

import za.ac.cput.Entity.Cashier;

import java.awt.event.ActionListener;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;


public class CashierGUI extends JFrame implements ActionListener{


    private JPanel panelNorth;
    private JPanel panelCenter;
    private JPanel panelSouth;

    private JButton btnClear;
    private JButton btnAddItem ;
    private JButton btnHome;
    private JButton btnInvoice;
    private JButton btnReport;
    private JButton btnVoid;


    private JLabel lblItem;
    private JLabel lblQTY;
    private JLabel lblUnitPrice;
    private JLabel lblDiscount;
    private JLabel lblSubtotal;
    private JLabel lblTotal;

    private JTextArea JArea ;
    private JTable table ;


    public CashierGUI(){
        super("Cashier");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();

        lblItem = new JLabel("Item");
        lblItem.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        lblItem.setHorizontalAlignment(JLabel.LEFT);

        lblQTY= new JLabel("Qty");
        lblUnitPrice = new JLabel("UnitPrice");
        lblDiscount = new JLabel("Discount");
        lblSubtotal = new JLabel("Subtotal");
        lblTotal = new JLabel("Total");

        JArea = new JTextArea();
        JScrollPane sp = new JScrollPane(JArea);


        JScrollPane scrollPane = new JScrollPane(table);

        btnClear = new JButton("CLEAR");
        btnHome = new JButton("HOME");
        btnAddItem= new JButton("ADD ITEM");
        btnInvoice = new JButton("INVOICE");
        btnReport = new JButton("REPORT");
        btnVoid = new JButton("VOID");
    }

    public void setGUI() {
        panelSouth.setLayout(new FlowLayout());
        panelCenter.setLayout(new GridLayout(15, 1));
        panelNorth.setLayout(new FlowLayout());

        panelSouth.add(btnClear);
        panelSouth.add(btnAddItem);
        panelSouth.add(btnHome);
        panelSouth.add(btnInvoice);
        panelSouth.add(btnReport);

         panelCenter.add(JArea);

        String[] columnNames = {"Item", "Qty", "Unit Price","Discount","Subtotal","Total"};
        Object[] data = {"Vicks","1","R20.00","0.00" ,"R20.00","R20.00"};

        panelNorth.add(lblItem);
        panelNorth.add(lblQTY);
        panelNorth.add(lblUnitPrice);
        panelNorth.add(lblDiscount);
        panelNorth.add(lblSubtotal);
        panelNorth.add(lblTotal);


        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnClear.addActionListener(this);
        btnHome.addActionListener(this);
        btnAddItem.addActionListener(this);
        btnReport.addActionListener(this);
        btnInvoice.addActionListener(this);
        btnVoid.addActionListener(this);

        this.setSize(600, 600);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()== btnClear){
            JArea.setText("");
        }
         if ((e.getActionCommand().equals("ADD ITEM"))){
        System.exit(0);
    }


}
}