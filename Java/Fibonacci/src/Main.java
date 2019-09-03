import java.util.Scanner;

public class Main {

    public static int Fibonacci(int n){
        if (n <= 1) {
            return n;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        for (int i = 0; i < input; i++) {
            System.out.print(Fibonacci(i) + " ");
        }
    }
}
