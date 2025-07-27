//Nikita Lazarev, ITS, N01690103
package Exercise;

public class BankAccount {
	private double balance;
	private double interestRate;
	private double interest;
	
	BankAccount(
		double balance,
		double interestRate
	) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.interest= 0;
	}
	
	void setBalance(double value) {
		this.balance = value;
	}

	void setInterestRate(double value) {
		this.interestRate = value;
	}
	
	double getBalance() {
		return this.balance;
	}

	double getInterestRate() {
		return this.interestRate;
	}

	double getInterest() {
		return this.interest; 
	}
	
	void deposit(double value) {
		this.balance += value;
	}
	
	void withdraw(double value) {
		this.balance -= value;
	}
	
	void calculateInterest() {
		this.interest = this.interestRate * this.balance;
	}
	
	void addInterest() {
		this.calculateInterest();
		this.balance += this.interest;
	}
}
