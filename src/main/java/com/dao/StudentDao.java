package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.dto.Student;
import com.util.HibernateUtil;

public class StudentDao {

	public void saveStudent(Student student) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteStudent(int id) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Student student = session.get(Student.class, id);
			if (student != null) {
				session.delete(student);
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
	public List<Student> getAllStudents() {

		Transaction transaction = null;
		List < Student > listOfStudents = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			listOfStudents = session.createQuery("from Student").getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfStudents;
	}

}
