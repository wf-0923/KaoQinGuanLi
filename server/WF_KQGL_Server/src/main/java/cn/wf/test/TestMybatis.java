//import cn.wf.dao.UserDao;
//import cn.wf.pojo.User;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
////import org.junit.Test;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
///*
//以下为mybatis单独使用时的Test方法，需要有mybatis的配置文件：mybatis。xml
//在mybatis和spring整合之后，就会删除mybatis。xml
//加载配置文件时就会出错，使用applicationContext.xml也不行。
//以下Test方法想要使用，则需要重新调整
//
//之后的数据库语言仅需注解
//在class、inference上加入@Repository,可以把类加入到Ioc容器，
//
//在service的实现类中  注入 dao的接口 用@Autowired接口，并在
//方法中 return （接口名。方法名（有参数的话，写实体类的参数，会在方法的（）里面））
//
//去controller层，class上加入注解
// */
//
//
//public class TestMybatis {
//
///*
//查询所有
// */
////    @Test
////    public void  run1() throws Exception {
////        //加载配置文件
////        InputStream in = Resources.getResourceAsStream("mybatis.xml");
////        //创建sqlSessionFactory
////        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(in);
////        //创建sqlSession对象
////        SqlSession session = factory.openSession();
////        //获取到代理对象
////        UserDao dao =session.getMapper(UserDao.class);
////        //查询所有数据
////        List<User> list = dao.findAll();
////        for (User user:list){
////            System.out.println(user);
////        }
////        //关闭资源
////        session.close();
////        in.close();
//
////    }
//
//    /*
//    添加用户
//     */
//
////    @Test
//    public void  run2() throws Exception {
////    User user=new User();
////    user.setUsername("熊三");
////    user.setPassword("123456");
////        //加载配置文件
////        InputStream in = Resources.getResourceAsStream("mybatis.xml");
////        //创建sqlSessionFactory
////        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(in);
////        //创建sqlSession对象
////        SqlSession session = factory.openSession();
////        //获取到代理对象
////        UserDao dao =session.getMapper(UserDao.class);
////        //保存
////        dao.saveUser(user);
////        //查询所有
////        List<User> list = dao.findAll();
////        for (User uuser:list){
////            System.out.println(uuser);
////        }
////        //提交事务
////        session.commit();
////        //关闭资源
////        session.close();
////        in.close();
//
//    }
//}
