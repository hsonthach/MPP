package lab2.ans2.prob2B;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String ordernum;
    private LocalDate orderdate;
    private List<OrderLine> orderLineList;

    public Order(String ordernum, LocalDate orderdate) {
        this.ordernum = ordernum;
        this.orderdate = orderdate;
        this.orderLineList = new ArrayList<>();
    }

    public OrderLine addOrder(int orderlinenum, double price, int qty) {
        OrderLine orderLine = new OrderLine(orderlinenum, price, qty, this);
        orderLineList.add(orderLine);
        return orderLine;
    }

    public List<OrderLine> getOrders() {
        return orderLineList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ordernum='" + ordernum + '\'' +
                ", orderdate=" + orderdate +
                '}';
    }
}
