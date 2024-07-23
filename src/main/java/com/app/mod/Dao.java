package com.app.mod;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Dao {

	@Autowired
	EntityManager manager;

	@Autowired
	EntityTransaction transaction;

	public void saveEmployee(Emp employee) {
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
	}

	public Emp getEmployeeById(int id)
	{
		return manager.find(Emp.class, id);
	}

	public void updateEmployee(Emp employee) {
		transaction.begin();
		manager.merge(employee);
		transaction.commit();
	}

	public void deleteEmployee(int id) {
		Emp employee=manager.find(Emp.class, id);
		transaction.begin();
		manager.remove(employee);
		transaction.commit();
	}

	public List<Emp> getAllEmployee() {
		Query q=manager.createQuery("SELECT e FROM Emp e");
		return q.getResultList();
	}
}