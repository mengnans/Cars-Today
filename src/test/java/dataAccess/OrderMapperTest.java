package dataAccess;

import models.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Mengnan Shi
 * @create 2018-08-21-19:08
 */

public class OrderMapperTest {

    @Test
    void createUserTest(){
        Order order = new Order(1L,1L,"Flemington Road","13186633546");
        OrderMapper.createOrder(order);

        ArrayList<Order> orders;
        orders = OrderMapper.readAllOrders();

        for (Order myOrder: orders){
            System.out.println(myOrder.toString());
        }
    }

}
