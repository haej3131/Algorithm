package study.algo.kakao.y2017;

import java.util.HashSet;
import java.util.Set;

public class SimilarSets {

	public static void main(String[] args) {

		System.out.println(solution("FRANCE", "french"));
		System.out.println(solution("handshake", "shake hands"));
		System.out.println(solution("aa1+aa2", "AAAA12"));
		System.out.println(solution("E=M*C^2", "e=m*c^2"));
	}
	
	public static int solution(String str1, String st2) {
		Set<String> set1 = new HashSet<String>();
		for(int i=0;i<str1.length();i++) {
			if(i != str1.length()-1) {
				set1.add(str1.substring(i, i+2));
			}
		}

		
		
		return 0;
	}

}
