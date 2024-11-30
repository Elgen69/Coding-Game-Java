import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Read the number of elements in the array
        int n = sc.nextInt(); 
        int sum = 0; // Variable to store the sum of even numbers

        // Step 2: Read the n space-separated integers
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt(); // Read each number

            // Step 3: Check if the number is even
            if (num % 2 == 0) {
                sum += num; // Add to sum if it's even
            }
        }

        // Step 4: Output the sum of even numbers
        System.out.println(sum);
    }
}
