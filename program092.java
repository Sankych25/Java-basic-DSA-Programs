//write a code for cycle detection of undirected graph
//Time complexity O(V + E)

import java.util.ArrayList;

/**
 * program092
 */
public class program092 {
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
         
       
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,4,1));

        graph[4].add(new Edge(4,0,1));
        graph[4].add(new Edge(4,1,1));
        graph[4].add(new Edge(4,5,1));
        
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,4,1));
        graph[1].add(new Edge(1,2,1));

        graph[3].add(new Edge(3,2,1));
        
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));

        graph[5].add(new Edge(5,4,1));
    }
    public static boolean isCycleUndirected(ArrayList<Edge> graph[],boolean visited[],int curr,int par){
        visited[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(visited[e.dest] && e.dest != par){
                return true;
            }else if(!visited[e.dest]){
                if(isCycleUndirected(graph, visited, e.dest, curr)){
                    return true;
                }
            }
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        /*  
          0 -- 1 -- 2 -- 3
           \  /
             4 -- 5          
          
         */
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        //System.out.println("Topological sorting order for directed graph : ");
        boolean x = isCycleUndirected(graph, new boolean[v], 0, -1);
        if(x){
            System.out.println("Cycle id detected in undirected graph");
        }else {
            System.out.println("Cycle is not present in undirected garph");
        }
    }
}