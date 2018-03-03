package hw10_perry_leah;

import java.text.DecimalFormat;

public class JuniorEmployee extends Employee implements EmployeeCompensation{
	
	double commission;

	public JuniorEmployee(int uID, int uYearHired, double uBaseSalary, double uCom) {
		super(uID, uYearHired, uBaseSalary);//uses employee constructor
		commission = uCom;//sets commission
		CalculateTotalCompensation();
	}//end Constructor
	
	public String GetTitle(){
		return "Junior";
	}//end GetTitle

	public double GetCommission(){
		return commission;
	}//end GetCommission
	
	public void SetCommission(double uCom){
		commission = uCom;
	}//end SetCommission
	
	public String toString(){
		/* FUNCTION: toString
		 * PURPOSE: prints information about an employees
		 * @Parameter	empInfo			stores string to return
		 * 				temp			temporarily stores info while converting values
		 */
		DecimalFormat df = new DecimalFormat("#.00");//ensures money has proper decimal spaces
		String empInfo; //stores string to return
		String temp; //temporarily stores info while converting values
		temp = Integer.toString(super.GetID());//get id
		empInfo = "Junior employee, ID number " + temp;//add id to info
		temp = Integer.toString(super.GetYearHired());//get year
		empInfo = empInfo + " was hired in " + temp;//add year to info
		temp = df.format(commission);//converts to string with 2 decimal format
		empInfo = empInfo + " and has a commission of $" + temp + ".";//add commission to info
				
		return empInfo;
	}//end toString
	
	public void CalculateTotalCompensation(){
		SetTotalCompensation(GetBaseSalary() + commission);
	}//end CalculateTotalComensation
	
}//end JuniorEmployee
