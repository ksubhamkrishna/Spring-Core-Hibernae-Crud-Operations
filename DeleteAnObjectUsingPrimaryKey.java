package hibernate.project.use.entity.implementdatabase;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.project.entitypackage.EmployeeEntityClass;

public class DeleteAnObjectUsingPrimaryKey {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate-config-file.xml")
				.addAnnotatedClass(EmployeeEntityClass.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int employee_id = 3;

			session.beginTransaction();

			List<EmployeeEntityClass> particularEmployees = session.createQuery("from EmployeeEntityClass ").list();

			System.out.println("\n\nEmployee Table before deleting employee with id = 3 :");
			for (EmployeeEntityClass wiproemployees : particularEmployees) {
				System.out.println(wiproemployees);
			}

			EmployeeEntityClass myEmployee = session.get(EmployeeEntityClass.class, employee_id);

			System.out.println("\n\nEmployee to be deleted is :" + myEmployee);

			System.out.println("\nDeleting Employee with id " + employee_id + " ...");
			session.delete(myEmployee);

			session.getTransaction().commit();

			System.out.println("Employee with id " + employee_id + " deleted successfully.");
			// or directly :-

			// session.createQuery("delete from EmployeeEntityClass where id
			// =2").executeUpdate();
			session = factory.getCurrentSession();

			session.beginTransaction();

			particularEmployees = session.createQuery("from EmployeeEntityClass ").list();

			System.out.println("\n\nEmployee Table after deleting employee with id = 3 :");
			for (EmployeeEntityClass wiproemployees : particularEmployees) {
				System.out.println(wiproemployees);
			}

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
