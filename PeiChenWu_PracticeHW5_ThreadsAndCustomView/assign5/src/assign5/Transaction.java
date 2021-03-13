package assign5;

public class Transaction {

	private int from;
	private int to;
	private int amount;
	
	public Transaction(int from, int to, int amount) {
		this.from = from;
		this.to = to;
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}
	
	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}
}