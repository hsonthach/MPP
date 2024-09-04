package lab2.ans2.prob2B.execute;

import lab2.ans2.prob2B.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Order myOrder = new Order("2", LocalDate.now());

        OrderLine myLine1 = myOrder.addOrder(1, 12.5,5);
        OrderLine myLine2 = myOrder.addOrder(2, 6.3,2);

        System.out.println(myOrder.getOrders());
        System.out.println(myLine1);
        System.out.println(myLine2);
    }
}
