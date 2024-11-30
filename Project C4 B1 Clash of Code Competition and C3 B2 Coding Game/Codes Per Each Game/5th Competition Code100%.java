/*The elevator floor display had a problem and displayed its log up/down of the day with brackets ( for go up one floor and ) for go down one floor. The elevator starts on floor 0 and there is no limit to the number of floors in both up (positive) and down (negative) directions
Input
A string log from the elevator display log
Output
An integer floor telling the floor where we are
Constraints
4 ≤ length of log ≤ 5600*/

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String l = sc.nextLine(); // Read the log input
        int f = 0; // Initialize the floor to 0
        
        // Loop through each character in the log string
        for (int i = 0; i < l.length(); i++) {
            if (l.charAt(i) == '(') f++; // Increase floor for each '('
            else if (l.charAt(i) == ')') f--; // Decrease floor for each ')'
        }
        
        // Output the final floor
        System.out.println(f);
    }
}
