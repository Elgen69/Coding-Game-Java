import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Input the integer

        // Extract the last digit of the number
        int result = N % 10;

        // Print the result
        System.out.println(result);
    }
}
