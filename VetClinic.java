import java.util.*;
import java.text.*;
/**
*To give the name of the VetClinic
*And as Function Manager
*@author Putu Ricky Hemawan || E1600732
*/
public class VetClinic{
	private String clinicName;
	public VetClinic(){
		this.clinicName = "";
	}
	//setter
	public void setClinicName(String clinicName){
		this.clinicName = clinicName;
	}
	//getter
	public String getClinicName(){
		return this.clinicName;
	}
	//Functions for Console and Objects stored here

	/**
	*@param any date object
	*@return string of the date inputted
	*/
	public static String dateToStr(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);
		return strDate;
	}
	/**
	*use this function to convert string into date
	*all of the param is inputted by passing string
	*that is converted from integer
	*or a String which already
	*been splitted into 3 number that represent
	*day, month, and year consecutively
	*@param the day of the date
	*@param the month of the date
	*@param the Year of the date
	*@return returning the date object
	*/

	public static Date strToDate(String strDay, String strMonth, String strYear){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String realDate = strDay + "/" + strMonth + "/" + strYear;
		Date date = new Date();
		try{
			date = formatter.parse(realDate);
		}catch (ParseException e){
			e.printStackTrace();
		}
		return date;
	}
	/**
	*printing the menu list for main menu
	*/
	public static void printMainMenu(){
		System.out.println("\n1. Add a pet!");
		System.out.println("2. Delete a pet!");
		System.out.println("3. Show all pet(s)!");
		System.out.println("4. Add a drug for a pet!");
		System.out.println("5. Edit pet info!");
		System.out.println("0. Quit \n");
		System.out.print("Your Choice : ");
	}
	/**
	*printing the menu list for choose pet
	*/
	public static void printChoosePet(){
		System.out.println("\nChoose a pet to be inputted!");
		System.out.println("1. Cat");
		System.out.println("2. Dog");
		System.out.println("0. Back to menu");
		System.out.print("Your Choice : ");
	}
	/**
	*printing the menu list for invalid menu
	*/
	public static void printInvalid(){
		System.out.println("Invalid Choice! \n");
		System.out.print("Your Choice : ");
	}
	/**
	*printing the menu list for wrong pet id menu
	*/
	public static void printWrongPetID(){
		System.out.println("Pet ID doesn't exist.");
		System.out.print("Input pet ID (0 to cancel) : ");
	}
	/**
	*printing the menu list for modifying dog menu
	*/
	public static void printModifyDog(){
		System.out.println("\nChange this dog data (0 to back) : ");
		System.out.println("1. change dog name");
		System.out.println("2. change dog weight");
		System.out.println("3. change dog date of birth");
		System.out.println("4. change dog breed");
		System.out.print("Your Choice : ");

	}
	/**
	*printing the menu list for modifying cat menu
	*/
	public static void printModifyCat(){
		System.out.println("\nChange this cat data (0 to back) : ");
		System.out.println("1. change cat name");
		System.out.println("2. change cat weight");
		System.out.println("3. change cat date of birth");
		System.out.println("4. change cat allergic status");
		System.out.print("Your Choice : ");
	}
	/**
	*printing the menu list for sort menu
	*/
	public static void printSortMenu(){
		System.out.println("\nSort pet(s) : ");
		System.out.println("1. Sort by pet id's");
		System.out.println("2. Sort by pet lowest accumulated dose");
		System.out.println("3. Sort by pet highest accumulated dose");
		System.out.println("4. Sort by pet type followed by smallest age");
		System.out.println("5. Sort by pet type followed by highest age");
		System.out.println("0. Back to Menu");
		System.out.print("Your Choice : ");
	}
	/**
	*printing the sorted pet by id
	*@param the list of the pets
	*/
	public static void printSortedByID(ArrayList<Pet> pets){
		ArrayList<Pet> dummyList = new ArrayList<Pet>();
		dummyList.addAll(pets);
		for(int i = 0; i < dummyList.size(); i++){
			for(int j = i; j < dummyList.size(); j++){
				if(dummyList.get(i).getPetID() > dummyList.get(j).getPetID()){
					Pet dummyPet = dummyList.get(j);
					dummyList.set(j, dummyList.get(i));
					dummyList.set(i, dummyPet);

				}
			}

		}
		for(int i = 0; i < dummyList.size(); i++){
			if(dummyList.get(i) instanceof Dog){
				System.out.println("Dog : " + dummyList.get(i).toString());
			}else{
				System.out.println("Cat : " + dummyList.get(i).toString());
			}
		}
	}
	/**
	*printing the sorted pet by lowest accumulated dose
	*@param the list of the pets
	*/
	public static void printSortedByAccumulationLowest(ArrayList<Pet> pets){
		for(int i = 0; i < pets.size(); i++){
			for(int j = i; j < pets.size(); j++){
				if(pets.get(j).getAccumulatedDose() < pets.get(i).getAccumulatedDose()){
					Pet dummyPet = pets.get(j);
					pets.set(j, pets.get(i)); //pets.get(j) = pets.get(i);
					pets.set(i, dummyPet);
				}
			}
			
		}
		for(int i = 0; i < pets.size(); i++){
			if(pets.get(i) instanceof Dog){
				System.out.println("Dog : " + pets.get(i).toString());
			}else{
				System.out.println("Cat : " + pets.get(i).toString());
			}
		}	
	}
	/**
	*printing the sorted pet by highest accumulated dose
	*@param the list of the pets
	*/
	public static void printSortedByAccumulationHighest(ArrayList<Pet> pets){
		for(int i = 0; i < pets.size(); i++){
			for(int j = i; j < pets.size(); j++){
				if(pets.get(j).getAccumulatedDose() > pets.get(i).getAccumulatedDose()){
					Pet dummyPet = pets.get(j);
					pets.set(j, pets.get(i)); //pets.get(j) = pets.get(i);
					pets.set(i, dummyPet);
				}
			}
		}
		for(int i = 0; i < pets.size(); i++){
			if(pets.get(i) instanceof Dog){
				System.out.println("Dog : " + pets.get(i).toString());
			}else{
				System.out.println("Cat : " + pets.get(i).toString());
			}
		}	
	}
	/**
	*printing the sorted pet by type then smallest age
	*
	*creating different arraylist of pets based on 
	*the child, then print it sorted by smallest age
	*@param the list of the pets
	*/
	public static void printSortedByTypeAgeSmallest(ArrayList<Pet> pets){
		ArrayList<Pet> sortedCat = new ArrayList<Pet>();
		ArrayList<Pet> sortedDog = new ArrayList<Pet>();
		for(int i = 0; i < pets.size(); i++){
			if(pets.get(i) instanceof Cat){
				sortedCat.add(pets.get(i));
			}
		}
		for(int i = 0; i < pets.size(); i++){
			if(pets.get(i) instanceof Dog){
				sortedDog.add(pets.get(i));
			}
		}
		System.out.println("Cat(s) : ");
		for(int i = 0; i < sortedCat.size(); i++){
			for(int j = i; j < sortedCat.size(); j++){
				if(sortedCat.get(j).findAge() < sortedCat.get(i).findAge()){
					Pet dummyPet = sortedCat.get(j);
					sortedCat.set(j,sortedCat.get(i));
					sortedCat.set(i,dummyPet);
				}
			}
			System.out.println(sortedCat.get(i).toString());
		}
		System.out.println("Dog(s) : ");
		for(int i = 0; i < sortedDog.size(); i++){
			for(int j = i; j < sortedDog.size(); j++){
				if(sortedDog.get(j).findAge() < sortedDog.get(i).findAge()){
					Pet dummyPet = sortedDog.get(j);
					sortedDog.set(j, sortedDog.get(i));
					sortedDog.set(i, dummyPet);
				}
			}
			System.out.println(sortedDog.get(i).toString());
		}		
	}
	/**
	*printing the sorted pet by type then oldest age
	*
	*creating different arraylist of pets based on 
	*the child, then print it sorted by highest age
	*@param list of pets;
	*/ 
	public static void printSortedByTypeAgeHighest(ArrayList<Pet> pets){
		ArrayList<Pet> sortedCat = new ArrayList<Pet>();
		ArrayList<Pet> sortedDog = new ArrayList<Pet>();
		
		for(int i = 0; i < pets.size(); i++){
			if(pets.get(i) instanceof Cat){
				sortedCat.add(pets.get(i));
			}
		}
		for(int i = 0; i < pets.size(); i++){
			if(pets.get(i) instanceof Dog){
				sortedDog.add(pets.get(i));
			}
		}
		System.out.println("Cat(s) : ");
		for(int i = 0; i < sortedCat.size(); i++){
			for(int j = i; j < sortedCat.size(); j++){
				if(sortedCat.get(j).findAge() > sortedCat.get(i).findAge()){
					Pet dummyPet = sortedCat.get(j);
					sortedCat.set(j,sortedCat.get(i));
					sortedCat.set(i,dummyPet);
				}
			}
			System.out.println(sortedCat.get(i).toString());
		}
		System.out.println("Dog(s) : ");
		for(int i = 0; i < sortedDog.size(); i++){
			for(int j = i; j < sortedDog.size(); j++){
				if(sortedDog.get(j).findAge() > sortedDog.get(i).findAge()){
					Pet dummyPet = sortedDog.get(j);
					sortedDog.set(j, sortedDog.get(i));
					sortedDog.set(i, dummyPet);
				}
			}
			System.out.println(sortedDog.get(i).toString());
		}
		
	}
}