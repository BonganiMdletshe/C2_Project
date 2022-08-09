package com.util;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import com.dto.Student;
import com.dto.Subject;
import com.dto.Teacher;


public class HibernateUtil {


	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if(sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				Properties settings = new Properties();

				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatedemo?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "mysqlCMB!22");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Student.class);
				configuration.addAnnotatedClass(Subject.class);
				configuration.addAnnotatedClass(Teacher.class);


				ServiceRegistry serviceRegistery = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistery);

			}catch(Exception e) {
				e.printStackTrace();

			}
		}
		return sessionFactory;
	}


}
