class Solution {
    public int findContentChildren(int[] g, int[] s) {
        /**
        Sort the two arrays ascending order
        1.cookie jar
        2.hunger sizes
        2-pointer
        if hunger ==1 find >=1 and move pointers
        move pointer 1 until cookie not found
        */
        if(s.length==0)return 0;
        Arrays.sort(s);
        Arrays.sort(g);
        //7 8 9 10
        // 5 6 7 8
        int kids=0;
        int cookies=0;

        while(kids<g.length && cookies<s.length){
            if(s[cookies]>=g[kids]){
                kids++;
                cookies++;
            }else{
                cookies++;
            }
        } 
        return kids;

    }
}