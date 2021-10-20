package za.ac.cput.Entity;

import java.awt.*;
import javax.swing.*;

public class PrescriptionGUI {

    private JFrame prescriptionFrame;
    private JPanel panelNorth, panelSouth;
    private JLabel lblCreatePrescription, lblMedicineName, lblDirections, lblDosage, lblReason;
    private TextField txtMedicineName, txtDirection, txtDosage, txtReason;
    private Button btnCreatePrescription;

    public PrescriptionGUI() {
        prescriptionFrame = new JFrame("Create Prescription");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        lblCreatePrescription = new JLabel("Create Prescription");
        lblMedicineName = new JLabel("Medicine Name:");
        lblDirections = new JLabel("Directions:");
        lblDosage = new JLabel("Dosage:");
        lblReason = new JLabel("Reason:");
        btnCreatePrescription = new Button("Create Prescription");
        txtMedicineName = new TextField();
        txtDirection = new TextField();
        txtDosage = new TextField();
        //txt
    }

}
