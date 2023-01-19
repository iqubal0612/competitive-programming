import java.util.*;
public class BipartiteGraph{
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
		graph[0].add(new Edge(0,2));
		graph[1].add(new Edge(1,0));
		graph[1].add(new Edge(1,3));
		graph[2].add(new Edge(2,0));
		graph[2].add(new Edge(2,4));
		graph[3].add(new Edge(3,1));
		graph[3].add(new Edge(3,4));
		graph[4].add(new Edge(4,3));
		graph[4].add(new Edge(4,2));
	}
	public static boolean checkBipartite(ArrayList<Edge> graph[]){
	    int  col[] = new int[graph.length];
		for(int i=0;i<col.length;i++){
			col[i]=-1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<graph.length;i++){
			if(col[i]==-1){
				q.add(i);
				col[i]=0;
			
		while(!q.isEmpty()){
			int curr=q.remove();
			for(int j=0;j<graph[curr].size();j++){
				Edge e = graph[curr].get(j);
				q.add(e.des);
				//case3....
				if(col[e.des]==0){
					int nextColor=col[curr]==0?1:0;
					col[e.des]=nextColor;
					q.add(e.des);
				}
				else if(col[e.des]==col[curr])
					return false;
			}
		}
			}
		}
		return true;
	
	}
	public static void main(String[] args){
		int V =5;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);
		System.out.println(checkBipartite(graph));
	}
}
