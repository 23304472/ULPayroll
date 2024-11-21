import java.util.Scanner;
//Conor
public class PayrollMenu {

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
			System.out.println("(3) Back");

			//password system

			int choice = in.nextInt();
			if (choice == 0) {
				System.out.println(emp.toString());     
			} 
			else if (choice == 1) {

			} else if (choice == 2) {

			} else {
				//Didn't choose an action
				System.out.println("Returning");  
			}
		}

		
		
		
		//Admin
		if(user_type == 1){
			System.out.println("Admin Menu:");
			System.out.println("(0) Add Employee");
			System.out.println("(1) Back");

			int choice = in.nextInt();
			if(choice == 0) { 
				//adding new employee
				//enter id
				System.out.println("Please enter employee id");
				String empId = in.next();
				if (empId.length() == 5 && isDigitsOnly(empId)) {
					System.out.println("Employee id is " + empId);
				} else {
					System.out.println("Invalid");
				}
			}

			//enter name
			System.out.println("Please enter employee name");
			String empName = in.next();
			System.out.println("Employee name is " + empName);

			else {
				System.out.println("Returning");          
			}
		}





		//Human Resources
		if(user_type == 2) {
			System.out.println("Human Resources Menu:");
			System.out.println("(0) Implement Promotion for full-time staff");
			System.out.println("(1) Back");

			int choice = in.nextInt();
			if(choice == 0) {
				//Promotion for full time staff
			} else {
				System.out.println("Returning");
			}

		}




























	}

}
