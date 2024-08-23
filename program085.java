//write a code to implement trie datastructure

//import java.util.ArrayList;
//import java.util.Scanner;

//import java.util.Scanner;

/**
 * program080
 */
public class program085 {

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
    //find longest string in words such that every prefix of its also in words. 
    public static String ans = "";
    public static void longestWord(Node root,StringBuilder temp){
        // if(root == null){
        //     return;
        // }
        for(int i = 0;i<26; i++){
            if(root.children[i] != null && root.children[i].EOW == true){
                temp.append((char)(i+'a'));
                if(temp.length() > ans.length()){
                    ans = temp.toString();               
                 }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public static void buildTrie(String str){
        //insert all suffixes into trie
        root = new Node();

        for(int i=0; i<str.length();i++){
            insert(str.substring(i));
        }
    }
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        //String words[] = {"the","a","there","their","any","thee","i","like","sam","samsung","mobile"};
        String words[] = {"the","a","there","ap","app","thee","appl","like","apply","samsung","apple"};
        //String words[] = {"a","banana","app","appl","apply","ap","apple"};
        for(String word : words){
            insert(word);
            //System.out.print(word+", ");
        }  
        System.out.println("Trie element are :");
        for(String word : words){
            System.out.print(word+", ");
        }
        System.out.println();
        longestWord(root,new StringBuilder(""));
        System.out.println("Longest word is "+ans+ " which all substring are present in Trie");
    }
}