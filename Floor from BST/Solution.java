import java.util.*;

public class solution {
	public static int Floor(BinaryTreeNode<Integer> node, int input) {
		int floor=-1;
		while(node!=null){
			if(node.data==input){
				floor=node.data;
				return floor;
			}else if(node.data>input){
				node=node.left;
			}else{
				floor=node.data;
				node=node.right;
			}
		}
		return floor;
	}

}
