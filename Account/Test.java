import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String n,d;	//name and id
		int b;	//balance
		Scanner scan = new Scanner(System.in);
		System.out.println("請依序輸入名字,ID,錢 : ");
		n = scan.nextLine();	//input name
		d = scan.nextLine();	//input id
		b = scan.nextInt();		//input money in an account
		//建立物件 a的帳戶
		Account a = new Account(n,d,b);
		System.out.println(a.balance);	//若Account.java的balance為public 則這行有效 若為private則無效
		int de,wi;	//存錢 取錢
		System.out.println(a.toString());	//目前的狀態
		System.out.println("存多少錢?");
		de = scan.nextInt();
		a.deposit(de);	//a帳戶存de錢
		System.out.println(a.getBalance());	//目前多少錢
		System.out.println("取多少錢?");
		wi = scan.nextInt();
		a.withdraw(wi);	//a帳戶取wi錢
		System.out.println(a.getBalance());	//目前多少錢
		System.out.println("---------轉帳前---------");	
		System.out.println(a.toString());	//目前的狀態
		Account Liam = new Account("Liam","RRR-777",5000); //建立Liam的帳戶
		System.out.println(Liam.toString());	//目前Liam的狀態
		System.out.println("---------轉帳後---------");	
		a.transfer(Liam, 1000);	//Liam轉帳1000元給a
		System.out.println(a.toString());	//目前a的狀態
		System.out.println(Liam.toString());	//目前Liam的狀態
	}

}
