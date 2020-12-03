// Luis Santander
// CS3310 - Analysis of Algorithms
// Professor Nima
// Final Exam 

public class App {
	
	public static void main(String[] args) {
		
/**
 * 2. You are given an array of integers (both positive and negative val-ues). Find the contiguous sequence with the largest sum.
EXAMPLE
Input: 2, -8, 3, -2, 4, -10
Output: 5    which is the sequence [3, -2, 4]
 */
// --------------------------------------------------------------------------
		int arr[] = {2, -8, 3, -2, 4, -10};
		
		ContinousSubSequenceLargeSum seq = new ContinousSubSequenceLargeSum();
		seq.generateAllSubSequences(arr);
		seq.solve(arr);
// --------------------------------------------------------------------------	
// 3. Given 2 very large binary trees T1 and T2. Create an algorithm to
//   determine if T2 is a subtree of T1. Assume T1 is always much larger than T2.
	
		Tree<Integer> t1 = new BinarySearchTree<>(); 
		Tree<Integer> t2 = new BinarySearchTree<>(); 

		t1.insert(1);
		t1.insert(2);
		t1.insert(5);
		t1.insert(10);
		t1.insert(1);
		t1.insert(100);
		t1.insert(90);
		t1.insert(80);
		t1.insert(70);
		t1.insert(360);
			
		t2.insert(100);
		t2.insert(90);
		t2.insert(80);
		t2.insert(70);
		t2.insert(360);
	
		System.out.println("T2 is a subtree of T1 " + subTreeTest(t1, t2));
// --------------------------------------------------------------------------			
// 4.	Given an NxN matrix of positive and negative integers, 
//		find the sub-matrix with the largest possible sum.
        int[][] matrix = { { 1, 1, 1, 1, 1 },  
                { 2, 2, 2, 2, 2 },  
                { 3, 8, 6, 7, 3 },  
                { 4, 4, 4, 4, 4 }, 
            { 5, 5, 5, 5, 5 } }; 
		int k = 3; 
		
		LargestPossibleSumSubMatrix solve = new LargestPossibleSumSubMatrix(); 
		
		solve.findMaxMatrixSum(matrix, k);
// --------------------------------------------------------------------------
	}
	
	static public Boolean subTreeTest(Tree<Integer> t1, Tree<Integer> t2) {
		
		// Do a Pre-Order Traversal 
		t1.traversal(1);
		t2.traversal(1);
		
		// Get the Traversal String 
		String t1Values = t1.getTraversalString();
		String t2Values = t2.getTraversalString(); 
		
		Boolean isSubTree = false; 
		
		for(int i = 0; i < t1Values.length(); i++) {
			 // System.out.println(t1Values.substring(i));
			 
			if (t1Values.substring(i).equals(t2Values)) {
				isSubTree = true; 
				break; 
			}
		}
		 return isSubTree; 
	}
}
