import java.time.LocalDate;

public class SystemDate {
    public static LocalDate systemDate = LocalDate.now(); //default date

    public static void setSystemDate(LocalDate newDate){
        systemDate = newDate; //use to set new system date for all classes
    }

    public static LocalDate getSystemDate(){
        return systemDate; //use when system date is needed
    }


}
