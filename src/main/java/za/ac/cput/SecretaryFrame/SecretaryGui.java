package za.ac.cput.SecretaryFrame;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecretaryGui extends JFrame implements ActionListener {
    private JButton btnView, btnAdd, btnUpdate, btnDelete, btnBack;
    private JLabel lblHeading;
    private JPanel pN, pC, pS;
    private Font hFt;

    public SecretaryGui() {
        super("Secretary Main Menu");

        pN = new JPanel();
        pC = new JPanel();
        pS = new JPanel();

        btnView = new JButton("View All Secretary");
        btnAdd = new JButton("Add New Secretary");
        btnUpdate = new JButton("Update Secretary");
        btnDelete = new JButton("Delete Secretary");
        btnBack = new JButton("Back");

        lblHeading = new JLabel("Secretary", SwingConstants.CENTER);

        hFt = new Font("Arial", Font.BOLD, 30);
    }

    public void setGUI() {
        pN.setLayout(new FlowLayout(FlowLayout.CENTER));
        pC.setLayout(new GridLayout(4, 1));
        pS.setLayout(new GridLayout(1, 1));

        this.setPreferredSize(new Dimension(600, 600));

        lblHeading.setFont(hFt);

        pN.add(lblHeading);

        pC.add(btnView);
        pC.add(btnAdd);
        pC.add(btnUpdate);
        pC.add(btnDelete);

        pS.add(btnBack);


        this.add(pN, BorderLayout.NORTH);
        this.add(pC, BorderLayout.CENTER);
        this.add(pS, BorderLayout.SOUTH);

        btnView.addActionListener(this);
        btnAdd .addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnBack.addActionListener(this);

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "View All Secretary":
                 GetSecretary.main(null);
                this.setVisible(false);
                break;
            case "Add New Secretary":
               
                break;
            case "Update Secretary":

                break;
            case "Delete Secretary":

                break;
            case "Back":

                break;
        }
    }

    public static void main(String[] args) {
        new SecretaryGui().setGUI();
    }
}
