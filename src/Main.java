
public class Main {




	public static void main(String[] args) {

		StudentCourse.readCoursesFile();
		StudentCourse.readStudentFile();


		StudentCourse.courses.get(1).students.print();

	}

}
