package Hibernate_Study.test;

//hibernate的hello world
import javax.persistence.EntityTransaction;
import javax.transaction.Synchronization;
import Hibernate_Study.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import java.lang.Throwable;

public class test {

    @Test
    public void test1() throws HibernateException {
        Customer customer=new Customer();
        customer.setName("xzz");
        customer.setAge(20);
        customer.setGender("男");
        customer.setLevel("至尊VIP");


        //1.读取hibernate.cfg.xml文件
        Configuration cfg=new Configuration();
        cfg.configure();

        //2.创建SessionFactory工厂
        SessionFactory factory=cfg.buildSessionFactory();

        //3.创建Session对象
        Session session= factory.openSession();

        //4.开启事务
        Transaction tx= session.beginTransaction();

        //5.执行添加操作
        session.save(customer);

        //6.提交事务
        tx.commit();
        
        
        //7.关闭资源
        session.close();

    }
}
