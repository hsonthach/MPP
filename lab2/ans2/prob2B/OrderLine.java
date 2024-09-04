package lab2.ans2.prob2B;


public class OrderLine {
    private int orderlinenum;
    private double price;
    private int qty;
    private Order order;

    OrderLine(int orderlinenum, double price, int qty, Order order) {
        this.orderlinenum = orderlinenum;
        this.price = price;
        this.qty = qty;
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "orderlinenum=" + orderlinenum +
                ", price=" + price +
                ", qty=" + qty +
                ", order=" + order +
                '}';
    }
}
