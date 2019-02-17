package com.izdebski.client;

import java.util.Date;
import java.util.List;

import com.izdebski.entities.Employee;
import com.izdebski.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDao {

    public List<Employee> getEmployeeList(){

        Session session = null;
        List<Employee> empList = null;
        try {
            session = HibernateUtil.getSession();
            String queryStr = "select emp from Employee emp";
            Query query = session.createQuery(queryStr);
            empList = query.list();
        } catch(Exception ex) {
            ex.printStackTrace();
            // handle exception here
        } finally {
            try {if(session != null) session.close();} catch(Exception ex) {}
        }
        return empList;
    }

    public static void main(String a[]) {

        EmployeeDao empDao = new EmployeeDao();
        System.out.println("---------------------------");

        List<Employee> empList = empDao.getEmployeeList();
        System.out.println("emp size: "+empList.size());
        empList.stream().forEach(System.out::println);

        System.out.println("---------------------------");
    }
}