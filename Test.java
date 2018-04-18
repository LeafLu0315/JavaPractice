import java.util.Scanner;
public class Test {
	final static int maxsize = 10000;
	static int score[] = new int[maxsize];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int index = 0;
		float average;
		boolean flag = true;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the scores (-1 will be the end):");
		while(true){
			int input = scan.nextInt();
			if(input == -1) break;
			score[index++] = input;
		}
		scan.close();
		if(improving(index)) flag = true;
		else flag = false;
		average = avg(index);
		System.out.println("The min score is = "+minScore(index));
		System.out.println("The max score is = "+maxScore(index));
		System.out.println("The average score is = "+average);
		if(flag) System.out.println("The score improves!!");
		else System.out.println("The score didn't improves");
		System.out.println("The standard deviation is = "+standarddeviation(index,average));
		System.out.println("The adjusted score is = " + adjusted(average));
	}
	
	public static boolean improving(int length){
		for(int i=0;i<length-1;i++) 
			if(score[i]>=score[i+1]) return false;
		return true;
	}
	
	public static int minScore(int length){
		int min = score[0];
		for(int i=0;i<length;i++) if(min > score[i]) min = score[i];
		return min;
	}
	
	public static int maxScore(int length){
		int max = score[0];
		for(int i=0;i<length;i++) if(max < score[i]) max = score[i];
		return max;
	}
	
	public static float avg(int length){
		float sum = 0;
		for(int i = 0;i < length;i++) sum += score[i];
		return sum/length;
	}
	
	public static float squareRoot(float a){
		float up=0,down,x=0;
		int i;
		for(i=0;i*i<=a;i++){
			if(i*i==a) return i;
			up=i;
		}
		down = i;
		for(x=(up+down)/2;abs(x*x-a)>0.000001;x = (up+down)/2){
			if(x * x < a){ 
				up = x; 
				x = (down + x)/2;
			}
			else{
				down = x;
				x = (up + x)/2;
			}
		}
		return x;
	}
	
	public static float abs(float a){
		if(a < 0) return -a;
		return a;
	}
	
	public static float power(float x,int y){
		float ans=1;
		for(int i=0;i<y;i++) ans*=x;
		return ans;
	}
	
	public static float standarddeviation(int length,float average){
		float sd=0;
		for(int i=0;i<length;i++) sd+=power((score[i]-average),2);
		return squareRoot(sd/(length-1));
	}
	
	public static float adjusted(float average){
		return squareRoot(average) * 10;
	}
}
