import java.util.*;
public class NextGreater{
	public static void calculate(int arr[] , int nextGreater[]){
		Stack<Integer> s = new Stack<>();
		for(int i=arr.length-1;i>=0;i--){
			while(!s.isEmpty() && arr[s.peek()]<=arr[i] ){
				s.pop();
			}
			if(s.isEmpty())
				nextGreater[i]=-1;
			else
				nextGreater[i]=arr[s.peek()];
			
		        s.push(i);
		}
			for(int i=0;i<arr.length;i++){
			System.out.print(nextGreater[i]+" ");
		}
	}
	public static void main(String[] args){
		int arr[]={5,6,2,1,8};
		int nextGreater[] = new int[arr.length];
		calculate(arr,nextGreater);
	}
}
