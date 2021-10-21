package za.ac.cput.SecretaryFrame;



import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.Entity.Secretary;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GetSecretary extends JFrame implements ActionListener {
    private static OkHttpClient client = new OkHttpClient();

    private JTable table;
    private JPanel pC, pS;
    private JButton btnBack;

    public GetSecretary() {
        super("All Secretary");
        table = new JTable();

        pC = new JPanel();
        pS = new JPanel();

        btnBack = new JButton("Back");
    }

    public void setGUI() {
        pC.setLayout(new GridLayout(1,1));
        pS.setLayout(new GridLayout(1,1));

        pC.add(table);
        pS.add(btnBack);

        this.add(pC, BorderLayout.CENTER);
        this.add(pS, BorderLayout.SOUTH);

        btnBack.addActionListener(this);

        getAll();
        table.setRowHeight(30);
        this.add(new JScrollPane(table));
        this.pack();
        this.setSize(1000, 450);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void getAll() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addColumn("Student ID");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Salary");


        try {
            final String URL = "http://localhost:8080/Secretary/getall";
            String responseBody = run(URL);
            JSONArray secretary = new JSONArray(responseBody);

            for (int i = 0; i < secretary.length(); i++) {
                JSONObject student = secretary.getJSONObject(i);

                Gson g = new Gson();
                Secretary s = g.fromJson(student.toString(), Secretary.class);

                Object[] rowData = new Object[4];
                rowData[0] = s.getId();
                rowData[1] = s.getName();
                rowData[2] = s.getLastName();
                rowData[3] = s.getSalary();

                model.addRow(rowData);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            SecretaryGui.main(null);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new GetSecretary().setGUI();
    }
}

