import java.util.Scanner;
import java.io.File;

public class HashChain {

	public static void main(String[] args)throws Exception {
		File fn = new File(args[0]);
		Scanner fin = new Scanner(fn);
		Scanner kb = new Scanner(System.in);
		LinkedList[] array = new LinkedList[5];
		int choice;
		
		while(fin.hasNext()) {
			String str = fin.nextLine();
			String[] arr = str.split(",", 2);
			Node n = new Node(Integer.parseInt(arr[0]), arr[1], null);
			array = hash(n, array);
		}
		
		do {
			choice = menu(kb);
			
			switch(choice)
	         {
	         	case 1: array = insert(array, kb);
	         			break;
				
	         	case 2: array = delete(array, kb);
	         			break;
	         		
	         	case 3: search(array, kb);
	         			break;
	         		
	         	case 4:	print(array);
	         			break;
			
	         }
			
		}while(choice != 5);
		
		
		fin.close();
		kb.close();
	}
	
	public static int menu(Scanner kb) {
		int choice = 0;
		
		while(choice < 1 || choice > 5) {
		System.out.println("Choose one of the following options.");
		System.out.println("====================================");
		System.out.println("1) insert/update a new student record");
		System.out.println("2) delete a student record");
		System.out.println("3) search for a student record");
		System.out.println("4) print all the student records");
		System.out.println("5) quit\n");
		System.out.print("Your choice: ");
		choice = kb.nextInt();
		kb.nextLine();
		}
		
		return choice;
	}
	
	public static LinkedList[] hash(Node n, LinkedList[] arr) {
		int i = (7 * n.getId() + 29) % 5;
		if(arr[i] == null) 
			arr[i] = new LinkedList();
		arr[i].add(n);
		return arr;
	}
	
	public static LinkedList[] insert(LinkedList[] arr, Scanner kb) {
		Node cur;
		System.out.print("Input the student id: ");
		int id = kb.nextInt();
		kb.nextLine();
		System.out.print("Input the student name: ");
		String name = kb.nextLine();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null) {
				cur = arr[i].head();
			while(cur != null) {
				if(cur.getId() == id) {
					cur.setName(name);
					System.out.println("The student was existing"
							+ " and the record has been updated.");
					return arr;
				}
				cur = cur.getNext();
			}				
			}
		}
		
		Node n = new Node(id, name, null);
		arr = hash(n, arr);
		System.out.println("The new student has been added successfully.");
		return arr;
	}
	
	public static LinkedList[] delete(LinkedList[] arr, Scanner kb) {
		Node cur;
		System.out.print("Input the student id: ");
		int id = kb.nextInt();
		kb.nextLine();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null) {
				cur = arr[i].head();
			while(cur != null) {
				if(cur.getId() == id) {
					arr[i].remove(cur);
					System.out.println("The student has been"
							+ " deleted successfully.");
					return arr;
				}
				cur = cur.getNext();
			}
			}
			
		}
		System.out.println("No such student.");
		return arr;
	}
	
	public static void search(LinkedList[] arr, Scanner kb) {
		Node cur;
		System.out.print("Input the student id: ");
		int id = kb.nextInt();
		kb.nextLine();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null) {
				cur = arr[i].head();
			while(cur != null) {
				if(cur.getId() == id) {
					System.out.println("Student id: "
							+ cur.getId()
							+ " Student name: " 
							+ cur.getName());
					return;
				}
				cur = cur.getNext();
			}
			}
		}
		System.out.println("No such student.");
		
	}
	
	public static void print(LinkedList[] arr) {
		Node cur;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null) {
			cur = arr[i].head();
			while(cur != null) {
				System.out.print("(" + cur.getId() + ", " 
			+ cur.getName()	+ ")" + " ");
			cur = cur.getNext();
			}
			}
			System.out.println();
		}
	}

}
