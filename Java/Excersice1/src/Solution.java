import java.util.Scanner;

public class Solution {
    public int numJewelsInStone(String J, String S){
        Scanner scan = new Scanner(System.in);
        int NumberOfJewels = 0;
        char[] c = S.toCharArray();
        double d = scan.next
        for(char s:c){
            if (J.indexOf(s) > -1) {
                ++NumberOfJewels;
            }
        }
        return NumberOfJewels;
    }
}
