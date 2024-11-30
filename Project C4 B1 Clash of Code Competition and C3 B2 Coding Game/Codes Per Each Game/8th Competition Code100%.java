/*There are multiple organisations that span the chess world, each with their own method of calculating a player's skill. You must convert an ECF chess rating into a FIDE chess rating.

Rules:
ECF x 7.5 + 700 = FIDE*/

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0, N = sc.nextInt(); i < N; i++) 
            System.out.println((int) (sc.nextInt() * 7.5 + 700));
    }
}
