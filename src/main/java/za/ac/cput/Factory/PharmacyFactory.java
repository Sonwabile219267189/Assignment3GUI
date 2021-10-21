package za.ac.cput.Factory;

import za.ac.cput.Entity.Pharmacy;
import za.ac.cput.Util.CreateID;

public class PharmacyFactory {
    public static Pharmacy build(int quantity, double price){
        //unique ID for medicine
        String medicineID = CreateID.createUUID();
        Pharmacy ph = new Pharmacy.Builder().setPrice(price).setQuantity(quantity).setMedicineID(medicineID).build();
        return ph;
    }
}
