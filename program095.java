//A MST(Minimum Spanning Tree) or weight spanning tree is as subset of the edges of a connected ,edge weighted undirected graphthat connects all the vertices together , without any cycle & with the minimum possible total edge weight
//Time Complexity O(ElogE)

import java.util.ArrayList;
import java.util.PriorityQueue;

public class program095 {
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
         
       
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,3,30));
        graph[0].add(new Edge(0,2,15));

        //graph[4].add(new Edge(4,1,-1));
        //graph[4].add(new Edge(4,5,5));
        
        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[3].add(new Edge(3,1,10));
        graph[3].add(new Edge(3,0,30));
        graph[3].add(new Edge(3,2,50));
        
        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        
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
    public static void primsAlgo(ArrayList<Edge> graph[],int v){
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // non mst
        boolean visited[] = new boolean[v]; // mst
        pq.add(new Pair(0, 0));

        int mstcost = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.node]){
                visited[curr.node] = true;
                mstcost += curr.cost;

                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    if(!visited[e.dest]){
                        pq.add(new Pair(e.dest,e.wt));
                    }
                }
            }
        }
        System.out.println("Min cost of MST : "+mstcost);
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        primsAlgo(graph, v);
    }
}
