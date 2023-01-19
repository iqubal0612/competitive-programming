import java.util.*;
public class CycleDetectionDirected{
static class Edge{
		int src;
		int des;
		
		public Edge(int s , int d){
			this.src=s;
			this.des = d;
		}
	}
	public static void createGraph(ArrayList<Edge> graph[]){
		for(int i=0;i<graph.length;i++){
			graph[i]=new ArrayList<>();
		}
	   graph[0].add(new Edge(0,1));
	   graph[2].add(new Edge(2,3));
	   graph[3].add(new Edge(3,4));
	   graph[4].add(new Edge(4,2));
	}
	public static boolean isCycle(ArrayList<Edge> graph[]){
		boolean vis[] = new boolean[graph.length];
		boolean stack[] = new boolean[graph.length];
		
		for(int i=0;i<graph.length;i++){
			if(!vis[i]){
				if(isCycleUtil(graph,i,vis,stack))
					return true;
			}
		}
		return false;
	}
	public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr,boolean vis[],boolean stack[]){
		vis[curr]=true;
		stack[curr]=true;
		
		for(int i=0;i<graph[curr].size();i++){
			Edge e = graph[curr].get(i);
			if(stack[e.des]){
				return true;
			}
			if(!vis[e.des] && isCycleUtil(graph,e.des,vis,stack))
				return true;
		}
		stack[curr] = false;
		return false;
	}
	public static void main(String[] args){
		int V =5;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);
		System.out.println(isCycle(graph));
	}
}
