package za.ac.cput;

import za.ac.cput.GUI.CashierGUI;
import za.ac.cput.GUI.PrescriptionGUI;

import java.awt.*;

public class App {

    public static void main(String[] args){
        new PrescriptionGUI().setGUI();
        new CashierGUI().setGUI();
    }
}
