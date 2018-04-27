import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		String name;
		final int product_size = 100;
		int quantity,price,product_num = 0,id,total=0;
		Scanner scan = new Scanner(System.in);
		Product p[] = new Product[product_size];
		System.out.println("Please input the product name and price(q = quit)");
		while(true){
			name = scan.next();
			if(name.equals("q")) break;
			price = scan.nextInt();
			p[product_num++] = new Product(name, price);
		}
		//êiâ›
		while(true){
			id = -1;
			System.out.println("What product to purchase? (q to quit)");
			name = scan.next();
			if(name.equals("q")) break;
			for(int i=0;i<product_num;i++) 
				if(p[i].getProductName().equals(name)){
					id = i; 
					break;
				}
			if(id == -1){ 
				System.out.println("Product Not Found");
				continue;
			}
			System.out.println("How many "+p[id].getProductName()+" do you want to purchase?");
			quantity = scan.nextInt();
			p[id].Purchase(quantity);
		}
		//ÊÃèo
		while(true){
			System.out.println("What product to be sold?(q = quit)");
			id = -1;
			name = scan.next();
			if(name.equals("q")) break;
			for(int i=0;i<product_num;i++) 
				if(p[i].getProductName().equals(name)){
					id = i; 
					break;
				}
			if(id == -1){ 
				System.out.println("Product Not Found");
				continue;
			}
			System.out.println("How many "+p[id].getProductName()+" do you want to sell?");
			quantity = scan.nextInt();
			total+=p[id].Sell(quantity);
		}
		System.out.println("-------Information--------");
		for(int i=0;i<product_num;i++)
			System.out.println(p[i].toString()+"\n");
		System.out.println("Total Amount = "+total);
		scan.close();
	}

}
