package ProjectP;
/**
 * Class for the product product class: a collection of methods that can be used to alter the product
 * it implements the comparable class
 * @author Gabriel Koomson
 * 
 */

public class Product implements Comparable<Product> {
	//instance variables of the class
	String name;
	Integer number;
	String category;
	Boolean avail;
	int numAvail;
	
	//default class constructor
	public Product() {
		
	}
	
	//parameterized class constructor
	public Product(String name, Integer number, String category, Boolean avail, int numAvail) {
		this.name = name;
		this.number = number;
		this.category = category;
		this.avail = avail;
		this.numAvail = numAvail;
	}
	
	//setter methods for the class
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setAvail(Boolean avail) {
		this.avail = avail;
	}
	public void setNumAvail(int num) {
		this.numAvail = num;
	}
	
	//getter methods for the class
	
	public String getName() {
		return this.name;	
	}
	
	public Integer getNumber(){
		return this.number;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public Boolean getAvail() {
		return this.avail;
	}
	
	public int getNumAvail() {
		return this.numAvail;	
	}
	
	//the toString method
	public String toString() {
		return "{ product name: "+this.name+", product number:"+this.number+", product category: "+this.category
				+", product is available: "+ this.avail+" }";
	
	}
	
	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
        return Integer.compare(this.number, o.number);

	}
	 

}
