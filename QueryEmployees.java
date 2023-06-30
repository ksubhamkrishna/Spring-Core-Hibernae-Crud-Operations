package hibernate.project.use.entity.implementdatabase;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.project.entitypackage.EmployeeEntityClass;

public class QueryEmployees {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate-config-file.xml")
				.addAnnotatedClass(EmployeeEntityClass.class).buildSessionFactory();

		try {
			Session session = factory.getCurrentSession();

			session.beginTransaction();
			List<EmployeeEntityClass> particularEmployees = session
					.createQuery("from EmployeeEntityClass where company = 'Wipro'").list();

			for (EmployeeEntityClass wiproemployees : particularEmployees) {
				System.out.println(wiproemployees);
			}

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
