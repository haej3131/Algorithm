package study.algo.codility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

	public static void main(String[] args) {
		// print(solution(new int[] {}, 99)); // 3 -> 1 1+3
//		System.out.println(solution2(new int[] {2, 1, 1, 2, 3, 1}));
//		System.out.println(solution3(1));
		System.out.println(solution4(new int[] {-2,3}));
	}

	public static int solution4(int[] A) {
		int curSum = 0;
		int maxSum = 0;
		int maxVal = 1000000 * (-1);
		for (int a : A) {
			if(a > maxVal) {
				maxVal = a;
			}
			curSum += a;
			if(curSum > maxSum) {
				maxSum = curSum;
			}else if(curSum < 0){
				curSum = 0;
			}
		}
		return maxSum == 0 ? maxVal:maxSum;
	}

	public static int solution3(int N) {
		String binStr = Integer.toBinaryString(N);

		int max = 0;
		int cnt = 0;
		boolean gap = false;
		for (int i = 0; i < binStr.length(); i++) {
			char binChar = binStr.charAt(i);
			if (binChar == '1') {
				gap = true;
				if (max < cnt) {
					max = cnt;
				}
				cnt = 0;
			} else if (gap && binChar == '0') {
				cnt++;
			}
		}

		return max;
	}

	public static int solution2(int[] A) {
		Map<Integer, Integer> N = new HashMap<Integer, Integer>();
		int cnt = 0;
		for (int a : A) {
			if (N.get(a) == null) {
				cnt++;
				N.put(a, 0);
			}
		}
		return cnt;
	}

	public static int[] solution(int[] A, int K) {
		if (A.length == 0)
			return A;

		int[] R = new int[A.length];
		int mod = K % A.length;
		for (int i = 0; i < A.length; i++) {
			if (i + mod < A.length) {
				R[i + mod] = A[i];
			} else {
				R[i + mod - A.length] = A[i];
			}
		}
		return R;
	}

	public static void print(int[] R) {
		for (int r : R) {
			System.out.print(r + " ");
		}
	}
}
