package study.algo.programmers;

import java.util.Arrays;

public class Example1 {

	public static void main(String[] args) {
		print(solution(new int[] {1,2,3,4,5}));
		print(solution(new int[] {1,3,2,4,2}));
	}
	
	
	/*
	 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ... 
	 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ... 
	 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
	 * 
	 * 제한 조건 시험은 최대 10,000 문제로 구성되어있습니다. 문제의 정답은 1, 2, 3, 4, 5중 하나입니다. 가장 높은 점수를 받은
	 * 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
	 * 
	 */
	public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] cnt = {0, 0, 0};
        int[][] pattern = {
        		{1, 2, 3, 4, 5}, 
        		{2, 1, 2, 3, 2, 4, 2, 5},
        		{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        for(int i=0; i<answers.length; i++) {
        	for(int j=0;j<pattern.length;j++) {
        		if(answers[i] == pattern[j][i % pattern[j].length])
	        	{
	        		cnt[j]++;
	        	}
        	}
        }
        
        int max = -1;
        for(int i=0;i<cnt.length;i++) {
        	if(cnt[i] > max) {
        		max = cnt[i];
        		answer = new int[1];
        		answer[0] = i+1;
        	} else if(cnt[i] == max){
        		int len = answer.length;
        		answer = Arrays.copyOf(answer, len+1);
        		answer[len] = i+1;
        	}
        }
        
        return answer;
    }
	
	
	public static int[] solution1(int[] answers) {
        int[] answer = {};
        int[] cnt = {0, 0, 0};
        int[] P1 = {1, 2, 3, 4, 5};
        int[] P2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] P3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i=0; i<answers.length; i++) {
        	if(i == 0) {
        		if(answers[0] == P1[0])
            	{
            		cnt[0]++;
            	}
            	if(answers[0] == P2[0])
            	{
            		cnt[1]++;
            	}
            	if(answers[0] == P3[0])
            	{
            		cnt[2]++;
            	}
        	}else {
	        	if(answers[i] == P1[i % P1.length])
	        	{
	        		cnt[0]++;
	        	}
	        	if(answers[i] == P2[i % P2.length])
	        	{
	        		cnt[1]++;
	        	}
	        	if(answers[i] == P3[i % P3.length])
	        	{
	        		cnt[2]++;
	        	}
        	}
        }
        
        int max = -1;
        for(int i=0;i<cnt.length;i++) {
        	if(cnt[i] > max) {
        		max = cnt[i];
        		answer = new int[1];
        		answer[0] = i+1;
        	} else if(cnt[i] == max){
        		int len = answer.length;
        		answer = Arrays.copyOf(answer, len+1);
        		answer[len] = i+1;
        	}
        }
        
        return answer;
    }
	
	
	public static void print(int[] answers) {
		System.out.print("[");
		boolean first = true;
		for(int a : answers) {
			if(first) {
				System.out.print(a);
				first = false;
			}else {
				System.out.print(", "+a);
			}
		}
		System.out.print("]");
		
	}
}
