package leetcode.editor.cn;

//200-岛屿数量
public class P200_NumberOfIslands {

    public static void main(String[] args) {

        char[][] grid = {//
                {'1', '1', '1', '1', '0'},//
                {'1', '1', '0', '1', '0'},//
                {'1', '1', '0', '0', '0'},//
                {'0', '0', '0', '0', '0'}};
        char[][] grid2 = {//
                {'1', '1', '0', '0', '0'},//
                {'1', '1', '0', '0', '0'},//
                {'0', '0', '1', '0', '0'},//
                {'0', '0', '0', '1', '1'}//
        };
        Solution solution = new P200_NumberOfIslands().new Solution();
        System.out.println(solution.numIslands(grid));
        System.out.println(solution.numIslands(grid2));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private void dfs(int i, int j, char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            if (i >= m || i < 0 || j >= n || j < 0) {
                return;
            }
            //访问过,或者为0;
            if (grid[i][j] == '0' || grid[i][j] == '2') {
                return;
            }
            grid[i][j] = '2';
            dfs(i + 1, j, grid);
            dfs(i - 1, j, grid);
            dfs(i, j + 1, grid);
            dfs(i, j - 1, grid);
        }


        public int numIslands(char[][] grid) {
            //使用深度优先进行遍历;
            int m = grid.length;
            int n = grid[0].length;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        cnt++;
                        dfs(i, j, grid);
                    }

                }
            }
            return cnt;
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)
}
