import java.util.List;

public class Payment {
    public int id;
    public String paymentType;
    // public int paymentTypeId;
    public int invoiceNo;
    public int customerId;
    public boolean status;
    public double amountPaid;
    PaymentOperation operations;

    // int _paymentTypeId,
    public Payment(int _id, String _paymentType, int _invoiceNo, double _amountPaid, int _customerId, boolean _status) {
        id = _id;
        paymentType = _paymentType;
        // paymentTypeId = _paymentTypeId;
        invoiceNo = _invoiceNo;
        customerId = _customerId;
        status = _status;
        amountPaid = _amountPaid;
    }

    // updating the details or a paticular order
    public void updateInvoice(PaymentOperation _interface, List<Invoice> invoices, int invoiceIndex, boolean status) {
        this.operations = _interface;
        operations.updateInvoice(invoices, invoiceIndex, status);
    }
    public void printReceipt(Customer customer, Invoice invoice,Payment payment){
        System.out.println("********Customer payment receipt****************");
        System.out
                .println(
                          "Customer:          " + customer.name + 
                        "\nTelephone:         " + customer.phoneNo +
                        "\nAddress:           " + customer.address + 
                        "\nOrder number:      " + invoice.orderNo + 
                        "\nInvoice #:         " + invoiceNo+
                        "\nAmount paid:       "+ amountPaid + 
                        "\nPayment Reference: " + payment.id+ 
                        "\nPayment Via:       " + payment.paymentType
                        + "\n************Thank you and come again.************");
    }
}
