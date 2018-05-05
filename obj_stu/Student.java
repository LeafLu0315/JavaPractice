import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Student implements StudentInfo {
	private static int scoreSize = 4;
	private String ID,gpa;
	private double scores[] = new double[scoreSize];
	private static double allavg[] = new double[scoreSize];
	
	private double totalsc = 0,avgsc = 0;
	/* Constructor */
	public Student(String ID,double scores[]) {
		this.ID = ID;
		this.scores = scores;
	}
	/* Methods */
	public String getId() {
		return this.ID;
	}
	
	public double[] getStuScore() {
		return this.scores;
	}
	
	public void setStuTtlScore() {
		for(int i=0;i<scoreSize;i++) {
			if(i == 0) this.totalsc += scores[i] * 0.4;
			else this.totalsc += scores[i] * 0.2;
		}
	}
	
	public double getStuTtlScore() {
		return this.totalsc;
	}
	
	public void setStuAvgScore() {
		double sum=0;
		for(int i=0;i<scoreSize;i++) sum+=scores[i];
		this.avgsc = sum/scoreSize;
	}
	
	public double getStuAvgScore() {
		return this.avgsc;
	}
	
	public void setStuGpa() {
		if(this.totalsc >= 98 ) gpa = "A+";
		else if(this.totalsc < 98 && this.totalsc >= 92) gpa = "A";
		else if(this.totalsc < 92 && this.totalsc >= 90) gpa = "A-";
		else if(this.totalsc < 90 && this.totalsc >= 88) gpa = "B+";
		else if(this.totalsc < 88 && this.totalsc >= 82) gpa = "B";
		else if(this.totalsc < 82 && this.totalsc >= 80) gpa = "B-";
		else if(this.totalsc < 80 && this.totalsc >= 78) gpa = "C+";
		else if(this.totalsc < 78 && this.totalsc >= 72) gpa = "C";
		else if(this.totalsc < 72 && this.totalsc >= 70) gpa = "C-";
		else if(this.totalsc < 70 && this.totalsc >= 60) gpa = "D";
		else gpa = "F";
	}
	
	public String getStuGpa() {
		return this.gpa;
	}
	
	public static double[] allStuAvgScore(ArrayList<Student> students) {
		double avg;
		for(int i=0;i<scoreSize;i++) {
			avg = 0;
			for(int j=0;j<students.size();j++) 	avg += students.get(j).scores[i];
			allavg[i] = avg/students.size();
		}
		return allavg;
	}
	
	public static double[] allStuStd(ArrayList<Student> students) {
		double sd[] = new double[scoreSize];
		double sumup = 0,x;
		for(int i=0;i<scoreSize;i++) {
			for(int j=0;j<students.size();j++) {
				x = students.get(j).scores[i] - allavg[i];
				sumup += x * x;
			}
			sd[i] = sumup/students.size();
		}
		return sd;
	}
	
	public static void gradeDistribution(ArrayList<Student> students) {
		int distribution[] = new int[11];
		String[] gpas = {"A+","A","A-","B+","B","B-","C+","C","C-","D","F"};
		for(int i=0;i<11;i++) distribution[i] = 0;
		for(int i=0;i<students.size();i++) {
			switch (students.get(i).gpa) {
			case "A+":
				distribution[0]++;
				break;
			case "A":
				distribution[1]++;
				break;
			case "A-":
				distribution[2]++;
				break;
			case "B+":
				distribution[3]++;
				break;
			case "B":
				distribution[4]++;
				break;
			case "B-":
				distribution[5]++;
				break;
			case "C+":
				distribution[6]++;
				break;
			case "C":
				distribution[7]++;
				break;
			case "C-":
				distribution[8]++;
				break;
			case "D":
				distribution[9]++;
				break;
			case "F":
				distribution[10]++;
				break;
			default:
				break;
			}
		}
		for(int i=0;i<11;i++) System.out.println(gpas[i] +"\t"+distribution[i]);
	}
	
	public static ArrayList<Student> scoreSorting(ArrayList<Student> students, String str) {
		int pos = 0;
		String exams[] = {"Midterm","preQuiz","LabQuiz","HW1"};
		for(int i=0;i<4;i++) System.out.println(exams[i]+"\t");
		for(int i=0;i<students.size();i++) System.out.println(students.get(i).scores[i]);
		System.out.println("Sort by "+ str);
		ArrayList<Student> sorts = new ArrayList<Student>(students);
		for(int i=0;i<4;i++) 
			if(str.equals(exams[i])) {
				pos=i;
				break;
			}
		for(int i=0;i<sorts.size()-1;i++)
			for(int j=i+1;j<sorts.size();j++) 
				if(sorts.get(i).getStuScore()[pos]<sorts.get(j).getStuScore()[pos]) 
					Collections.swap(sorts, i, j);
		return sorts;
	}
	
}