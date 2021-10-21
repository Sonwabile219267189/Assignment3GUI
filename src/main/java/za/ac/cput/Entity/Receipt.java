package za.ac.cput.Entity;

public class Receipt {

    private String receiptID;
    private int quantity;
    private double price;

    private Receipt(Builder builder) {

        this.receiptID = builder.receiptID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getReceiptID() {
        return receiptID;
    }

    public static class Builder {

        private String receiptID;


        public Builder setReceiptID(String receiptID) {
            this.receiptID = receiptID;
            return this;
        }


        public Receipt build() {
            return new Receipt(this);
        }


        public Receipt.Builder copy(Receipt receipt) {
            this.receiptID = receipt.receiptID;
            return this;
        }
    }

    public double totalAmount() {
        double grandTotal = 0.0;
        double totalForProduct = price * quantity;

        grandTotal += totalForProduct;
        return grandTotal;
    }

    public String generateReceipt() {
        return "Receipt{" +
                "receiptID=" + receiptID +
                "totalAmountDue=" + totalAmount() +
                '}';
    }
}
