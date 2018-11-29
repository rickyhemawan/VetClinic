import java.util.*;
/**
*this is child of pet class
*which store pet type dog
*@author Putu Ricky Hemawan || E1600732
*/

public class Dog extends Pet {
    //private variables
    private String breed;
    //constructor
    public Dog() {
    }

    public Dog(int petID, String name, double weight, Date dob, double accumulatedDose, String breed) {
        super(petID, name, weight, dob, accumulatedDose);
        this.breed = breed;
    }
    //getter and setters
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
    /**
    *Declaring abstract function from class
    *Overriding it to run faster
    *@return dose for a Drug
    */

    @Override
    public double getDose() {
        double myDog;
        if(findAge() > 12 && getWeight() < 2){
            myDog = 6 + 0.75 * getWeight();
        }else{
            myDog = 12 + 0.65 * getWeight();
        }

        if(findAge() < 3){
            return 0;
        }else if(getAccumulatedDose() >= 750){
            return 0;
        }else if(getAccumulatedDose() + myDog >= 750){
            myDog = 750 - getAccumulatedDose();
            return myDog;
        }else{
            return myDog;
        }
    }
    /**
    *printing dog info, and drug(s)
    *if drug list is not empty
    */
    @Override
    public String toString() {
        String dogInfoStr = "ID no." + getPetID() + ": " + getName() + " the DOG, \n with weight of " + String.format("%.2f",getWeight()) 
            + "kg , with date of birth of "
            + VetClinic.dateToStr(getDob()) + ", with accumulated dose of " + String.format("%.2f",getAccumulatedDose()) 
            + ", and the breed of " + getBreed()
            + "\n";
        String dogListStr = ""; 
        if(getDoseList().size() > 0){
            dogInfoStr = dogInfoStr + "Drugs : \n";
            for(int i = 0; i < getDoseList().size(); i++){
                dogListStr = dogListStr + "\t" + String.format("%.2f",getDoseList().get(i).getDoseInGrams()) + " mg of "
                 + getDoseList().get(i).getNameOfDrug() + "\n"; 
            }
        }
        return  dogInfoStr + dogListStr;
    }

}