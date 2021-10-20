package za.ac.cput.PatientFrame;


import okhttp3.*;
import za.ac.cput.Entity.Patient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class MainPatientView extends JFrame implements ActionListener {

//Entrance ot th Main patient menu
    //declares variables
    ArrayList<Patient> list = new ArrayList<>(GetAllPatients.getAll());
    private static OkHttpClient client = new OkHttpClient();
    private JButton edit;
    private JFrame frame;
    private JButton new_patient;
    private JButton DeletePatient;
    private JTable clientTable;
    String col[] ={"ID","Name","Age","Gender"};
    DefaultTableModel tabMod =new DefaultTableModel(col,0);
    private JPanel top;
    private JPanel bottom;
    private JButton del;


//constructor
    public MainPatientView() {
        super("Create Patient");
        edit = new JButton("Edit");
        frame =new JFrame();
        top = new JPanel();
        bottom = new JPanel();
        new_patient = new JButton("Submit Patient");
        DeletePatient = new JButton("Delete Patient");
        del = new JButton("Del");
        clientTable=new JTable(tabMod);

    }
//Generates the main GUI
    public void setGUI() {
        JTableHeader header=clientTable.getTableHeader();
        header.setBackground(Color.CYAN);
        JScrollPane pane = new JScrollPane(clientTable);
        bottom.add(pane);


        for (int i = 0; i < list.size(); i++){
            Object[] obj ={list.get(i).getPatientID(),list.get(i).getPatientName(),list.get(i).getPatientAge(),list.get(i).getGender(),this.del};
            tabMod.addRow(obj);
        }

        top.setSize(500,600);
        top.setLayout(new GridLayout(1,3));
        bottom.setLayout(new GridLayout(1,1));
        frame.setLayout(new GridLayout(2, 1));
        frame.add(top);
        frame.add(bottom);
        top.add(edit);
        top.add(new_patient);
        top.add(DeletePatient);

        DeletePatient.addActionListener(this);
        new_patient.addActionListener(this);
        edit.addActionListener(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(500,450);
    }
//Action Listeners
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == new_patient) {
            (new NewPatientView()).setGUI();
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        } else if (e.getSource() == DeletePatient) {
            (new DeletePatientView()).setGUI();
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

        } else if (e.getSource() == edit) {
            (new EditPatientView()).setGUI();
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));


        }
    }


}
