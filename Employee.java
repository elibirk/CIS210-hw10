package hw10_perry_leah;

import java.text.DecimalFormat;

public abstract class Employee {

	private int ID;
	private int yearHired;
	private double baseSalary;
	private double totalCompensation;
	
	public Employee(int uID, int uYearHired, double uBaseSalary){//default constructor
		ID = uID;
		yearHired = uYearHired;
		baseSalary = uBaseSalary;
		totalCompensation = baseSalary; //defaults to base, since no bonus is added yet
	}//end Employee constructor
	
	//getters:
	public String GetTitle(){
		return "Employee";
	}//end GetTitle
	
	public int GetID(){
		return ID;
	}//end GetID
	
	public int GetYearHired(){
		return yearHired;
	}//end GetYearHired
	
	public double GetBaseSalary(){
		return baseSalary;
	}//end GetBaseSalary
	
	public double GetTotalCompensation(){
		return totalCompensation;
	}//end GetTotalCompensation
	
	//setters:
	public void SetID(int uID){
		ID = uID;
	}//end SetID
	
	public void SetYearHired(int uYear){
		yearHired = uYear;
	}//end SetYearHired
	
	public void SetBaseSalary(double uSalary){
		baseSalary = uSalary;
	}//end SetBaseSalary
	
	public void SetTotalCompensation(double uComp){
		totalCompensation = uComp;
	}//end SetTotalCompensation
	
	
	public String toString(){
		/* FUNCTION: toString
		 * PURPOSE: prints information about an employee
		 * @Parameter	empInfo			stores string to return
		 * 				temp			temporarily stores info while converting values
		 */
		DecimalFormat df = new DecimalFormat("#.00");//ensures money has proper decimal spaces
		String empInfo; //stores string to return
		String temp; //temporarily stores info while converting values
		temp = Integer.toString(ID);//get id
		empInfo = "Employee number " + temp;//add id to info
		temp = Integer.toString(yearHired);//get year
		empInfo = empInfo + " was hired in " + temp;//add year to info
		temp = df.format(baseSalary);//converts to string with 2 decimal format
		empInfo = empInfo + " and makes a base salary of $" + temp;//add salary to info
		temp = df.format(totalCompensation);//converts to string with 2 decimal format
		empInfo = empInfo + ", but has a total compensation of $" + temp + ".";//add total comp to info
				
		return empInfo;
	}//end toString

}//end Employee
