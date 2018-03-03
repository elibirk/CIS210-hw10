package hw10_perry_leah;

import java.text.DecimalFormat;

public class SeniorEmployee extends Employee implements EmployeeCompensation{
	
	double annualBonus;

	public SeniorEmployee(int uID, int uYearHired, double uBaseSalary, double uBonus) {
		super(uID, uYearHired, uBaseSalary);//uses employee constructor
		annualBonus = uBonus;//set bonus
		CalculateTotalCompensation();
	}//end Constructor
	
	public String GetTitle(){
		return "Senior";
	}//end GetTitle

	public double GetBonus(){
		return annualBonus;
	}//end GetCommission
	
	public void SetBonus(double uBonus){
		annualBonus = uBonus;
	}//end SetCommission
	
	public String toString(){
		/* FUNCTION: toString
		 * PURPOSE: prints information about an employees
		 * @Parameter	empInfo			stores string to return
		 * 				temp			temporarily stores info while converting values
		 */
		DecimalFormat df = new DecimalFormat("#.00");//ensured money has proper decimal spaces
		String empInfo; //stores string to return
		String temp; //temporarily stores info while converting values
		temp = Integer.toString(super.GetID());//get id
		empInfo = "Senior employee, ID number " + temp;//add id to info
		temp = Integer.toString(super.GetYearHired());//get year 
		empInfo = empInfo + " was hired in " + temp;//add year to info
		temp = df.format(annualBonus);//converts to string with 2 decimal format
		empInfo = empInfo + " and has an annual bonus of $" + temp + ".";//add bonus to info
				
		return empInfo;
	}//end toString
	
	public void CalculateTotalCompensation(){
		SetTotalCompensation(GetBaseSalary() + annualBonus);
	}//end CalculateTotalComensation
	
}//end SeniorEmployee
