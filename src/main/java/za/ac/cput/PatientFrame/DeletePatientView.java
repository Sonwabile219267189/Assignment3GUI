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

public class DeletePatientView extends JFrame implements ActionListener {


//gets the array list of items from the server
    ArrayList<Patient> list = new ArrayList<>(GetAllPatients.getAll());

//Declares all the variables

    private JComboBox deleteItems;
    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();
    private JFrame frame;
    private JLabel lbID;
    private JButton DeletePatient;
    private JButton Back;
    private JPanel button;

//Creates readable string to populate the dropdwon box
    public ArrayList<String> deletelistFormater(){

        ArrayList<String> deleted_List =new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            deleted_List.add("ID: "+list.get(i).getPatientID()+"\tName: "+list.get(i).getPatientName()+"\tAge:"+list.get(i).getPatientAge()+"\tGender: "+list.get(i).getGender());
        }
        return deleted_List;

    }
//Constructor
    public DeletePatientView() {
        super("Delete Patient");
        frame =new JFrame();
        deleteItems = new JComboBox(new Vector(deletelistFormater()));
        lbID = new JLabel("PatientID");
        DeletePatient = new JButton("Delete Patient");
        Back = new JButton("Back");
        button = new JPanel();

    }
//generates the main GUI
    public void setGUI() {

        button.setLayout(new GridLayout(1,2));
        frame.setLayout(new GridLayout(2, 1));
        button.add(DeletePatient);
        button.add(Back);
        frame.add(deleteItems);
        frame.add(button);

        DeletePatient.addActionListener(this);
        Back.addActionListener(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(500,150);
    }
//Action listenrs
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == DeletePatient) {
            int selected = deleteItems.getSelectedIndex();
            String delete = list.get(selected).getPatientID();
            delete(delete);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            (new MainPatientView()).setGUI();

        }else if(e.getSource() == Back){
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            (new MainPatientView()).setGUI();
        }


    }

//sends the id of the id to delete to the server
    public void delete(String deleted) {
        try {
            final String URL = "http://localhost:8080/patient/delete/"+deleted;

            Gson g = new Gson();
            String jsonsStrinjg = g.toJson(deleted);
            String p = post(URL, jsonsStrinjg);
            if (p != null)
                JOptionPane.showMessageDialog(null,"Deleted");
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

