import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class StudentDao {
    private final EntityManagerFactory emFactory;

    public StudentDao(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }



    public Student findById(int id) {
        EntityManager em = emFactory.createEntityManager();
        try{
            Student student = em.find(Student.class, id);
        return student;
    }
        finally {
            em.close();
        }
    }

    public List<Student> findAll(){
        EntityManager em = emFactory.createEntityManager();
        try{ return em.createQuery("select s from Student s", Student.class).getResultList();}
        finally {
            em.close();
        }

    }
    public void add(Student student){
        EntityManager em = emFactory.createEntityManager();
       try{ em.getTransaction().begin();
           em.persist(student);
           em.flush();
           em.getTransaction().commit();}
       catch (Exception e){
           em.getTransaction().rollback();
       }
       finally {
           em.close();
       }

    }
    public void update(Student student){
        EntityManager em = emFactory.createEntityManager();
        if (findById(student.getId())==null){
            add(student);
        }else
        try{ em.getTransaction().begin();

          em.merge(student);
            em.getTransaction().commit();}
        catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
    }



    public void delete(int id){
        EntityManager em = emFactory.createEntityManager();
        try{ em.getTransaction().begin();
            Student student = em.getReference(Student.class, id);
            em.remove(student);
            em.getTransaction().commit();}
        catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
    }
}
