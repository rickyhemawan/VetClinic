import java.util.*;
import java.text.*;
/**
*The main console of this app
*@author Putu Ricky Hemawan || E1600732
*/
public class VetClinicConsole{
	private static Scanner sc;
	//setting the first pet id,
	//not from 0 because it will
	//cause some problems
	//within the validation
	//of the loop
	private static int petID = 1;
	public static void main(String[] args){
		//declaring empty pet list
		ArrayList<Pet> pets = new ArrayList<Pet>();
		sc = new Scanner(System.in);
		System.out.print("What is your Clinic Name? \n Name: ");
		VetClinic myClinic = new VetClinic();
		String myClinicname = sc.nextLine();
		myClinic.setClinicName(myClinicname);
		//using selfmade function
		//to shorten and to not 
		//repeat the same
		//print code
		VetClinic.printMainMenu();
		int choice = sc.nextInt();
		//looping through the menu
		//until user inputted 0
		while(choice != 0){
			switch(choice){
				case 1:
					VetClinic.printChoosePet();
					int petChoice = sc.nextInt();
					while(petChoice != 0){
						if(petChoice == 1){
							//Cat code here
							sc.nextLine();
							int catID = petID;
							petID++;
							System.out.print("Enter Cat Name : ");
							String catName = sc.nextLine();
							System.out.print("Enter Cat Weight : ");
							Double catWeight = sc.nextDouble();
							sc.nextLine();
							System.out.print("Enter Cat Born 'Year' : ");
							String catYear = sc.nextLine();
							System.out.print("Enter Cat Born 'Month' : ");
							String catMonth = sc.nextLine();
							System.out.print("Enter Cat Born 'Day' in Month : ");
							String catDay = sc.nextLine();
							System.out.print("Is your cat allergic? (Y/N) : ");
							String catAllergic = sc.nextLine();
							
							while(!catAllergic.toLowerCase().equals("y") && !catAllergic.toLowerCase().equals("n")){
								VetClinic.printInvalid();
								catAllergic = sc.nextLine();
							}
							boolean boolAllergic = false;

							if(catAllergic.toLowerCase().equals("y")){
								boolAllergic = true;
							}else if(catAllergic.toLowerCase().equals("n")){
								boolAllergic = false;
							}
							Date catDate = VetClinic.strToDate(catDay,catMonth,catYear);
							//making new cat object based on the inputted info
							//and adding it to the list
							Pet myCat = new Cat(catID,catName,catWeight,catDate,0,boolAllergic);
							pets.add(myCat);
							System.out.println(myCat.toString());
							petChoice = 0;
							
						}else if(petChoice == 2){
							//Dog code here
							sc.nextLine();
							int dogID = petID;
							petID++;
							System.out.print("Enter Dog Name : ");
							String dogName = sc.nextLine();
							System.out.print("Enter Dog Weight : ");
							Double dogWeight = sc.nextDouble();
							sc.nextLine();
							System.out.print("Enter Dog Born 'Year' : ");
							String dogYear = sc.nextLine();
							System.out.print("Enter Dog Born 'Month' : ");
							String dogMonth = sc.nextLine();
							System.out.print("Enter Dog Born 'Day' in Month : ");
							String dogDay = sc.nextLine();
							System.out.print("Enter Dog Breed : ");
							String dogBreed = sc.nextLine();
							//making new cat object based on the inputted info
							//and adding it to the list
							Pet myDog = new Dog(dogID,dogName,dogWeight,VetClinic.strToDate(dogDay,dogMonth,dogYear),0,dogBreed);
							pets.add(myDog);
							System.out.println(myDog.toString());
							petChoice = 0;
						}else if(petChoice == 0){
							//Nothing to do here
						}else{
							VetClinic.printInvalid();
							petChoice = sc.nextInt();
						}
					}
					VetClinic.printMainMenu();
					choice = sc.nextInt();
					break;
				case 2:
					System.out.println("Input a pet ID to be deleted (0 to back)");
					int deletePetID = sc.nextInt();
					sc.nextLine();
					boolean isIDAvailable = false;
					//checking the id of the pet, if available
					//delete it, if not available
					//user can find again or quit
					while(deletePetID != 0 && !isIDAvailable){
						for(int i = 0;i < pets.size(); i++){
							if(pets.get(i).getPetID() == deletePetID){
								isIDAvailable = true;
								System.out.println(pets.get(i).toString());
								System.out.println("Are you sure want to delete this pet?");
								System.out.print("Your choice (y/n) : ");
								String confirmDelete = sc.nextLine();
								if(!confirmDelete.toLowerCase().equals("y") && !confirmDelete.toLowerCase().equals("n")){
									while(!confirmDelete.toLowerCase().equals("y") && !confirmDelete.toLowerCase().equals("n")){
									VetClinic.printInvalid();
									confirmDelete = sc.nextLine();
									}
								}
								if(confirmDelete.toLowerCase().equals("y")){
									pets.remove(i);
									System.out.println("This pet is successfully deleted!");
								}else if(confirmDelete.toLowerCase().equals("n")){
									System.out.println("This pet is not deleted!");
								}
							}
						}
						if(isIDAvailable == false){
							VetClinic.printInvalid();
							deletePetID = sc.nextInt();
							sc.nextLine();
						}
					}
					VetClinic.printMainMenu();
					choice = sc.nextInt();
					break;
				case 3:
					VetClinic.printSortMenu();
					int chooseSort = sc.nextInt();
					sc.nextLine();
					while(chooseSort !=0){
						switch(chooseSort){
							case 1:
								VetClinic.printSortedByID(pets);
								chooseSort = 0;
								break;
							case 2:
								VetClinic.printSortedByAccumulationLowest(pets);
								chooseSort = 0;
								break;
							case 3:
								VetClinic.printSortedByAccumulationHighest(pets);
								chooseSort = 0;
								break;
							case 4:
								VetClinic.printSortedByTypeAgeSmallest(pets);
								chooseSort = 0;
								break;
							case 5:
								VetClinic.printSortedByTypeAgeHighest(pets);
								chooseSort = 0;
								break;
							case 0:
								chooseSort = 0;
								break;
							default:
								VetClinic.printInvalid();
								chooseSort = sc.nextInt();
								sc.nextLine();
								break;
						}
					}
					VetClinic.printMainMenu();
					choice = sc.nextInt();
					break;
				case 4:
					//Dose code here aaand gg!
					System.out.println("Which pet(ID) Should be given the drug? (0 to back) ");
					for(int i = 0; i < pets.size(); i++){
						System.out.println(pets.get(i).toString());
					}
					System.out.print("\nYour choice : ");
					int dosePetID = sc.nextInt();
					sc.nextLine();
					isIDAvailable = false;
					while(dosePetID != 0 && !isIDAvailable){
						for(int i = 0; i < pets.size(); i++){
							if(pets.get(i).getPetID() == dosePetID){
								isIDAvailable = true;
								pets.get(i).toString();
								Date doseDate = new Date();
								System.out.print("Enter the name of the Drug : ");
								String drugName = sc.nextLine();
								Dose addDose = new Dose(drugName,doseDate,pets.get(i).getDose());
								if(pets.get(i) instanceof Dog && pets.get(i).getAccumulatedDose() <= 750){
									pets.get(i).setAccumulatedDose(pets.get(i).getAccumulatedDose() + pets.get(i).getDose());
									if(addDose.getDoseInGrams() != 0){
										pets.get(i).getDoseList().add(addDose);
									}
									

								} else if(pets.get(i) instanceof Cat && pets.get(i).getAccumulatedDose() <= 500){
									pets.get(i).setAccumulatedDose(pets.get(i).getAccumulatedDose() + pets.get(i).getDose());
									if(addDose.getDoseInGrams() != 0){
										pets.get(i).getDoseList().add(addDose);
									}

								}
								if(addDose.getDoseInGrams() != 0){
									System.out.println(addDose.getDoseInGrams() + " mg of " + drugName + " is added.");	
								}else{
									System.out.println(drugName + " is not added.");
								}
								
							}
						}
					}
					VetClinic.printMainMenu();
					choice = sc.nextInt();
					break;
				case 5:
					System.out.println("Input a pet ID to be modified (0 to back)");
					System.out.println("Your choice : ");
					int modifyPetID = sc.nextInt();
					sc.nextLine();
					isIDAvailable = false;
					while(modifyPetID != 0 && !isIDAvailable){
						for(int i = 0;i < pets.size(); i++){
							if(pets.get(i).getPetID() == modifyPetID){
								isIDAvailable = true;
								pets.get(i).toString();
								//check wether the pets is either dog or cat
								if(pets.get(i) instanceof Dog){
									//change dog menu here
									VetClinic.printModifyDog();
									int modifyDog = sc.nextInt();
									sc.nextLine();
									while(modifyDog != 0){
										switch(modifyDog){
											case 1:
												System.out.print("Input new Dog Name : ");
												String newDogName = sc.nextLine();
												pets.get(i).setName(newDogName);
												System.out.println("Dog name successfully modified!");
												modifyDog = 0;
												break;
											case 2:
												System.out.print("Input new Dog Weight : ");
												Double newDogWeight = sc.nextDouble();
												sc.nextLine();
												pets.get(i).setWeight(newDogWeight);
												System.out.println("Dog weight successfully modified!");
												modifyDog = 0;
												break;
											case 3:
												System.out.print("Input new Dog 'Year' : ");
												String newDogYear = sc.nextLine();
												System.out.print("Input new Dog 'Month' : ");
												String newDogMonth = sc.nextLine();
												System.out.print("Input new Dog 'Day' of the month : ");
												String newDogDay = sc.nextLine();
												pets.get(i).setDob(VetClinic.strToDate(newDogDay,newDogMonth,newDogYear));
												System.out.println("Dog date of birth successfully modified!");
												modifyDog = 0;
												break;
											case 4:
												System.out.println("Input new Dog Breed : ");
												String newDogBreed = sc.nextLine();
												((Dog) pets.get(i)).setBreed(newDogBreed);
												System.out.println("Dog breed successfully modified!");
												modifyDog = 0;
												break;
											default:
												VetClinic.printInvalid();
												modifyDog = sc.nextInt();
												sc.nextLine();
												break;
										}
									}

								}else{
									VetClinic.printModifyCat();
									int modifyCat = sc.nextInt();
									sc.nextLine();
									while(modifyCat != 0){
										switch(modifyCat){
											case 1:
												System.out.print("Input new Cat Name : ");
												String newCatName = sc.nextLine();
												pets.get(i).setName(newCatName);
												System.out.println("Cat name successfully modified!");
												modifyCat = 0;
												break;
											case 2:
												System.out.print("Input new Cat Weight : ");
												Double newCatWeight = sc.nextDouble();
												sc.nextLine();
												pets.get(i).setWeight(newCatWeight);
												System.out.println("Cat weight successfully modified!");
												modifyCat = 0;
												break;
											case 3:
												System.out.print("Input new Cat 'Year' : ");
												String newCatYear = sc.nextLine();
												System.out.print("Input new Cat 'Month' : ");
												String newCatMonth = sc.nextLine();
												System.out.print("Input new Cat 'Day' of the month : ");
												String newCatDay = sc.nextLine();
												pets.get(i).setDob(VetClinic.strToDate(newCatDay,newCatMonth,newCatYear));
												System.out.println("Cat date of birth successfully modified!");
												modifyCat = 0;
												break;
											case 4:
												System.out.println("Is the Cat still allergic? (y/n) : ");
												String newCatAllergic = sc.nextLine();
												while(!newCatAllergic.toLowerCase().equals("y") && !newCatAllergic.toLowerCase().equals("n")){
													VetClinic.printInvalid();
													newCatAllergic = sc.nextLine();
												}
												if(newCatAllergic.toLowerCase().equals("y")){
													((Cat) pets.get(i)).setAllergic(true);
												}else{
													((Cat) pets.get(i)).setAllergic(false);
												}
												System.out.println("Cat allergic successfully modified!");
												modifyCat = 0;
												break;
											default:
												VetClinic.printInvalid();
												modifyCat = sc.nextInt();
												sc.nextLine();
												break;
										}
									}
									
								}
							}

						}
						if(isIDAvailable == false){
							VetClinic.printWrongPetID();
							modifyPetID = sc.nextInt();
							sc.nextLine();
						}
					}
					VetClinic.printMainMenu();
					choice = sc.nextInt();
					break;
				case 6:
					break;
				default:
					VetClinic.printInvalid();
					VetClinic.printMainMenu();
					choice = sc.nextInt();
					break;
			}
		}
		System.out.println("Bye " + myClinic.getClinicName() + "!");			
	}

}