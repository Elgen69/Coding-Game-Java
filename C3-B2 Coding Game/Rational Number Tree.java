import java.util.*;
import java.math.*;

public class Solution {

    // Method to compute the mediant of two fractions (p1/q1) and (p2/q2).
    // The mediant is defined as (p1 + p2) / (q1 + q2). It's used to find the middle of two fractions.
    private static String mediant(long p1, long q1, long p2, long q2) {
        return (p1 + p2) + "/" + (q1 + q2);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();  // Read the number of test cases
        in.nextLine(); // Consume the newline after the integer input

        // A list to store the results of each test case
        List<String> result = new ArrayList<>();

        // Process each test case
        for (int i = 0; i < N; i++) {
            String line = in.nextLine().trim();  // Read the next line of input and trim whitespace

            // Check if the input contains 'L' or 'R', indicating that it's a path to find a rational number
            if (line.contains("L") || line.contains("R")) {
                // Initialize the left and right boundaries as fractions (p/q)
                long leftP = 0, leftQ = 1, rightP = 1, rightQ = 0, midP = 1, midQ = 1;
                
                // Iterate over each character in the path to compute the corresponding rational number
                for (char c : line.toCharArray()) {
                    if (c == 'L') {
                        // 'L' means we go left: update the right boundary to the current mediant
                        rightP = midP;
                        rightQ = midQ;
                        // Update the mediant to be the sum of the left and current mediant
                        midP = leftP + midP;
                        midQ = leftQ + midQ;
                    } else if (c == 'R') {
                        // 'R' means we go right: update the left boundary to the current mediant
                        leftP = midP;
                        leftQ = midQ;
                        // Update the mediant to be the sum of the right and current mediant
                        midP = rightP + midP;
                        midQ = rightQ + midQ;
                    }
                }
                // Add the final rational number in the form "numerator/denominator"
                result.add(midP + "/" + midQ);

            } else {
                // Otherwise, it's a rational number in the form "numerator/denominator"
                // Split the string into numerator and denominator parts
                String[] parts = line.split("/");
                long targetP = Long.parseLong(parts[0]);
                long targetQ = Long.parseLong(parts[1]);

                // Initialize the left and right boundaries and mediant
                long leftP = 0, leftQ = 1, rightP = 1, rightQ = 0, midP = 1, midQ = 1;
                StringBuilder path = new StringBuilder();  // To store the path directions ('L' or 'R')
                
                // Find the path by comparing the target fraction with the mediant fraction
                while (true) {
                    // Compare the target fraction with the current mediant using cross-multiplication to avoid floating point errors
                    if (targetP * midQ < targetQ * midP) {
                        // Target is to the left of the current mediant
                        path.append("L");
                        // Update the right boundary to the current mediant
                        rightP = midP;
                        rightQ = midQ;
                        // Compute a new mediant from the left boundary and the current mediant
                        midP = leftP + midP;
                        midQ = leftQ + midQ;
                    } else if (targetP * midQ > targetQ * midP) {
                        // Target is to the right of the current mediant
                        path.append("R");
                        // Update the left boundary to the current mediant
                        leftP = midP;
                        leftQ = midQ;
                        // Compute a new mediant from the right boundary and the current mediant
                        midP = rightP + midP;
                        midQ = rightQ + midQ;
                    } else {
                        // The target fraction matches the current mediant
                        break;
                    }
                }

                // Add the resulting path as the solution for this test case
                result.add(path.toString());
            }
        }

        // Print all results
        for (String res : result) {
            System.out.println(res);
        }
    }
}
