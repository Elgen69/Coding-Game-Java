import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    static int flip(int j, int width) {
        int position = 0;
        if (j <= width / 2) {
            position = width / 2 + j;
        } else {
            position = j - width / 2;
        }
        return position;
    }

    static class DirectionList {
        int[][] directions = new int[4][2];
        int[] orientations = new int[4];

        void createDirectionList(int rotation, String side) {
            if (side.equals("R") && rotation == 2) { // right
                directions[2][0] = -1; directions[2][1] = 0; orientations[2] = 1;
                directions[1][0] = 0; directions[1][1] = 1; orientations[1] = 2;
                directions[0][0] = 1; directions[0][1] = 0; orientations[0] = 3;
                directions[3][0] = 0; directions[3][1] = -1; orientations[3] = 4;
            } else if (side.equals("R") && rotation == 3) { // down
                directions[3][0] = -1; directions[3][1] = 0; orientations[3] = 1;
                directions[2][0] = 0; directions[2][1] = 1; orientations[2] = 2;
                directions[1][0] = 1; directions[1][1] = 0; orientations[1] = 3;
                directions[0][0] = 0; directions[0][1] = -1; orientations[0] = 4;
            } else if (side.equals("R") && rotation == 4) { // left
                directions[0][0] = -1; directions[0][1] = 0; orientations[0] = 1;
                directions[3][0] = 0; directions[3][1] = 1; orientations[3] = 2;
                directions[2][0] = 1; directions[2][1] = 0; orientations[2] = 3;
                directions[1][0] = 0; directions[1][1] = -1; orientations[1] = 4;
            } else if (side.equals("R") && rotation == 1) { // up
                directions[1][0] = -1; directions[1][1] = 0; orientations[1] = 1;
                directions[0][0] = 0; directions[0][1] = 1; orientations[0] = 2;
                directions[3][0] = 1; directions[3][1] = 0; orientations[3] = 3;
                directions[2][0] = 0; directions[2][1] = -1; orientations[2] = 4;
            }
            // Same pattern applies for "L" side.
            if (side.equals("L") && rotation == 2) {
                directions[0][0] = -1; directions[0][1] = 0; orientations[0] = 1;
                directions[1][0] = 0; directions[1][1] = 1; orientations[1] = 2;
                directions[2][0] = 1; directions[2][1] = 0; orientations[2] = 3;
                directions[3][0] = 0; directions[3][1] = -1; orientations[3] = 4;
            } else if (side.equals("L") && rotation == 3) {
                directions[3][0] = -1; directions[3][1] = 0; orientations[3] = 1;
                directions[0][0] = 0; directions[0][1] = 1; orientations[0] = 2;
                directions[1][0] = 1; directions[1][1] = 0; orientations[1] = 3;
                directions[2][0] = 0; directions[2][1] = -1; orientations[2] = 4;
            } else if (side.equals("L") && rotation == 4) {
                directions[2][0] = -1; directions[2][1] = 0; orientations[2] = 1;
                directions[3][0] = 0; directions[3][1] = 1; orientations[3] = 2;
                directions[0][0] = 1; directions[0][1] = 0; orientations[0] = 3;
                directions[1][0] = 0; directions[1][1] = -1; orientations[1] = 4;
            } else if (side.equals("L") && rotation == 1) {
                directions[1][0] = -1; directions[1][1] = 0; orientations[1] = 1;
                directions[2][0] = 0; directions[2][1] = 1; orientations[2] = 2;
                directions[3][0] = 1; directions[3][1] = 0; orientations[3] = 3;
                directions[0][0] = 0; directions[0][1] = -1; orientations[0] = 4;
            }
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        char[][] grid = new char[height + 2][width + 2];

        // Initialize grid with '#'
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                grid[i][j] = '#';
            }
        }

        // Reading the grid input
        for (int i = 0; i < height; i++) {
            String line = in.next();
            for (int j = 0; j < width; j++) {
                grid[i + 1][j + 1] = line.charAt(j);
            }
        }

        // Reading side (L or R)
        String side = in.next();

        // Initialize Pikachu's position and orientation
        int pC = 0, pR = 0, rotation = 0;
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                char cell = grid[i][j];
                if (cell != '0' && cell != '#') {
                    if (cell == '^') { rotation = 1; }
                    if (cell == '>') { rotation = 2; }
                    if (cell == 'v') { rotation = 3; }
                    if (cell == '<') { rotation = 4; }
                    grid[i][j] = '0';
                    pC = j;
                    pR = i;
                }
            }
        }

        int startR = pR;
        int startC = pC;

        // Copy the grid edges
        for (int i = 1; i < height + 1; i++) {
            grid[i][0] = grid[i][width];
            grid[i][width + 1] = grid[i][1];
        }
        for (int j = 1; j < width + 1; j++) {
            grid[0][flip(j, width)] = grid[height][j];
            grid[height + 1][flip(j, width)] = grid[1][j];
        }

        DirectionList directionList = new DirectionList();

        boolean notDone = true;
        while (notDone) {
            directionList.createDirectionList(rotation, side);

            // Check possible directions
            for (int s = 0; s < 4; s++) {
                int row = pR + directionList.directions[s][0];
                int col = pC + directionList.directions[s][1];
                if (grid[row][col] != '#') {
                    pR = row;
                    pC = col;

                    // Handle grid wrapping
                    if (pR == 0) { pR = height; pC = flip(pC, width); }
                    if (pR == height + 1) { pR = 1; pC = flip(pC, width); }
                    if (pC == 0) { pC = width; }
                    if (pC == width + 1) { pC = 1; }

                    grid[pR][pC]++;
                    rotation = directionList.orientations[s];
                    break;
                }
            }

            // Check if Pikachu is back at the start
            if (pR == startR && pC == startC) {
                notDone = false;
            }
        }

        // Output the final grid
        for (int i = 1; i < height + 1; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 1; j < width + 1; j++) {
                line.append(grid[i][j]);
            }
            System.out.println(line);
        }
    }
}
