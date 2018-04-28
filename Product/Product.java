
public class Product {
	private int volume,price,totalAmount;
	private String productName;
	public Product(String name,int price) {
		productName = name;
		this.price = price;
		volume = 0;
	}
	
	public Product(String name,int price,int volume){
		productName = name;
		this.price = price;
		this.volume = volume;
	}
	
	public void Purchase(int volume){
		this.volume += volume;
	}
	
	public int Sell(int volume){
		if(this.volume<volume) System.out.println("UNDERSTOCK!");
		else{
			this.volume-=volume;
			totalAmount = this.price * volume;
		}
		return totalAmount;
	}
	
	public String getProductName(){
		return productName;
	}
	
	public String toString(){
		if(volume <= 0) return "Product : "+ productName + " UNDERSTOCK!";
		else return "Product : "+productName+
				"\nPrice : "+price+
				"\nVolume : "+volume;
	}
}
