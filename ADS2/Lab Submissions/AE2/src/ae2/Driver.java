package ae2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import BinarySearchTree.BinarySearchTree;
import DoublyLinkedList.DoublyLinkedList;

public class Driver {
	public static BinarySearchTree t1 = new BinarySearchTree();
	public static BinarySearchTree t2 = new BinarySearchTree();
	public static BinarySearchTree t3 = new BinarySearchTree();
	
	public static DoublyLinkedList l1 = new DoublyLinkedList();
	public static DoublyLinkedList l2 = new DoublyLinkedList();
	public static DoublyLinkedList l3 = new DoublyLinkedList();
	public static void populateBSTTest() {
		t1.add(1);
		t1.add(2);
		t1.add(3);
		t1.add(11);
		t1.add(12);
		t1.add(13);
		t2.add(3);
		t2.add(2);
		t2.add(1);
		t2.add(13);
		t2.add(24);
		t1.printInorder(); System.out.println("- " + t1.getSize());
		t2.printInorder(); System.out.println("- " + t2.getSize());
	}

	public static void populateDLLTest() {
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(11);
		l1.add(12);
		l1.add(13);
		l2.add(3);
		l2.add(2);
		l2.add(1);
		l2.add(13);
		l2.add(24);
		l1.printInorder(); System.out.println("- " + l1.getSize());
		l2.printInorder(); System.out.println("- " + l2.getSize());
	}

	public static void populateBST() {
		System.out.println("Inputs will be accepted till you don't enter -1");
		System.out.println("Enter numbers for Set 1");
		Scanner in = new Scanner(System.in);
		int userInput = 0;
		while(userInput != -1) {
			userInput = in.nextInt();
			if (userInput != -1)
				t1.add(userInput);
		}
		System.out.println("Enter numbers for Set 2");
		userInput = 0;
		while(userInput != -1) {
			userInput = in.nextInt();
			if (userInput != -1)
				t2.add(userInput);
		}
		t1.printInorder(); System.out.println("- " + t1.getSize());
		t2.printInorder(); System.out.println("- " + t2.getSize());
	}
	
	public static void populateDLL() {
		System.out.println("Inputs will be accepted till you don't enter -1");
		System.out.println("Enter numbers for Set 1");
		Scanner in = new Scanner(System.in);
		int userInput = 0;
		while(userInput != -1) {
			userInput = in.nextInt();
			if (userInput != -1)
				l1.add(userInput);
		}
		System.out.println("Enter numbers for Set 2");
		userInput = 0;
		while(userInput != -1) {
			userInput = in.nextInt();
			if (userInput != -1)
				l2.add(userInput);
		}
		l1.printInorder(); System.out.println("- " + l1.getSize());
		l2.printInorder(); System.out.println("- " + l2.getSize());
	}

	private static void deleteBSTTest() {
		t2.deleteKey(1);
		t2.deleteKey(2);
		t2.deleteKey(3);
		t2.printInorder();
		System.out.println("- " + l2.getSize());
	}
	private static void deleteDLLTest() {
		l2.deleteElement(1);
		l2.deleteElement(2);
		l2.deleteElement(3);
		l2.printInorder();
		System.out.println("- " + l2.getSize());
	}
	private static void isEmptyBSTTest() {	
		System.out.println("is empty? " + t1.isEmpty());
	}
	private static void isEmptyDLLTest() {	
		System.out.println("is empty? " + l1.isEmpty());
	}

	private static void unionBSTTest() {
		t3 = new BinarySearchTree();
		t3 = t3.unionOfTrees(t1, t2);
		t3.printInorder();
		System.out.println("- " + t3.getSize());
	}
	
	private static void unionDLLTest() {
		
		l3 = l3.unionOfLists(l1, l2);
		l3.printInorder();
		System.out.println("- " + l3.getSize());
	}
	
	private static void intersectionBSTTest() {
		t3 = new BinarySearchTree();
		t3 = t3.intersectionOfTrees(t1, t2);
		t3.printInorder();
		System.out.println("- " + t3.getSize());
	}
	
	private static void intersectionDLLTest() {
		l3 = l3.intersectionOfLists(l1, l2);
		l3.printInorder();
		System.out.println("- " + l3.getSize());
	}

	private static void differenceBSTTest() {
		t3 = new BinarySearchTree();
		t3 = t3.differenceOfTrees(t1, t2);
		t3.printInorder(); System.out.println("- " + t3.getSize());
	}
	
