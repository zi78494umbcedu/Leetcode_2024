class Solution {
    int[][] dirs = new int[][]{{-1,0}, {1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2]-b[2]);
        pq.add(new int[]{0,0,grid[0][0]});
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int r = curr[0];
            int c = curr[1];
            int time = curr[2];
            for (int[] dir : dirs) {
                int dirR = r + dir[0];
                int dirC = c + dir[1];
                if (dirR < 0 || dirR >= m || dirC < 0 || dirC >= n || visited[dirR][dirC]) {
                    continue;
                }
                if (dirR == m-1 && dirC == n-1) {
                    return Math.max(time, grid[dirR][dirC]);
                }
                visited[dirR][dirC] = true;
                pq.add(new int[]{dirR, dirC, Math.max(time, grid[dirR][dirC])});
            }
        }
        return grid[0][0];
    }
}