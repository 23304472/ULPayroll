import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
//Conor
public class PayrollMenu {


    public static void main(String[] args) throws IOException {

        Employee[] employee = new Employee[5];
        FullTimeEmployee emp1 = new FullTimeEmployee(12345, "Michael Watson", "Lecturer");
        emp1.setPendingPromotion(true);
        employee[0] = emp1;

        //implements scanner
        Scanner in = new Scanner(System.in);

        //asks for user login (employee, admin, hr)
        System.out.println("(0) Employee");
        System.out.println("(1) Admin");
        System.out.println("(2) Human Resources");

        //takes input
        int user_type = in.nextInt();

        //handles illegal inputs
        if(user_type < 0 || user_type > 2) {
            throw new IllegalArgumentException("Please enter 0, 1, or 2");
        }

        //Employee
        if (user_type == 0) {
            System.out.println("Please enter employee id");
            int empId = in.nextInt();
            Employee loggedInEmployee = null;
            for (Employee emp : employee) {
                if ( emp != null && emp.getId() == empId) {
                    loggedInEmployee = emp;
                    break;
                }
            }
            if (loggedInEmployee == null) {
                System.out.println("Employee not found. Please try again");
                return;
            }


            System.out.println("Please enter password");
            String password = in.next();

            if (password.equals(loggedInEmployee.getPassword())) {
                //check for pending promotion
                if (Employee.isPendingPromotion()) {    //if password matches the stored password
                    //login successful
                    //first check if there is a pending promotion
                    boolean validChoice = false; //flag to determine if a valid choice has been made
                    while (!validChoice) { //loop until a valid choice is made
                        System.out.println("You have been offered a promotion");
                        System.out.println("(0) Accept Promotion");
                        System.out.println("(1) Reject Promotion");

                        int promotionChoice = in.nextInt();


                        if (promotionChoice == 0) {
                            int newGrade = Promotions.promote(loggedInEmployee.getTitle(), loggedInEmployee.getPayGrade()); //implement promotion if employee accepts
                            loggedInEmployee.setPayGrade(newGrade);
                            loggedInEmployee.setPendingPromotion(false);
                            validChoice = true; //exit the loop as the choice is valid
                        } else if (promotionChoice == 1) {
                            System.out.println("Are you sure you want to reject the promotion?");
                            System.out.println("(0) Yes");
                            System.out.println("(1) No");

                            int rejectionChoice = in.nextInt();

                            if (rejectionChoice == 0) {
                                loggedInEmployee.setPendingPromotion(false); //set pendingPromotion to false if employee rejects
                                System.out.println("Promotion rejected.");
                                validChoice = true; //exit the loop as the choice is valid
                            } else if (rejectionChoice == 1) {
                                System.out.println("Returning to promotion decision.");
                                //Do not set validChoice to true; the loop will restart
                            }else{
                                System.out.println("Invalid choice. Please enter 0 or 1.");
                            }
                        }else{
                            System.out.println("Invalid input. Please enter 0 or 1.");
                        }
                    }
                        //continue to employee menu
                        System.out.println("Employee Menu:");
                        System.out.println("(0) Access Personal Details");
                        System.out.println("(1) View Current Month's Payslip");
                        System.out.println("(2) View Historic Payslips");

                        int choice = in.nextInt();
                        if (choice == 0) {
                            System.out.println(employee[0].toString());
                        } else if (choice == 1) {
                            //view current months payslip
                        	double grosspay = employee[0].getGrossPay();
                        	try {
                        	Payslip payslip = new Payslip(employee[0], grosspay)
                        	System.out.println(payslip);
                        	} catch (FileNotFoundException e) {
                                System.err.println("Error reading salary information: " + e.getMessage());
                            }
                        } else if (choice == 2) {
                            //view historic payslips
                        	
                        } else {
                            //invalid input
                            System.out.println("Returning");
                        }

                } else if (!employee[0].passwordExists(empId)) { //if password does not exist for the given id
                    //ask for new password
                    System.out.println("Please enter a new password");
                    String newPassword = in.next();
                    employee[0].setPassword(newPassword); //invoke setPassword to store new password
                } else {
                    throw new IllegalArgumentException("Incorrect Password");
                }
            }
        }

        double empHours = 0.0;
        //Admin
        if(user_type == 1) {
            System.out.println("Admin Menu:");
            System.out.println("(0) Add Full Time Employee");
            System.out.println("(1) Add Hourly Employee");
            System.out.println("(2) Add Part Time Employee");

            int choice = in.nextInt();

            if(user_type < 0 || user_type > 2) {
                throw new IllegalArgumentException("Please enter 0, 1, or 2");
            }

            //adding new employee
            //enter id
            System.out.println("Please enter employee id");
            int empId = in.nextInt();
            if (empId >= 10000 && empId <= 99999) {   //checks if Id provided is exactly 5 digits
                System.out.println("Employee id is " + empId);
            } else {
                //invalid input
                System.out.println("Invalid id, must be exactly 5 digits");
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

            if (choice != 0) {
                System.out.println("Please enter the number of hours worked");
                empHours = in.nextDouble();
            }

            //creating employees
            try {
                if (choice == 0) {  //full-Time Employee
                    new FullTimeEmployee(empId, empName, empTitle);
                    System.out.println("Added Full-Time Employee");
                } else if (choice == 1) {  //hourly Employee
                    new HourlyEmployee(empId, empName, empTitle, empHours);
                    System.out.println("Added Hourly Employee");
                } else if (choice == 2) {  //part-Time Employee
                    new PartTimeEmployee(empId, empName, empTitle, empHours);
                    System.out.println("Added Part-Time Employee");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found"); //Handles FileNotFound exceptions while attempting to create employees
            }
        }


        //Human Resources
        if(user_type == 2) {
            System.out.println("Human Resources Menu:");
            System.out.println("(0) Promote all employees to next paygrade");
            System.out.println("(1) Promote employee to new title");


            int choice = in.nextInt();
            if(choice == 0) {
                if (SystemDate.getSystemDate().getMonthValue() == 10){
                    try{
                        Promotions promotions = new Promotions();
                        List<Employee> allEmployees = new ArrayList<>(List.of(employee)); //turns the array into a list
                        promotions.promoteAllEmployees(allEmployees);
                        System.out.println("All eligible employees have been offered promotions");
                    }catch (IOException e){
                        System.out.println("Error promoting employees: request failed" + e.getMessage());
                    }
                }else{
                    System.out.println("Promotions can only be processed in October: request failed.");
                }
            }
            else if(choice == 1) {
                TitlePromotion titlePromotion = new TitlePromotion();
                Promotions promotions = new Promotions();

                System.out.println(" Enter the id number of the employee you want to promote");
                int empId = in.nextInt();

                Employee empToPromote = null;
                for (Employee emp : employee) {
                    if (emp != null && emp.getId() == empId) {
                        empToPromote = emp;
                        break;
                    }
                }
                if (empToPromote == null) {
                    System.out.println("Employee not found. Returning to menu, please try again");
                    return;
                }

                System.out.println("Employee selected for title promotion: "+ empToPromote.getTitle() + "-" + empToPromote.getTitle());
                System.out.println("Enter employee's new title:");
                String newTitle = in.next();

                String currentTitle = empToPromote.getTitle();
                int currentGrade = empToPromote.getPayGrade();

                String promotionResult = titlePromotion.promoteToNewTitle(currentTitle, newTitle, currentGrade);

                System.out.println(promotionResult);
            }
        }


    }
}
