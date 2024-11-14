import java.util.Scanner;
//Conor
public class PayrollMenu {
    
       
    //implements scanner
    Scanner in = new Scanner(System.in);
    //asks for user login (employee, admin, hr)
    System.out.println("(0) Employee");
    System.out.println("(1) Admin");
    System.out.println("(2) Human Resources");

    int user_type = in.nextInt();
    if(user_type != 0 && user_type != 1 && user_type != 2){
        throw new ArithmeticException("Please enter 0, 1 or 2");
    }
    
    if(user_type == 0){
    //1. access personal details
    //2. access this months payslip
    //3. access historic payslip 
        
    }
 
    
    if(user_type == 1){
    //1.create employee
        
    }
   
    
    if(user_type == 2){
    //1.implement promotion
        
    }



    //admin: login, add employee
    //employee - view details, payslips, historic payslips
    //human resources - promotions, send message to employee for confirmation
}
