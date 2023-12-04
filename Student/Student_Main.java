package com.student;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class Student_Main {
public static void main(String[] args) {
	 EntityManagerFactory factory =null;	
  try {
	factory=Persistence.createEntityManagerFactory("sravya");
	EntityManager em = factory.createEntityManager();
	Student s1 = new Student(1,"sravya","patel","sravya@gmail.com","9876543210","female");
	Student s2 = new Student(2,"prem","chand","prem@gmail.com","8976543210","male");
	Student s3 = new Student(3,"nani","kamal","kamal@gmail.com","7985432100","male");
	Student s4 = new Student(4,"chitu","patel","chintu@gmail.com","7896543210","male");
	Student s5 = new Student (5,"nishali","mareddy","nishali@gmail.com","9087654321","female");
    StudentDAO s=new StudentDAO(em);
	s.createStudent(s1);
	s.createStudent(s2);
	s.createStudent(s3);
	s.createStudent(s4);
	s.createStudent(s5);
	System.out.println("Student details successfully added");
    System.out.println("----------------------------------------------------------------");
    System.out.println("updating studeent details");
	int  newid = 5;
	String newfirstName ="chitti" ;
	String newLastName = "patel" ;
	String newemail = "chitti@gmail.com";
	String newphoneNum = "6789054321" ;
	String newgender  ="female";
	s.updateStudent(newid, newfirstName, newLastName, newemail, newphoneNum, newgender);
	System.out.println("------------------------------------------------------------");
	System.out.println("student details based on id");
	Optional<Student> details = s.getById(2);
	System.out.println(details);
	System.out.println("------------------------------------------------------------");
	System.out.println("All students details");	 
	List<Student> all = s.getAll();
	System.out.println(all);
	System.out.println("------------------------------------------------------------");
	System.out.println("Removing student details based on id");	
	s.removeById(1);
   }
  catch (HibernateException e) {
		 e.printStackTrace();
	}
  catch (Exception e) {
	 e.printStackTrace();
	}

	}

}