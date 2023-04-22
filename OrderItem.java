public class OrderItem {
    public int id;
    public int menuId;
    public int quantity;
    public double total;

    public OrderItem(int id, int _menuId, int quantity) {
        this.id = id;
        this.menuId = _menuId-1;
        this.quantity = quantity;
        String menu[][] = new Menu().getMenu();
        this.total = Integer.parseInt(menu[this.menuId][1]) * quantity;
    }

    public String[] getOrderItemDetails() {
        // return "Item ID:"+id+"\tMenu ID: "+menuId+"\t Item Name" +menu[menuId][0]
        String menu[][] = new Menu().getMenu();
        String[] item = {
                id + "",
                menuId + "",
                menu[menuId][0] + "",
                menu[menuId][1] + "",
                quantity + "",
                total + ""
        };
        return item;
    }
}
