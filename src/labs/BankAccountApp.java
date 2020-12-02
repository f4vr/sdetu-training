package labs;

public class BankAccountApp {
	public static void main(String[] args) {
		BankAccount acc1 = new BankAccount("1234554321", 1000.50);
		BankAccount acc2 = new BankAccount("4524352343", 2000);
		BankAccount acc3 = new BankAccount("7867967885", 3000);
		
		acc1.setName("Jim");
		System.out.println(acc1.getName());
		acc1.makeDeposit(500);
		acc1.makeDeposit(600);
		acc1.payBill(1000);
		acc1.accrue();
		System.out.println(acc1.toString());
	}
}

class BankAccount implements IInterest{
	// Properties of Bank Account
	private static int iD = 1000; // Internal ID
	private String accountNumber; // iD + random 2-digit number + first 2 of SSN
	private static final String routingNumber = "07932483";
	private String name;
	private String SSN;
	private double balance;
	
	// Constructor
	public BankAccount(String SSN, double initDeposit) {
		System.out.println("New Account Created");
		balance = initDeposit;
		this.SSN = SSN;
		iD++;
		System.out.println(iD);
		setAccountNumber();
	}
	
	private void setAccountNumber() {
		int random = (int) (Math.random() * 100);
		accountNumber = iD + "" + random + SSN.substring(0,1); 
		System.out.println("Your Account Number: " + accountNumber);
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName( ) {
		return name;
	}
	
	public void payBill(double amount) {
		balance = balance - amount;
		System.out.println("Paying bill: " + amount);
		showBalance();
	}
	
	public void makeDeposit(double amount) {
		balance = balance + amount;
		System.out.println("Making deposit: " + amount);
		showBalance();
	}
	
	public void showBalance() {
		System.out.println("Balance: " + balance);
	}

	@Override
	public void accrue() {
		// TODO Auto-generated method stub
		balance = balance * (1 + rate/100);
		showBalance();
	}
	
	@Override
	public String toString() {
		return "[Name: " + name + " ]\n[Account Number: " + accountNumber + "]\n[Routing Number: " + routingNumber + "]\n[Balance: " + balance + "]";
	}
}