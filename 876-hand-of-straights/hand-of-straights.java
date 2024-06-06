class Solution {

    static Boolean findConsecutives(int[] hand, int curr, int groupSize, int p){
        int cnt=1;
        boolean foundConsec= false;
        int n=hand.length;
        while(cnt<groupSize){
            foundConsec=false;
            for(int i=p+1;i<n;i++){
                if(hand[i]!=-1 && hand[i]==curr+1){
                    curr=hand[i];
                    hand[i]=-1;
                    cnt++;
                    foundConsec=true;
                    break;
                }
            }  
            if(!foundConsec)return false;
        }
        return foundConsec;
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        //return false if the array is not divisible by groupSize
        int len = hand.length;
        Arrays.sort(hand);
        if(len%groupSize!=0)return false;
        //checking consecutives marking -1
        if(groupSize>1){
            for(int i=0;i<len;i++){
                //card cannot be -1
                if(hand[i]!=-1){
                    int curr= hand[i];
                    hand[i]=-1;
                    if(!findConsecutives(hand, curr, groupSize, i)){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
/** 
1, 2, 2, 3, 3, 4, 6, 7, 8, 
//checking consecutive numbers exist?
//using visited array O(n^2) and O(n)
1, 2, 3, 2, 3, 4, 6, 7, 8
*/