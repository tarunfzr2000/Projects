import java.util.*;
public class InsertionMerge
{
	static void insertion_sort(int A[])
	{
		for (int i=1; i< A.length; ++i)
        {
            int key = A[i];
            int j = i-1;
            while (j>=0 && A[j] > key)
            {
                A[j+1] = A[j];
                j = j-1;
            }
            A[j+1] = key;
        }
	}
	
	static void merge_sort(int A[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            merge_sort(A, l, m);
            merge_sort(A , m+1, r);
 
            // Merge the sorted halves
            merge(A, l, m, r);
        }
    }
	
	static void merge(int A[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = A[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = A[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                A[k] = L[i];
                i++;
            }
            else
            {
                A[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            A[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            A[k] = R[j];
            j++;
            k++;
        }
    }
 
    public static void main(String args[])  
	{
    	long start, time;
    	// A part ==>
    	System.out.println("2.A.)");
    	System.out.println();
    	int A[]=new int[100];
    	int B[]=new int[100];
    	for(int i=0;i<100;i++)
    	{
    		A[i] = i;
    	}
    	for(int i=0;i<100;i++)
    	{
    		B[100-i-1] = i;
    	}
    	Random random = new Random();
        int[] C = new int[100];
        for(int i = 0; i < 100; i++) 
        {
            C[i] = random.nextInt(100);
        }
    	System.out.println("case 1: for a sorted array of 100 elements in ascending order ==> ");
    	System.out.print("Insertion sort : ");
    	start = System.nanoTime();
    	insertion_sort(A);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.print("Merge sort : ");
    	start = System.nanoTime();
    	merge_sort(A,0,99);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.println();
    	System.out.println("case 2: for a sorted array of 100 elements in descending order ==> ");
    	System.out.print("Insertion sort : ");
    	start = System.nanoTime();
    	insertion_sort(B);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.print("Merge sort : ");
    	start = System.nanoTime();
    	merge_sort(B,0,99);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.println();
    	System.out.println("case 3: for a random array of 100 elements ==> ");
    	System.out.print("Insertion sort : ");
    	start = System.nanoTime();
    	insertion_sort(C);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.print("Merge sort : ");
    	start = System.nanoTime();
    	merge_sort(C,0,99);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.println();
    	// B part ==>
    	System.out.println("2.B.)");
    	System.out.println();
    	int D[]=new int[1000];
    	int E[]=new int[1000];
    	for(int i=0;i<1000;i++)
    	{
    		D[i] = i;
    	}
    	for(int i=0;i<1000;i++)
    	{
    		E[1000-i-1] = i;
    	}
        int[] F = new int[1000];
        for(int i = 0; i < 1000; i++) 
        {
            F[i] = random.nextInt(1000);
        }
    	System.out.println("case 1: for a sorted array of 1000 elements in ascending order ==> ");
    	System.out.print("Insertion sort : ");
    	start = System.nanoTime();
    	insertion_sort(D);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.print("Merge sort : ");
    	start = System.nanoTime();
    	merge_sort(D,0,999);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.println();
    	System.out.println("case 2: for a sorted array of 1000 elements in descending order ==> ");
    	System.out.print("Insertion sort : ");
    	start = System.nanoTime();
    	insertion_sort(E);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.print("Merge sort : ");
    	start = System.nanoTime();
    	merge_sort(E,0,999);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.println();
    	System.out.println("case 3: for a random array of 1000 elements ==> ");
    	System.out.print("Insertion sort : ");
    	start = System.nanoTime();
    	insertion_sort(F);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.print("Merge sort : ");
    	start = System.nanoTime();
    	merge_sort(F,0,999);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.println();
    	// C part ==>
    	System.out.println("2.C.)");
    	System.out.println();
    	int G[]=new int[10000];
    	int H[]=new int[10000];
    	for(int i=0;i<10000;i++)
    	{
    		G[i] = i;
    	}
    	for(int i=0;i<10000;i++)
    	{
    		H[10000-i-1] = i;
    	}
        int[] I = new int[10000];
        for(int i = 0; i < 10000; i++) 
        {
            I[i] = random.nextInt(10000);
        }
    	System.out.println("case 1: for a sorted array of 10000 elements in ascending order ==> ");
    	System.out.print("Insertion sort : ");
    	start = System.nanoTime();
    	insertion_sort(G);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.print("Merge sort : ");
    	start = System.nanoTime();
    	merge_sort(G,0,9999);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.println();
    	System.out.println("case 2: for a sorted array of 10000 elements in descending order ==> ");
    	System.out.print("Insertion sort : ");
    	start = System.nanoTime();
    	insertion_sort(H);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.print("Merge sort : ");
    	start = System.nanoTime();
    	merge_sort(H,0,9999);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.println();
    	System.out.println("case 3: for a random array of 10000 elements ==> ");
    	System.out.print("Insertion sort : ");
    	start = System.nanoTime();
    	insertion_sort(I);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.print("Merge sort : ");
    	start = System.nanoTime();
    	merge_sort(I,0,9999);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.println();
    	// D part ==>
    	System.out.println("2.D.)");
    	System.out.println();
    	int J[]=new int[100000];
    	int K[]=new int[100000];
    	for(int i=0;i<100000;i++)
    	{
    		J[i] = i;
    	}
    	for(int i=0;i<100000;i++)
    	{
    		K[100000-i-1] = i;
    	}
        int[] L = new int[100000];
        for(int i = 0; i < 100000; i++) 
        {
            L[i] = random.nextInt(100000);
        }
    	System.out.println("case 1: for a sorted array of 100000 elements in ascending order ==> ");
    	System.out.print("Insertion sort : ");
    	start = System.nanoTime();
    	insertion_sort(J);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.print("Merge sort : ");
    	start = System.nanoTime();
    	merge_sort(J,0,99999);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.println();
    	System.out.println("case 2: for a sorted array of 100000 elements in descending order ==> ");
    	System.out.print("Insertion sort : ");
    	start = System.nanoTime();
    	insertion_sort(K);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.print("Merge sort : ");
    	start = System.nanoTime();
    	merge_sort(K,0,99999);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.println();
    	System.out.println("case 3: for a random array of 100000 elements ==> ");
    	System.out.print("Insertion sort : ");
    	start = System.nanoTime();
    	insertion_sort(L);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.print("Merge sort : ");
    	start = System.nanoTime();
    	merge_sort(L,0,99999);
    	time = System.nanoTime() - start;
    	System.out.println(time);
    	System.out.println();
    }
}
