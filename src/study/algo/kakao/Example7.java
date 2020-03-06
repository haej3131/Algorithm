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

	// ��ī�����絵
	/*
	 * 
	 * �Է����δ� str1�� str2�� �� ���ڿ��� ���´�. �� ���ڿ��� ���̴� 2 �̻�, 1,000 �����̴�. �Է����� ���� ���ڿ��� ��
	 * ���ھ� ��� ���������� ���ҷ� �����. �̶� �����ڷ� �� ���� �ָ� ��ȿ�ϰ�, ��Ÿ �����̳� ����, Ư�� ���ڰ� ����ִ� ���� �� ����
	 * ���� ������. ���� ��� ��ab+���� �Է����� ������, ��ab���� ���������� ���ҷ� ���, ��b+���� ������.
	 * 
	 * �������� ���� ���̸� ���� ��, �빮�ڿ� �ҹ����� ���̴� �����Ѵ�. ��AB���� ��Ab��, ��ab���� ���� ���ҷ� ����Ѵ�.
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