//Write a code to find Shortest distance from source to target using Belman Ford algorithm in graph
//Time complexity O(E*v)
//write a code to find shortest distance from 0 to each node
import java.util.ArrayList;

public class  program094{
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
         
       
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[4].add(new Edge(4,1,-1));
        //graph[4].add(new Edge(4,5,5));
        
        //graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,-4));

        graph[3].add(new Edge(3,4,4));
        
        graph[2].add(new Edge(2,3,2));

        
    }
    public static void bellmanFord(ArrayList<Edge> graph[],int src,int v){
        int dist[] = new int[v];
        for(int i=0; i<v; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for(int k=0; k<v-1; k++){  ///O(v)
            for(int i=0;i<v; i++){
                for(int j=0; j<graph[i].size();j++){
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int V = e.dest;

                    if(dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[V]){
                        dist[V] = dist[u] + e.wt;
                    }
                }
            }
            //to check negative weight
            for(int i=0; i<v; i++){
                for(int j=0;j<graph[i].size(); j++){
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int V = e.dest;

                    if(dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[V]){
                        System.out.println("Negative weight cycle is detected");
                    }
                }
            }
        }
        for(int i=0; i<dist.length;i++){
            System.out.print(dist[i]+ " ");
        }
        System.out.println();
    }
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        /*
                0 --> 1 <-- -1 - 4
                |  2  |          ^
                |     v          | 4
                - 4-> 2 --2-- >  3
        */
        int v=5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println("Shortest distance form 0 to each node : ");
        bellmanFord(graph, 0, v);
    }
}