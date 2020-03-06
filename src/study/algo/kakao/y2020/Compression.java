package study.algo.kakao.y2020;

import java.util.ArrayList;
import java.util.List;

public class Compression {

	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ababcdcdababcdcd"));
		System.out.println(solution("abcabcdede"));
		System.out.println(solution("abcabcabcabcdededededede"));
		System.out.println(solution("xababcdcdababcdcd"));
		
		System.out.println(solution("xababcdcdababcdcdxababcdcdababcdcdxababcdcdababcdcdxababcdcdababcdcdxababcdcdababcdcdxababcdcdababcdcdxababcdcdababcdcdxababcdcdababcdcdxababcdcdababcdcdxababcdcdababcdcdxababcdcdababcdcdxababcdcdababcdcdxababcdcdababcdcd"));

	}
	
	
	/*
	 * 압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 
	 * 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.
	 */
	public static int solution(String s) {
		int answer = 1001;
		if(s.length() == 1) {
			return 1;
		}
		// 자르는 문자열 갯수
		for(int i=1;i<=s.length()/2;i++) {
			String comp = "";
			String prev = "";
			int duplCnt = 0;
			// 문자열 순회하며 자르기
			for(int j=0;j<s.length();j+=i) {//10 => 4 9 12
				if(j <= s.length() - i) {
					String cur = s.substring(j, j+i);
					if(prev.equals(duplCnt == 1 ? cur : duplCnt + cur)) {
						// 이전 문자열과 현재 문자열이 동일한 경우(연속 중복 등장)
						cur = ++duplCnt  + cur;
						// 중복인 경우 이전 문자열 제거 후 현재 문자열 추가
						comp = comp.substring(0, comp.length() - prev.length()) + cur;
					}else {
						// 연속 중복 문자열 아닌 경우
						comp += cur;
						duplCnt = 1;
					}
					prev = cur;
				}else {
					comp += s.substring(j);
					break;
				}
			}
			if(comp.length() < answer) {
				answer = comp.length();
			}
		}
		
		return answer;
	}
	
	
	 public int solution2(String s) {
	      int answer = 0;
	      for (int i = 1; i <= s.length() / 2; i++) {
	         int equalsCnt = 0;
	         String compressStr = "";
	         String nowStr = null;
	         String previousStr = null;
	         boolean endFlag = false;

	         for (int j = 0; j <= s.length(); j = i + j) {
	            int index = j + i;
	            if (index > s.length()) {
	               index = s.length();
	               endFlag = true;
	            }
	            nowStr = s.substring(j, index);
	            if (previousStr == null) {
	               equalsCnt++;
	               previousStr = nowStr;
	            } else {
	               if (previousStr.equals(nowStr)) {
	                  equalsCnt++;
	               } else {
	                  if (equalsCnt == 1) {
	                     compressStr += previousStr;
	                  } else {
	                     compressStr += equalsCnt + previousStr;
	                  }
	                  equalsCnt = 1;
	               }
	               previousStr = nowStr;
	            }
	            
	            if (endFlag) {
	               compressStr += nowStr;
	            }
	         }
	         
	         if (answer == 0) {
	            answer = compressStr.length();
	         } else if (compressStr.length() < answer) {
	            answer = compressStr.length();
	         }
	      }
	      return answer;
	   }
}
