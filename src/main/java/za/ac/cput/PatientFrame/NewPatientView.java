//package za.ac.cput.PatientFrame;
//
//import com.google.gson.Gson;
//import okhttp3.*;
//import za.ac.cput.Entity.Patient;
//import za.ac.cput.Factory.PatientFactory;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowEvent;
//import java.io.IOException;
//
//import static java.lang.Integer.parseInt;
//
////creates the new patient GUI
//public class NewPatientView extends JFrame implements ActionListener {
//
////Declares variables
//    private JComboBox deleteItems;
//    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");
//
//    private static OkHttpClient client = new OkHttpClient();
//    private JFrame frame;
//    private JTextField nameTxt;
//    private JLabel namelbl;
//    private JTextField genderTxt;
//    private JLabel genderLbl;
//    private JTextField ageTxt;
//    private JLabel ageLbl;
//    private JButton Submit;
//    private JButton Back;
//
////Constructor
//    public NewPatientView() {
//        super("Create Patient");
//        frame =new JFrame();
//        namelbl = new JLabel("Type in the patient Name");
//        nameTxt = new JTextField("Name goes here");
//        genderLbl = new JLabel("Type in the patient Gender");
//        genderTxt = new JTextField("Gender goes here");
//        ageLbl = new JLabel("Type in the patient Age");
//        ageTxt = new JTextField("Age Goes here");
//        Submit = new JButton("Submeit");
//        Back = new JButton("Cancel");
//
//    }
////Sets up the create patient GUI
//    public void setGUI() {
//
//
//        frame.setLayout(new GridLayout(4,2));
//        frame.add(namelbl);
//        frame.add(nameTxt);
//        frame.add(genderLbl);
//        frame.add(genderTxt);
//        frame.add(ageLbl);
//        frame.add(ageTxt);
//        frame.add(Submit);
//        frame.add(Back);
//
//        Submit.addActionListener(this);
//        Back.addActionListener(this);
//
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//        frame.setSize(500,300);
//    }
////Action listeners
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == Submit) {
//            int age =parseInt(ageTxt.getText());
//            save(nameTxt.getText(),genderTxt.getText(),age);
//
//        } else if (e.getSource() == Back) {
//            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
//            (new MainPatientView()).setGUI();
//        }
//
//
//    }
//
//
////Saves teh informasion to the server
//    public void save(String Name ,String gender ,int age) {
//        try {
//            final String URL = "http://localhost:8080/patient/create";
//            Patient pat = PatientFactory.build(Name, age, gender);
//            Gson g = new Gson();
//            String jsonsStrinjg = g.toJson(pat);
//            String p = post(URL, jsonsStrinjg);
//            if (p != null)
//                JOptionPane.showMessageDialog(null,"Sucsess");
//            else
//                JOptionPane.showMessageDialog(null,"Fail");
//
//
//        }catch (Exception e){
//            JOptionPane.showMessageDialog(null,e.getMessage());
//        }
//    }
//
//    public String post(final String url, String json) throws IOException {
//        RequestBody body = RequestBody.create(JSON, json);
//        Request request = new Request.Builder()
//                .url(url)
//                .post(body)
//                .build();
//        try(Response response= client.newCall(request).execute()){
//            return response.body().string();
//
//        }
//
//    }
//    public static void main(String[] args){new MainPatientView().setGUI();}
//
//
//}
