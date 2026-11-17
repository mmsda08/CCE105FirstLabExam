package p1;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CCE105 {
	
	static Scanner input = new Scanner(System.in);
	static Queue<String> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		int choice;
		do {
		System.out.println("===== Permutation =====");
		System.out.println("[1] Add Elements");
		System.out.println("[2] Display Queue");
		System.out.println("[3] Generate Permutation");
		System.out.println("[4] Dequeue Elements");
		System.out.println("[5] Exit");
		System.out.println("Enter choice: ");
		choice = input.nextInt();
		
			switch(choice) {
			case 1:
				addElements();
				break;
			case 2:
				displayQueue();
				break;
			case 3:
				generatePerm();
				break;
			case 4:
				dequeueE();
				break;
			case 5:
			System.out.println("Program Terminated...");
				break;
			default:
				System.out.println("Invalid choice...");
			}
			
		}while(choice !=5 );

	}
	
	static void addElements() {
		
		System.out.println("How many elements to add? ");
		int count = input.nextInt();
		
		for (int i = 1; i <= count; i++) {
			System.out.println("Elements "+ i +": ");
			queue.add(input.next());
		}
		System.out.println(count + " element added...");
	}
	
	static void displayQueue() {
	
	if (queue.isEmpty()) {
		System.out.println("\nQueue is empty...\n");
		return;
			}
		System.out.println("Queue: "+queue);
	}
	
	static void generatePerm() {
		if(queue.isEmpty()) {
			System.out.println("\nQueue is empty...");
			return;
		}
		List<String> items = new ArrayList<>(queue);
		int n = items.size();
		
		System.out.println("Enter number of elements to arrange: ");
		int r = input.nextInt();
		if(r < 1 || r > n) {
			System.out.println("Invalid r...");
			return;
			
		}
		
		permCount = 0;
		permute(items, r ,new boolean[n], "");
		System.out.println("Total Permutation: "+permCount);
	}
	
	static int permCount;
	static void permute(List<String> items, int r, boolean[] used, String current) {
		if(r == 0) {
			System.out.println(current);
			permCount++;
			return;
		}
		for(int i = 0; i < items.size(); i++) {
			if(!used[i]) {
				used[i] = true;
				permute(items, r -1, used, current + items.get(i)+" ");
				used[i] = false;
			}
		}
	}
	
	static void dequeueE() {
		if (queue.isEmpty()) {
		System.out.println("Queue is empty...");
		}	
		System.out.println("Current queue: " + queue);
		System.out.println("Enter element to dequeue: ");
		String element = input.next();
			
			if(queue.remove(element)) {
				System.out.println(element+" has beem dequeue...");
			}
				System.out.println("Updated Queue: "+queue);
		}
	}
	
