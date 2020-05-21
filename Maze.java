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
        Location position = entry;
        int[] collect = null;
        int count = 0;
        int right = maze[position.row][position.col + 1];
        int left = maze[position.row][position.col - 1];
        int up = maze[position.row + 1][position.col];
        int down = maze[position.row - 1][position.col];

        if (position.row == 0) {
            if (position.col == 0) { // 0,0
                if (right == 1 || visited[position.row][position.col + 1] == true) { // 서쪽으로 이동 불가
                    if (down == 1 || visited[position.row + 1][position.col] == true) { // 남쪽으로 이동 불가
                        collect[count] = 0;
                        count++;
                        //움직일 곳이 없는 경우
                    } else if (down == 0 && visited[position.row + 1][position.col] == false) {
                        position.row += position.row;
                        visited[position.row + 1][position.col] = true;
                        moveTo(position.row, position.col);
                    } else { // down == 0 && visited true
                        collect[count] += 0;
                        count++;
                    }
                } else if (right == 0 && visited[position.row][position.col + 1] == true) {
                    if (down == 1 || visited[position.row + 1][position.col] == true) { // 남쪽으로 이동 불가
                        collect[count] = 0;
                        count++;
                        //움직일 곳이 없는 경우
                    } else if (down == 0 && visited[position.row + 1][position.col] == false) {
                        position.row += position.row;
                        visited[position.row + 1][position.col] = true;
                        moveTo(position.row, position.col);
                    } else { // down == 0 && visited true
                        collect[count] += 0;
                        count++;
                    }
                } else {
                    moveTo(position.row, position.col + 1);
                    if (down == 1 || visited[position.row + 1][position.col] == true) { // 남쪽으로 이동 불가
                        collect[count] = 0;
                        count++;
                    } else if (down == 0 && visited[position.row + 1][position.col] == false) {
                        visited[position.row + 1][position.col] = true;
                        moveTo(position.row + 1, position.col);
                    } else { // down == 0 && visited true
                        collect[count] += 0;
                        count++;
                    }
                }
            } else if (position.col == numCols) { // (0,1) 좌 하 움직이기 가능
                if (left == 1 || visited[position.row][position.col - 1] == true) { // 동쪽으로 이동 불가
                    if (down == 1 || visited[position.row + 1][position.col] == true) { // 남쪽으로 이동 불가
                        collect[count] = 0;
                        count++;
                        //움직일 곳이 없는 경우
                    } else if (down == 0 && visited[position.row + 1][position.col] == false) {
                        position.row += position.row;
                        visited[position.row + 1][position.col] = true;
                        moveTo(position.row, position.col);
                    } else { // down == 0 && visited true
                        collect[count] += 0;
                        count++;
                    }
                } else if (left == 0 && visited[position.row][position.col - 1] == true) { // 동쪽 이동 불가
                    if (down == 1 || visited[position.row + 1][position.col] == true) { // 남쪽으로 이동 불가
                        collect[count] = 0;
                        count++;
                        //움직일 곳이 없는 경우
                    } else if (down == 0 && visited[position.row + 1][position.col] == false) {
                        position.row += position.row;
                        visited[position.row + 1][position.col] = true;
                        moveTo(position.row, position.col);
                    } else { // down == 0 && visited true
                        collect[count] += 0;
                        count++;
                    }
                } else { //동쪽 이동 가능
                    moveTo(position.row, position.col + 1);
                    if (down == 1 || visited[position.row + 1][position.col] == true) { // 남쪽으로 이동 불가
                        collect[count] = 0;
                        count++;
                    } else if (down == 0 && visited[position.row + 1][position.col] == false) {
                        visited[position.row + 1][position.col] = true;
                        moveTo(position.row + 1, position.col);
                    } else { // down == 0 && visited true
                        collect[count] += 0;
                        count++;
                    }
                }

            } else { // 좌 우 하 이동 가능
                if (left == 1 || visited[position.row][position.col - 1] == true) { // 동쪽으로 이동 불가
                    if (down == 1 || visited[position.row + 1][position.col] == true) { // 남쪽으로 이동 불가
                        collect[count] = 0;
                        count++;
                        //움직일 곳이 없는 경우
                    } else if (down == 0 && visited[position.row + 1][position.col] == false) {
                        position.row += position.row;
                        visited[position.row + 1][position.col] = true;
                        moveTo(position.row, position.col);
                    } else { // down == 0 && visited true
                        collect[count] += 0;
                        count++;
                    }
                } else if (left == 0 && visited[position.row][position.col - 1] == true) { // 동쪽 이동 불가
                    if (down == 1 || visited[position.row + 1][position.col] == true) { // 남쪽으로 이동 불가
                        collect[count] = 0;
                        count++;
                        //움직일 곳이 없는 경우
                    } else if (down == 0 && visited[position.row + 1][position.col] == false) {
                        position.row += position.row;
                        visited[position.row + 1][position.col] = true;
                        moveTo(position.row, position.col);
                    } else { // down == 0 && visited true
                        collect[count] += 0;
                        count++;
                    }
                } else { //동쪽 이동 가능
                    moveTo(position.row, position.col + 1);
                    if (down == 1 || visited[position.row + 1][position.col] == true) { // 남쪽으로 이동 불가
                        collect[count] = 0;
                        count++;
                    } else if (down == 0 && visited[position.row + 1][position.col] == false) {
                        visited[position.row + 1][position.col] = true;
                        moveTo(position.row + 1, position.col);
                    } else { // down == 0 && visited true
                        collect[count] += 0;
                        count++;
                    }
                }
            }
            visited[position.row][position.col] = true;
        }





        ///////////////////////////////////////////////////////////////////////////////////////////////////////





        else if(position.row == numRows){
            if (position.col == 0) {

            }
            else if (position.col == numCols) {

            }
            else {
            }
        }

        else {
            if (position.col == 0) {

            }
            else if (position.col == numCols){

            }
            else {

            }
        }
        /*
        1st 주변이 0이 4,3,2,1개 일 경우
            모든 moveTo(0 좌표) 생성
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