/**
 * This is the CollegeRegistration class.
 * This class imports ct417_assignment_1_a_bird project
 * @author Anthony Bird
 * email: a.bird6@universityofgalway.ie
 */

package ct417_assignment_1_a_bird_driver;

import ct417_assignment_1_a_bird.*;
import ct417_assignment_1_a_bird.Module;
import java.util.List;
import org.joda.time.LocalDate;
import java.util.ArrayList;

public class CollegeRegistration {
	
	// instance variables
	CourseProgramme ece, cs, eee;									// 3 course instances: ECE, EEE and Computer Science
	Student studentA, studentB, studentC, studentD;					// 4 students will be registered: 1 for each course and an additional ECE student
	Module eceModA, eceModB, eeeModA, eeeModB, csModA, csModB;		// 2 modules per course with some modules being used by multiple courses
	
	/**
	 * Instantiating instance variables for printing
	 */
	public void objectSetup() {
		
		// object instantiation
		System.out.println("Creating objects...");
		// courses - List<Module> and List<Student> place holders will be auto instantiated for each course
		ece = new CourseProgramme("ECE", new LocalDate(2023, 9, 10), new LocalDate(2024, 5, 4));
		eee = new CourseProgramme("EEE", new LocalDate(2023, 9, 10), new LocalDate(2024, 5, 4));
		cs = new CourseProgramme("CS", new LocalDate(2023, 9, 10), new LocalDate(2024, 5, 4));
		
		// modules - List<CourseProgramme>, List<Student> and Lecturer place holders will be auto instantiated for each module
		eceModA = new Module("EE203", "Digital Systems I");
		eceModB = new Module("EE214", "Wireless Communications");
		eeeModA = new Module("EE302", "Power Systems");
		eeeModB = new Module("EE113", "Analogue Systems");
		csModA = new Module("CT417", "Software Engineering");
		csModB = new Module("CT267", "Programming");
		
		// students - CourseProgramme and List<Module> place holders will be auto instantiated for each student
		studentA = new Student("19357176", "Anthony Bird", "22", new LocalDate(2000, 10, 10));
		studentB = new Student("19343711", "Joe Bloggs", "21", new LocalDate(2000, 12, 25));
		studentC = new Student("19482367", "Tim Boland", "20", new LocalDate(2002, 11, 13));
		studentD = new Student("18364473", "Jane Doe", "23", new LocalDate(1999, 8, 12));
		
		// object coupling
		System.out.println("Coupling objects...");
		
		// adding modules to courses - this will automatically add the courses to the Module objects
		ece.addModule(eceModA);
		ece.addModule(eceModB);
		ece.addModule(csModA);
		ece.addModule(eeeModA);
		eee.addModule(eeeModA);
		eee.addModule(eeeModB);
		eee.addModule(eceModA);
		cs.addModule(csModA);
		cs.addModule(csModB);	
		
		// enrolling students - this will automatically assign associated modules to the student and vice versa
		ece.addStudent(studentA);
		ece.addStudent(studentB);
		eee.addStudent(studentC);
		cs.addStudent(studentD);
		
		System.out.println("College registration complete");
		
	}
	
	/**
	 * Formatting print statements and printing instantiated objects
	 */
	public void objectPrint() {
		System.out.println("Printing in progress.....");
		
		// printing courses and associated modules
		// setting up table headers
		String courseColumn = "| %-10s | %-10s | %-30s | %n";
		String courseRow = "------------------------------------------------------------";
		System.out.printf(courseColumn, "Course", "Module ID", "Module Name");
		System.out.println(courseRow);
		
		// setting up table body
		System.out.printf(courseColumn, ece.getName(), ece.getModules().get(0).getID(), ece.getModules().get(0).getName());
		for ( int i=1; i<ece.getModules().size(); i++ ) {
			System.out.printf(courseColumn, " ", ece.getModules().get(i).getID(), ece.getModules().get(i).getName());
		}
		
		System.out.println(courseRow);
		System.out.printf(courseColumn, eee.getName(), eee.getModules().get(0).getID(), eee.getModules().get(0).getName());
		for ( int i=1; i<eee.getModules().size(); i++ ) {
			System.out.printf(courseColumn, " ", eee.getModules().get(i).getID(), eee.getModules().get(i).getName());
		}
		
		System.out.println(courseRow);
		System.out.printf(courseColumn, cs.getName(), cs.getModules().get(0).getID(), cs.getModules().get(0).getName());
		for ( int i=1; i<cs.getModules().size(); i++ ) {
			System.out.printf(courseColumn, " ", cs.getModules().get(i).getID(), cs.getModules().get(i).getName());
		}
			
		// printing students
		// setting up table headers
		String studentRow = "------------------------------------------------------------------------------------------------------------------------";
		System.out.println("\n" + studentRow + "\n" + "\n");
		String studentColumn = "| %-10s | %-15s | %-3s | %-17s | %-10s | %-10s | %-30s | %n";
		System.out.printf(studentColumn, "Student ID", "Student Name", "Age", "Username", "Course", "Module ID", "Module Name");
		System.out.println(studentRow);
		
		// setting up table body
		System.out.printf(studentColumn, studentA.getID(), studentA.getName(), studentA.getAge(), studentA.getUsername(), studentA.getCourse().getName(), studentA.getModules().get(0).getID(), studentA.getModules().get(0).getName());
		for ( int i=1; i<studentA.getModules().size(); i++ ) {
			System.out.printf(studentColumn, " ", " ", " ", " ", " ", studentA.getModules().get(i).getID(), studentA.getModules().get(i).getName());
		}
		System.out.println(studentRow);
		
		System.out.printf(studentColumn, studentB.getID(), studentB.getName(), studentB.getAge(), studentB.getUsername(), studentB.getCourse().getName(), studentB.getModules().get(0).getID(), studentB.getModules().get(0).getName());
		for ( int i=1; i<studentB.getModules().size(); i++ ) {
			System.out.printf(studentColumn, " ", " ", " ", " ", " ", studentB.getModules().get(i).getID(), studentB.getModules().get(i).getName());
		}
		System.out.println(studentRow);
		System.out.printf(studentColumn, studentC.getID(), studentC.getName(), studentC.getAge(), studentC.getUsername(), studentC.getCourse().getName(), studentC.getModules().get(0).getID(), studentC.getModules().get(0).getName());
		for ( int i=1; i<studentC.getModules().size(); i++ ) {
			System.out.printf(studentColumn, " ", " ", " ", " ", " ", studentC.getModules().get(i).getID(), studentC.getModules().get(i).getName());
		}
		System.out.println(studentRow);
		System.out.printf(studentColumn, studentD.getID(), studentD.getName(), studentD.getAge(), studentD.getUsername(), studentD.getCourse().getName(), studentD.getModules().get(0).getID(), studentD.getModules().get(0).getName());
		for ( int i=1; i<studentD.getModules().size(); i++ ) {
			System.out.printf(studentColumn, " ", " ", " ", " ", " ", studentD.getModules().get(i).getID(), studentD.getModules().get(i).getName());
		}
		System.out.println(studentRow);	
	}
	
	// running driver program with...
	public static void main(String[] args) {
		CollegeRegistration cr = new CollegeRegistration();
		cr.objectSetup();
		cr.objectPrint();
	}
}
