package practical;

import java.util.Random;

class NumberGenerator extends Thread {
	Random rand =  new Random();
	int number;
	boolean running = true;
	
	@Override
	public void run() {
		while(running) {
			number = rand.nextInt(100);
			System.out.println("\nRegister number: 2462603\n[Generator] Number generated;"+number);
			
			if (number % 2 ==0) {
				new EvenThread(number).start();
			} else {
				new OddThread(number).start();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Generator stopped.");
			}
		}
	}
}
 class EvenThread extends Thread {
	 int num;
	 
	 EvenThread(int num){
		 this.num = num;
	 }
	 @Override
	 public void run() {
		 System.out.println("[Even Thread] Square of"+num+"="+(num*num));
	 }
 }
 class OddThread extends Thread{
	 int num;
	 
	 OddThread(int num){
		 this.num = num;
	 }
	 
	 @Override
	 public void run() {
		 System.out.println("[OddThread] Cube of"+num+"="+(num*num*num));
	 }
}
 public class MultiThreading{
	 public static void main(String[] args) {
		 NumberGenerator generator = new NumberGenerator();
		 generator.start();
	 }
 }
