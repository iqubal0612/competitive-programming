import java.util.*;
public class BellmanFordsAlgoModi{
	static class Edge{
		int src;int des;int wt;
		public Edge(int s,int d,int wt){
			this.src = s;this.des=d;this.wt=wt;
		}
	}
	public static void createGraph(ArrayList<Edge> graph){
	
		graph.add(new Edge(0,1,2));
		graph.add(new Edge(0,2,4));
		
		graph.add(new Edge(1,2,-4));

		
		graph.add(new Edge(2,3,2));
		
		graph.add(new Edge(3,4,4));
		
		graph.add(new Edge(4,1,-1));
	}
	public static void bellmanFord(ArrayList<Edge> graph , int src,int V){
		int dist[] = new int[V];
		// initilize +infinity
		for(int i=0;i<dist.length;i++){
			if(i!=src)
				dist[i]=Integer.MAX_VALUE;
		}
		
		for(int i=0;i<V-1;i++){
			for(int j=0;j<graph.size();j++){
					Edge e = graph.get(j);
					int u = e.src;
					int v= e.des;
					int wt = e.wt;
					
					if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v])
						dist[v]=dist[u]+wt;
		
				}
			}
			//print all shortest path
		for(int i=0;i<dist.length;i++)
			System.out.print(dist[i]+ " ");
		System.out.println();
	}
	public static  void main(String[] args){
		int V = 5;
		ArrayList<Edge> graph = new ArrayList<>();
		createGraph(graph);
		int src =0;
		bellmanFord(graph,src,V);
	}
}
