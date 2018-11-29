import java.util.*;
/**
*this is child of pet class
*which store pet type dog
*@author Putu Ricky Hemawan || E1600732
*/

public class Cat extends Pet {
    //private variables
    private boolean allergic;
    //constructor
    public Cat() {
    }

    public Cat(int petID, String name, double weight, Date dob, double accumulatedDose, boolean allergic) {
        super(petID, name, weight, dob, accumulatedDose);
        this.allergic = allergic;
    }
    //setter and getters;
    public boolean isAllergic() {
        return allergic;
    }

    public void setAllergic(boolean allergic) {
        this.allergic = allergic;
    }
    /**
    *Declaring abstract function from class
    *Overriding it to run faster
    *@return dose for a Drug
    */

    @Override
    public double getDose() {
        double myCat;
        if(findAge() > 3 && getWeight() > 0.5){
            myCat =  7 + 0.61 * getWeight();
        }else{
            myCat = 0.81 * getWeight();
        }

        if(isAllergic()){
            return 0;
        }else if(getAccumulatedDose() >= 500){
            return 0;
        }else if(myCat + getAccumulatedDose() >=500){
            myCat = 500 - getAccumulatedDose();
            return myCat;
        }else{
            return myCat;
        }
    }
    /**
    *printing cat info, and drug(s)
    *if drug list is not empty
    */
    @Override
    public String toString() {
        String allergicStr = "";
        if(isAllergic()){
            allergicStr = " and this cat is ALLERGIC.";
        }else{
            allergicStr = " and this cat is NOT ALLERGIC.";
        }
        String catInfoStr = "ID no." + getPetID() + " : " + getName() + " the CAT, \n with weight of " + String.format("%.2f",getWeight()) 
            + ", with date of birth of "
            + VetClinic.dateToStr(getDob()) + ", with accumulated dose of " + String.format("%.2f",getAccumulatedDose()) 
            + allergicStr
            + "\n";
        String catListStr = ""; 
        if(getDoseList().size() > 0){
            catListStr = catListStr + "Drugs : \n";
            for(int i = 0; i < getDoseList().size(); i++){
                catListStr = catListStr + "\t" + String.format("%.2f",getDoseList().get(i).getDoseInGrams()) + " mg of " 
                + getDoseList().get(i).getNameOfDrug() + "\n"; 
            }
        }
        return  catInfoStr + catListStr;
    }

}