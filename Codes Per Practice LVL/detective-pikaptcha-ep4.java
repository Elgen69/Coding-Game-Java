import java.util.*;

class Player {

    // Directions for movement in terms of dx, dy (Right, Left, Up, Down)
    static final int[] dx = {0, 0, -1, 1}; // Right, Left, Up, Down
    static final int[] dy = {1, -1, 0, 0}; // Right, Left, Up, Down
    static final char[] directions = {'>', '<', '^', 'v'};

    // Define face transitions for wall-following behavior (for Left/Right)
    static final int[][] cube_edges = {
        {1, 5, 2, 4},  // For Face 0: [right, left, up, down]
        {0, 4, 2, 3},  // For Face 1: [right, left, up, down]
        {1, 3, 4, 5},  // For Face 2: [right, left, up, down]
        {0, 2, 4, 5},  // For Face 3: [right, left, up, down]
        {0, 2, 3, 5},  // For Face 4: [right, left, up, down]
        {1, 3, 0, 2}   // For Face 5: [right, left, up, down]
    };

    static int N;  // The size of each face of the cube
    static char[][][] cube = new char[6][][];  // Each face of the cube represented by a 2D grid
    static int[][][] visit_count = new int[6][][];  // To store visit counts for each face

    // Function to simulate Pikaptcha's wall-following on the cube
    static void simulateMaze(int startFace, int x, int y, char side) {
        // Initialize the visited grid for counting steps
        visit_count = new int[6][N][N];

        // Find direction index based on the initial direction ('>', '<', '^', 'v')
        int directionIdx = (side == 'R' ? 0 : 1);  // Right or Left

        // Directions as 4 cardinal directions: right, left, up, down
        int direction = -1;
        for (int i = 0; i < 4; i++) {
            if (cube[startFace][x][y] == directions[i]) {
                direction = i;
                break;
            }
        }

        // Starting position
        int curFace = startFace;
        int curX = x;
        int curY = y;

        // Wall-following logic
        while (true) {
            // Increment the visit count at the current position
            visit_count[curFace][curX][curY]++;

            // Move based on direction
            int nx = curX + dx[direction];
            int ny = curY + dy[direction];

            // Check if the new position is valid
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && cube[curFace][nx][ny] == '0') {
                // Valid move, update position
                curX = nx;
                curY = ny;
            } else {
                // Wall-following logic
                if (side == 'R') {  // Follow right wall
                    int nextFace = cube_edges[curFace][direction];  // Transition to the next face
                    curFace = nextFace;
                } else if (side == 'L') {  // Follow left wall
                    int nextFace = cube_edges[curFace][(direction + 2) % 4];  // Opposite direction
                    curFace = nextFace;
                }
            }

            // Check if we have returned to the starting position
            if (curX == x && curY == y && curFace == startFace) {
                break;
            }
        }
    }

    // Main function to read input and solve the problem
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the cube
        N = scanner.nextInt();
        scanner.nextLine();  // Consume the newline after the integer

        // Read the cube faces
        for (int i = 0; i < 6; i++) {
            cube[i] = new char[N][N];
            for (int j = 0; j < N; j++) {
                cube[i][j] = scanner.nextLine().toCharArray();
            }
        }

        // Read the wall-following side
        char side = scanner.nextLine().charAt(0);

        // Find the starting position and direction
        int startFace = -1, startX = -1, startY = -1;
        outerLoop:
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (cube[i][j][k] == '>' || cube[i][j][k] == 'v' || cube[i][j][k] == '<' || cube[i][j][k] == '^') {
                        startFace = i;
                        startX = j;
                        startY = k;
                        break outerLoop;
                    }
                }
            }
        }

        // Simulate the maze traversal with the given starting position and direction
        simulateMaze(startFace, startX, startY, side);

        // Output the transformed grid
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (cube[i][j][k] == '#') {
                        System.out.print('#');
                    } else {
                        System.out.print(visit_count[i][j][k]);
                    }
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}
