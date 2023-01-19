import java.util.*;
public class LinkedListEx{
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
	public void addMiddle(int idx , int data){
		Node newNode = new Node(data);
		Node temp=head;
		if(idx==0){
			addFirst(data);
			return;
		}
		size++;
		int i=0;
		while(i< idx-1){
			temp = temp.next;
			i++;
		}
		//i==idx-1 (get previous)
		newNode.next = temp.next;
		temp.next = newNode;
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
	public int removeFirst(){
		// ll is empty then
		if(size==0){
			System.out.println("Linked List is Empty");
			return Integer.MAX_VALUE;
		}
		//ll is size 1 then..
	else if(size==1){
		int val = head.data;
		head=tail=null;
		size=0;
		return val;
	}
		int  temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
	public int removeLast(){
		// ll is empty then
		if(size==0){
			System.out.println("Linked List is Empty");
			return Integer.MAX_VALUE;
		}
		//ll is size 1 then..
	else if(size==1){
		int val = head.data;
		head=tail=null;
		size=0;
		return val;
	}
	Node prev = head;
	for(int i=0;i<size-2;i++){
		prev = prev.next;
	}
	int val = prev.next.data;
	prev.next = null;
	tail = prev;
	size--;
	return val;
	}
	public static void main(String[] args){
		LinkedListEx ll = new LinkedListEx();
		ll.addFirst(2);
		ll.addFirst(1);
		ll.addLast(3);
 		ll.addLast(4);
		ll.addMiddle(2,9);
		ll.print();
		ll.removeFirst();
        ll.print();
		ll.removeLast();ll.print();
		System.out.println(ll.size);
	}
}
