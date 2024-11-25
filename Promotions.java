//Ava
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Promotions {
    //maps each role onto another map which maps a paygrade to its salary
    private Map<String, Map<Integer, Double>> payScaleMap = new HashMap<>();

    //maps  role onto another map that  maps a current pay grade to the next paygrade
    private Map<String, Map<Integer, Integer>> promotionPathMap = new HashMap<>();

    //sets up the promotion system from the paygrade csv
    public Promotions() throws IOException {
       loadPayScaleFromCSV("FullTimeRates.csv");
    }

    //goes through the cvs and gets the paygrades, convert them to ints
    public void loadPayScaleFromCSV(String fileName) throws IOException {
       try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
           String currentLine;
           String currentTitle = null; //when the title is null it means we are onto the next title
           Map<Integer, Double> payScale = null; //clears the info from the last title since we are on nect title now
           Map<Integer, Integer> promotionPath = null; //clears info from last title


           while((currentLine = reader.readLine()) != null) {//read first line
               currentLine = currentLine.trim(); //reads each line until end of paygrades for that job(null line)
               if(currentLine.isEmpty()){ //when we get to the last paygrade for a title (blank line)
                   payScaleMap.put(currentTitle, payScale);
                   promotionPathMap.put(currentTitle, promotionPath); //saves the info from that title
               }
               currentTitle = null;
               payScale = null;
               promotionPath = null;
               continue; //clears everything again to move onto next title

           }
           String[] tokensCurrentLine = currentLine.split(","); //puts the parts of each line (parts are split from eachother where there is a comma) into an array
           if (currentTitle == null) { //if it's null we are onto next title
               currentTitle = tokensCurrentLine[0];
               payScale = new HashMap<>();
               promotionPath = new HashMap<>(); //sets up the new maps for the next title
           }
           int payGrade = Integer.parseInt(tokensCurrentLine[1]); //makes the thing after the first comma an int that represents the paygrade
           double salary = Double.parseDouble(tokensCurrentLine[2]); //makes the thing after the second comma a double that represents the salary
           payScale.put(payGrade, salary); //adds them to payScale

           //gets the paygrades from payscale and creates the mappings from one paygrade onto the next
           if (payScale.size() > 1){ //if there is more than one paygrade for the role
               ArrayList<Integer> grades = new ArrayList<>(payScale.keySet()); //makes an array list containing all paygrades for a title
               grades.sort(Integer::compareTo);
               for (int i = 0; i < grades.size() -1; i++){
                   promotionPath.put(grades.get(i), grades.get(i+1)); //sets the path going from current grade to next grade
               }
           }
           //puts the title with its paygrades and their corresponding salaries as well as the title with possible promotion paths
           if(currentTitle != null && payScale != null){
               payScaleMap.put(currentTitle, payScale);
               promotionPathMap.put(currentTitle, promotionPath);
           }
       }
    }
    public int promote(String title, int currentGrade){
        //checks if title exists, if not throws an exception
        if(!promotionPathMap.containsKey(title)){
            throw new IllegalArgumentException("Title not found: " + title);
        }
        //checks if a higher paygrade for the employee exists, if not the employee is told they are at the top paygrade for their title
        Map<Integer, Integer> promotionPath = promotionPathMap.get(title);
        Map<Integer, Double> payScale = payScaleMap.get(title);
        if(!promotionPath.containsKey(currentGrade)){
            throw new IllegalArgumentException("Employee is at highest paygrade for current title. Employee cannot be promoted further in their current role.");
        }
        int newGrade = promotionPath.get(currentGrade);
        double oldSalary = payScale.get(currentGrade);
        double newSalary = payScale.get(newGrade);

        System.out.println("Employee has been promoted from " + title + ": pay grade" + currentGrade + " to paygrade " + newGrade);
        System.out.println("Previous salary was €" + oldSalary + ", new salary is €" + newSalary);
        return newGrade;
    }

    public boolean pendingPromotion;

    public boolean isPendingPromotion(FullTimeEmployee employee){
        return pendingPromotion;
    }

    public boolean setPendingPromotion(boolean value){
        pendingPromotion = value;
        return pendingPromotion;
    }

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
}
