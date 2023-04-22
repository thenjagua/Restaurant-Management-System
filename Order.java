import java.util.List;

public class Order {
    protected int orderNo;
    protected int customerId;
    // protected int menuId;
    // protected double amount;
    protected int staffId;
    protected long timeOfOder;
    protected List<OrderItem> orderItems;
    OrderOperationInterface orderinterface;

    public Order(int _orderNo, int _customerId, int _staffId, long _timeOfOder, List<OrderItem> _orderItems) {
        orderNo = _orderNo;
        customerId = _customerId;
        // menuId = _menuId;
        // amount = _amount;
        staffId = _staffId;
        timeOfOder = _timeOfOder;
        orderItems = _orderItems;
    }

    // list all orders
    public void listAllOrders(OrderOperationInterface orderinterface, List<Order> orders) {
        this.orderinterface = orderinterface;
        orderinterface.printOrderList(orders);
    }

    // Printing details of a particular order
    public void printOrderDetails(OrderOperationInterface orderinterface, Order order) {
        this.orderinterface = orderinterface;
        orderinterface.printOrderDetails(order);
    }

    // updating the details or a paticular order
    public void updateOrder(OrderOperationInterface orderinterface, Order order, OrderItem item, int quantity) {
        this.orderinterface = orderinterface;
        orderinterface.updateOrder(order, item, quantity);
    }

    // Deliting the order from the list
    public void deleteOrder(OrderOperationInterface orderinterface, List<Order> orders, Order order) {
        this.orderinterface = orderinterface;
        orderinterface.deleteOrder(orders, order);
    }

    // get the order totals
    public double getOrderTotals(Order order) {
        List<OrderItem> orderItems = order.orderItems;
        double total = 0;
        for (int e = 0; e < orderItems.size(); e++) {
            String[] item = orderItems.get(e).getOrderItemDetails();
            total += Double.parseDouble(item[5]);
        }
        return total;
    }
    //get the order from order number
    // public Order getOrder(int  orderNo) {

    // }
}
