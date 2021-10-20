package za.ac.cput.PatientFrame;

import com.google.gson.Gson;
import okhttp3.*;
import za.ac.cput.Entity.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import static java.lang.Integer.parseInt;

public class EditPatientView extends JFrame implements ActionListener {


//Variables
    ArrayList<Patient> list = new ArrayList<>(GetAllPatients.getAll());

    private JComboBox select;
    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();
    private JTextField nameTxt;
    private JLabel namelbl;
    private JTextField genderTxt;
    private JLabel genderLbl;
    private JTextField ageTxt;
    private JLabel ageLbl;
    private JButton Submit;
    private JFrame frame;
    private JButton editPatient;
    private JButton Back;
    private JPanel button;

//List to populate the drown down list
    public ArrayList<String> editlistFormater(){

        ArrayList<String> deleted_List =new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            deleted_List.add("ID: "+list.get(i).getPatientID()+"\tName: "+list.get(i).getPatientName()+"\tAge:"+list.get(i).getPatientAge()+"\tGender: "+list.get(i).getGender());
        }
        return deleted_List;

    }
//constructor
    public EditPatientView() {
        super("Delete Patient");
        frame =new JFrame();
        select = new JComboBox(new Vector(editlistFormater()));
        editPatient = new JButton("Edit Patient");
        Back = new JButton("Back");
        namelbl = new JLabel("Type in the patient Name");
        nameTxt = new JTextField("Name goes here");
        genderLbl = new JLabel("Type in the patient Gender");
        genderTxt = new JTextField("Gender goes here");
        ageLbl = new JLabel("Type in the patient Age");
        ageTxt = new JTextField("Age Goes here");
        Submit = new JButton("Submit");
        button = new JPanel();

    }
//creates the main view
    public void setGUI() {

        button.setLayout(new GridLayout(1,2));
        frame.setLayout(new GridLayout(2, 1));
        button.add(editPatient);
        button.add(Back);
        frame.add(select);
        frame.add(button);

        editPatient.addActionListener(this);
        Back.addActionListener(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(500,150);
    }
//creates Edit GUi once selected
    public void setEditGui(String age,String Gender,String Name,String ID) {

        frame.setTitle(ID);
        nameTxt.setText(Name);
        genderTxt.setText(Gender);
        ageTxt.setText(age);
        frame.setLayout(new GridLayout(4,2));
        frame.add(namelbl);
        frame.add(nameTxt);
        frame.add(genderLbl);
        frame.add(genderTxt);
        frame.add(ageLbl);
        frame.add(ageTxt);
        frame.add(Submit);
        frame.add(Back);

        Submit.addActionListener(this);
        Back.addActionListener(this);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(500,300);
    }
//Action listenes
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editPatient) {
            int selected = select.getSelectedIndex();
            (new EditPatientView()).setEditGui(String.valueOf(list.get(selected).getPatientAge()),list.get(selected).getGender(),list.get(selected).getPatientName(),list.get(selected).getPatientID());
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

        }else if(e.getSource() == Back){
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            (new MainPatientView()).setGUI();
        }
        else if(e.getSource() == Submit){
            String id =frame.getTitle();
            int age =parseInt(ageTxt.getText());
            Patient pat = new Patient.Builder().setID(id).setfirstName(nameTxt.getText()).age(age).gender(genderTxt.getText()).building();
            edit(pat);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            (new MainPatientView()).setGUI();
        }


    }
    //sends the patient object that has ot be edited
    public void edit(Patient pat) {

        try {
            final String URL = "http://localhost:8080/patient/update";
            Gson g = new Gson();
            String jsonsStrinjg = g.toJson(pat);
            String p = post(URL, jsonsStrinjg);
            if (p != null)
                JOptionPane.showMessageDialog(null,"Updated");
            else
                JOptionPane.showMessageDialog(null,"Fail");


        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    public String post(final String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try(Response response= client.newCall(request).execute()){
            return response.body().string();
        }

    }
    public static void main(String[] args){new MainPatientView().setGUI();}

}

