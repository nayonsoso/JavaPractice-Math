package recursion.basicRecursion;

public class Basic {
    public static void main(String[] args) {
        System.out.println("fibo(5) : " + fibo(5));
        System.out.println("fact(5) : " + factorial(5));
    }

    public static int gcd(int a, int b){
        if(a%b==0){
            return b;
        }
        return gcd(b,a%b);
    }

    public static int fibo(int n){
        if(n<=2){
            return 1;
        }
        return fibo(n-1) + fibo(n-2);
    }

    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return factorial(n-1)*n;
    }
}