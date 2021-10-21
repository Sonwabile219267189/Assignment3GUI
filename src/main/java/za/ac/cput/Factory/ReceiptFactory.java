package za.ac.cput.Factory;

import za.ac.cput.Entity.Receipt;
import za.ac.cput.Util.CreateID;

public class ReceiptFactory {
    public static Receipt build(String receiptID){
        //unique ID for receipt
        receiptID = CreateID.createUUID();

        Receipt rcp = new Receipt.Builder().setReceiptID(receiptID).build();
        return rcp;
    }
}
