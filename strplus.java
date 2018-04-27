import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		//input 12345 => output 6 (1+2+3+4+5=15,1+5=6)
		String str;
		Scanner scan = new Scanner(System.in);
		System.out.println("Input the number : (q to quit)");
		while(true){
			str = scan.nextLine();
			if(str.equals("q")) break;
			System.out.println(strplus(str));
		}
		scan.close();
	}
	
	public static int strplus(String s){
		int sum=0;
		char[] str = s.toCharArray();
		for(int i=0;i<str.length;i++) sum+=str[i]-'0';
		while(sum/10 > 0) sum = sum/10 + sum %10;
		return sum;
	}

}
