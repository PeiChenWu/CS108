package assign5;


public class Account {
	
	private int id;
	private int balance;
	private int numOfTrans;
	
	public Account(int id, int balance) {
		this.id = id;
		this.balance = balance;
		this.numOfTrans = 0;
	}
	
	public synchronized void deposit(int amount) {
		balance += amount;
		numOfTrans++;
	}
	
	public synchronized void withdraw(int amount) {
		balance -= amount;
		numOfTrans++;
	}
	
	public synchronized void selfTransaction () {
		numOfTrans++;
	}
	
	@Override
	public String toString() {
		return ("Account: " + id + " Balance: " + balance + " # of Transactions: " + numOfTrans);
	}
	
	public int getId() {
		return id;
	}
	
}