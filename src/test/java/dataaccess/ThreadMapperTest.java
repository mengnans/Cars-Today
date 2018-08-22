package dataaccess;

import domain.Administrator;
import domain.ThreadItem;
import domain.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Mengnan Shi
 * @create 2018-08-21-19:08
 */

public class ThreadMapperTest {

    private static ThreadMapper threadMapper;

    static {
        threadMapper = new ThreadMapper();
    }

    @Test
    void createTest() {
        User _user = new User(1, "2", "3");
        ThreadItem _item = new ThreadItem(_user, "headText", "contentText");
        threadMapper.createThread(_item);

        ThreadItem _itemNew = threadMapper.readThreadByUser(_user).get(0);
        assert _item.getUid() == _itemNew.getUid();
        assert _item.getUserName().equals(_itemNew.getUserName());
        assert _item.getHeader().equals(_itemNew.getHeader());
        assert _item.getContent().equals(_itemNew.getContent());
    }

    @Test
    void updateTest() {
        ThreadItem _item = threadMapper.readThreadAll().get(0);
        _item.setHeader("NewHeader");
        _item.setContent("NewContent");

        threadMapper.updateThread(_item);
        ThreadItem _itemNew = threadMapper.readThreadAll().get(0);
        assert _item.getHeader().equals(_itemNew.getHeader());
        assert _item.getContent().equals(_itemNew.getContent());
    }

    @Test
    void deleteTest() {
        ThreadItem _item = threadMapper.readThreadAll().get(0);
        threadMapper.deleteThread(_item);

        ArrayList<ThreadItem> _lst = threadMapper.readThreadById(_item.getTid());
        assert _lst.size() == 0;
    }

}