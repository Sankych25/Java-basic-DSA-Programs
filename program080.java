//write a code to implement trie datastructure and inser element into it

//import java.util.ArrayList;
//import java.util.Scanner;

/**
 * program080
 */
public class program080 {

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
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        //String words[] = {"the","a","there","their","any","thee","i","like","sam","samsung","mobile"};
        String words[] = {"the","a","there","ap","app","thee","appl","like","apply","samsung","apple"};
        //String words[] = {"a","banana","app","appl","apply","ap","apple"};

        String key = "ilikesamsung";
        String prefix = "sam";
        for(String word : words){
            insert(word);
        }  
        System.out.println("Trie element are :");
        for(String word : words){
            System.out.print(word+", ");
        }    
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