import java.util.*;
public class BellmanFordsAlgo{
	static class Edge{
		int src;int des;int wt;
		public Edge(int s,int d,int wt){
			this.src = s;this.des=d;this.wt=wt;
		}
	}
	public static void createGraph(ArrayList<Edge> graph[]){
		for(int i=0;i<graph.length;i++)
			graph[i]=new ArrayList<>();
		graph[0].add(new Edge(0,1,2));
		graph[0].add(new Edge(0,2,4));
		
		graph[1].add(new Edge(1,2,-4));

		
		graph[2].add(new Edge(2,3,2));
		
		graph[3].add(new Edge(3,4,4));
		
		graph[4].add(new Edge(4,1,-1));
	}
	public static void bellmanFord(ArrayList<Edge> graph[] , int src){
		int dist[] = new int[graph.length];
		// initilize +infinity
		for(int i=0;i<graph.length;i++){
			if(i!=src)
				dist[i]=Integer.MAX_VALUE;
		}
		
		int V = graph.length;
		
		for(int i=0;i<V-1;i++){
			for(int j=0;j<graph.length;j++){
				for(int k=0;k<graph[j].size();k++){
					Edge e = graph[j].get(k);
					int u = e.src;
					int v= e.des;
					int wt = e.wt;
					
					if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v])
						dist[v]=dist[u]+wt;
		
				}
			}
		}
			//print all shortest path
		for(int i=0;i<graph.length;i++)
			System.out.print(dist[i]+ " ");
		System.out.println();
	}
	public static  void main(String[] args){
		int V = 5;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);
		int src =0;
		bellmanFord(graph,src);
	}
}
