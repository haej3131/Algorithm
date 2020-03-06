package study.algo.kakao;

public class Example3 {

	public static void main(String[] args) {

		printStrArr(calcBit(10, new int[] { 46, 33, 33, 22, 31, 50 }, new int[] { 27, 56, 19, 14, 14, 10 }));

	}

	// 비트연산
	public static String[] calcBit(int n, int[] arr1, int[] arr2) {
		String[] results = new String[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			String binStrs = Integer.toBinaryString(arr1[i] | arr2[i]);
			StringBuilder strBuilder = new StringBuilder();
			for (int j = 0; j < binStrs.length(); j++) {
				char ch = binStrs.charAt(j);
				if (ch == '0') {
					strBuilder.append(' ');
				} else if (ch == '1') {
					strBuilder.append("#");
				}
			}
			results[i] = strBuilder.toString();
		}
		return results;
	}

	public static void printStrArr(String[] strs) {
		System.out.print("[");
		boolean first = true;
		for (String s : strs) {
			if (first) {
				first = false;
			} else {
				System.out.print(",");
			}
			System.out.print("\"" + s + "\"");
		}
		System.out.print("]");
	}

}