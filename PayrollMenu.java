import java.util.Scanner;
//Conor
public class PayrollMenu {
    
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
    if(userType < 0 || userType > 2){
    	throw new IllegalArgumentException("Please enter 0, 1, or 2");
    }
    
    //Employee 
    if(user_type == 0){
    	  System.out.println("Employee Menu:");
          System.out.println("(0) Access Personal Details");
          System.out.println("(1) View Current Month's Payslip");
          System.out.println("(2) View Historic Payslips");
          System.out.println("(3) Back");

          int choice = in.nextInt();
          if (choice == 0) {
             System.out.println(emp.toString());     
          } 
          else if (choice == 1) {
             
          } else if (choice == 2) {
             
          } else {
            System.out.println("Returning");  
          }
    //Admin
    if(user_type == 1){
        System.out.println("Admin Menu:");
        System.out.println("(0) Add Employee");
        System.out.println("(1) Back");

        int choice = in.nextInt();
        if(choice == 0) { 
        //Adding new Employee
        } else {
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
}
