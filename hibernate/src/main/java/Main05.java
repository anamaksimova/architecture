import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main05 {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        EntityManager em = emFactory.createEntityManager();
        StudentDao studentDao = new StudentDao(emFactory);
        Student student =  new Student(0,"Henry", 4);
//        for (int i = 0; i < 1000; i++) {
//
 //           studentDao.add(student);
//        }
       studentDao.update(new Student(1011,"Henry", 5));
////        System.out.println(studentDao.findAll());
      System.out.println(studentDao.findById(1011));

//        for (int id = 100; id < 1000; id++) {
////
//            studentDao.delete(id);
//       }





    }
}
