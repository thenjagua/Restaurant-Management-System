import java.beans.Customizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class RMSMain {

    public static void main(String[] args) {
        System.out.println("Welcome to Restaurant Management System(RMS)");
        int choice = 0;
        int staffId = 0, customerId = 0, OrderNo = 1120, invoiceNo = 1400, paymentId = 5402;
        Staff rmsStaff = null;
        Customer customer = null;
        Order customerOrder = null;
        Invoice customerInvoice = null;
        List<Order> RMSOrders = new ArrayList<>();
        List<Invoice> RMSInvoices = new ArrayList<>();
        // 2 Dimensional Array with menu items
        String menu[][] = new Menu().getMenu();
        Scanner scannerInput = new Scanner(System.in);
        do {
            /*
             * 
             * "1. Create Staff\n" +
             * "2. Print Staff\n" +
             * "3. Add Customer\n" +
             * "4. Update Customer\n" +
             * "5. Print Customer\n" +
             * "6. Place Order\n" +
             * "7. Update Order\n" +
             * "8. Delete Order\n" +
             * "9. Print order\n" +
             * "10. Generate Invoice\n" +
             * "11. Make payment\n" +
             * "12. List Orders\n" +
             * "13. List Invoices\n" +
             * "14. List Payments\n" +
             * "0. Exit the system
             */
            System.out.println("Please select the appropriate action below\n" +
                    "1. Create Staff\n" +
                    "2. Print Staff\n" +
                    "3. Add Customer\n" +
                    "4. Update Customer\n" +
                    "5. Print Customer\n" +
                    "6. Place Order\n" +
                    "7. Update Order\n" +
                    "8. Delete Order\n" +
                    "9. Print order\n" +
                    "10. Generate Invoice\n" +
                    "11. Make payment\n" +
                    // "12. List Orders\n" +
                    // "12. List Invoices\n" +
                    // "13. List Payments\n" +
                    "0. Exit the system\n");
            System.out.print("Please enter your choice: ");
            choice = scannerInput.nextInt();
            if (choice == 1) {
                /******* Create Staff******** */
                staffId++;
                String staffName = "";
                String staffAddress = "";
                int staffPhoneNo = 0;
                System.out.println("*******CREATE STAFF********* ");
                // Get the required information to create the Staff ie. like KYC
                staffName = getScreenInput("Enter the staff Name");
                staffAddress = getScreenInput("Enter the staff Address");
                staffPhoneNo = Integer.parseInt(getScreenInput("Enter the staff Telephone"));
                // Create a staff who will serve the customers by instantiating the staff class
                rmsStaff = new Staff(staffId, staffName, staffAddress, staffPhoneNo);
                System.out.println("--Staff was created successfully--");
            } else if (choice == 2) {
                /******* Print Staff******** */
                // Using interface to print
                if (rmsStaff == null) {
                    System.out.println("Sorry, we dont have any staff at the moment");
                } else {
                    rmsStaff.printUserInfo(new StaffOperation(), rmsStaff);
                }

            } else if (choice == 3) {
                /******* Create Customer******** */
                customerId++;
                // create a customers account by instantiating the customer class
                String custName = "";
                String custAddress = "";
                int custPhoneNo = 0;
                System.out.println("*******CREATE CUSTOMER********* ");
                custName = getScreenInput("Enter the Customer Name");
                custAddress = getScreenInput("Enter the Customer Address");
                custPhoneNo = Integer.parseInt(getScreenInput("Enter the Customer Telephone"));
                customer = new Customer(customerId, custName, custAddress, custPhoneNo);
                System.out.println("----------------Customer created successfully------------------ ");
            } else if (choice == 4) {
                /******* Update Customer******** */
                if (customer == null) {
                    System.out.println("Sorry, we dont have any customers at the moment");
                } else {
                    // String custName = "";
                    String custAddress = "";
                    int custPhoneNo = 0;
                    System.out.println("*******UPDATE CUSTOMER********* ");
                    // System.out.print("Enter the Customer Name: ");
                    // custName = scannerInput.next();
                    custAddress = getScreenInput("Enter the Customer Address");
                    custPhoneNo = Integer.parseInt(getScreenInput("Enter the Customer Telephone"));
                    // Using interface to update the customer details
                    customer.updateInfo(new CustomerOperation(), customer, custPhoneNo, custAddress);
                }
            } else if (choice == 5) {
                /******* Print Customer******** */
                if (customer == null) {
                    System.out.println(
                            "Sorry, we dont have any customers at the moment, please create a customer before updating the customer details");
                } else {
                    // Use of interface
                    // printing the current updated customer details
                    customer.printUserInfo(new CustomerOperation(), customer);
                }
            } else if (choice == 6) {
                /******* Create Order******** */
                if (rmsStaff == null) {
                    System.out.println(
                            "Sorry, we dont have any staff at the moment. Please create a staff before placing an order");
                }
                if (customer == null) {
                    System.out.println(
                            "Sorry, we dont have any customers at the moment. Please create a customer before placing an order");
                } else {

                    System.out.println("Please select the food to eat from the menu below");
                    List<OrderItem> orderitems = new ArrayList<>();

                    for (int a = 0; a < menu.length; a++) {
                        System.out.println((a + 1) + ". " + menu[a][0] + " @ Ksh. " + menu[a][1]);
                    }

                    System.out.println("0. exit selecting order items\n" +
                            "Select the Order food item(s) from the menu above (Note: Enter zero to finish selecting order items): \n");
                    // control for selecting menu items
                    int continueSelectingmenu = 0;
                    int orderitemsId = 0;
                    do {
                        // get the selected order item from the menu
                        continueSelectingmenu = Integer.parseInt(getScreenInput("Enter menu item id"));

                        if (continueSelectingmenu == 0)
                            continue;

                        if (continueSelectingmenu > menu.length) {
                            System.out.println("invalid menu option");
                            continue;
                        }

                        // get the quantity of the menu item selected
                        int quantity = Integer.parseInt(getScreenInput("Enter quantity ordered"));
                        // increment the order items id
                        orderitemsId++;
                        orderitems.add(new OrderItem(orderitemsId, continueSelectingmenu, quantity));
                    } while (continueSelectingmenu != 0);
                    // check if order has any ordered items
                    if (orderitems.size() < 1) {
                        System.out.println("Sorry, you cannot create order with empty order items");
                    }
                    // Update the new order number
                    OrderNo++;
                    // create a customer order instance
                    customerOrder = new Order(OrderNo, customer.id, rmsStaff.id, new Date().getTime(), orderitems);
                    RMSOrders.add(customerOrder);
                    System.out.println("You have successfully placed the order No: " + OrderNo);
                }
            } else if (choice == 7) {
                /******* Update Order******** */
                if (RMSOrders.size() < 1) {
                    System.out.println("No orders at the moment.");
                    continue;
                }
                // UPDATE ORDER
                System.out.println("Select the Order to update from the list below. Enter zero to exit");
                customerOrder.listAllOrders(new OrderOperation(), RMSOrders);
                // get the order ID to update
                int orderIndex = Integer.parseInt(getScreenInput("Enter the # to update"));
                if (orderIndex == 0)
                    continue;
                if (orderIndex > RMSOrders.size()) {
                    System.out.println("Invalid choice");
                    continue;
                }

                Order order = RMSOrders.get(orderIndex - 1);
                // Display the order Items
                customerOrder.printOrderDetails(new OrderOperation(), order);
                int orderItemIndex = Integer
                        .parseInt(getScreenInput("Select the Order item to update(Enter zero to exit editing)"));
                if (orderItemIndex == 0)
                    continue;
                if (orderItemIndex > order.orderItems.size()) {
                    System.out.println("Invalid choice");
                    continue;
                }
                OrderItem _orderItem = order.orderItems.get(orderItemIndex);
                // get the units ordered
                int unitsOrdered = Integer
                        .parseInt(getScreenInput("Enter the units ordered(Enter zero to remove the order item)"));
                if (orderItemIndex < 0) {
                    System.out.println("Invalid quantity");
                    continue;
                }
                // update the order item
                customerOrder.updateOrder(new OrderOperation(), order, _orderItem, unitsOrdered);

            } else if (choice == 8) {
                /******* Delete Order******** */
                if (RMSOrders.size() < 1) {
                    System.out.println("No orders at the moment.");
                    continue;
                }
                // UPDATE ORDER
                System.out.println("Select the Order to update from the list below. Enter zero to exit");
                customerOrder.listAllOrders(new OrderOperation(), RMSOrders);
                // get the order ID to update
                int orderIndex = Integer.parseInt(getScreenInput("Enter the # to delete"));
                if (orderIndex == 0)
                    continue;
                if (orderIndex > RMSOrders.size()) {
                    System.out.println("Invalid choice");
                    continue;
                }

                Order order = RMSOrders.get(orderIndex - 1);
                // delete the order
                customerOrder.deleteOrder(new OrderOperation(), RMSOrders, order);
            } else if (choice == 9) {
                /******* Print Order details******** */
                if (RMSOrders.size() < 1) {
                    System.out.println("No orders at the moment.");
                    continue;
                }
                // UPDATE ORDER
                System.out.println("Select the Order to update from the list below. Enter zero to exit");
                customerOrder.listAllOrders(new OrderOperation(), RMSOrders);
                // get the order ID to update
                int orderIndex = Integer.parseInt(getScreenInput("Enter the # to view details"));
                if (orderIndex == 0)
                    continue;
                if (orderIndex > RMSOrders.size()) {
                    System.out.println("Invalid choice");
                    continue;
                }

                Order order = RMSOrders.get(orderIndex - 1);
                // Display the order Items
                customerOrder.printOrderDetails(new OrderOperation(), order);
            } else if (choice == 10) {
                /******* Generate Invoice******** */
                if (RMSOrders.size() < 1) {
                    System.out.println("No orders at the moment.");
                    continue;
                }
                // UPDATE ORDER
                System.out.println("Select the Order to generate invoice from the list below. Enter zero to exit");
                customerOrder.listAllOrders(new OrderOperation(), RMSOrders);
                // get the order ID to update
                int orderIndex = Integer.parseInt(getScreenInput("Enter the # to generate the invoice"));
                if (orderIndex == 0)
                    continue;
                if (orderIndex > RMSOrders.size()) {
                    System.out.println("Invalid choice");
                    continue;
                }

                Order order = RMSOrders.get(orderIndex - 1);
                    invoiceNo++;
                    System.out.println("Generating an invoice for order no:" + OrderNo + "\n");

                    // System.out.print("********Customer Invoice****************");
                    // System.out.print("Customer : " + customer.name + "\nTelephone: " +
                    // customer.phoneNo + "\nAddress: "
                    // + customer.address + "\n" + "Order number: " + OrderNo + "\nOrder Item(s): "
                    // + menu[customerOrder.menuId - 1] + "\nGrand Total: " + customerOrder.getOrderTotals(customerOrder)
                    // + "\nThank you and come again.");
                    // (int _invoiceNo, int _orderNo,int _staffId,long _time,double _total
                    customerInvoice = new Invoice(invoiceNo, order.orderNo,rmsStaff.id,new Date().getTime(),order.getOrderTotals(order),false);
                    RMSInvoices.add(customerInvoice);
                    customerInvoice.printInvoiceDetails(new InvoiceOperation(), customerInvoice, RMSOrders);
                    System.out.println("You have successfully generated an invoice number: "+invoiceNo);
                // }
            } else if (choice == 11) {
                /******* Generate Invoice******** */
                if (RMSInvoices.size() < 1) {
                    System.out.println("No invoices at the moment.");
                    continue;
                }
                // UPDATE INVOICE
                System.out.println("Select the invoice to make payment from the list below. Enter zero to exit");
                customerInvoice.printInvoiceList(new InvoiceOperation(), RMSInvoices);
                // get the order ID to update
                int invoiceIndex = Integer.parseInt(getScreenInput("Enter the # of the invoice to make payment"));
                if (invoiceIndex == 0)
                    continue;
                if (invoiceIndex > RMSInvoices.size()) {
                    System.out.println("Invalid choice");
                    continue;
                }

                Invoice invoice = RMSInvoices.get(invoiceIndex - 1);
                    paymentId++;
                    System.out.println("Making payment for Invoice #:" + invoice.invoiceNo + "\n");
                    String[] paymentModes = { "Card\n", "Cash\n", "M-Pesa\n" };
                    System.out.println("Select the preferred mode of payment");
                    for (int a = 0; a < paymentModes.length; a++)
                        System.out.print((a+1)+". "+paymentModes[a]);
                    int paymentModeId = Integer.parseInt(getScreenInput("Select Mode"));
                    double amountPaid = Double.parseDouble(getScreenInput("Amount to pay"));
                    Payment myInvoicePayment = new Payment(paymentId, paymentModes[paymentModeId],
                            customerInvoice.invoiceNo, amountPaid, customer.id, true);
                            myInvoicePayment.updateInvoice(new PaymentOperation(), RMSInvoices, invoiceIndex-1, true);
                            myInvoicePayment.printReceipt(customer, invoice, myInvoicePayment);
                    // System.out.println("Payment processed successfully. ");
                  

                // }
            } else {
                if (choice != 0)
                    System.out.println("Invalid choice");

            }
            // customer.printUserInfo(new CustomerOperations(), customer);
            // create a customer order
            // Order customerOrder = new Order(70, customer.id, 2080, rmsStaff.id, new
            // Date().getTime());
            // // create an invoice from the above order. by instantiating class Invoice
            // Invoice customerInvoice = new Invoice(604, customerOrder.orderNo);
            // // Make payment by Instantiating Payment class
            // // (int _id, String _paymentType, int _invoiceNo, int _customerId, boolean
            // // _status)
            // Payment myInvoicePayment = new Payment(125, "cash",
            // customerInvoice.invoiceNo, customer.id, true);
        } while (choice != 0);
        System.out.println("Thank you for using the RMS system.");
        scannerInput.close();
    }

    // Function to assist in getting the user input without skipping the white
    // spaces in words such as Fullname ie Ezekiel Ronoh
    private static String getScreenInput(String prompt) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        // show the message to the user
        System.out.print(prompt + ": ");
        // clean the buffer storage
        System.out.flush();
        try {
            // read the next line
            return stdin.readLine();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}