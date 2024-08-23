//write a code to implement trie datastructure

//import java.util.ArrayList;
import java.util.Scanner;

/**
 * program080
 */
public class program084 {

    static class Node{
        Node[] children = new Node[26];
        boolean EOW ; //eow --> end of word

        public Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
            EOW = false;
        }
    }
//insert elements in trie datastructure
public static Node root = new Node();

public static void insert(String word){ //O(L)  --> length of string

    int idx = 0;

    Node curr = root;
    for(int level =0;level<word.length();level++){
        idx = word.charAt(level)-'a';
        if(curr.children[idx] == null){
            curr.children[idx] = new Node();
        }
        if(level == word.length()-1){
            curr.children[idx].EOW = true;
        }
        curr = curr.children[idx];
    }
}
//search element in trie datastructure
public static boolean search(String key){  //O(L)
    int level = 0;
    int len = key.length();
    int idx = 0;

    Node curr = root;
    for(level=0;level<len;level++){
        idx = key.charAt(level)-'a';

        if(curr.children[idx]==null){
            return false;
        }
        if(level == key.length()-1 && curr.children[idx].EOW == false){
            return false;
        }
        curr = curr.children[idx];
    }
    return true;
}
public static boolean StartsWith(String prefix){
    Node curr = root;

    for(int i=0;i<prefix.length();i++){
        int idx = prefix.charAt(i)-'a';
         if(curr.children[idx]==null){
            return false;
         }
         curr = curr.children[idx];
    }
    return true;
}
 //given an input string and a dictionary of words . find out if the input string can be broken into a space - separated sequence of dictionary words.
 public static boolean wordBreak(String key){
     int len = key.length();

     if(len == 0){
         return true;
     }

     for(int i = 1;i<=len;i++){
         if(search(key.substring(0,i)) && wordBreak(key.substring(i))){
             return true;
         }
     }
     return false;
 }
    //given a string of length n of lowercase alphabets characters, we need to count total number of distinct substrings of this string.
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }

        int count = 0;
        for(int i=0; i<26; i++){
            if(root.children[i] != null){
                count += countNodes(root.children[i]);
            }
        }
        return 1 + count;
    }
    //@SuppressWarnings("unused")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string for count distinct substring : " );
        String key = sc.next();
        for (int i = 0; i < key.length(); i++) {
            String suffix = key.substring(i);
            insert(suffix);
        }
        System.out.println(countNodes(root));
        sc.close();
        //************************** */
       /* Scanner sc = new Scanner(System.in);
        System.out.print("Enter number number of element which insert into trie : ");
        int n = sc.nextInt();
        String[] words = new String[n];
        System.out.println("Enter element to insert in trie datastructure : ");
        
        for(int j =0;j<n;j++){
           // if(sc.next()!="10"){
                insert(sc.next());
          //  }
          //  break;
        }
        System.out.println("Enter element to search in trie");
        String str = sc.next();
        if(search(str)==true){
            System.out.println(str+" word found in  trie datastructure");
        }else System.out.println(str+" word not found");

        System.out.println("create function for trie datastructure which returns true if there is a \\r\\n" + //
                        "\" + \"previously inserted string word that has the prefix, and false otherwise." );
        System.out.println("Enter prefix to check : ");
        System.out.println(StartsWith(sc.next()));

        System.out.println("Enter a string to word break problem :");
        String Wbreak = sc.next();
        if(wordBreak(Wbreak)==true){
            System.out.println("Your string's substrings is present in trie");
        }else System.out.println("Your string's substring not present in trie");

        System.out.println("Enter any word to count distinct substring");
        String x = sc.next();
        for (int i = 0; i < x.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }
        System.out.println(x+" has total "+countNodes(root)+" distinct substrings.");

        longestWord(root,new StringBuilder(""));
        System.out.println("Longest word is "+ans+ " which all substring are present in Trie");
        sc.close(); */
    }
}