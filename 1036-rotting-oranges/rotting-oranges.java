import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int cntFresh = 0;
        Queue<int[]> q = new LinkedList<>();
        
        // Initialization: Adding rotten oranges to the queue and counting fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (grid[i][j] == 2) {
                        q.add(new int[]{i, j});
                        visited[i][j] = true;
                    } else if (grid[i][j] == 1) {
                        cntFresh++;
                    }
                }
            }
        }
        
        // BFS traversal
        int minTime = 0;
        int[] rows = {-1, 0, 1, 0};
        int[] cols = {0, 1, 0, -1};
        
        // BFS loop
        while (!q.isEmpty() && cntFresh > 0) {
            int size = q.size();
            boolean changed = false; // Flag to check if any fresh oranges were rotten in this iteration
            
            // Process all oranges currently in the queue
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                int r = temp[0];
                int c = temp[1];
                
                // Check all four directions
                for (int j = 0; j < 4; j++) {
                    int ru = r + rows[j];
                    int cu = c + cols[j];
                    
                    // If the neighboring cell is within bounds, not visited, and a fresh orange
                    if (ru >= 0 && ru < m && cu >= 0 && cu < n && !visited[ru][cu] && grid[ru][cu] == 1) {
                        visited[ru][cu] = true;
                        q.add(new int[]{ru, cu});
                        grid[ru][cu] = 2; // Mark the orange as rotten
                        cntFresh--; // Decrement the count of fresh oranges
                        changed = true; // Set the flag indicating a change occurred
                    }
                }
            }
            
            // If any fresh oranges were rotten in this iteration, increment the time
            if (changed) {
                minTime++;
            }
        }
        
        // If there are still fresh oranges left, return -1; otherwise, return the minimum time
        return cntFresh == 0 ? minTime : -1;
    }
}
