package hibernate.project.use.entity.implementdatabase;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.project.entitypackage.EmployeeEntityClass;

public class SaveObjects {
	public static void main(String args[]) {

		// creating session factory
		SessionFactory factory = new Configuration().configure("hibernate-config-file.xml")
				.addAnnotatedClass(EmployeeEntityClass.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			System.out.println("\nSaving Employee Records...");
			EmployeeEntityClass myEmployee1 = new EmployeeEntityClass("Subham", "Krishna", "Oracle");
			EmployeeEntityClass myEmployee2 = new EmployeeEntityClass("Kumar", "Ram", "Infosys");
			EmployeeEntityClass myEmployee3 = new EmployeeEntityClass("Ramana", "Venketesh", "Wipro");
			EmployeeEntityClass myEmployee4 = new EmployeeEntityClass("Trilokeshwar", "Binod", "Accenture");

			// saving student records.
			session.save(myEmployee1);
			session.save(myEmployee2);
			session.save(myEmployee3);
			session.save(myEmployee4);

			// commit transaction saving it in database
			session.getTransaction().commit();

			System.out.println("\ndone!");

			session = factory.getCurrentSession();
			session.beginTransaction();

			List<EmployeeEntityClass> employees = session.createQuery("from EmployeeEntityClass").list();

			System.out.println("\n\nThe Employees saved in the Employee table are :");
			for (EmployeeEntityClass employee : employees) {
				System.out.println(employee);
			}

			session.getTransaction().commit();

		} finally {
			factory.close();

		}
	}

}
