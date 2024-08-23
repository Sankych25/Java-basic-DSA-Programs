//write a code to detect Cycle in directed graph
//Time complexity O(V + E)
import java.util.ArrayList;

/**
 * program090
 */
public class program090 {

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
         
       
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        
        
        graph[2].add(new Edge(2,3,1));

        //graph[3].add(new Edge(3,0,1));
       
       
    }
    public static boolean isCycleDetected(ArrayList<Edge> graph[],boolean visited[],int curr,boolean rec[]){
        visited[curr] = true;
        rec[curr] = true;

        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            //cycle
            if(rec[e.dest]){
                return true;
            }else if(!visited[e.dest]){
                if(isCycleDetected(graph, visited, e.dest, rec)){
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //createGraph(cycle)
        // 1 --> 0 --> 2 --> 3
        //       ^           |
        //       |___________|
        //
        //creategraph2(no cycle)
        // 0 --> 1
        // |     |
        // v     v
        // 2 --> 3

        int v = 4;
        ArrayList<Edge> []graph = new ArrayList[v];
        createGraph(graph);

        boolean visited[] = new boolean[v];
        boolean rec[] = new boolean[v];
        for(int i=0; i<v; i++){
            if(!visited[i]){
                boolean isCycle = isCycleDetected(graph, visited, 0, rec);
                if(isCycle){
                    System.out.println("Cycle is  detected in directed graph");
                    break;
                    
                }else{
                    System.out.println("Cycle is not detected in directed graph");
                    break;
                }
            }
        }
    }

}