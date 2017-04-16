import java.util.ArrayList;

public class Student implements Comparable<Student>{

	private String name;
	private int id;

	ArrayList<Course> courses = new ArrayList<>();

	public Student(String name , int id) {

        name.toLowerCase();
        name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
		this.name = name;

		this.id = id;


	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
        name.toLowerCase();
        name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
		this.name = name;
	}

	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + "]";
	}


	@Override
	public int compareTo(Student o) {
		return this.getName().compareTo(o.getName());
	}


}
