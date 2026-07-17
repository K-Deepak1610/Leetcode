class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] safeness = new int[n][n];
        for (int[] row : safeness) {
            Arrays.fill(row, -1);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    safeness[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[] dir = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i];
                int nc = c + dir[i + 1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && safeness[nr][nc] == -1) {
                    safeness[nr][nc] = safeness[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        
        // Step 2: Dijkstra's Algorithm with Max-Heap to find the safest path
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{safeness[0][0], 0, 0});
        
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int safe = curr[0];
            int r = curr[1];
            int c = curr[2];
            
            // Reached the bottom-right corner
            if (r == n - 1 && c == n - 1) {
                return safe;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i];
                int nc = c + dir[i + 1];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    pq.offer(new int[]{Math.min(safe, safeness[nr][nc]), nr, nc});
                }
            }
        }
        return 0;
    }
}