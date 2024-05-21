//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        //DLRU since lexicographical answer required
        //extra space to keep track of visited nodes
        //checking if DLRU possible if 1 present since that is allowedPath
        //checking if DLRU possible if not visited
        //checking if DLRU possible if reached edge of the graph 
        //checking if DLRU possible if reached n-1*n-1
        ArrayList<String> paths = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        int[] di = {+1, 0, 0, -1};
        int[] dj = {0, -1, +1, 0};
        if(m[0][0]==1){
            visited[0][0]=true;
            recursivePathFindings(0,0, visited, paths,n, "",m, di, dj);
        }
        return paths;
    }
    
    static void recursivePathFindings(int row, int col, boolean[][] visited, ArrayList<String> path, int n, String str, int[][] m, int[] di, int[] dj){
        if(row==n-1 && col==n-1){
            path.add(str);
            return;
        }
        String dir = "DLRU";
        for(int i=0;i<4;i++){
            int nextRow = row+di[i];
            int nextCol = col+dj[i];
            if(nextRow>=0 && nextCol>=0 && nextRow<n && nextCol<n && !visited[nextRow][nextCol] && m[nextRow][nextCol]==1){
                visited[nextRow][nextCol]=true;
                recursivePathFindings(nextRow, nextCol, visited, path, n, str+dir.charAt(i), m, di, dj);
                visited[nextRow][nextCol]=false;
            }
        }
    }
    
    

    static void recursivePathFinding(int row,int col,  boolean[][] visited, ArrayList<String> paths, int n, String str, int[][] m){
        if(row==n-1 && col==n-1){
            paths.add(str);
            return;
        }
        ////DLRU
        //Going Down option | +1, 0
        if(row+1<n && !visited[row+1][col] && m[row+1][col]==1){
            visited[row+1][col]=true;
            recursivePathFinding(row+1, col, visited, paths, n, str+"D", m);
            visited[row+1][col]=false;
        }
        //Going Left option | 0, -1
        if(col-1>=0 && !visited[row][col-1] && m[row][col-1]==1){
            visited[row][col-1]=true;
            recursivePathFinding(row, col-1, visited, paths, n, str+"L", m);
            visited[row][col-1]=false;
        }
         //Going right option | 0, +1
        if(col+1<n && !visited[row][col+1] && m[row][col+1]==1){
            visited[row][col+1]=true;
            recursivePathFinding(row, col+1, visited, paths, n, str+"R", m);
            visited[row][col+1]=false;
        }
         //Going up option | -1, 0
        if(row-1>=0 && !visited[row-1][col] && m[row-1][col]==1){
            visited[row-1][col]=true;
            recursivePathFinding(row-1, col, visited, paths, n, str+"U", m);
            visited[row-1][col]=false;
        }
    }
}
