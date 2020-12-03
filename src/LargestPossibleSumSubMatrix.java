
public class LargestPossibleSumSubMatrix {
	
	class Coordinate {
		int x; 
		int y; 
		
		Coordinate(int x, int y) {
			this.x = x; 
			this.y = y; 
		}
		
		public void updatePositionOnGraph(int x, int y) {
			this.x = x; 
			this.y = y; 
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
	}
	
	
	public void findMaxMatrixSum(int[][] matrix, int k) {
		
		int N = matrix.length;
		
		// Checks if K is bigger than the size of the array 
		// it breaks off from the function 
        if (k > N) 
            return; 
  
        int[][] stripSum = new int[N][N]; 
  
        // Go column by column 
        for (int j = 0; j < N; j++) { 
  
        	int sum = 0; 
        	
        	
            for (int i = 0; i < k; i++) {
                sum += matrix[i][j]; 
            }
            
            stripSum[0][j] = sum; 
  
            // Calculate sum of remaining rectangles 
            for (int i = 1; i < N - k + 1; i++) { 
                sum += (matrix[i + k - 1][j] - matrix[i - 1][j]); 
                stripSum[i][j] = sum; 
            } 
        } 

        int maximumSum = Integer.MIN_VALUE; 
        Coordinate cor = new Coordinate(-1, -1); 
  
        for (int i = 0; i < N - k + 1; i++) { 
  

            int sum = 0; 
            for (int j = 0; j < k; j++) 
                sum += stripSum[i][j]; 
  
            if (sum > maximumSum) { 
                maximumSum = sum; 
                cor.updatePositionOnGraph(i, 0); 
            } 
  
            for (int j = 1; j < N - k + 1; j++) { 
                sum += (stripSum[i][j + k - 1] - stripSum[i][j - 1]); 
  
                // Update max_sum and position of result 
                if (sum > maximumSum) { 
                    maximumSum = sum; 
                    cor.updatePositionOnGraph(i, j); 
                } 
            } 
        } 
  
        // Print the result matrix 
        for (int i = 0; i < k; i++) { 
            for (int j = 0; j < k; j++) { 
                System.out.print(matrix[i + cor.getX()][j + cor.getY()] + " "); 
            } 
            System.out.println(); 
        } 
		
	}	
}
