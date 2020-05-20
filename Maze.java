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
        /*
        1st 주변이 0이 4,3,2,1개 일 경우
            col 과 row가 큰 곳으로 이동
        2nd 주변이 0이 없는 경우
            i) 주변에 passed가 1개 있는 경우
               passed로 이동
            ii) 주변에 passed가 2개 이상 있는 경우
                passed의 숫자가 낮은 곳으로 이동
                만약 passed가 같다면 col과 row가 큰 곳으로 이동

            iii) 주변에 passed가 없는 경우
               return false
        3rd exit에 도달한 경우
            return true
        return false;
         */
    }
}