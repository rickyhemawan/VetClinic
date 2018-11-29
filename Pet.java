import java.util.*;
/**
*The Parent Class of Dog and Cat
*Cannot be Declared as this parent class
*But can be Declared using child class
*@author Putu Ricky Hemawan || E1600732
*/
public abstract class Pet {
    //private variables
    private int petID;
    private String name;
    private double weight;
    private Date dob;
    private double accumulatedDose;
    private ArrayList<Dose> doseList = new ArrayList<Dose>();
    //constructor
    public Pet() {
    }

    public Pet(int petID, String name, double weight, Date dob, double accumulatedDose) {
        this.petID = petID;
        this.name = name;
        this.weight = weight;
        this.dob = dob;
        this.accumulatedDose = accumulatedDose;
    }
    //getter and setters
    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public double getAccumulatedDose() {
        return accumulatedDose;
    }

    public void setAccumulatedDose(double accumulatedDose) {
        this.accumulatedDose = accumulatedDose;
    }
    public int findAge(){
        //converting to calendar
        //to avoid compiling to xlint
        int differenceInMonth = 0;
        Date firstDate = this.dob;
        Date secondDate = new Date();
        Calendar firstCalendar = Calendar.getInstance();
        firstCalendar.setTime(firstDate);
        int firstMonth = firstCalendar.get(Calendar.MONTH) + 1;
        int firstYear = firstCalendar.get(Calendar.YEAR);
        int firstDay = firstCalendar.get(Calendar.DAY_OF_MONTH);

        Calendar secondCalendar = Calendar.getInstance();
        secondCalendar.setTime(secondDate);
        int secondMonth = secondCalendar.get(Calendar.MONTH) + 1;
        int secondYear = secondCalendar.get(Calendar.YEAR);
        int secondDay = secondCalendar.get(Calendar.DAY_OF_MONTH);

        if(firstDay <= secondDay && firstMonth == secondMonth){
            differenceInMonth = (secondYear - firstYear) * 12;
        }else if(firstMonth > secondMonth){
            differenceInMonth = (secondMonth + 12 - firstMonth) + ((secondYear - firstYear - 1) * 12);
        }else if(firstMonth < secondMonth){ 
            differenceInMonth = (secondMonth - firstMonth) + (secondYear - firstYear ) * 12;
        }else if(firstMonth == secondMonth && firstDay > secondDay){
            differenceInMonth = (secondYear - firstYear -1) * 12 + 11;
        }

        if(secondMonth - firstMonth == 1 && secondDay + 30 - firstDay < 30){
        	differenceInMonth = differenceInMonth - 1;
        }
        return differenceInMonth;

    }
    public void setDoseList(ArrayList<Dose> doseList){
    	this.doseList = doseList;
    }
    public ArrayList<Dose> getDoseList(){
    	return doseList;
    }

    /**
    *is not declared by parent,
    *but inheritors/child must declare
    *this function
    */
    public abstract double getDose();
}