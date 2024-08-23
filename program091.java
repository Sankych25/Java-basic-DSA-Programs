//write a code for topological sorting in graph(only for directed acyclic graph[DAG])
//Time complexity O(V + E)
import java.util.ArrayList;
import java.util.Stack;

/**
 * program091
 */
public class program091 {

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
         
       
        graph[5].add(new Edge(5,2,1));
        graph[5].add(new Edge(5,0,1));

        graph[4].add(new Edge(4,0,1));
        graph[4].add(new Edge(4,1,1));
        
        
        graph[2].add(new Edge(2,3,1));

        graph[3].add(new Edge(3,1,1));
       
    }
    public static void topSortUtil(ArrayList<Edge> graph[],int curr,boolean visited[],Stack<Integer> stack){
        visited[curr] = true;
        for (int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                topSortUtil(graph, e.dest, visited, stack);
            }
        }
        stack.push(curr);
    }
    public static void topSort(ArrayList<Edge> graph[],int v){
        boolean visited[] = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<v; i++){
            if(!visited[i]){
                topSortUtil(graph, i, visited, stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    } 
    /**
     * @param args
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        /*
         5 --> 2 --> 3
         |           |
         v           v
         0 <-- 4 --> 1
         */
        int v=6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println("Topological sorting order for directed graph : ");
        topSort(graph, v);
    }
}