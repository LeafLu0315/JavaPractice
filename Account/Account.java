
public class Account {
	/*
	 * public : 全部的class都可以用的變數
	 * private : 只有宣告private的class內才可用到
	 * ex: private int balance 不可在 Test.java 使用
	 * 	   public int balance 可在Test.java 使用
	 */
	private String name,id;
	public int balance;
	/*Constructor 建構子: 名稱需與class名(line 2)一樣
	 * Account(這裡的參數看有甚麼條件)
	 */
	Account(String name,String id,int balance){
		this.name = name;	//line 9 name = line 14 name 即method的引數指派給line 9 的變數
		this.id = id;
		this.balance = balance;
	}

	public Account(String name,String id) {
		this.name = name;
		this.id = id;
		this.balance = 0;
	}
	//存錢 不須傳回值
	public void deposit(int money){
		//防呆
		if(money < 0) System.out.println("Error number of money");
		else this.balance += money;
	}
	//提款
	public void withdraw(int money){
		//防呆
		if(money < 0) System.out.println("Error number of money");
		else this.balance -= money;
	}
	//傳回主函式目前的金錢數(int)
	public int getBalance(){
		return this.balance;
	}
	//轉帳 從a帳戶轉money至某人(b)帳戶
	public void transfer(Account a,int money){
		//防呆
		if(money < 0) System.out.println("Error number of money");
		else if(money > a.balance) System.out.println("Not enough money");
		else{
			//a - money
			a.balance -= money;
			//b + money
			this.balance += money;
		}
	}
	//印出所有訊息
	public String toString(){
		return "Name = "+this.name+
			    "\nID = "+this.id+
			    "\nBalance = "+this.balance+"\n";
		// = return String.format("Name = %s\nID = %s\nBalance = %d\n",this.name,this.id,this.balance)
	}
}
