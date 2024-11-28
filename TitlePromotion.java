import java.util.Map;

public class TitlePromotion {
    //ref to promotions class
    private Promotions promotions;

    public void titlePromotion(Promotions promotions){
        this.promotions = promotions;
    }

    public String promoteToNewTitle(String currentTitle, String newTitle, int currentGrade){
        //checks if new title exists
        if(!promotions.getTitlesList().contains(newTitle)){
            return "Request failed: Job title does not exist. Please try again.";
        }
        Map<Integer, Double> currentTitlePayScale = promotions.getPayScaleMap().get(currentTitle); //gets the payscale for teh current role
        int highestPayGrade = currentTitlePayScale.keySet().stream().max(Integer::compare).orElse(-1); //finds the highest paygrade for the current title, if no max is found returns -1
        if(currentGrade < highestPayGrade){
            return "Request failed: Employee must reach top paygrade in their current title before being promoted to another title";
        }
        double newSalary = currentTitlePayScale.get(currentGrade);
        return "Employee has been promoted to "+ newTitle + "with a new salary of" + newSalary;
    }
}
