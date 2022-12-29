import java.util.*;
public class MaxAreaHistogram{
	public static int area(int arr[]){
		int maxArea=0;
		int nsr[]= new int[arr.length];
		int nsl[]=new int[arr.length];
		//nsr........
		Stack<Integer> s = new Stack<>();
		for(int j=arr.length-1;j>=0;j--){
			while(!s.isEmpty()&& arr[j] <= arr[s.peek()]){
				s.pop();
			}
			if(s.isEmpty()){
				nsr[j]=arr.length;
			}else{
				nsr[j]=s.peek();
			}
			s.push(j);
		}
		//nsl
        
		for(int i=0;i<arr.length;i++){
			while(!s.isEmpty()&& arr[i] <= arr[s.peek()]){
				s.pop();
			}
			if(s.isEmpty()){
				nsl[i]=-1;
			}else{
				nsl[i]=s.peek();
			}
			s.push(i);
		}
		//currArea........:width=j-i-1 //nsr-nsl-1;
		for(int i=0;i<arr.length;i++){
			int height=arr[i];
			int width = nsr[i]-nsl[i]-1;
			int currArea=height*width;
			maxArea = Math.max(maxArea,currArea);
		}
		return maxArea;
	}
	public static void main(String[] args){
		int heights[]={2,1,5,6,2,3};
		System.out.println(area(heights));
	}
}
