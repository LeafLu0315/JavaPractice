import java.util.ArrayList;
import java.util.Collections;

public class Student extends GlobalVar implements StudentInfo {
	private String ID,gpa;
	private double Scores[] = new double[scoreSize];
	private double StuTtlScore = 0,StuAvgScore = 0;
	/* Constructor */
	public Student(String ID,double Scores[]) {
		this.ID = ID;
		for(int i=0;i<scoreSize;i++) this.Scores[i] = Scores[i];
	}
	/* Methods */
	public String getId() {
		return this.ID;
	}
	
	public double[] getStuScore() {
		return this.Scores;
	}
	
	public void setStuTtlScore() {
		StuTtlScore += this.Scores[0] * 0.4;
		for(int i = 1;i<scoreSize;i++) StuTtlScore += this.Scores[i] * 0.2;
	}
	
	public double getStuTtlScore() {
		return StuTtlScore;
	}
	
	public void setStuAvgScore() {
		int nonZero = scoreSize;
		for(int i=0;i<scoreSize;i++) {
			if(this.Scores[i] == 0) nonZero--;
			StuAvgScore += this.Scores[i];
		}
		if(nonZero > 0) StuAvgScore /= nonZero;
		else StuAvgScore = 0;
	}
	
	public double getStuAvgScore() {
		return StuAvgScore;
	}
	
	public void setStuGpa() {
		if(StuTtlScore >= 98) gpa = GPA[0];
		else if(StuTtlScore >= 92 && StuTtlScore < 98) gpa = GPA[1];
		else if(StuTtlScore >= 90 && StuTtlScore < 92) gpa = GPA[2];
		else if(StuTtlScore >= 88 && StuTtlScore < 90) gpa = GPA[3];
		else if(StuTtlScore >= 82 && StuTtlScore < 88) gpa = GPA[4];
		else if(StuTtlScore >= 80 && StuTtlScore < 82) gpa = GPA[5];
		else if(StuTtlScore >= 78 && StuTtlScore < 80) gpa = GPA[6];
		else if(StuTtlScore >= 72 && StuTtlScore < 78) gpa = GPA[7];
		else if(StuTtlScore >= 70 && StuTtlScore < 72) gpa = GPA[8];
		else if(StuTtlScore >= 60 && StuTtlScore < 70) gpa = GPA[9];
		else if(StuTtlScore < 60) gpa = GPA[10];
	}
	
	public String getStuGpa() {
		return gpa;
	}
	
	public static double[] allStuAvgScore(ArrayList<Student> stu) {
		for(int i=0;i<scoreSize;i++) {
			for(int j=0;j<stu.size();j++)
				allavg[i] += stu.get(j).getStuScore()[i];
			allavg[i] /= stu.size();
		}
		return allavg;
	}
	
	public static double[] allStuStd(ArrayList<Student> stu) {
		for(int i=0;i<scoreSize;i++) {
			for(int j=0;j<stu.size();j++)
				std[i] += Math.pow(stu.get(j).getStuScore()[i]-allavg[i], 2);
			std[i] = Math.sqrt(std[i]/stu.size());
		}
		return std;
	}
	
	public static void gradeDistribution(ArrayList<Student> stu) {
		for(int i=0;i<stu.size();i++)
			for(int j=0;j<Gpasize;j++) 
				if(stu.get(i).getStuGpa().equals(GPA[j])) {
					distribution[j]++;
					break;
				}
		for(int i=0;i<Gpasize;i++) System.out.println(GPA[i] + "\t" + distribution[i]);
	}
	
	public static ArrayList<Student> scoreSorting(ArrayList<Student> stu,String s) {
		ArrayList<Student> sortingList = new ArrayList<Student>(stu);
		int pos = findTitlePos(s);
		printTitle();
		printAllScores(stu);
		System.out.println("Sort by : "+ s);
		sorting(sortingList,pos);
		printTitle();
		printAllScores(sortingList);
		return sortingList;
	}
	
	private static void printTitle() {
		for(int i=0;i<scoreSize;i++) System.out.print(title[i]+"\t");
		System.out.print("\n");
	}
	
	private static void printAllScores(ArrayList<Student> stu) {
		for(int i=0;i<scoreSize;i++) {
			for(int j=0;j<stu.size();j++)
				System.out.print(stu.get(j).getStuScore()[i]+"\t");
			System.out.print("\n");
		}
	}
	
	private static int findTitlePos(String s) {
		for(int i=0;i<scoreSize;i++)
			if(title[i].equals(s)) return i;
		return 0;
	}
	
	private static void sorting(ArrayList<Student> stu,int pos) {
		for(int i=0;i<stu.size()-1;i++)
			for(int j=i+1;j<stu.size();j++)
				if(stu.get(i).getStuScore()[pos] < stu.get(j).getStuScore()[pos])
					Collections.swap(stu, i, j);
	}
}
