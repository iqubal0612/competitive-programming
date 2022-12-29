import java.util.*;
public class StockSpan{
	public static void calculate(int stocks[] , int span[]){
		Stack<Integer> s = new Stack<>();
		span[0]=1;
		s.push(0);
		for(int i=1;i<stocks.length;i++){
			int curr=stocks[i];
			while(!s.isEmpty() && curr >stocks[s.peek()]){
				s.pop();
			}
         if(s.isEmpty()){
			 span[i]=i+1;
		 }else{
			 int prev_high = s.peek();
			 span[i]=i-prev_high;
		 }
         s.push(i);		 
		}
		for(int i=0;i<span.length;i++){
			System.out.println(span[i]+" ");
		}
	}
	public static void main(String[] args){
		int stocks[] = {100,80,60,70,60,85,100};
		int span[] = new int[stocks.length];
		calculate(stocks,span);
	}
}
