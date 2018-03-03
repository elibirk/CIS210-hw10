package hw10_perry_leah;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainProgram {
	/*PROGRAM: EmployeesTest / Assignment 10
	 * AUTHOR: Leah Perry
	 * Due Date: November 26, 2015
	 * SUMMARY: Tests Jr./Sr./Manager Employee classes
	 */
	public static void main(String[]args) throws IOException, FileNotFoundException{
		try{ 
			Scanner scanner = new Scanner(new File("Employees.txt"));//opens file
			Scanner inputfile = scanner.useDelimiter(":|\\n");//delimiter to ensure it works properly
	
		ArrayList<Employee> emps = new ArrayList <Employee>();
		
		emps = arrayCreator(emps, inputfile);//creates array from file info
		emps = arraySort(emps);//sorts the array
		printEmpInfo (emps);//prints employee info
		System.out.println("---------------------------------");//line to divide emp info and dividends
		showManagerDividends(emps);//prints dividends of all mangers
		
		} catch (Exception e){
			System.out.println("ERROR! Sorry, are you sure the file is in the right place?");
			System.out.println("Please check file name and location, then try rerunning the program.");
		}//end catch
		finally {
			System.out.println("\nThat's all, good bye.");
		}
		
	}//end main
	
	
	
	public static ArrayList<Employee> arrayCreator (ArrayList<Employee> emps, Scanner inputfile){
		/* FUNCTION: arrayCreator
		 * PURPOSE: creates an array of employee objects from a file
		 * @Parameter	emps			arraylist to put info into
		 * 				inputfile		file to get info from
		 * 				tempID			stores temporary employee id for temp employee creation
		 * 				tempYear		stores temporary employee year for temp employee creation
		 * 				tempTitle		stores temporary employee title for temp employee creation
		 * 				tempSalary		stores temporary employee salary for temp employee creation
		 * 				tempBonus		stores temporary employee bonus for temp employee creation
		 * 				eTemp			stores temporary employee object
		 * 				empTemp			String from file to convert to employees
		 */
		int tempID; //stores temporary employee id for temp employee creation
		int tempYear; //stores temporary employee year for temp employee creation
		String tempTitle; //stores temporary employee title for temp employee creation
		double tempSalary; //stores temporary employee salary for temp employee creation
		double tempBonus; //stores temporary employee bonus for temp employee creation
		Employee eTemp; //stores temporary employee object
		String empTemp = inputfile.nextLine();//gets rid of header; String to convert to employees
		empTemp = ""; //cleans empTemp
		
		while (inputfile.hasNext()){//adds input info to string with linebreaks
			empTemp = empTemp + inputfile.nextLine() + "\n";
		}//end while
		
		StringTokenizer empTokens = new StringTokenizer(empTemp, " .,;$'\n");//breaks up empTemp
		while (empTokens.hasMoreTokens()) {//while there are more tokens
			tempID = Integer.parseInt(empTokens.nextToken());//set id
			tempYear = Integer.parseInt(empTokens.nextToken());//set year
			tempTitle = empTokens.nextToken();//set title
			empTemp = empTokens.nextToken() + empTokens.nextToken();//get salary
			tempSalary = Integer.parseInt(empTemp);//convert salary to int
			empTemp = empTokens.nextToken() + empTokens.nextToken();//get bonus
			tempBonus = Integer.parseInt(empTemp);//convert bonus to int
			switch (tempTitle){
			case ("Junior")://if jr make a jr object
				eTemp = new JuniorEmployee(tempID, tempYear, tempSalary, tempBonus);
				break;
			case ("Senior")://if sr make a sr object
				eTemp = new SeniorEmployee(tempID, tempYear, tempSalary, tempBonus);
				break;
			case ("Manager")://if manager make a manger object
				eTemp = new Manager(tempID, tempYear, tempSalary, tempBonus);
				break;
			default:
				System.out.println("There was a problem with your file, please ensure titles are "
						+ "spelled correctly.");
				eTemp = new JuniorEmployee(-1, -1, -1, -1);	//defaults to -1s
			}//end switch case 
			emps.add(eTemp);//ands to array
		}//end while
		
		return emps;//returns the array
	}//end arrayCreator
	
	
	 public static ArrayList<Employee> arraySort(ArrayList<Employee> emps){
		 /* FUNCTION: arraySort
			 * PURPOSE: sorts an array of employee objects by ID
			 * @Parameter	emps			arraylist to sort
			 * 				minIndex		index of current minimum value
			 * 				minValue		current minimum ID to compare
			 * 				temp			temp employee to store while swapping object spots
			 * 				i				int for for loop
			 * 				j				int for for loop
		*/
	      int minIndex; //index of current minimum value
	      int minValue; //current minimum ID to compare
	      Employee temp; //temp employee to store while swapping object spots

	      for (int i = 0; i < (emps.size()-1); i++){//loops lowest spot
	         minIndex = i;//increases index to evaluate
	         minValue = emps.get(i).GetID();//resets newmin to current spot
	         
	         //finds smallest ID
	         for(int j = i + 1; j < emps.size(); j++){//loops comparison spot
	            if (emps.get(j).GetID() < minValue){//if id is lower
	               minValue = emps.get(j).GetID();//store value
	               minIndex = j;//store index
	            }//end if
	         }//end for
	         
	         //swap min value with the new lowest value.
	         temp = emps.get(i);
	         emps.set(i, emps.get(minIndex));
	         emps.set(minIndex, temp);
	      }//end for
	      
	      return emps;
	 }//end arraySort
	 
	 
	 public static void printEmpInfo(ArrayList<Employee> emps){
		 /* FUNCTION: printEmpInfo
			 * PURPOSE: prints information about all employees
			 * @Parameter	emps			arraylist to store employee information
			 * 				i				int for for loop
		*/
		 System.out.println("ID\tYEAR_HIRED\tTITLE\tBASE_SALARY\tCOMPENSATION");
		 for(int i = 0; i < emps.size(); i++){//loop through array
			System.out.print(emps.get(i).GetID() + "\t");//print ID
			System.out.print(emps.get(i).GetYearHired() + "\t\t");//print year
			System.out.print(emps.get(i).GetTitle() + "\t");//print title
			System.out.printf("  $%.2f\t", emps.get(i).GetBaseSalary());//print title
			System.out.printf("  $%.2f\n", emps.get(i).GetTotalCompensation());//print compensation
			System.out.println(emps.get(i).toString());//print toString method
		 }//end for
	 }//end printEmpInfo
	 
	 public static void showManagerDividends(ArrayList<Employee> emps){
		 /* FUNCTION: showManagerDividends
			 * PURPOSE: prints dividends of all managers
			 * @Parameter	emps			arraylist to store employee information
			 * 				i				int for for loop
		*/
		 for(int i = 0; i < emps.size(); i++){//go through the array again
				if(emps.get(i) instanceof Manager){//if a manager
					((Manager) emps.get(i)).ShowDividend();//call show dividend
				}//end if
			}//end for
	 }//end showManagerDividends
	
}//end MainProgram
