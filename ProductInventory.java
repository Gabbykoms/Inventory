package ProjectP;
/**
 * Class for the product inventory class: a collection of methods that can be used to alter the product inventory
 * it extends the LinkedPositionalList class
 * It also has the main method to interact with users
 * @author Gabriel Koomson
 * 
 */
import java.util.*;



public class ProductInventory extends LinkedPositionalList<Product> {
	
	//instance variables
		String compName;
		static LinkedPositionalList<Product> list = new LinkedPositionalList<Product>();
		static int size = 0;
		
		public static void main(String[] args) {
			Scanner sn = new Scanner(System.in);
			System.out.print("What is your company name? :");
			String comp = sn.next();
			System.out.println("Welcome to "+comp+"!");
			Integer cont;
			
			do {		
				//I use a do-while loop to make sure I keep activity unless the user quits
				//if the user enters an invalid input for the activity number, they're asked to select another activity or quit
			System.out.println("Choose an option by number from the list of activities below to begin with");
			System.out.println(" "+1+" insert new product. \n "+2+" remove product from inventory \n "+3+" display products by unique numbers in inventory \n "+
					 4+" find if product is available in inventory \n "+5+" display all product from inventory \n " +6+" list top 5 recently searched products \n");
			System.out.print("activity number: ");
			int ans = sn.nextInt();
			if(ans == 1) {
				insert();
				}
			else if(ans == 2) {
				System.out.print("Enter the product number: ");
				Integer prodNum = sn.nextInt();
				remove(prodNum);
			}
			else if(ans == 3) {
				System.out.println("the products are displayed by their numbers as follows");
				display();
				}
			else if(ans == 4) {
				System.out.print("Enter the product number: ");
				Integer prodNum = sn.nextInt();
				find(prodNum);
				}
			else if(ans == 5) {
				System.out.println("All available products are displayed as follows: ");
				displayAvailable();
				}
			else if(ans == 6) {
				//placeholder
				//System.out.print("All available products are displayed as follows");
				//displayAvailable();
				}
			
			
			System.out.println("Press 0 if you'd like to quit else press any number and choose another activity: ");
			 cont = sn.nextInt();
			}while(cont != 0);
			

		}
	//method implementations
	/* This methods take information from the user and uses it to create a new product
	 * the newly created product is then inserted into the product inventory list/*
	 */
		public static void insert() {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the product name: ");
			String name = input.next();
		    input.nextLine(); 

			System.out.print("Enter the product number: ");
			Integer num ;
			try{
				num= input.nextInt();
			}catch(InputMismatchException e){
		        System.out.println("Please enter a valid integer for product number.");
		        return;
		        }
			System.out.print("Enter the product category: ");
			String cate = input.next();
			System.out.print("Enter 1 if this product is available else enter 0: ");
			Integer ans;
			try{
				ans= input.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Please enter either 0 or 1 for availability.");
		        return;
				
			}
			
			//delimiters
			Boolean avail;
			int numAvail = 0;
			if(ans == 1) {avail = true;}
			else {avail = false;}
			
			if(ans == 1) {
				System.out.print("how many items are available?: ");
				try {
				numAvail = input.nextInt();
				while(numAvail <0) { // this while loop is to ensure the user doesn't enter negative for number of products
					System.out.println("Item can not be less than 0");
					System.out.println("Re-enter number available : ");
					numAvail = input.nextInt();
				}
			}catch(InputMismatchException e) {
				System.out.println("Please enter a valid number for number of items available.");
		        return;
				}
				
			}
			//create a new product with the provided information and store in the positionalLinkedList
			Product p1 = new Product(name, num, cate, avail, numAvail);
			
			if(list.isEmpty()) {
				list.addFirst(p1);
			}
			else {
				 if(p1.compareTo(list.last().getElement())>0){
					 list.addLast(p1); 
					 
				 }else {
					 list.addBefore(list.last(), p1);
				 }
			}
			size++;
			
		}
		/*This method takes a product number of any product from the user
		 * if the product is found, it is removed from the product inventory list*/
		public static void remove(Integer prodNum) {
			 //TO DO
			Position<Product> traversalNode = list.first(); 
			Position<Product> current = traversalNode;
			while(current != null && current != list.trailer ) {
				if(current.getElement().number == prodNum) {
					System.out.println("Now removing "+current.getElement().getName());
					Position<Product> toRemove = current;
					current = list.after(current);
					list.remove(toRemove);
					size--;
					System.out.println("Item "+toRemove.getElement().getName()+"removed!");
					return;
					
				}
				current = list.after(current);
			}
			//System.out.println("Item not found");
			 
		 }
		
		public static void display() {// method displays the available products by their unique product numbers
			Position<Product> traversalNode = list.first(); 
			Position<Product> current = traversalNode;
			while(current != null && current != list.trailer ) {		
					System.out.println(current.getElement().getNumber());
					current = list.after(current);
			}			
		}
		
		/* this method displays all the available product and their particulars details
		 * including how many each of them is in the list*/
		public static void displayAvailable() {
			Position<Product> traversalNode = list.first(); 
			Position<Product> current = traversalNode;
			if(size == 0) {
				System.out.println("The inventory is empty");
				return;
			}
			
			while(current != null && current != list.trailer ) {
				Product prod = current.getElement();
				 Product product = current.getElement();
			        System.out.println("Product Name: " + product.getName());
			        System.out.println("Product Number: " + product.getNumber());
			        System.out.println("Product Category: " + product.getCategory());
			        System.out.println("Product Availability: " + (product.getAvail() ? "Available" : "Not Available"));
			        if (product.getAvail()) {
			            System.out.println("Number Available: " + product.getNumAvail());
			        }
			        System.out.println();
					current = list.after(current);
			}	
				
		}
		
		/* this method is used for finding product if they're available in the inventory*/
		public static void  find(Integer prodNum) {
			//Position<Product> traversalNode = list.first(); 
			//temporary node that points to the head
			Position<Product> current = list.first();
			while(current != null && current != list.trailer ) {
				if(current.getElement().getNumber().equals(prodNum)) {
		           System.out.println("Product with number " + prodNum + " found in inventory.");
					return ;
				}
				current = list.after(current);
			}
	           System.out.println("Product with number " + prodNum + " not found in inventory.");

		}
		
		/*this method is to find and return the 5 most recently searched elements*/
		public static void topSearched() {
			//TO DO
			/* Instantiate a linkedStack object to store a copy of any searched product
			 * Instantiate a temporary linkedStack
			 * Store a copy of the products in the original in the temporary stack.
			 * pop the first five elements from the temporary stack and print them
			 * */
			
			
			
		}


}
