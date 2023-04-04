import model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args)  {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistanceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        String jpqlQuery = "SELECT e FROM Employee e WHERE e.age> :minAge";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
        query.setParameter("minAge", 30);
        List<Employee> employees = query.getResultList();
        System.out.println(employees);

        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();

    }
}

