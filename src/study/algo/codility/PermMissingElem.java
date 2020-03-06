package study.algo.codility;

public class PermMissingElem {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1}));

	}
	
	/*
	 * 길이 N인 배열 A에서 1~N+1 중 빠진 정수 찾기
	 * 
	 * An array A consisting of N different integers is given. The array contains
	 * integers in the range [1..(N + 1)], which means that exactly one element is
	 * missing. N is an integer within the range [0..100,000]; the elements of A are
	 * all distinct; each element of array A is an integer within the range [1..(N +
	 * 1)].
	 */
	public static int solution(int[] A) {
		long lenA = A.length+1;
		long sumN = (lenA*(lenA+1))/2;
		long sumA = 0;
		for(int a :A) {
			sumA += a;
		}
		return (int)(sumN - sumA);
	}
	public static int solution2(int[] A) {
		long lenA = A.length+1;
		long sumN = 0;
		long sumA = 0;
		for(int i=0;i<lenA;i++) {
			sumN += i+1;
		}
		for(int a :A) {
			sumA += a;
		}
		return (int)(sumN - sumA);
	}

}
