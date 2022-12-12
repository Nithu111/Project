 package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.Query;

import dto.user;

public class userdao {
	
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
public void adduser(user user) {
	
		transaction.begin();
		manager.persist(user);
		transaction.commit();
}
public List<user> login(String email)
{
	return manager.createQuery("select u from user u where email=?1").setParameter(1, email).getResultList();
}
public List<user> viewcustomer()
{
	return manager.createQuery("select u from user u where role='customer'").getResultList();
}
}
