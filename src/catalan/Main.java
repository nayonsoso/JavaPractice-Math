package catalan;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<Integer,Long> hm = new HashMap<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(recur(n));
    }

    public static long recur(int n) {
        if (n == 0) {
            return 1;
        }
        if(hm.get(n)==null){
            long result = 0;
            for(int i=0; i<n; i++){
                result += recur(i)*recur(n-1-i);
            }
            hm.put(n,result);
        }
        return hm.get(n);
    }
}