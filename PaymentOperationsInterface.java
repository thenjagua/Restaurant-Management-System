import java.util.List;

public interface PaymentOperationsInterface {
    //update payment status
    public void updateInvoice(List<Invoice> invoices,int invoiceIndex, boolean status);

}
