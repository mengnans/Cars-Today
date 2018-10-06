package dataAccess;

import models.Bid;
import models.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Mengnan Shi
 * @create 2018-09-28-19:08
 */

public class BidMapperTest {

    @Test
    void createUserTest() {
        Bid bid = new Bid(1L, 1L, "Flemington Road", "13186633546", 33323);
        BidMapper.createBid(bid);

        ArrayList<Bid> bids;
        bids = BidMapper.readAllBidsByUserId(1L);

        for (Bid myBid : bids) {
            myBid.setStatus("Failed");
            BidMapper.updateBid(myBid);
        }

        bids = BidMapper.readAllBidsByUserId(1L);

        for (Bid myBid : bids) {
            System.out.println(myBid.toString());
        }


    }

}
