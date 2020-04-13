package SortingAlgorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MedianOfThreeQuickSort {
	private static void prettyprint(int arr[]) { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
    } 

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

	
	//SWAP
	private static int[] swap(int[] A, int a, int b) {
		int key = A[a];
		A[a] = A[b];
		A[b] = key;
		return A;
	}
	//MEDIAN OF THREE VALUE PARTITION
	private static int medianValuePiviot(int[] A, int p, int r) {
		int c = (p + r) / 2;
		if (A[r] < A[p])
			A = swap(A, r, p);
		if (A[c] < A[p])
		    A = swap(A, c, p);
		if (A[r] < A[c])
		    A = swap(A, r, c);
		A = swap(A, r-1, c);
		int x = A[r-1];
		int i = p - 1;
		for (int j=p; j<r; j++) {
			if(A[j]<=x) {
				i += 1;
				A = swap(A, i, j);
			}
		}
		A = swap(A, i+1, r);
		return i+1;
		
		

	}
	//PART 1C
	public static int[] medianOfThreeQuickSort(int[] A, int p, int r) {
		if(p<r) {
			int q = medianValuePiviot(A,p,r);
			medianOfThreeQuickSort(A,p,q-1);
			medianOfThreeQuickSort(A,q+1,r);
		}
		return A;
	}
	
	//PATHOLOGICAL INPUT
	public static int[] pathologicalInput(int a) {
        int[] A= new int[a]; //initialising pathological array.
        
        int i=0; //index value counter
        for(int num=0; num<a;num++) {
          if(num%2==0){ //all even numbers get added to the left positions of A.
            A[i] = num;
            i++;
          }
          else { //all odd numbers get added to the left positions of A.
            A[a-i] = num;
          }
        }
        return A;
    }
	public static void main(String... args) {
//		prettyprint(pathologicalInput(10));
		String[] files = {"int10", "int50","int100","int1000","int20k", "int500k", "intBig", "dutch"};
		System.out.println("--------------------------");
		System.out.println("MEDIAN OF THREE QUICK SORT");
		for(String file: files) {
			try {
				System.out.println("--------------------------");
				System.out.print("File Name: ");
				System.out.println(file);
				int[] A = readFile(System.getProperty("user.dir")+ "\\Files\\" + file +".txt");
				int n = A.length;
				System.out.print("Is Sorted? ");
				long startTime = System.nanoTime();
				int[] B = medianOfThreeQuickSort(A, 0, n-1);
				long endTime = System.nanoTime();
				System.out.println(isSorted(B));
				System.out.println("time taken: "+(endTime - startTime)+" ns");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
