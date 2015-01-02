package com.lftechnology.dec31;

/**
 * Write a program that calculates percentage and GPA of 5 studen ts. Each of
 * the students has following attributes: name, class, rollnum, and marks
 * obtained in 5 subjects.
 * 
 * @author satish
 *
 */
public class StudentDriver {

	public static void main(String[] args) {

		String[] studentNames = { "Ram", "Hari", "Shyam", "Gopal", "Krishna" };
		String[] studentSections = { "A", "A", "B", "A", "B" };
		final String[] SUBJECTS = { "English", "Maths", "Science", "Computer",
				"Social Studies" };

		int[] rollNumbers = { 1, 2, 1, 3, 2 };
		float[][] marks = { { 50, 70, 65, 35, 80 }, { 80, 70, 85, 55, 75 },
				{ 45, 68, 54, 70, 52 }, { 90, 75, 85, 82, 78 },
				{ 70, 78, 85, 79, 67 } };

		Student[] students = new Student[5];

		for (int i = 0; i < 5; i++) {
			students[i] = new Student(studentNames[i], studentSections[i],
					rollNumbers[i]);
			students[i].assignMarks(marks[i]);

			System.out
					.println("Name: " + students[i].name + "\nSection: "
							+ students[i].section + "\nrollNum: "
							+ students[i].rollNum);
			System.out.println("Subjects  Marks ");

			for (int j = 0; j < students[i].marks.length; j++) {
				System.out.println(SUBJECTS[j] + ":\t" + students[i].marks[j]);
			}

			System.out.println();
			System.out.println("Percentage:" + students[i].percentage);
			System.out.println("Gpa:" + students[i].gpa);
			System.out.println("--------------------------------------");
		}

	}
}

/**
 * This class represent student and holds the information of students such as
 * name, section, roll number, marks and calculates their percentage, gpa
 * 
 * @author satish
 *
 */
class Student {
	public String name;
	public String section;
	public int rollNum;
	public float[] marks = new float[5];

	public float percentage = 0;
	public float gpa = 0;

	Student(String name, String section, int rollNum) {
		this.name = name;
		this.section = section;
		this.rollNum = rollNum;
	}

	/**
	 * assign marks to student and also get their percentage and gpa calculated
	 * 
	 * @param marks
	 */
	public void assignMarks(float[] marks) {
		this.marks = marks;
		calculatePercentage();
		calculateGpa();
	}

	/**
	 * calculates percentage of a student
	 */
	public void calculatePercentage() {
		float totalMarks = 0;
		for (float mark : marks) {
			totalMarks += mark;
		}
		percentage = totalMarks / marks.length;
	}

	/**
	 * calculate gpa of a student
	 */
	public void calculateGpa() {
		float totalMarks = 0;
		for (float mark : marks) {
			totalMarks += mark;
		}
		gpa = totalMarks / (marks.length * 100) * 4;
	}
}
