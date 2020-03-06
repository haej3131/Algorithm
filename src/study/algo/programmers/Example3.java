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

		// ����
		// 4C3 (3! : 6����)

		int check[] = new int[n];
		System.out.println("****��  ��****"); // nPr => r�� �ߺ� ����, ���� �ְ� �̱�
//		perm(arr, new int[n], new boolean[n], 0, n, r);	// (int[] arr, int[] output, boolean[] visited, int depth, int n, int r)
		perm2(arr, 0, n, r); // (int[] arr, int depth, int n, int r)

//		//�ߺ�����
//		System.out.println("****�ߺ�����****");	// n^r => r�� �ߺ� �ְ�, ���� �ְ� �̱�
//		rePermutation(list, n, r);
//		list.clear();
//		
//		//����
//		System.out.println("****��  ��****");		// nCr => r�� �ߺ� ����, ���� ���� �̱�(�� �̱�)
//		combination(list, n, r, 0);
//		list.clear();
//		
//		//�ߺ�����
//		System.out.println("****�ߺ�����****");	// nHr ( = n+r-1Cr) => r�� �ߺ� �ְ� ���� ���� �̱�
//		reCombination(list, n, r, 0);

	}

	// �ߺ�����
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

	// ����
	private static void combination(LinkedList<Integer> list, int n, int r, int index) {
		if (r == 0) { // r�� 0�̸� �� �̾Ҵٴ� ��
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		if (index == n)
			return; // �� Ž�������� ����..

		list.add(index);
		combination(list, n, r - 1, index + 1); // �̾����� ,r-1
		list.removeLast();
		combination(list, n, r, index + 1); // �Ȼ̾�����, r
	}

	// �ߺ�����
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
			list.removeLast(); // �ش� �ѹ��� �ٽ� ���� (��,���� �ʰ� ���� ��ȣ �̱�����)
		}
	}

	// ����
	// ������ ��Ű�鼭 n ���߿��� r ���� �̴� ���
	// ��� ����: perm(arr, output, visited, 0, n, 3);
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

	// ���� ���� n ���߿��� r ���� �̴� ���
	// ��� ����: permutation(arr, 0, n, 4);
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

	// �迭 ���
	static void print(int[] arr, int r) {
		for (int i = 0; i < r; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}