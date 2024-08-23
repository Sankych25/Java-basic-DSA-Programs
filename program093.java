//Shortest path algorithm(Dijkstra's algorithm) in directed weighted graph 
// this algo works on BFS
//This algo not works in negative weight
//Time complexity O(E + Elogv) 
//write a code to find shortest distance from 0 to each node

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * program093
 */
public class program093 {

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

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
        
        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));

        graph[3].add(new Edge(3,5,1));
        
        graph[2].add(new Edge(2,4,3));

        
    }
    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;
        public Pair(int n, int c){
            this.node = n;
            this.cost = c;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost; //ascending
            //return p2.dist - this.dist; //ascending

        }
    }
    public static void dijkstra(ArrayList<Edge> graph[], int src,int v){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[v];
        for(int i=0;i<v;i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean visited[] = new boolean[v];
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove(); //shortest distance
            if(!visited[curr.node]){
                visited[curr.node] = true;

                for(int i = 0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int w = e.dest;

                    if(dist[u]+e.wt<dist[w]){
                        dist[w] = dist[u] + e.wt;
                        pq.add(new Pair(w,dist[w]));
                    }
                }
            }
        }
        for(int i=0;i<v;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        /*  
         0 --2-> 1 --7--> 3 --1--> 5
         |       | 1      ^        ^
         |       v       2|        |
          --4--> 2 --3--> 4 --5-----
         
        */
        int v= 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println("Shortest path using Dijkstras algorithm is : ");
        dijkstra(graph, 0, v);
    }
}