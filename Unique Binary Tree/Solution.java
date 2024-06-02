public class Solution {
    public static boolean uniqueBinaryTree(int a, int b){
        //preOrder==1
        //inOrder ==2
        //postOrder==3
        //not all 2, and at max one ==2
        return (a==2||b==2)&&(!(a==2&&b==2));
    }
}
