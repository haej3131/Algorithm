package study.algo.programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Example5 {
	static int N;
	static int M;
	static int V;

	static boolean[][] adj;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점의 갯수(1<=N<=1,000)
		M = sc.nextInt(); // 간선의 갯수(1<=M<=10,000)
		V = sc.nextInt(); // 탐색을 시작할 정점의 번호

		adj = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];
		initializeVisitedArr();
		for (int i = 0; i < M; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			adj[num1][num2] = adj[num2][num1] = true;
		}

		System.out.println("--DFS 재귀--");
		dfs_reculsive(V);
		initializeVisitedArr();
		System.out.println();
		System.out.println("--DFS 스택--");
		dfs(V);
		initializeVisitedArr();
		System.out.println();
		System.out.println("--DFS 큐--");
		bfs(V);
	}

	public static void initializeVisitedArr() {
		for (int i = 1; i <= N; i++) {
			visited[i] = false;
		}
	}

	/**
	 * DFS : 깊이 우선 탐색 재귀 사용
	 */
	public static void dfs_reculsive(int V) {
		if (visited[V]) {
			return;
		}
		visited[V] = true;
		System.out.print(V + " ");
		for (int i = 1; i <= N; i++) {
			if (adj[V][i]) {
				dfs_reculsive(i);
			}
		}
	}

	/**
	 * DFS : 깊이 우선 탐색 스택 사용
	 */
	public static void dfs(int V) {
		Stack<Integer> stack = new Stack<Integer>();

		if (visited[V]) {
			return;
		}
		stack.push(V);
		while (!stack.isEmpty()) {
			int pop = stack.pop();
			visited[pop] = true;
			System.out.print(pop + " ");

			for (int i = 1; i <= N; i++) {
				if (adj[pop][i] && !visited[i] && !stack.contains(i)) {
					stack.push(i);
				}
			}
		}

	}

	/**
	 * BFS : 너비 우선 탐색 큐 사용
	 */
	public static void bfs(int V) {
		Queue<Integer> queue = new LinkedList<Integer>();

		if (visited[V]) {
			return;
		}
		queue.add(V);
		while (!queue.isEmpty()) {
			int poll = queue.poll();
			visited[poll] = true;
			System.out.print(poll + " ");

			for (int i = 1; i <= N; i++) {
				if (adj[poll][i] && !visited[i] && !queue.contains(i)) {
					queue.add(i);
				}
			}
		}
	}
}