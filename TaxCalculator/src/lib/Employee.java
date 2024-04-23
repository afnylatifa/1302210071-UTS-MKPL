package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {
	private PersonalInfo personalInfo;
	private PersonalInfo person
	private Family family;
	private Salary salary;
	
	public Employee(PersonalInfo personalInfo, PersonalInfo person , Family family, Salary salary) {
		this.personalInfo = personalInfo;
		this.person = person;
		this.family = family;
		this.salary = salary;
	}
	
	public int getAnnualIncomeTax() {
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate currentDate = LocalDate.now();
		int monthsWorked = 12;
		
		if (currentDate.getYear() == dateJoined.getYear()){
			monthsWorked = currentDate.getMonthValue() - dateJoined.getMonthValue();
		}
		
		int numChildren = childIdNumbers.size();
		boolean isMarried = spouseIdNumber != null && !spouseIdNumber.isEmpty();

		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthsWorked, annualDeductible, isMarried, numChildren);
	}
}
