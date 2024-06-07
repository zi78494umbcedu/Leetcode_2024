class Solution {

    static void dfs(int row, int col, int[] rows, int[] cols, int[][] grid, boolean[][] visited, int row0, int col0, int m, int n, List<int[]> island) {
        visited[row][col] = true;
        island.add(new int[]{row, col});
        for (int i = 0; i < rows.length; i++) {
            int ru = row + rows[i];
            int cu = col + cols[i];
            if (ru >= 0 && ru < m && cu >= 0 && cu < n && !visited[ru][cu] && grid[ru][cu] == 1) {
                dfs(ru, cu, rows, cols, grid, visited, row0, col0, m, n, island);
            }
        }
    }

    public int numDistinctIslands2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] rows = {-1, 0, +1, 0};
        int[] cols = {0, +1, 0, -1};
        // depth-first traversal
        Set<Map<Integer, Integer>> allDistinctIslands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    List<int[]> island = new ArrayList<>();
                    dfs(i, j, rows, cols, grid, visited, i, j, m, n, island);
                    Map<Integer, Integer> allDistanceCountMap = new HashMap<>();
                    for (int p = 0; p < island.size(); p++) {
                        for (int r = p + 1; r < island.size(); r++) {
                            int dist = (int) Math.pow(island.get(p)[0] - island.get(r)[0], 2) + (int) Math.pow(island.get(p)[1] - island.get(r)[1], 2);
                            allDistanceCountMap.put(dist, allDistanceCountMap.getOrDefault(dist, 0) + 1);
                        }
                    }
                    allDistinctIslands.add(allDistanceCountMap);
                }
            }
        }
        return allDistinctIslands.size();
    }

}
