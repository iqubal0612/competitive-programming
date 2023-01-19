import java.util.*;
public class IterativeSearchLL{
	public static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
			this.next = null;
		}
	}
	public static Node head;
	public static Node tail;
	public static int size;
	
	public  void addFirst(int data){
		// 1...create a newNode....
		Node newNode = new Node(data);
		size++;
		//bc
		if(head==null){
			head=tail=newNode;
			return;
		}
		// 2.... newNode.next=head;
		newNode.next = head;
		
		// create newNode as head..
		head = newNode;
	}
	public void addLast(int data){
		// step 1 -- create a new node..
		Node newNode = new Node(data);
		size++;
		if(head==null){
			head=tail=newNode;
			return;
		}
		
		//step 2---- tail.next=newNode
		tail.next = newNode;
		//step3---> tail=newNode
		tail = newNode;
	}
		public void print(){
		Node temp = head;
		if(head==null){
			System.out.println("Linked List is Empty");
			return ;
		}
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	public static int search(int key){
		Node temp = head;
		int i=0;
		while(temp!=null){
			if(temp.data==key)
				return i;
			temp=temp.next;
			i++;
		}
		return -1;
	}
	public static int helper(Node head , int key){
		if(head==null)
			return -1;
		if(head.data==key)
			return 0;
		int idx = helper(head.next,key);
		if(idx==-1)
			return -1;
		return idx+1;
	}
	public static int recSearch(int key){
		return helper(head,key);
	}
	public static void main(String[] args){
		IterativeSearchLL ll = new IterativeSearchLL();
		ll.addFirst(2);
		ll.addFirst(1);
		ll.addLast(3);
		ll.addLast(4);
		ll.addLast(5);
		ll.print();
		System.out.println("Iterative Search:-"+search(4));
		System.out.println(search(14));
		System.out.println("Recursive Search:-"+search(5));
		
	}
}
