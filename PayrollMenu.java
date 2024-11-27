import java.util.Scanner;
import java.io.FileNotFoundException;
//Conor
public class PayrollMenu {

	//for payroll menu
	//to start a promotion admin uses setPendingPromotion to set pendingPromotion to true
	//after employee user logs in,
	//before user is prompted to select what actions to take (view payslips, view eployee details etc)
	//check if(pendingPromotion){                                                        //check if theres a pending promotion
	//        if (users next input = accepts){                                            //user is prompted to accept or reject promotion
	//             Promotion.promote(employee title, employee grade);                    //implement promotion if employee accepts
	//        } else { 
	//                setPendingPromotion(false);                                        //set pendingPromotion to false if employee rejects
	//} else if(!pendingPromotion){                                                       //if there is no pending promotion
	//         continue with user actions (view employee details, request payslips etc)   //go to normal user activity
	//}


	private static boolean isDigitsOnly(String str) {    //accepts string as input
		for (char c : str.toCharArray()) {               //loops through each character
			if (!Character.isDigit(c)) {                 //for each character, checks if it is a digit
				return false;                            //returns false if there is a single non digit character
			}
		}
		return true;
	}

	public static void main(String[] args) {   

		//implements scanner
		Scanner in = new Scanner(System.in);

		//asks for user login (employee, admin, hr)
		System.out.println("(0) Employee");
		System.out.println("(1) Admin");
		System.out.println("(2) Human Resources");

		//takes input
		int user_type = in.nextInt();

		//handles illegal inputs
		if(user_type < 0 || user_type > 2){
			throw new IllegalArgumentException("Please enter 0, 1, or 2");
		}

		//Employee	
		if(user_type == 0) {
			System.out.println("Please enter employee id");
			int empId = in.nextInt();
			if(employee.passwordExists(empId)){    
				System.out.println("Please enter password");
				String password = in.next();
				if(password == employee.getPassword()) {    //if password matches the stored password

					//login successful
					System.out.println("Employee Menu:");
					System.out.println("(0) Access Personal Details");
					System.out.println("(1) View Current Month's Payslip");
					System.out.println("(2) View Historic Payslips");

					int choice = in.nextInt();
					if (choice == 0) {
						System.out.println(employee.toString());     
					} 
					else if (choice == 1) {
						//view current months payslip
					} else if (choice == 2) {
						//view historic payslips
					} else {
						//invalid input
						System.out.println("Returning");  
					}
				}


			} else {
				throw exception to say incorrect password       
			}
			else if(!passwordExists(employee id){               //if password does not exist for the given id
				ask for new password                            //get user to set new password
				employee.setPassword(given password)            //invoke setPassword to store new password
			}
		}


		//Admin
		if(user_type == 1){
			System.out.println("Admin Menu:");
			System.out.println("(0) Add Full Time Employee");
			System.out.println("(1) Add Hourly Employee");
			System.out.println("(2) Add Part Time Employee");

			int choice = in.nextInt();

			if(user_type < 0 || user_type > 2){
				throw new IllegalArgumentException("Please enter 0, 1, or 2");
			}

			//adding new employee 
			//enter id
			System.out.println("Please enter employee id");
			int empId = in.nextInt();
			if (empId.length() == 5 && isDigitsOnly(empId)) {   //checks if Id provided is exactly 5 digits
				System.out.println("Employee id is " + empId);
			} else {
				//invalid input
				System.out.println("Returning");
			}

			//enter name
			System.out.println("Please enter employee name");
			String empName = in.next();
			System.out.println("Employee name is " + empName);

			//enter title
			System.out.println("Please enter employee title");
			String empTitle = in.next();
			System.out.println("Employee title is " + empTitle);

			//enter hours for part time and hourly employees
			double empHours;
			if (choice != 0) {
				System.out.println("Please enter the number of hours worked");
				empHours = in.nextDouble();
			}

			//creating employees
			try {
				if (choice == 0) {  // full-Time Employee
					new FullTimeEmployee(empId, empName, empTitle, empHours);
					System.out.println("Added Full-Time Employee");
				} else if (choice == 1) {  // hourly Employee
					new HourlyEmployee(empId, empName, empTitle, empHours);
					System.out.println("Added Hourly Employee");
				} else if (choice == 2) {  // part-Time Employee
					new PartTimeEmployee(empId, empName, empTitle, empHours);
					System.out.println("Added Part-Time Employee");
				}
			} catch (FileNotFoundException e) {                     
				System.out.println("Error: File not found");        //Handles FileNotFound exceptions while attempting to create employees 
			}
		}


		//Human Resources
		if(user_type == 2) {
			System.out.println("Human Resources Menu:");
			System.out.println("(0) Implement Promotion for full-time staff");

			int choice = in.nextInt();
			if(choice == 0) {
				//Promotion for full time staff
			} else {
				System.out.println("Returning");
			}
		}

	}
}

