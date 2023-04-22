import java.util.List;

public class Invoice {
    protected int invoiceNo;
    protected int orderNo;
    protected int staffId;
    protected long timeOfInvoice;
    protected double total;
    protected boolean status;
    InvoiceOperationInterface operation;

    public Invoice(int _invoiceNo, int _orderNo,int _staffId,long _time,double _total,boolean _status) {
        invoiceNo = _invoiceNo;
        orderNo = _orderNo;
        staffId=_staffId;
        timeOfInvoice=_time;
        total=_total;
        status=_status;
    }
      // Printing Invoice list
      public void printInvoiceList(InvoiceOperationInterface  _operation, List<Invoice> invoices) {
        this.operation = _operation;
        operation.printInvoiceList(invoices);
    }
       // Printing details of a particular order
       public void printInvoiceDetails(InvoiceOperationInterface  _operation,Invoice invoice, List<Order> orders) {
        this.operation = _operation;
        operation.printInvoiceDetails(invoice, orders);
    }
}
