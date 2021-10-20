package za.ac.cput.PatientFrame;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.Entity.Patient;
import java.io.IOException;
import java.util.ArrayList;


public class GetAllPatients
{

    private static OkHttpClient server = new OkHttpClient();

    private static String run(String url) throws IOException{
        Request request = new Request.Builder()
                .url(url)
                .build();
        try(Response response = server.newCall(request).execute()) {
            return response.body().string();
        }
    }
    //gets a list of patient form the server
    public static ArrayList<Patient> getAll(){

        ArrayList patientList = new ArrayList();
        try{
            final String url = "http://localhost:8080/patient/getall";

            String responseBody = run(url);
            JSONArray patients = new JSONArray(responseBody);
            for(int i = 0 ;i<patients.length();i++){
                JSONObject patient = patients.getJSONObject(i);
                Gson g = new Gson();
                Patient p = g.fromJson(patient.toString(),Patient.class);
                patientList.add(p);
            }
        }
        catch(Exception e){
        }
        return patientList;
    }
}
