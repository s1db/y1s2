package SortingAlgorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {
	private static int[] readFile(String filePath) throws IOException{
		ArrayList<Integer> arrayList = new ArrayList<>();
		try (Scanner s = new Scanner(new File(filePath))) {
		    while (s.hasNext()) {
		    	int p = Integer.parseInt(s.nextLine());
		        arrayList.add(p);
		    }
		}
		catch (FileNotFoundException e) {
		    // Handle the potential exception
		}
		int[] A = new int[arrayList.size()];
	    for (int i=0; i < A.length; i++)
	    {
	        A[i] = arrayList.get(i).intValue();
	    }
	    return A;
	}

	//TEST
	public static boolean isSorted(int a[]){
		int n = a.length;
		for (int i = 0; i < n-1; i++){
			if (a[i] > a[i+1]){
				return false;
			}
		}
		return true;
	}
	//INSERTION SORT
	private static int[] insertionSort(int[] A, int p, int r) {
		for (int x = p + 1; x <= r; x++){
            int key = A[x];
            int j = x - 1;
            while (j >= 0 && key < A[j]){
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key;
        }
		return A;
	}

	public static void main(String... args) {
		String[] files = {"int10", "int50","int100","int1000","int20k", "int500k", "intBig", "dutch"};
		System.out.println("---------------------");
		System.out.println("INSERTION SORT");
		for(String file: files) {
			try {
				System.out.println("---------------------");
				System.out.print("File Name: ");
				System.out.println(file);
				int[] A = readFile(System.getProperty("user.dir")+ "\\Files\\" + file +".txt");
				int n = A.length;
				System.out.print("Is Sorted? ");
				long startTime = System.nanoTime();
				int[] B = insertionSort(A, 0, n-1);
				long endTime = System.nanoTime();
				System.out.println(isSorted(B));
				System.out.println("time taken: "+(endTime - startTime)+" ns");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
