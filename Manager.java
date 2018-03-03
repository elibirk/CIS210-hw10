package hw10_perry_leah;

import java.text.DecimalFormat;

public class Manager extends Employee implements EmployeeCompensation{
	
	double stockDividend;

	public Manager(int uID, int uYearHired, double uBaseSalary, double uDividend) {
		super(uID, uYearHired, uBaseSalary);//uses employee constructor
		stockDividend = uDividend;//sets dividend
		CalculateTotalCompensation();
	}//end Constructor
	
	public String GetTitle(){
		return "Manager";
	}//end GetTitle

	public double GetDividend(){
		return stockDividend;
	}//end GetCommission
	
	public void SetDividend(double uDividend){
		stockDividend = uDividend;
	}//end SetCommission
	
	public void ShowDividend(){
		DecimalFormat df = new DecimalFormat("#.00");//ensures money has proper decimal spaces
		String temp = df.format(GetDividend());//converts to string with 2 decimal format
		System.out.println("Employee " + super.GetID() + " is a manger. Dividend is $" + temp);
	}//end toString
	
	public String toString(){
		/* FUNCTION: toString
		 * PURPOSE: prints information about an employee
		 * @Parameter	empInfo			stores string to return
		 * 				temp			temporarily stores info while converting values
		 */
		DecimalFormat df = new DecimalFormat("#.00");//ensures money has proper decimal spaces
		String empInfo; //stores string to return
		String temp; //temporarily stores info while converting values
		temp = Integer.toString(super.GetID());//get id
		empInfo = "Manager, ID number " + temp;//add id to info
		temp = Integer.toString(super.GetYearHired());//get year
		empInfo = empInfo + " was hired in " + temp;//add year to info
		temp = df.format(stockDividend);//converts to string with 2 decimal format
		empInfo = empInfo + " and has a stock dividend of $" + temp + ".";//add dividend to info
				
		return empInfo;
	}//end toString
	
	public void CalculateTotalCompensation(){
		SetTotalCompensation(GetBaseSalary() + stockDividend);
	}//end CalculateTotalComensation

}//end Manager
