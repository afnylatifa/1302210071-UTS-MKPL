package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	private static final int MAX_CHILDREN = 3;
	private static final double TAX_RATE = 0.05;

	public static int calculateTax(double monthlySalary, double otherMonthlyIncome, int numberOfMonthsWorking, double deductible, boolean isMarried, int numberOfChildren) {
		
		if (numberOfMonthsWorking > 12) {
			System.err.println("More than 12 month working per year");
			return 0;
		}
		
		// Menghitung penghasilan yang tidak kena pajak berdasarkan status perkawinan dan jumlah anak
		double nonTaxableIncome = calculateNonTaxableIncome(isMarried, numberOfChildren);
		
		// Menghitung penghasilan kena pajak
		double taxableIncome = calculateTaxableIncome(monthlySalary, otherMonthlyIncome, numberOfMonthsWorking, deductible, nonTaxableIncome);
		
		// Calculate tax amount
		int taxAmount = calculateTaxAmount(taxableIncome);
		
		return taxAmount;
	}
	
	private static double calculateNonTaxableIncome(boolean isMarried, int numberOfChildren) {
		double nonTaxableIncome = 0;
		if (isMarried) {
			nonTaxableIncome += 2_000_000;
		} else {
			nonTaxableIncome += 1_000_000;
		}
		nonTaxableIncome += numberOfChildren * 500_000;
		nonTaxableIncome *= 12;
		return nonTaxableIncome;
	}
	
	private static double calculateTaxableIncome(double monthlySalary, double otherMonthlyIncome, int numberOfMonthsWorking, double deductible, double nonTaxableIncome) {
		double totalIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthsWorking;
		totalIncome -= deductible;
		totalIncome -= nonTaxableIncome;
		return totalIncome;
	}
	
	private static int calculateTaxAmount(double taxableIncome) {
		return (int) Math.ceil(taxableIncome * TAX_RATE);
	}
}
