package com.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.dto.Teacher;
import com.util.HibernateUtil;

public class TeacherDao {
	
	 public void saveTeacher(Teacher teacher) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.save(teacher);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	    
	    public void deleteTeacher(int id) {

	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            Teacher teacher = session.get(Teacher.class, id);
	            if (teacher != null) {
	                session.delete(teacher);
	            }
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	    
	    @SuppressWarnings("unchecked")
	    public List<Teacher> getAllTeachers() {

	        Transaction transaction = null;
	        List <Teacher> listOfTeachers = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            listOfTeachers = session.createQuery("from Teacher").getResultList();
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listOfTeachers;
	    }

}
