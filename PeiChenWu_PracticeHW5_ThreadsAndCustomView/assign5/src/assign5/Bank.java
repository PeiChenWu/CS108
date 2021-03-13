package assign5;

import java.util.*;
import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Bank {
	private final static int DEFAULT_BALANCE = 1000;
	private final static int NUM_ACCOUNTS = 20;
	private final static int QUEUE_SIZE = 100;
	private int numOfWorkers;
	private CountDownLatch latch;
	private final Transaction nullTransaction = new Transaction(-1, 0, 0);

	private static List<Account> accountList;
	private BlockingQueue<Transaction> transQueue = new ArrayBlockingQueue<Transaction>(QUEUE_SIZE);
	
	private class Worker extends Thread {
		@Override
		public void run() {
			try {
				Transaction currentTrans = transQueue.take();
				while(currentTrans != nullTransaction) {
					int from = currentTrans.getFrom();
					int to = currentTrans.getTo();
					int amount = currentTrans.getAmount();
					if (from == to) accountList.get(from).selfTransaction();
					else {
						accountList.get(from).withdraw(amount);
						accountList.get(to).deposit(amount);
					}
					currentTrans = transQueue.take();
				}
				if (currentTrans == nullTransaction) transQueue.put(currentTrans);
				latch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private void createAccountList() {
		accountList = new ArrayList<Account>();
		for (int i=0; i < NUM_ACCOUNTS; i++) {
			accountList.add(new Account(i, DEFAULT_BALANCE));
		}
	}

	private void createTransactionQueue(String fileName) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String line = in.readLine();
			while (line != null) {
				String[] s = line.split(" ");
				int from = Integer.parseInt(s[0]);
				int to = Integer.parseInt(s[1]);
				int amt = Integer.parseInt(s[2]);
				Transaction t = new Transaction(from, to, amt);
				transQueue.put(t);
				line = in.readLine();
			}
			in.close();
			for (int i = 0; i < numOfWorkers; i++) transQueue.put(nullTransaction);
		} catch (FileNotFoundException e) {
			System.err.println("File not found!");
			System.exit(-1);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private void NumberOfThreads(String num) {
		try {
			numOfWorkers = Integer.parseInt(num);
		} catch (NumberFormatException e) {
			System.err.println("incorrect input format!");
			System.exit(-1);
		}
	}
	
	public void setup(String[] args) {
		NumberOfThreads(args[1]);
		latch = new CountDownLatch(numOfWorkers);
		for (int i = 0; i < numOfWorkers; i++) {
			Worker w = new Worker();
			w.start();
		}
		createAccountList();
		createTransactionQueue(args[0]);
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(this.toString());
	}
	
	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("java assign5/Bank fileName numOfThreads");
		}
		Bank bank = new Bank();
		bank.setup(args);
	}
	
	@Override
	public String toString() {
		StringBuilder sbuilder = new StringBuilder();
		for (Account account : accountList)
		{
			sbuilder.append(account.toString());
			sbuilder.append("\n");
		}
		return sbuilder.toString();
	}
	
}