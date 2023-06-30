package hibernate.project.use.entity.implementdatabase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.project.entitypackage.EmployeeEntityClass;

public class RetrieveObjectsUsingPrimaryKey {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate-config-file.xml")
				.addAnnotatedClass(EmployeeEntityClass.class).buildSessionFactory();

		try {
			int employee_id = 3;
			Session session = factory.getCurrentSession();

			session.beginTransaction();
			EmployeeEntityClass myEmployee = session.get(EmployeeEntityClass.class, employee_id);

			System.out.println("Student details with id : " + employee_id + " is :" + myEmployee);
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
