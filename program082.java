//write a code to implement trie datastructure and solve startswith problem
//to check entered string is substring of any trie element

//import java.util.ArrayList;
import java.util.Scanner;

/**
 * program080
 */
public class program082 {

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
    //@SuppressWarnings("unused")
    public static void main(String[] args) {
        //String words[] = {"the","a","there","their","any","thee","i","like","sam","samsung","mobile"};
        //String words[] = {"the","a","there","ap","app","thee","appl","like","apply","samsung","apple"};
        String words[] = {"a","banana","app","appl","apply","ap","apple"};

        for(String word : words){
            insert(word);
            //System.out.print(word+", ");
        }  
        System.out.println("Trie element are :");
        for(String word : words){
            System.out.print(word+", ");
        }
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string for Starts with problem : " );
        String prefix = sc.next();
        //String prefix = "ap";
        System.out.println(StartsWith(prefix));
        sc.close(); 
    }
}