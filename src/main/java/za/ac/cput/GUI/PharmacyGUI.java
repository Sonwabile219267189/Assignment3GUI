package za.ac.cput.GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class PharmacyGUI{

    public static void main(String[] args) {

        JFrame frame = new JFrame("Pharmacy");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);


        JLabel userLabel = new JLabel("Enter MedicineID");

        userLabel.setBounds(10,20,130,25);
        panel.add(userLabel);

        JTextField medicineIDText = new JTextField(20);
        medicineIDText.setBounds(120,20,165,25);
        panel.add(medicineIDText);

        JLabel quantityLabel = new JLabel("Enter Quantity");
        quantityLabel.setBounds(10,50,130,25);
        panel.add(quantityLabel);


        JTextField quantityText = new JTextField(20);
        quantityText.setBounds(120,50,165,25);
        panel.add(quantityText);


        JButton addItemButton = new JButton("Add Item");
        addItemButton.setBounds(10, 80, 120, 25);
        panel.add(addItemButton);

        JButton generateReceiptButton = new JButton("Generate Receipt");
        generateReceiptButton.setBounds(120, 80, 160, 25);
        panel.add(generateReceiptButton);
    }

}
