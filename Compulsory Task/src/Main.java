//Below are all the packages that have been imported.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//Below is the main class containing all code.
public class Main {

	//Below is the customer class and is used to contain the customer object and attributes.
    static class customer 
	
	{
		  int orderNumber;
		  static String customerName;
		  static String contactNumber;
		  static String customerAddress;
		  static String city;
		  static String email;
	}
	
	//Below is the restaurant class and is used to contain the restaurant object and attributes.
    static class restaurant 
    
    {
    	  static String restaurantName;
    	  static String restaurantLocation;
    	  static String contactNumber;
    	  static String orderInfo;
    	  static String specialInstructions;
    	  static String total;
    	  
    	  static String nearestDriver;
    }
    
	//Below is the class that will run first in the program.
	public static void main(String[] args) 
	
	    {
		customerInvoice();
		restaurantInfo();
		drivers();
		invoice();
	    }
	
	
	      
		//Below is the method that takes customer information for the customer object.
		static void customerInvoice()
		
		 {
			System.out.println("Please enter some relevant personal information: \n");

			Scanner Scanner1 = new Scanner(System.in); 
			System.out.println("Enter full name: ");
			String customerName = Scanner1.nextLine();  

			
			Scanner Scanner2 = new Scanner(System.in); 
			System.out.println("\nEnter phone number");
			String phoneNum = Scanner2.nextLine();  

			
			Scanner Scanner3 = new Scanner(System.in);
			System.out.println("\nEnter email: ");
			String email = Scanner3.nextLine(); 

			
			Scanner Scanner4 = new Scanner(System.in);  
			System.out.println("\nEnter delivery address");
			String customerAddress = Scanner4.nextLine(); 

			
			Scanner Scanner5 = new Scanner(System.in); 
			System.out.println("\nEnter location (city): ");
			String location = Scanner5.nextLine();  
			
			customer myObj = new customer();
			myObj.customerName = customerName;
			myObj.contactNumber = phoneNum;
			myObj.customerAddress = customerAddress;
			myObj.city = location;
			myObj.email = email;
			
			System.out.println("\nFull name: " + myObj.customerName);
			System.out.println("Phone number: " + myObj.contactNumber);
			System.out.println("Email: " + myObj.email);
			System.out.println("Delivery Address: " + myObj.customerAddress);
			System.out.println("Location: " + myObj.city);
		}
		    
		//Below is the method that takes restaurant information for the restaurant object.
		static void restaurantInfo() 
		
		{
			
			System.out.println("\nPlease enter your order information: \n");
			
			Scanner Scanner1 = new Scanner(System.in); 
			System.out.println("Enter restaurant name: ");
			String restaurantName = Scanner1.nextLine();

			
			Scanner Scanner2 = new Scanner(System.in);  
			System.out.println("\nEnter location of restaurant (city/town): ");
			String location = Scanner2.nextLine();  

			
			Scanner Scanner3 = new Scanner(System.in);  
			System.out.println("\nEnter contact number of restaurant: ");
			String phoneNum = Scanner3.nextLine(); 

			
		    Scanner Scanner4 = new Scanner(System.in);  
			System.out.println("\nEnter amount of meals being ordered: ");
			String amountOfMeals = Scanner4.nextLine(); 

			
			Scanner Scanner5 = new Scanner(System.in); 
			System.out.println("\nEnter list of items/meals being ordered: ");
			String summary = Scanner5.nextLine();  

			
			Scanner Scanner6 = new Scanner(System.in); 
			System.out.println("\nEnter any special instructions: ");
			String specialInstructions = Scanner6.nextLine();  

			
			Scanner Scanner7 = new Scanner(System.in); 
			System.out.println("\nEnter total: ");
			String total = Scanner7.nextLine();  
			
			restaurant myRestaurant = new restaurant();
			
			myRestaurant.restaurantName = restaurantName;
			myRestaurant.restaurantLocation = location;
			myRestaurant.contactNumber = phoneNum;
			myRestaurant.orderInfo = summary;
			myRestaurant.specialInstructions = specialInstructions;
		    myRestaurant.total = total;

			System.out.println("\nRestaurant: " + myRestaurant.restaurantName);
			System.out.println("Location: " + myRestaurant.restaurantLocation);
			System.out.println("Phone number: " + myRestaurant.contactNumber);
			System.out.println("Amount of each order: " + amountOfMeals);
			System.out.println("Summary of: " + myRestaurant.orderInfo);
			System.out.println("Special instructions: " + myRestaurant.specialInstructions);
			System.out.println("Total: " + myRestaurant.total);
		    
		}	
		
