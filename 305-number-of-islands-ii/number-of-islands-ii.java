class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            size.add(1);
            parent.add(i);
        }
    }
    public int getParent(int node){
        if(node==parent.get(node)){
            return node;
        }
        int interimParent= getParent(parent.get(node));
        parent.set(node, interimParent);
        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int parentU = getParent(u);
        int parentV = getParent(v);
        if(parentU==parentV)return;
        int sizeU = size.get(parentU);
        int sizeV = size.get(parentV);
        if(sizeU>sizeV){
            parent.set(parentV, parentU);
            size.set(parentU, sizeU+sizeV);
        }
        else{
            parent.set(parentU, parentV);
            size.set(parentV, sizeU+sizeV);
        }
    }
    public void unionByRank(int u, int v){
         int parentU = getParent(u);
        int parentV = getParent(v);
        if(parentU==parentV)return;
        int rankU = rank.get(parentU);
        int rankV = rank.get(parentV);
        if(rankU>rankV){
            parent.set(parentV, parentU);
        }
        else if(rankU<rankV){
            parent.set(parentU, parentV);
        }else{
            parent.set(parentU, parentV);
            rank.set(parentV, rank.get(parentV)+1);
        }
    }

}   

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        //mark visited
        //check adjacent nodes if 
        //can connect, for the adjancent parent is not connected already then connect and count--
        //if parent matching then connect only
        //number of islands at turn operation
        List<Integer> answer=new ArrayList<>();
        boolean[][] visited =new boolean[m][n];
        DisjointSet ds=new DisjointSet(m*n);
        int cnt=0;
        for(int ptr=0;ptr<positions.length;ptr++){
            int i=positions[ptr][0];
            int j=positions[ptr][1];
            if(visited[i][j]){
                answer.add(cnt);
                continue;
            }
            visited[i][j]=true;
            cnt++;
            //top row-1, col//right row, col+1//down row+1, col//left row col-1
            int[] rows={-1, 0, +1, 0};
            int[] cols={0, +1, 0, -1};
            for(int k=0;k<4;k++){
                int ru = i+rows[k];
                int cu = j+cols[k];
                if(ru>=0 && ru<m && cu>=0 && cu<n){
                    if(visited[ru][cu]){
                        int nodeNo = i*n+j;
                        int adjacent = ru*n+cu;
                        if(ds.getParent(nodeNo)!=ds.getParent(adjacent)){
                            cnt--;
                            ds.unionByRank(nodeNo, adjacent);
                        }
                    }
                }
            }
            answer.add(cnt);
        }
    return answer;
    }
}