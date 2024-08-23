//write a code to perform basic function on hashmap(iternally) using array of linkedlist
import java.util.*;
public class  program074{
    static class HashMap<K,V>{ //generics
        private class Node{
            K key;
            V value;

            //constructor
            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        private int n; // n --> nodes of linkedlist
        private int N; // N --> buckets/size of ArrayList
        private LinkedList<Node> buckets[]; //creating array
        //N = buckets.length;

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[N];
            for(int i=0;i<N;i++){
                 this.buckets[i] = new LinkedList<>(); 
            }
        }
        private int hashFunction(K key){
            int bi = key.hashCode();
            return Math.abs(bi)% N; 
        }
        private int searchInLL(K key,int bi){
            LinkedList<Node> ll = buckets[bi];
            for(int i=0;i<ll.size();i++){
                if(ll.get(i).key == key){
                    return i; //it returns data index(di)
                }
            }
            return -1;
        }
        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBucket[] = buckets;
            N = N*2;
            buckets = new LinkedList[N];

            for(int i=0;i<N;i++){
                 buckets[i] = new LinkedList<>();
            }

            for(int i=0;i<oldBucket.length;i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key,node.value);
                } 
            }
        }
        public void put(K key,V value){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);

            if(di == -1){  // when doesnt exist
                buckets[bi].add(new Node(key, value));
                n ++;
            }else{  // when kay doesnt exist
                Node node = buckets[bi].get(di);
                node.value = value;
            }
            double lambda =(double)n/N;
            if(lambda > 2.0){
                rehash();
            }
        }
        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);

            if(di == -1){   //when key doesnt exist
                return false;
            }else{
                return true;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);

            if(di == -1){   //when key doesnt exist
                return null;
            }else{
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }
        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);

            if(di == -1){   //when key doesnt exist
                return null;
            }else{
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll = buckets[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n == 0;
        }
    }
    public static void main(String args[]){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("India",150);
        map.put("China",140);
        map.put("US",150);

        ArrayList<String> keys = map.keySet();
        for(int i=0;i<keys.size();i++){
             System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
        }
        map.remove("India");
    }
}