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
	 * ������ ���ڿ� s�� �Ű������� �־��� ��, ���� ������ ������� 1�� �̻� ������ ���ڿ��� �߶� 
	 * �����Ͽ� ǥ���� ���ڿ� �� ���� ª�� ���� ���̸� return �ϵ��� solution �Լ��� �ϼ����ּ���.
	 */
	public static int solution(String s) {
		int answer = 1001;
		if(s.length() == 1) {
			return 1;
		}
		// �ڸ��� ���ڿ� ����
		for(int i=1;i<=s.length()/2;i++) {
			String comp = "";
			String prev = "";
			int duplCnt = 0;
			// ���ڿ� ��ȸ�ϸ� �ڸ���
			for(int j=0;j<s.length();j+=i) {//10 => 4 9 12
				if(j <= s.length() - i) {
					String cur = s.substring(j, j+i);
					if(prev.equals(duplCnt == 1 ? cur : duplCnt + cur)) {
						// ���� ���ڿ��� ���� ���ڿ��� ������ ���(���� �ߺ� ����)
						cur = ++duplCnt  + cur;
						// �ߺ��� ��� ���� ���ڿ� ���� �� ���� ���ڿ� �߰�
						comp = comp.substring(0, comp.length() - prev.length()) + cur;
					}else {
						// ���� �ߺ� ���ڿ� �ƴ� ���
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
