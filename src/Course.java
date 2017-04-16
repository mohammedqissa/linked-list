
public class Course implements Comparable<String>{
	
	String cName;
	String cID;
	int year;
	int start;
	int finish;
	int max;

	LinkedList students = new LinkedList();

	public Course(String cName, String cID, int year, String start, String finish, int max) {

		this.cName = cName;
		this.cID = cID;
		this.year = year;
		this.start = getMinutes(start);
		this.finish = getMinutes(finish);
		this.max = max;

		
	}

	public int getMinutes(String oclock){

	    String[] hm = oclock.split(":");

	    int hours = Integer.parseInt(hm[0])*60;
	    int minutes = Integer.parseInt(hm[1]);

	    return hours+minutes;
    }

    public String getOclock(int oclock){
	    return oclock/60+":"+oclock%60;
    }


    public String toString(){
        return cName+", "+cID;
    }

    @Override
    public int compareTo(String o) {
        return this.cID.compareTo(o);
    }
}
