import java.util.*;
public class CreateGraph{
	static class Edge{
		int src; int des;int wt;
		public Edge(int s,int d,int w){
			this.src=s;
			this.des=d;
			this.wt=w;
		}
	}
	public static void main(String[] args){
		int V=5;
		ArrayList<Edge>[] graph = new ArrayList[V];
		for(int i=0;i<V;i++){
			graph[i]=new ArrayList<>();
		}
		// 0th vertex.......
		graph[0].add(new Edge(0,1,5));
		
		//1st vertex.....
		graph[1].add(new Edge(1,0,5));
		graph[1].add(new Edge(1,2,1));
		graph[1].add(new Edge(1,3,1));
		
		//2nd vertex...........
		graph[2].add(new Edge(2,1,1));
		graph[2].add(new Edge(2,3,1));
		graph[2].add(new Edge(2,4,2));
		
		//3rd Vertex.........
		graph[3].add(new Edge(3,1,3));
		graph[3].add(new Edge(3,2,1));
		
		//4th vertex
		graph[4].add(new Edge(4,2,2));
		
		//Store 2's Neighbours............
		for(int i=0;i<graph[2].size();i++){
			Edge e = graph[2].get(i);
			System.out.println(e.des);
		}
	}
}
