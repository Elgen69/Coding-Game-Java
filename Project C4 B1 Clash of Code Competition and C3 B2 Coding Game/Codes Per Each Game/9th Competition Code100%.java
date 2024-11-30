/*Given a string consisting only of the characters A, T, G and C, do the following:
- double the A-s
- triple the T-s
- remove the G-s
- leave the C-s as is
Input
A single line of characters [ATGC].
Output
A single line of characters [ATGC].
Constraints
The input string is at most 20 characters long.*/

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); // Read the input string
        StringBuilder result = new StringBuilder(); // Use StringBuilder to construct the result
        
        // Loop through each character of the input string
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i); // Get the current character
            if (ch == 'A') {
                result.append("AA"); // Double the A
            } else if (ch == 'T') {
                result.append("TTT"); // Triple the T
            } else if (ch == 'C') {
                result.append("C"); // Keep the C as is
            }
            // Skip the G, no need to append anything
        }
        
        System.out.println(result.toString()); 
    }
}

//OR

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == 'A') result.append("AA");
            else if (ch == 'T') result.append("TTT");
            else if (ch == 'C') result.append("C");
        }
        System.out.println(result.toString());
    }
}
