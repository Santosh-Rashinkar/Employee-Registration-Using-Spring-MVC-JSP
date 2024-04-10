package com.prowings.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prowings.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean saveEmployee(Employee employee) {
		
		System.out.println("inside saveEmployee() of EmployeeDaoImpl");
		
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		session.save(employee);
		txn.commit();
		session.close();
		
		// code to interact with DB and saves the incoming Employee object
		return true;
		
	}

	@Override
	public List<Employee> getEmployeesList() {

System.out.println("inside getEmployeeList() of EmployeeDaoImpl");
		
		Session session = null;
		Transaction txn = null;
		List<Employee> temp = new ArrayList();
		
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			String hql = "FROM Employee";
			Query query = session.createQuery(hql);	
			temp = query.getResultList();
			txn.commit();
		}catch (Exception e) {
			System.out.println("Error while fetching the employee list!!");
			e.printStackTrace();
			if(txn != null)
				txn.rollback();
		}
		return temp;
	}	
}
