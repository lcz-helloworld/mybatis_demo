package dao.impl;

import dao.UserDao;
import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User finUserById(Integer userId) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlsession对象
        SqlSession session = factory.openSession();
        //执行sql语句。通过sql映射文件中，sql语句的标识来指定需要执行的sql语句
        User resultUser = session.selectOne("user.findUserById", userId); //参数一：namespace.id

        //查询对象
        User resultUserInt = session.selectOne("user.findUserByIdInt", 1); //参数一：namespace.id
        System.out.println("查询对象的结果：" + resultUser);
        //查询list集合
        List list = session.selectList("user.listUser");
        System.out.println("查询集合的结果：" + list);

        //关闭sqlsession对象
        session.close();
        return resultUser;
    }
}