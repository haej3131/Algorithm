package study.algo.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Example6 {
	// 우 하 좌 상
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {

	}

	/*
	 * N*M 배열 ( 2<=N, M<=100>) (1,1) -> (N,M) 갈 때 지나는 최소 칸 수 // 4 6 // 101111 //
	 * 101010 // 101011 // 111011
	 * 
	 * // 15
	 * 
	 */
	// 최단거리 구하기
	public static int solution(int N, int M, int[][] arr) {
		boolean[][] visited = new boolean[N][M];
		return 0;
	}

	public static void bfs(int x, int y, int[][] arr, boolean[][] visited) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();

		qx.add(x);
		qy.add(y);
		while (!qx.isEmpty() && !qy.isEmpty()) {
			int popx = qx.poll();
			int popy = qy.poll();
			visited[popx][popy] = true;

			if (arr[popx][popy] == 1 && !visited[popx][popy]) {
				qx.add(popx);
				qy.add(popy);
			}
		}
	}
}