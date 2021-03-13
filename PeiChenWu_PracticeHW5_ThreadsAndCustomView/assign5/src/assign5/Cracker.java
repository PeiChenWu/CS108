package assign5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Cracker {
	// Array of chars used to produce strings
	public static final char[] CHARS = "abcdefghijklmnopqrstuvwxyz0123456789.,-!".toCharArray();	
	public static final String TEST_WORD = "molly";
	public static final String DEFAULT_HASH = "4181eecbd7a755d19fdf73887c54837cbecf63fd";
	public static final String DEFAULT_LEN = "5";
	public static final String DEFAULT_NUM_OF_THREADS = "8";
	private CountDownLatch latch;
	private List<String> resultWord = new ArrayList<String>();
	private String crackedHash;
	private int part;
	private int wordLength;
	private int numOfWorkers;
	
private class Worker extends Thread {
		
		private int endPos;
		private String firstSeg;
		
		Worker(String firstSeg) {
			endPos = firstSeg.length();
			this.firstSeg = firstSeg;
		}
		
		@Override
		public void run() {
			//String currThread = Thread.currentThread().getName();
			//System.out.println(currThread + " used chars: " + Arrays.toString(firstSeg.toCharArray()));
			for (int i = 0; i < endPos; i++) crackHash(firstSeg.substring(i, i+1));
			latch.countDown();
		}
		
		private void crackHash(String s) {
			if (s.length() > wordLength) return;
			if (createHash(s).equals(crackedHash)) {
				resultWord.add(s);
			} else {
				for (char CHAR : CHARS) crackHash(s + CHAR);
			}
		}
	}

	private static String createHash(String word) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(word.getBytes());
			return hexToString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void NumberOfThreads(String num) {
		try {
			numOfWorkers = Integer.parseInt(num);
			if (numOfWorkers > CHARS.length) numOfWorkers = CHARS.length;
		} catch (NumberFormatException e) {
			System.err.println("incorrect input format!");
			System.exit(-1);
		}
	}
	
	private void startWorkers() {		
		int startPos = 0;
		for (int i = 0; i < numOfWorkers; i++) {
			String s = new String(CHARS, startPos, part);
			startPos += part;
			new Worker(s).start();
		}
		String s = new String(CHARS, startPos, CHARS.length - startPos);
		new Worker(s).start();
	}

	private void setup(String hash, String len, String numOfThreads) {
		NumberOfThreads(numOfThreads);
		part = CHARS.length / numOfWorkers;
		latch = new CountDownLatch(numOfWorkers);
		crackedHash = hash;
		wordLength = Integer.parseInt(len);
		startWorkers();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Result passwords: " + resultWord);
	}
	
	public static void main(String[] args) {
		if (args.length == 1) {
			System.out.println(createHash(args[0]));
		} 
		else if (args.length == 3) {
			Cracker cracker = new Cracker();
			cracker.setup(args[0], args[1], args[2]);
		} else {
			System.err.println("incorrect input format");
			System.err.println("java assign5/Cracker [hash]");
			System.err.println("or");
			System.err.println("java assign5/Cracker [hash] [wordlength] [numOfThreads]");
			
			System.err.println("Start Program with default hash to crack");
			Cracker cracker = new Cracker();
			cracker.setup(DEFAULT_HASH, DEFAULT_LEN, DEFAULT_NUM_OF_THREADS);			
		}
	}
	
	
	/*
	 Given a byte[] array, produces a hex String,
	 such as "234a6f". with 2 chars for each byte in the array.
	 (provided code)
	*/
	public static String hexToString(byte[] bytes) {
		StringBuffer buff = new StringBuffer();
		for (int i=0; i<bytes.length; i++) {
			int val = bytes[i];
			val = val & 0xff;  // remove higher bits, sign
			if (val<16) buff.append('0'); // leading 0
			buff.append(Integer.toString(val, 16));
		}
		return buff.toString();
	}
	
	/*
	 Given a string of hex byte values such as "24a26f", creates
	 a byte[] array of those values, one byte value -128..127
	 for each 2 chars.
	 (provided code)
	*/
	public static byte[] hexToArray(String hex) {
		byte[] result = new byte[hex.length()/2];
		for (int i=0; i<hex.length(); i+=2) {
			result[i/2] = (byte) Integer.parseInt(hex.substring(i, i+2), 16);
		}
		return result;
	}

}
