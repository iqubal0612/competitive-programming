import java.util.*;
public class HasGraph{
	static class Edge{
		int src; int des;
		public Edge(int s,int d){
			this.src=s;
			this.des=d;
		}
	}
	public static boolean hasPath(ArrayList<Edge> graph[] , int src,int des , boolean vis[]){
		if(src==des){
			return true;
		}
		vis[src]=true;
	    for(int i=0;i<graph[src].size();i++){
			Edge e = graph[src].get(i);
		if(!vis[e.des]&&hasPath(graph,e.des,des,vis)){
			return true;
		}
		}
		return false;
	}
	public static void createGraph(ArrayList<Edge> graph[]){
		for(int i=0;i<graph.length;i++){
			graph[i]=new ArrayList<>();
		}
		graph[0].add(new Edge(0,1));
		graph[0].add(new Edge(0,2));
		
		graph[1].add(new Edge(1,0));
		graph[1].add(new Edge(1,3));
		
		graph[2].add(new Edge(2,0));
		graph[2].add(new Edge(2,4));
		
	    graph[3].add(new Edge(3,1));
		graph[3].add(new Edge(3,4));
	    graph[3].add(new Edge(3,5));
        
		graph[4].add(new Edge(4,2));
		graph[4].add(new Edge(4,3));
		graph[4].add(new Edge(4,5));
		
		graph[5].add(new Edge(5,3));
		graph[5].add(new Edge(5,4));
		graph[5].add(new Edge(5,6));
	    
		graph[6].add(new Edge(6,5));
	}
   public static void main(String[] args){
	   int V = 7;
	   ArrayList<Edge>[] graph = new ArrayList[V];
	   createGraph(graph);
	   System.out.println(hasPath(graph,0,5,new boolean[V]));
   }
}
