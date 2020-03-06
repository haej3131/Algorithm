package study.algo.programmers;

import java.util.LinkedList;
import java.util.Scanner;

public class Example3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int r = sc.nextInt();

		int arr[] = new int[n];
		for (int i = 1; i <= n; i++)
			arr[i - 1] = i;

		LinkedList<Integer> list = new LinkedList<>();

		// 순열
		// 4C3 (3! : 6가지)

		int check[] = new int[n];
		System.out.println("****순  열****"); // nPr => r개 중복 없이, 순서 있게 뽑기
//		perm(arr, new int[n], new boolean[n], 0, n, r);	// (int[] arr, int[] output, boolean[] visited, int depth, int n, int r)
		perm2(arr, 0, n, r); // (int[] arr, int depth, int n, int r)

//		//중복순열
//		System.out.println("****중복순열****");	// n^r => r개 중복 있게, 순서 있게 뽑기
//		rePermutation(list, n, r);
//		list.clear();
//		
//		//조합
//		System.out.println("****조  합****");		// nCr => r개 중복 없이, 순서 없이 뽑기(조 뽑기)
//		combination(list, n, r, 0);
//		list.clear();
//		
//		//중복조합
//		System.out.println("****중복조합****");	// nHr ( = n+r-1Cr) => r개 중복 있게 순서 없이 뽑기
//		reCombination(list, n, r, 0);

	}

	// 중복조합
	private static void reCombination(LinkedList<Integer> list, int n, int r, int index) {
		if (r == 0) {
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		if (index == n)
			return;

		list.add(index);
		reCombination(list, n, r - 1, index);
		list.removeLast();
		reCombination(list, n, r, index + 1);
	}

	// 조합
	private static void combination(LinkedList<Integer> list, int n, int r, int index) {
		if (r == 0) { // r이 0이면 다 뽑았다는 뜻
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		if (index == n)
			return; // 다 탐색했으면 종료..

		list.add(index);
		combination(list, n, r - 1, index + 1); // 뽑았으니 ,r-1
		list.removeLast();
		combination(list, n, r, index + 1); // 안뽑았으니, r
	}

	// 중복순열
	private static void rePermutation(LinkedList<Integer> list, int n, int r) {
		if (list.size() == r) {
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			list.add(i);
			rePermutation(list, n, r);
			list.removeLast(); // 해당 넘버를 다시 제거 (즉,뽑지 않고 다음 번호 뽑기위함)
		}
	}

	// 순열
	// 순서를 지키면서 n 개중에서 r 개를 뽑는 경우
	// 사용 예시: perm(arr, output, visited, 0, n, 3);
	static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {
			print(output, r);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visited, depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

	// 순서 없이 n 개중에서 r 개를 뽑는 경우
	// 사용 예시: permutation(arr, 0, n, 4);
	static void perm2(int[] arr, int depth, int n, int r) {
		if (depth == r) {
			print(arr, r);
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			perm2(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	static void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

	// 배열 출력
	static void print(int[] arr, int r) {
		for (int i = 0; i < r; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}