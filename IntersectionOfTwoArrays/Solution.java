import java.util.* ;
import java.io.*; 
public class Solution
{
	public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m)
	{
		int i=0;
		int j=0;
		ArrayList<Integer> intersection = new ArrayList<>();
		while(i<n && j<m){
			if(arr1.get(i)<arr2.get(j)){
				i++;
			}
			else if(arr1.get(i)>arr2.get(j)){
				j++;
			}
			else{
				intersection.add(arr1.get(i));
				i++;
				j++;
			}
			
		}
		return intersection;
	}
}
