package com.rocksang.study.sharing.demo.leetcode.medium;

/**
 * @Author: Rock Sang
 * @Date: 2020/6/11 10:03 上午
 */
public class P200NumberOfIslands {


    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();

        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        solution.numIslands(grid);

    }

    class Solution {

        public int numIslands(char[][] grid) {

            int islandsNum = 0;
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[0].length; c++) {
                    if (grid[r][c] == '1') {
                        islandsNum++;
                        dfs(grid, r, c);
                    }
                }
            }
            System.out.println(islandsNum);
            return islandsNum;
        }

        private void dfs(char[][] grid, int r, int c) {

            int gr = grid.length;
            int gc = grid[0].length;

            if (r < 0 || c < 0 || r >= gr || c >= gc || grid[r][c] != '1') {
                return;
            }

            grid[r][c] = '0';
            dfs(grid, r - 1, c);
            dfs(grid, r + 1, c);
            dfs(grid, r, c + 1);
            dfs(grid, r, c - 1);
        }
    }


}