	private static void differenceDLLTest() {
		l3 = l3.differenceOfLists(l1, l2);
		l3.printInorder(); System.out.println("- " + l3.getSize());
	}

	private static void isSubsetBSTTest() {
		System.out.println("is t2 a subset of t1? " + t2.isSubset(t1));
	}
	private static void isSubsetDLLTest() {
		System.out.println("is l2 a subset of l1? " + l2.isSubset(l1));
	}
	
	private static int[] readFile(String filePath) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		try (Scanner s = new Scanner(new File(filePath))) {
			while (s.hasNext()) {
				int p = Integer.parseInt(s.nextLine());
				arrayList.add(p);
			}
		} catch (FileNotFoundException e) {
			// Handle the potential exception
		}
		int[] A = new int[arrayList.size()];
		for (int i = 0; i < A.length; i++) {
			A[i] = arrayList.get(i).intValue();
		}
		return A;
	}
	
	private static void empericalStudy() {
		int[] A = readFile(System.getProperty("user.dir")+ "\\Files\\" + "int20k" +".txt");
		long BSTTimeSum = 0;
		long DLLTimeSum = 0;
	    Random random = new Random();
		for(int number : A) {
			t1.add(number);
			l1.add(number);
		}
		long startTime = 0, endTime = 0;
		for (int i = 0; i < 100; i++)
	    {
			int number = random.nextInt(50000);
			System.out.println(number);
	        startTime = System.nanoTime();
	        l1.hasElement(number);
	        endTime = System.nanoTime();
	        DLLTimeSum += (endTime - startTime)/100;
	        
	        startTime = System.nanoTime();
	        t1.hasElement(number);
	        endTime = System.nanoTime();
	        BSTTimeSum += (endTime - startTime)/100;
	    }
		System.out.println("-------------------------------");
		System.out.println("Average time taken by BST: " + BSTTimeSum);
		System.out.println("Average time taken by DLL: " + DLLTimeSum);
		System.out.println("Set size of BST: "+t1.getSize());
		System.out.println("Set size of DLL: "+l1.getSize());
		System.out.println("Depth of BST: "+t1.maxDepth());
	}
	
	public static void BSTSwitchCase() {
		System.out.println("Choose thing following option. Enter -1 to end. \n 1: Populate with own data \n 2: Populate with test data");
		Scanner in = new Scanner(System.in);
		int option = in.nextInt();
		switch(option) {
		case 1:
			populateBST();
			break;
		case 2:
			populateBSTTest();
			break;
		}
			System.out.println("Choose thing following option. \n 1: union \n 2: interesection \n 3: difference \n 4: subset test");
			option = in.nextInt();
			switch(option) {
			case 1:
				unionBSTTest();
				break;
			case 2:
				intersectionBSTTest();
				break;
			case 3:
				differenceBSTTest();
				break;
			case 4:
				isSubsetBSTTest();
				break;
			}
	}
	public static void DLLSwitchCase() {
		System.out.println("Choose thing following option. Enter -1 to end. \n 1: Populate with own data \n 2: Populate with test data");
		Scanner in = new Scanner(System.in);
		int option = in.nextInt();
		switch(option) {
		case 1:
			populateDLL();
			break;
		case 2:
			populateDLLTest();
			break;
		}
			System.out.println("Choose thing following option.\n 1: union \n 2: interesection \n 3: difference \n 4: subset test");
			option = in.nextInt();
			switch(option) {
			case 1:
				unionDLLTest();
				break;
			case 2:
				intersectionDLLTest();
				break;
			case 3:
				differenceDLLTest();
				break;
			case 4:
				isSubsetDLLTest();
				break;
			}
		
		in.close();
	}
	public static void main(String... args) {
		System.out.println("Choose thing following option. \n 1: BST \n 2: DLL");
		Scanner in = new Scanner(System.in);
		int option = in.nextInt();
		switch(option) {
		case 1:
			BSTSwitchCase();
			break;
		case 2:
			DLLSwitchCase();
			break;
		}
		in.close();
		
//		populateDLL();
//		differenceDLLTest(); 
//		populateBST();
//		isSubsetDLLTest();
//		intersectionBSTTest();
//		unionBSTTest();
//		deleteBSTTest();
//		empericalStudy();
	}
}
