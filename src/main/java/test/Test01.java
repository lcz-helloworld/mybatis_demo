package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import org.junit.Test;
import java.io.IOException;
public class Test01 {
    @Test
    public void test01() throws IOException {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.finUserById(1);
        System.out.println(user);
    }
}