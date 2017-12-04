package deadLockTutorial;

public class Account1 {
	private int balance = 10000;
	
	public void deposit(int i){
		balance += i;
	}
	
	public void withdraw(int i){
		balance -= i;
	}
	public int getBalance(){
		return balance;
	}
	public static void transfer(Account1 acc1, Account1 acc2, int amount){
		acc1.withdraw(amount);
		acc2.deposit(amount);
	}
	
}
