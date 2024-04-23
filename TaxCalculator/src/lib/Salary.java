package lib;

public class Salary{
    private int grade;
    private boolean isForeigner;
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;

    public Salary(int grade, boolean isForeigner) {
        this.grade = grade;
        this.isForeigner = isForeigner;
        setMonthlySalary();
    }

    	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
	public void setMonthlySalary(int grade) {
		switch (grade){
			case 1:
				monthlySalary = 3000000;
				break;
			case 2:
				monthlySalary = 5000000;
				break;
			case 3:
				monthlySalary = 7000000;
				break;
			default:
				throw new IllegalArgumentException("Invalid grade: " + grade);
		}

		if (isForeigner){
			monthlySalary = (int) (monthlySalary * 1.5);
		} 
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }

    public int getGrade() {
        return grade;
    }

    public boolean isForeigner() {
        return isForeigner;
    }
}