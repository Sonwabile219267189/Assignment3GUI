package za.ac.cput.GUI;

import za.ac.cput.Entity.Cashier;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;


public class CashierGUI extends JFrame implements ActionListener{


    private JPanel panelNorth;
    private JPanel panelCenter;
    private JPanel panelSouth;
    private JPanel panelEast;
    private JPanel panelWest;

    private JButton btnClear;
    private JButton btnAddItem ;
    private JButton btnLogOut;
    private JButton btnInvoice;
    private JButton btnReport;
    private JButton btnVoid;

    private JButton btnReceipt;


    private JLabel lblItem;
    private JLabel lblQTY;
    private JLabel lblUnitPrice;
    private JLabel lblDiscount;
    private JLabel lblSubtotal;
    private JLabel lblTotal;

    private JTextField txtItem ;
    private JTextField txtQTY;
    private JTextField txtUnitPrice;
    private JTextField txtDiscount;
    private JTextField txtSubtotal;
    private JTextField txtTotal;

    private JTextArea JArea;

    private String Item, Qty, UnitPrice,Discount,Subtotal,Total;

    public CashierGUI(){
        super("Cashier");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();

        lblItem = new JLabel("Item");
        txtItem = new JTextField();

        lblQTY= new JLabel("Qty");
        txtQTY= new JTextField();

        lblUnitPrice = new JLabel("UnitPrice");
        txtUnitPrice = new JTextField();

        lblDiscount = new JLabel("Discount");
        txtDiscount = new JTextField();

        lblSubtotal = new JLabel("Subtotal");
        txtSubtotal = new JTextField();

        lblTotal = new JLabel("Total");
        txtTotal = new JTextField();

        btnReceipt = new JButton("Receipt");

        JArea = new JTextArea("No Items Scanned");



        btnClear = new JButton("CLEAR");
        btnAddItem= new JButton("ADD ITEM");
        btnInvoice = new JButton("INVOICE");
        btnReport = new JButton("REPORT");
        btnVoid = new JButton("VOID");
        btnLogOut = new JButton("LOG OUT");
    }

    public void setGUI() {
        panelSouth.setLayout(new FlowLayout());
        panelCenter.setLayout(new GridLayout(7,1));
        panelEast.setLayout(new FlowLayout());
        panelWest.setLayout(new GridLayout(6,0));
        panelNorth.setLayout(new FlowLayout());


        panelWest.add(lblItem);
        panelWest.add(lblQTY);
        panelWest.add(lblUnitPrice);
        panelWest.add(lblDiscount);
        panelWest.add(lblSubtotal);
        panelWest.add(lblTotal);

        panelCenter.add(txtItem);
        panelCenter.add(txtQTY);
        panelCenter.add(txtUnitPrice);
        panelCenter.add(txtDiscount);
        panelCenter.add(txtSubtotal);
        panelCenter.add(txtTotal);
        panelCenter.add(btnReceipt);

        panelSouth.add(btnClear);
        panelSouth.add(btnAddItem);
        panelSouth.add(btnInvoice);
        panelSouth.add(btnReport);
        panelSouth.add(btnLogOut);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.add(panelEast, BorderLayout.EAST);
        this.add(panelWest, BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnClear.addActionListener(this);
        btnLogOut.addActionListener(this);
        btnAddItem.addActionListener(this);
        btnReport.addActionListener(this);
        btnInvoice.addActionListener(this);
        btnVoid.addActionListener(this);

        this.setSize(600, 600);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnReceipt){
            txtItem.getText();
            txtQTY.getText();
            txtUnitPrice.getText();
            txtDiscount.getText();
            txtSubtotal.getText();
            txtTotal.getText();
            JOptionPane.showMessageDialog(null,"Printing out Receipt");


        }
        else if(e.getSource()== btnClear){
            txtItem.setText("");
            txtQTY.setText("");
            txtUnitPrice.setText("");
            txtDiscount.setText("");
            txtSubtotal.setText("");
            txtTotal.setText("");
        }
        else if (e.getSource()==btnAddItem){
            txtItem.setText("Mist Alba");
            txtQTY.setText("2");
            txtUnitPrice.setText("R25.00");
            txtDiscount.setText("R0.00");
            txtSubtotal.setText("R50.00");
            txtTotal.setText("R50.00");
        }
        else if (e.getSource()==btnInvoice){
            JOptionPane.showMessageDialog(null,"Printing out Invoice");
        }
        else if (e.getSource()==btnReport){
            JOptionPane.showMessageDialog(null,"Added to the list of payments that needs to be reported to management");
        }
        else if (e.getSource() == btnVoid){
            JOptionPane.showMessageDialog(null,"Payment Void ");
        }
        else if(e.getSource()==btnLogOut){
            JOptionPane.showMessageDialog(null,"You are logged out");
            System.exit(0);
        }


    }
}

