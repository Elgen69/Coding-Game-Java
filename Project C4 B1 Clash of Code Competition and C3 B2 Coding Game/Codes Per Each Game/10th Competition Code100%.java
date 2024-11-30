/*Initially output equals 0. Iterate through each number in the input and perform the following operation:
If the number is odd: Multiply it to output
If the number is even: Add it to the output
Input
Line 1: An integer count which represents the amount of given numbers.
Line 2: A list of integer numbers of length count seperated by space.
Output
Line 1: An integer output
Constraints
0 < count <= 100
-10000 <= number <= 10000
-2147483648 < output < 2147483648
*/

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt(); // Read the count of numbers
        int output = 0; // Initialize output to 0
        for (int i = 0; i < count; i++) {
            int num = sc.nextInt(); // Read each number
            if (num % 2 == 0) {
                output += num; // If even, add to output
            } else {
                output *= num; // If odd, multiply to output
            }
        }
        System.out.println(output); // Output the result
    }
}
