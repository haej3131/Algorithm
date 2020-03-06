package study.algo.kakao;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Example7 {

	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french")); // FRANCE french 16384
		System.out.println(solution("handshake", "shake hands")); // handshake shake hands 65536
		System.out.println(solution("aa1+aa2", "AAAA12")); // aa1+aa2 AAAA12 43690
		System.out.println(solution("E=M*C^2", "e=m*c^2")); // E=M*C^2 e=m*c^2 65536

	}

	// 자카드유사도
	/*
	 * 
	 * 입력으로는 str1과 str2의 두 문자열이 들어온다. 각 문자열의 길이는 2 이상, 1,000 이하이다. 입력으로 들어온 문자열은 두
	 * 글자씩 끊어서 다중집합의 원소로 만든다. 이때 영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자
	 * 쌍을 버린다. 예를 들어 “ab+”가 입력으로 들어오면, “ab”만 다중집합의 원소로 삼고, “b+”는 버린다.
	 * 
	 * 다중집합 원소 사이를 비교할 때, 대문자와 소문자의 차이는 무시한다. “AB”와 “Ab”, “ab”는 같은 원소로 취급한다.
	 * 
	 */
	public static int solution(String str1, String str2) {

		String engChk = "^[a-zA-Z]{2}$";
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		Set<String> kyo = new HashSet<String>();
		Set<String> hap = new HashSet<String>();

		char[] ca1 = str1.toCharArray();
		char[] ca2 = str2.toCharArray();

		for (int i = 0; i < ca1.length - 1; i++) {
			String combine = charToUpperStr(ca1[i]) + charToUpperStr(ca1[i + 1]);
			if (Pattern.matches(engChk, combine)) {
				set1.add(combine);
			}
		}
		for (int i = 0; i < ca2.length - 1; i++) {
			String combine = charToUpperStr(ca2[i]) + charToUpperStr(ca2[i + 1]);
			if (Pattern.matches(engChk, combine)) {
				set2.add(combine);
			}
		}

		for (String s : set1) {
			hap.add(s);
			if (set2.contains(s)) {
				kyo.add(s);
				set2.remove(s);
			}
		}
		for (String s : set2) {
			hap.add(s);
		}

		double calcJa = kyo.size() == 0 && hap.size() == 0 ? 1 : (double) kyo.size() / (double) hap.size();
		return (int) Math.floor(calcJa * 65536);
	}

	private static String charToUpperStr(char ch) {
		return String.valueOf(ch).toUpperCase();
	}
}