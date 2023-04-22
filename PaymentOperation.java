import java.util.List;

public class PaymentOperation implements PaymentOperationsInterface {
    @Override

    public void updateInvoice(List<Invoice> invoices, int invoiceIndex, boolean status) {
        Invoice inv = invoices.get(invoiceIndex);
        inv.status = status;
        invoices.add(invoiceIndex, inv);
        System.out
                .println("---------Payment successful and the invoice payment status has been updated---------------");
    }
}
