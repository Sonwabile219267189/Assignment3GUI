package za.ac.cput.Entity;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class PrescriptionGUI implements ActionListener {

    private JFrame prescriptionFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelCenter;
    private JLabel lblCreatePrescription, lblMedicineName, lblDirections, lblDosage, lblReason;
    private TextField txtMedicineName, txtDirection, txtDosage, txtReason;
    private Button btnCreatePrescription;

    public PrescriptionGUI() {
        prescriptionFrame = new JFrame("Create Prescription");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelEast = new JPanel();
        panelCenter = new JPanel();
        lblCreatePrescription = new JLabel("Create Prescription");
        lblMedicineName = new JLabel("Medicine Name:");
        lblDirections = new JLabel("Directions:");
        lblDosage = new JLabel("Dosage:");
        lblReason = new JLabel("Reason:");
        btnCreatePrescription = new Button("Create Prescription");
        txtMedicineName = new TextField();
        txtDirection = new TextField();
        txtDosage = new TextField();
        txtReason = new TextField();
    }

    public void setGUI(){

        prescriptionFrame.add(panelNorth, BorderLayout.NORTH);
        prescriptionFrame.add(panelSouth, BorderLayout.SOUTH);
        prescriptionFrame.add(panelEast, BorderLayout.WEST);
        prescriptionFrame.add(panelCenter, BorderLayout.CENTER);

        //panel
        panelNorth.setLayout(new GridLayout(1, 1));
        panelNorth.setPreferredSize(new Dimension(800,50));
        panelEast.setLayout(new GridLayout(4, 1));
        panelCenter.setLayout(new GridLayout(4, 1));
        panelSouth.setLayout(new GridLayout(1, 2));
        panelNorth.add(lblCreatePrescription);
        panelEast.add(lblMedicineName);
        panelEast.add(lblDirections);
        panelEast.add(lblDosage);
        panelEast.add(lblReason);
        panelCenter.add(txtMedicineName);
        panelCenter.add(txtDirection);
        panelCenter.add(txtDosage);
        panelCenter.add(txtReason);
        panelSouth.add(btnCreatePrescription);
        btnCreatePrescription.addActionListener(this);

        //prescription frame
        prescriptionFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);}

        });
        prescriptionFrame.setSize(800, 600);
        prescriptionFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnCreatePrescription){}

    }
}