		static void drivers() {
			
//			Below is the try - catch block that reads the lines from the txt file containing delivery drivers information.
			BufferedReader reader;
					
					try {
						reader = new BufferedReader(new FileReader("src/drivers.txt"));
						
						//Below is the variable used to access each line of text in the file.
						String line = reader.readLine();
						//Below there is an arrayList initialized that is used to store each drivers information. 
						ArrayList<String> lines = new ArrayList<String>();
						//Below is the arrayList used to store matched drivers.
						ArrayList<String> matchedDrivers = new ArrayList<String>();
						
						 ArrayList<String> deliveryLoads = new ArrayList<>();
						 
						 HashMap<String, Integer> driverLoads = new HashMap<String, Integer>();
						 
						 
						 
						 
						
						
						//Below is a while loop that iterates while there is still a next line of text in the file. 
						while (line != null) {
							lines.add(line);
							// read next line
							line = reader.readLine();
						}
						
						reader.close();
						
						//Below is the for loop that accesses and adds each appropriate drivers information from the arrayList.
						for(int i = 0;i<lines.size();i++) {
							
							String driver = lines.get(i);
							boolean match = driver.contains(restaurant.restaurantLocation);
							
							if(match == true) {
								matchedDrivers.add(driver);
							}
						}
						
						//Below is for loop that iterates you matchedDrivers and separates the drivers information into name and current load
						//then the driverLoads map is populated with this new information of the drivers.
						for(int i = 0;i<matchedDrivers.size();i++) {
							String mDriver = matchedDrivers.get(i);
							
							String[] drivers = mDriver.split(",");
							
							String LOADZ = drivers[2];
							
							String pureLoad = LOADZ.substring(1);
							
							int currentLoad = Integer.parseInt(pureLoad);
							
							driverLoads.put(drivers[0],currentLoad);
							
                            String driverLocation = drivers[1];
                            
                            String pureDriverLocation = driverLocation.substring(1);
							
							restaurant.nearestDriver = pureDriverLocation;

						        
						     }				
						
						
						//Below is for loop that iterates through the keys of the driverLoads map.
						for (String i : driverLoads.keySet()) {
//							  System.out.println(i);
						}
						//Below is for loop that iterates through the values of the driverLoads map.
						for (Integer i : driverLoads.values()) {
//							System.out.println(i);
						}
						
						//Below is the integer variable that finds the lowest value in the driverLoads map 
						int min = Collections.min(driverLoads.values());
						
//					    System.out.println(min);
							  
					    //For loop that searches the values for the min variable to identify the driver with the lowest load.
					    for(java.util.Map.Entry<String, Integer> entry: driverLoads.entrySet()) {

					    	//Below is the if statement that check which driver has the lowest load. 
					        if(entry.getValue() == min) {
					          System.out.println("The driver that will deliver your order is " + entry.getKey());
					          break;
					        }
						
					    }
						
					    } catch (IOException e) {
						e.printStackTrace();
					    }
					
		}
					
				    
					  //Below is the method that prints the customers invoice to a newly created file based on their personal and order information.
		              static void invoice() 
		              
		              {
		            	  
		            	  String customerLocation = customer.city;
		                  String driverLocation = restaurant.nearestDriver;
		            	  
		                  //This is the if statement that checks if the drivers are in the same area as the customer. 
		            	  if (customerLocation.equals(driverLocation)) {
		            		try {
		            	    File myObj = new File("src/Invoice.txt");
		            	    if (myObj.createNewFile()) {
		            	      System.out.println("File created: " + myObj.getName());
		            	    } else {
		            	      System.out.println("File already exists.");
		            	    }
		            	  } catch (IOException e) {
		            	    System.out.println("An error occurred.");
		            	    e.printStackTrace();
		            	  }

		            	  try {
		            		      FileWriter myWriter = new FileWriter("src/Invoice.txt");
		     
		            			myWriter.write("Order Number: " + 
		            			               "\nCustomer: " + customer.customerName +
		            			               "\nEmail: " + customer.email +
		            			               "\nPhone Number: "+ customer.contactNumber +
		            			               "\nLocation: " + customer.city +      			               
		            			               "\n \nYou have ordered the following from " + restaurant.restaurantName + " in " + restaurant.restaurantLocation + ":\n"
		            			                + restaurant.orderInfo +
		            			                "\n \nSpecial Instructions: " + restaurant.specialInstructions +
		            			                "\nTotal: " + restaurant.total +
		            			                "\n \n" + restaurant.nearestDriver + " is your nearest driver and so he will be delivering your order to you at: \n" + customer.customerAddress +
		            			                "\n \nIf you need to contact the restaurant their number is: " + restaurant.contactNumber);
		            		      myWriter.close();
		            		    } catch (IOException e) {
		            		      System.out.println("An error occurred.");
		            		      e.printStackTrace();
		            		    }		            	
		            		} else {
		            			try {
		            			    File myObj = new File("src/Invoice.txt");
		            			    if (myObj.createNewFile()) {
		            			      System.out.println("File created: " + myObj.getName());
		            			    } else {
		            			      System.out.println("File already exists.");
		            			    }
		            			  } catch (IOException e) {
		            			    System.out.println("An error occurred.");
		            			    e.printStackTrace();
		            			  }

		            			try {
		            			    FileWriter myWriter = new FileWriter("src/Invoice.txt");
		            			   
		            				myWriter.write("We're sorry, our drivers are too far away from you to be able to drive to your location.");
		            			    myWriter.close();
		            			  } catch (IOException e) {
		            			    System.out.println("An error occurred.");
		            			    e.printStackTrace();
		            			  }
		                   }
 }
}
		              
		            	  
		        
					
		
		            	  
		              
		

		            	  
		              


			

		    

		    
		    
		    
			

		    
		
		    
		    
			
		   
		    
		    
			

		    


		    
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		