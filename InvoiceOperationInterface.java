import java.util.List;

public interface InvoiceOperationInterface {
    // print invoice list
    public void printInvoiceList(List<Invoice> invoices);

    // print Invoice details
    public void printInvoiceDetails(Invoice invoice,List<Order> orders);

}