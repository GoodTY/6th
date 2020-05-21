package cse2010.homework4;
/*
 * CSE2010 Homework #4:
 * Problem 3: Maze
 *
 * Complete the code below.
 */

import java.util.Arrays;

public class Maze {
    private int numRows;
    private int numCols;

    private int[][] maze;
    private boolean[][] visited = null;

    private Location entry; // Entry Location
    private Location exit;  // Exit Location

    public Maze(int[][] maze, Location entry, Location exit) {

        this.maze = maze;
        numRows = maze.length;
        numCols = maze[0].length;
        visited = new boolean[numRows][numCols]; // initialized to false

        this.entry = entry;
        this.exit = exit;
    }

    public void printMaze() {

        System.out.println("Maze[" + numRows + "][" + numCols + "]");
        System.out.println("Entry index = (" + entry.row + ", " + entry.col + ")");
        System.out.println("Exit index = (" + exit.row + ", " + exit.col + ")" + "\n");

        for (int i = 0; i < numRows; i++) {
            System.out.println(Arrays.toString(maze[i]));
        }
        System.out.println();
    }

    public boolean findPath() {

        return moveTo(entry.row, entry.col);
    }

    private boolean moveTo(int row, int col) {
        if (row == exit.row && col == exit.col) {
            return true;
        }
        else {
            if (row >= 0 || row < numRows || col >= 0 || col < numCols) {
                int right = maze[row][col + 1], left = maze[row][col - 1],
                        up = maze[row + 1][col], down = maze[row - 1][col];
                boolean visitR = visited[row][col + 1], visitL = visited[row][col - 1],
                        visitU = visited[row - 1][col], visitD = visited[row + 1][col];
                if (up == 0 && visitU == false && row - 1 >= 0) {
                    visited[row][col] = true;
                    moveTo(row - 1, col);
                }
                if (left == 0 && visitL == false && col - 1 >= 0) {
                    visited[row][col] = true;
                    moveTo(row, col - 1);
                }
                if (down == 0 && visitD == false && row + 1 < numCols) {
                        visited[row][col] = true;
                        moveTo(row + 1, col);
                }
                if (right == 0 && visitR == false && col + 1 < numCols) {
                    visited[row][col] = true;
                    moveTo(row, col + 1);
                }

                else {
                    if ((up == 1 || (up == 0 && visitU == true) || row - 1 < 0) &&
                            (left == 1 || (left == 0 && (visitL == true) || col - 1 < 0)) &&
                            (down == 1 || (down == 0 && visitD == true) || row + 1 >= numRows)&&
                            (right == 1 || (right == 0 && visitR == true) || col + 1 >= numCols))
                    {
                            return false;
                    }
                }
            }
        }
    }
}