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
		N = sc.nextInt(); // ������ ����(1<=N<=1,000)
		M = sc.nextInt(); // ������ ����(1<=M<=10,000)
		V = sc.nextInt(); // Ž���� ������ ������ ��ȣ

		adj = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];
		initializeVisitedArr();
		for (int i = 0; i < M; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			adj[num1][num2] = adj[num2][num1] = true;
		}

		System.out.println("--DFS ���--");
		dfs_reculsive(V);
		initializeVisitedArr();
		System.out.println();
		System.out.println("--DFS ����--");
		dfs(V);
		initializeVisitedArr();
		System.out.println();
		System.out.println("--DFS ť--");
		bfs(V);
	}

	public static void initializeVisitedArr() {
		for (int i = 1; i <= N; i++) {
			visited[i] = false;
		}
	}

	/**
	 * DFS : ���� �켱 Ž�� ��� ���
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
	 * DFS : ���� �켱 Ž�� ���� ���
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
	 * BFS : �ʺ� �켱 Ž�� ť ���
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