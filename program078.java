/*find itinerary path from tickets using hashmap
"chennai" --> "bengaluru"
"mumbai" --> "delhi"
"goa" --> "chennai"
"delhi" --> "goa"
/**
 * program078
 */

import java.util.HashMap;
import java.util.Scanner;

public class program078 {
    public static String  getStart(HashMap<String,String> tickets){
        HashMap<String,String> revMap = new HashMap<>();

        for(String key : tickets.keySet()){
            revMap.put(tickets.get(key),key);
        }
        for(String key : tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String,String> tickets = new HashMap<>();
        // tickets.put("Chennai", "Bengaluru");
        // tickets.put("Mumbai", "Delhi");
        // tickets.put("Goa", "Chennai");
        // tickets.put("Delhi", "Goa");
        Scanner sc = new Scanner(System.in);
        System.out.println("chennai --> bengaluru\n"+
                        "mumbai --> delhi\n"+
                        "goa --> chennai\n"+
                        "delhi --> goa\n");
        System.out.print("How many route you have : ");
        int x = sc.nextInt();
        for(int i=1;i<=x;i++){
            System.out.print("Enter source for route "+i+" : ");
            String a = sc.next();
            System.out.print("Enter a destination for "+a+" : ");
            String b = sc.next();
            tickets.put(a, b);
        }
        sc.close();
        String start = getStart(tickets);
        while(tickets.containsKey(start)){
            System.out.print(start + " --> ");
            start = tickets.get(start);
        }
        System.out.println(start);
    }
}