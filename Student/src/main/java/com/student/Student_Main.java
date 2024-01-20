package com.Student;

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
    StudentDAO s=new StudentDAO(em);
	s.createStudent(s1);
	s.createStudent(s2);
	s.createStudent(s3);
	s.createStudent(s4);
	System.out.println("Student details successfully added");
    System.out.println("----------------------------------------------------------------");
	System.out.println("updating studeent details");
	int  newid = 4;
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
	System.out.println(" 1st Record is Removed based  on id");
	System.out.println(" Data removed successfully  ");
	s.removeById(2);
	Course c1 = new Course();
	  c1.setCourseName("Java Programming");
	  c1.setCourseCode("CS101");

	  Course c2 = new Course();
	  c2.setCourseName("Database Management");
	  c2.setCourseCode("DB101");

	  Course c3 = new Course();
	  c3.setCourseName("Web Development");
	  c3.setCourseCode("WD101");

	  CourseDAO courseDAO = new CourseDAO(em);

	  // Adding courses
	  courseDAO.createCourse(c1);
	  courseDAO.createCourse(c2);
	  courseDAO.createCourse(c3);

	  System.out.println("Course details successfully added");
	  System.out.println("----------------------------------------------------------------");

	  // Updating course details
	  int newCourseId = 3;
	  String newCourseName = "Advanced Web Development";
	  String newCourseCode = "AWD101";
	  courseDAO.updateCourse(newCourseId, newCourseName, newCourseCode);
	  System.out.println("------------------------------------------------------------");

	  // Retrieving course details based on ID
	  System.out.println("Course details based on ID");
	  Optional<Course> courseDetails = courseDAO.getById(2);
	  System.out.println(courseDetails);
	  System.out.println("------------------------------------------------------------");

	  // Retrieving all courses
	  System.out.println("All course details");
	  List<Course> allCourses = courseDAO.getAll();
	  System.out.println(allCourses);
	  System.out.println("------------------------------------------------------------");

	  // Removing a course by ID
	  System.out.println("Removing 1st course based on ID");
	  System.out.println("Data removed successfully");
	  courseDAO.removeById(1);
   }

  catch (HibernateException e) {
		 e.printStackTrace();
	}
  catch (Exception e) {
	 e.printStackTrace();
	}

	}

}
