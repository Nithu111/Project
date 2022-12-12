package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.product;
import dto.user;

public class productdao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void addproduct(product product) {
		transaction.begin();
		manager.persist(product);
		transaction.commit();
		
	}
	
	public List<product> fetchProducts(){
		
	return manager.createQuery("select w from product w").getResultList();
		
	}
	public product fetchProduct(int id){
		
		return manager.find(product.class, id);
	
}
	public void deleteproduct(product product){
		
		transaction.begin();
		manager.remove(product);
		transaction.commit();
		
	}
	public void updateproduct(product product)
	{
		transaction.begin();
		manager.merge(product);
		transaction.commit();
	}
	
}
