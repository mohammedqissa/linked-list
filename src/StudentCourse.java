import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentCourse {

    public static ArrayList<Course> courses = new ArrayList<>();
    public static ArrayList<Student> students = new ArrayList<>();


    public static void addCourse(Student student , Course course){

        if (canAddCourse(course,student) && canAddStudent(course)){
            course.students.add(student);
            student.courses.add(course);
        }



    }

    private static boolean canAddCourse(Course course,Student student){

        if (courses.contains(course)){
            if (canGetCourseByID(course,student)){
                if (isConflict(course,student)){
                    if (student.courses.size()<5){
                        return true;
                    }
                    else
                    {
                        System.out.println("Student "+student.getName()+" cant get more than 5 courses!");
                    }
                }
                else
                {
                    System.out.println("Student "+student.getName()+" have conflict in his/her courses!");
                }
            }
            else
            {
                System.out.println("Student "+student.getName()+" cant get "+course.cName+" course because he is sanfor!");
            }
        }
        else
        {
            System.out.println("course not found!");
        }

        return false;




    }

    private static boolean canAddStudent(Course course){
        return course.max > course.students.length();
    }

    private static boolean canGetCourseByID(Course course, Student student){
        int id = student.getId()/10000;
        return id <= course.year;
    }

    private static boolean isConflict(Course course, Student student){

        int start = course.start;
        int finish = course.finish;

        ArrayList<Course> courses = student.courses;

        for (int i = 0; i < courses.size(); i++) {
            if( start >= courses.get(i).start && start <= courses.get(i).finish ||  finish >= courses.get(i).start && finish <= courses.get(i).finish )
            {
                return false;
            }
        }

        return true;


    }

    public static void readCoursesFile(){

        File file = new File("/Users/mohammedissa/Desktop/projects/src/Courses.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()){

            String line = scanner.nextLine();

            String[] lineSplitted = line.trim().split("#");

            Course course = new Course(lineSplitted[0].trim().toUpperCase(),lineSplitted[1].trim().toUpperCase(),Integer.parseInt(lineSplitted[2].trim()),lineSplitted[3].trim(),lineSplitted[4].trim(),Integer.parseInt(lineSplitted[5].trim()));

            courses.add(course);

//            System.out.println(course);

        }





    }

    public static void readStudentFile(){


        File file = new File("/Users/mohammedissa/Desktop/projects/src/Students.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()){

            String line = scanner.nextLine();

//            System.out.println(line);
            String[] lineSplitted = line.trim().split("#").clone();

            Student student = new Student(lineSplitted[0].trim(),Integer.parseInt(lineSplitted[1].trim()));

            students.add(student);
//            System.out.println(student);


            for (int k = 2; k <lineSplitted.length ; k++) {
                Course course = null;

                for (int i = 0; i <courses.size() ; i++) {
                    if (courses.get(i).compareTo(lineSplitted[k].trim().toUpperCase()) == 0){
                        course = courses.get(i);
                        break;
                    }
                }

                if (course != null ){
                    addCourse(student,course);
                    System.out.println(student+"       "+course);
                }
                else {
                    System.out.println("Course Not Found"); //course not found in this semester
                }
            }


        }

    }



}
