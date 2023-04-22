import java.util.List;

public interface OrderOperationInterface {
    // update Order
    public Order updateOrder(Order order, OrderItem item, int quantity);

    // delete Order
    public void deleteOrder(List<Order> orders, Order order);

    // delete Order
    public void printOrderList(List<Order> orders);

    // print printOrderDetails
    public void printOrderDetails(Order order);

}