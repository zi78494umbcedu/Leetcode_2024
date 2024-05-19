class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
	int[] rs = new int[N + 1];

	backtrack(1, rs, paths);
	int[] ans = new int[N];
	System.arraycopy(rs, 1, ans, 0, N);
	return ans;
}

private void backtrack(int t, int[] rs, int[][] paths) {
	for (int i = 1; i <= 4; i++) {
		rs[t] = i;
		if (ok(t, rs, paths)) {
			if (t + 1 < rs.length)
				backtrack(t + 1, rs, paths);
			break;
		}
		rs[t] = 0;
	}
}

private boolean ok(int t, int[] rs, int[][] paths) {
	for (int i = 0; i < paths.length; i++) {
		if (paths[i][0] == t && rs[paths[i][1]] == rs[t]) {
			return false;
		}
		if (paths[i][1] == t && rs[paths[i][0]] == rs[t]) {
			return false;
		}
	}
	return true;
}
}