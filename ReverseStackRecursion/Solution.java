import java.util.Stack;

public class Solution {
    
	public static void reverseStack(Stack<Integer> stack) {
		if(stack.isEmpty()){
			return;
		}
		int top_ref = stack.peek();
		stack.pop();
		reverseStack(stack);
		insert_at_bottom(top_ref, stack);
	}
	static void insert_at_bottom(int top_ref, Stack<Integer> s){
		if(s.isEmpty()){
			s.push(top_ref);
			return;
		}
		int temp = s.peek();
		s.pop();
		reverse(element, s);
		s.push(temp);
	}

}
