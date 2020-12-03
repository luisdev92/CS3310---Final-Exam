
public class ContinousSubSequenceLargeSum {
	
	void generateAllSubSequences(int[] arr) {
		
		int n = arr.length;
        // Pick starting point 
        for (int i=0; i <n; i++) 
        { 
            // Pick ending point 
            for (int j=i; j<n; j++) 
            { 
                // Print subarray between current starting 
                // and ending points 
            	
            	int sum = 0; 
            	
                for (int k=i; k<=j; k++) {
                    System.out.print(arr[k]+" "); 
                    sum += arr[k]; 
                }
                System.out.println(" Sum=" + sum);
            } 
        } 
	}
	
	// 
	void solve(int[] arr) {
		int global_maximum = arr[0]; 
		int current_maximum = arr[0]; 
		
		int n = arr.length;
		
		for(int i = 1; i < n; i++) {
			
			current_maximum = Math.max(arr[i], current_maximum + arr[i]);
			
			if (current_maximum > global_maximum) {
				global_maximum = current_maximum; 
			}
		}
		
		System.out.println(global_maximum); 
	}
}
