import java.util.*;
public class DuplicateParanthesis{
	public static boolean check(String str){
		Stack<Character> s = new Stack<>();
	
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			//closing
			if(ch==')'){
				int count=0;
				while(s.peek()!='('){
					s.pop();
					count++;
				}
				if(count<1){
					return true;//duplicate
				}else{
					s.pop();
				}
			}else{
			//opening..
		     	s.push(ch);
			}
		}
		return false;
	}
	public static void main(String[] args){
		String str = "(((a+b)+(c+d)))";
		System.out.println(check(str));
	}
}
