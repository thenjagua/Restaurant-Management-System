import java.util.List;

public class OrderOperation implements OrderOperationInterface {
    // implementing the overriden methods
    @Override

    public Order updateOrder(Order order, OrderItem item, int quantity) {
        List<OrderItem> orderItems=order.orderItems;
        if (quantity < 1) {
            orderItems.remove(item);
            System.out.println("Item removed successfully");
        } else {
            int itemIndex = orderItems.indexOf(item);
            item.quantity = quantity;
            orderItems.add(itemIndex, item);
            System.out.println("Updated the Order details");
        }
        order.orderItems = orderItems;
        return order;
    }

    @Override

    public void deleteOrder(List<Order> orders, Order order) {
        orders.remove(order);
        System.out.println("deleted the Order details");
    }

    @Override

    public void printOrderList(List<Order> orders) {
        System.out.println(
                "*******************LIST ORDERS*************\n# |\tOrder ID |\tCustomer ID |\tStaff ID |\tOrdered At |\tTotal Items Ordered |\n");

        for (int u = 0; u < orders.size(); u++) {
            Order order = orders.get(u);
            System.out.println((u + 1) + "\t" +
                    order.orderNo + "\t" + "\t" +
                    order.customerId + "" + "\t" + "\t" +
                    order.staffId + "" + "\t" + "\t" +
                    order.timeOfOder + "" + "\t" + "\t" +
                    order.orderItems.size() + "");
        }

    }

    @Override

    public void printOrderDetails(Order order) {
        System.out.println(
                "-------------ORDER SUMMARY----------\nOrder ID: " + order.orderNo + "\t" +
                        "Customer ID: " + order.customerId + "\t" +
                        "Staff Number: " + order.staffId + "\t" +
                        "Placed At: " + order.timeOfOder +
                        "\n-------------ORDER DETAILS----------\n" +
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
        System.out.println("-----------------------------------------------Grand Total: \t" + grandTotal);// \t\t\t\t\t\t\t\t

    }
}