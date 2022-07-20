package dao;

import entity.User;
import java.io.IOException;
public interface UserDao {
    User finUserById(Integer userId) throws IOException;
}