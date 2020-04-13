package SortingAlgorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {
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
	static void merge(int a[], int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];

		for (int i = 0; i < n1; i++)
			L[i] = a[p + i];
		for (int j = 0; j < n2; j++)
			R[j] = a[q + 1 + j];
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;

		int i = 0;
		int j = 0;
		for (int k = p; k <= r; k++) {
			if (L[i] <= R[j]) {
				a[k] = L[i];
				i++;
			} else {
				a[k] = R[j];
				j++;
			}
		}
	}

	public static int[] sort(int a[], int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			sort(a, p, q);
			sort(a, q + 1, r);
			merge(a, p, q, r);
		}
		return a;
	}
	
	public static void main(String... args) {
		String[] files = {"int10", "int50","int100","int1000","int20k", "int500k", "intBig", "dutch"};
		System.out.println("---------------------");
		System.out.println("MERGE SORT");
		for(String file: files) {
			try {
				System.out.println("---------------------");
				System.out.print("File Name: ");
				System.out.println(file);
				int[] A = readFile(System.getProperty("user.dir")+ "\\Files\\" + file +".txt");
				int n = A.length;
				System.out.print("Is Sorted? ");
				long startTime = System.nanoTime();
				int[] B = sort(A, 0, n-1);
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