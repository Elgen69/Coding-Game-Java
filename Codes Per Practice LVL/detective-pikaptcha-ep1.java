import java.util.*;
import java.io.*;

class Player {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Read the dimensions of the grid
        int width = in.nextInt();
        int height = in.nextInt();
        in.nextLine(); // Consume the newline character

        // Read the grid into a 2D character array
        char[][] grid = new char[height][width];
        for (int i = 0; i < height; i++) {
            grid[i] = in.nextLine().toCharArray();
        }

        // Directions arrays to check the 4 neighbors (up, down, left, right)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // Process each cell in the grid
        for (int i = 0; i < height; i++) {
            StringBuilder resultRow = new StringBuilder();
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '#') {
                    resultRow.append('#'); // Keep walls as is
                } else {
                    // Count the number of adjacent '0' cells
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        // Check if the neighbor is within bounds and passable
                        if (ni >= 0 && ni < height && nj >= 0 && nj < width && grid[ni][nj] == '0') {
                            count++;
                        }
                    }
                    resultRow.append(count); // Replace '0' with the count
                }
            }
            // Output the transformed row
            System.out.println(resultRow.toString());
        }
        in.close();
    }
}
