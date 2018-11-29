import java.util.*;
/**
*this is the dose object will store
*detail of the drug
*which is used by pet
*@author Putu Ricky Hemawan || E1600732 
*/
public class Dose {
    //private variables
    private String nameOfDrug;
    private Date date;
    private double doseInGrams;
    //constructor
    public Dose() {
    }

    public Dose(String nameOfDrug, Date date, double doseInGrams) {
        this.nameOfDrug = nameOfDrug;
        this.date = date;
        this.doseInGrams = doseInGrams;
    }
    //getter and setters
    public String getNameOfDrug() {
        return nameOfDrug;
    }

    public void setNameOfDrug(String nameOfDrug) {
        this.nameOfDrug = nameOfDrug;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getDoseInGrams() {
        return doseInGrams;
    }

    public void setDoseInGrams(double doseInGrams) {
        this.doseInGrams = doseInGrams;
    }
} 