import java.util.Scanner;
//Conor
public class PayrollMenu {

	//payroll menu asks for employee id
    //check if(passwordExists(employee id)){
    //          if password == employee.getPassword(){          //if password matches the stored password
    //              successful login (select next action)
    //           } else {
    //          throw exception to say incorrect password       
    //          }
    //} else if(!passwordExists(employee id){                   //if password does not exist for the given id
    //          ask for new password                            //get user to set new password
    //          employee.setPassword(given password)            //invoke setPassword to store new password
    //}

	private static boolean isDigitsOnly(String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
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

		//password system. should passwords be a variable attached to each user object?

		//handles illegal inputs
		if(user_type < 0 || user_type > 2){
			throw new IllegalArgumentException("Please enter 0, 1, or 2");
		}

		//Employee
		if(user_type == 0){
			System.out.println("Employee Menu:");
			System.out.println("(0) Access Personal Details");
			System.out.println("(1) View Current Month's Payslip");
			System.out.println("(2) View Historic Payslips");


			int choice = in.nextInt();
			if (choice == 0) {
				System.out.println(emp.toString());     
			} 
			else if (choice == 1) {
				//view current months payslip
			} else if (choice == 2) {
				//view historic payslips
			} else {
				//Invalid input
				System.out.println("Returning");  
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
			if (empId.length() == 5 && isDigitsOnly(empId)) {
				System.out.println("Employee id is " + empId);
			} else {
				//Invalid input
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
				if (choice == 0) {  // Full-Time Employee
					new FullTimeEmployee(empId, empName, empTitle, empHours);
					System.out.println("Added Full-Time Employee");
				} else if (choice == 1) {  // Hourly Employee
					new HourlyEmployee(empId, empName, empTitle, empHours);
					System.out.println("Added Hourly Employee");
				} else if (choice == 2) {  // Part-Time Employee
					new PartTimeEmployee(empId, empName, empTitle, empHours);
					System.out.println("Added Part-Time Employee");
				}
			} catch (FileNotFoundException e) {
				System.out.println("Error");
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
