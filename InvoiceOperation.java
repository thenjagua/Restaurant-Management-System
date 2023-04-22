import java.util.List;

public class InvoiceOperation implements InvoiceOperationInterface {
    @Override

    public void printInvoiceList(List<Invoice> invoices) {
        System.out.println("*******************LIST INVOICES*************\n" +
                "# |\nInvoice ID |\tStaff ID |\tOrdered At |\t Amount |\n");

        for (int u = 0; u < invoices.size(); u++) {
            Invoice invoice = invoices.get(u);
            System.out.println((u + 1) + "\t" +
                    invoice.invoiceNo + "\t" + "\t" +
                    invoice.orderNo + "\t" + "\t" +
                    invoice.staffId + "" + "\t" + "\t" +
                    invoice.timeOfInvoice + "" + "\t" +
                    invoice.total + "" + "\t" + "\t");
        }

    }

    @Override

    public void printInvoiceDetails(Invoice invoice, List<Order> orders) {
        // get Order
        Order order = null;
        for (int a = 0; a < orders.size(); a++) {
            if (orders.get(a).orderNo == invoice.orderNo) {
                order = orders.get(a);
                break;
            }
        }
        if (order == null) {
            System.out.println("Invalid order");
        } else {
            System.out.println("-------------INVOICE SUMMARY----------\n" +
                    "Invoice ID: " + invoice.invoiceNo + "\t" +
                    "Order ID: " + order.orderNo + "\t" +
                    "Customer ID: " + order.customerId + "\t" +
                    "Staff Number: " + order.staffId + "\t" +
                    "Placed At: " + order.timeOfOder +
                    "Payment status: " + (invoice.status == true ? "PAID" : "NOT PAID") +
                    "\n-------------INVOICE DETAILS----------\n" +
                    "id |\tMenu ID |\tItem Name |\tPrice |\tQuantity |\tTotal\n");
            List<OrderItem> orderItemList = order.orderItems;
            double grandTotal = 0;
            for (int u = 0; u < orderItemList.size(); u++) {
                OrderItem orderItem = orderItemList.get(u);
                String[] item = orderItem.getOrderItemDetails();
                System.out.println(
                        (u + 1) + "\t" +
                                item[1] + "\t" +
                                item[2] + "\t" +
                                item[3] + "\t" +
                                item[4] + "\t" + "\t" +
                                item[5] + "\t");
                grandTotal += Double.parseDouble(item[5] + "");
            }
            System.out.println("-----------------------------------------------Grand  Total: \t" + grandTotal);// \t\t\t\t\t\t\t\t
        }
    }
}
