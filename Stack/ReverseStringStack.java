import java.util.*;
public class ReverseStringStack{
	public static String reverseStack(String str){
		 Stack<Character> s = new Stack<>();
		 for (int i=0;i<str.length();i++){
			 s.push(str.charAt(i));
		 }
		 StringBuilder result = new StringBuilder("");
		 while(!s.isEmpty()){
			 char curr = s.pop();
			 result.append(curr);
		 }
		 return  result.toString();
		 
		
	}
	public static void main(String[] args){
		String str = "abcd";
		System.out.println(reverseStack(str));
	}
}
