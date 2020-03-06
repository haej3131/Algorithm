package study.algo.hackerrank;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Example4 {
    
    /**
 * ����(interval)�� �̷���� �迭�� �־�����, ��ġ�� ���� ���ҵ��� ��ģ ���ο� �迭�� ����ÿ�.
 * ������ ���۰� ������ �̷���� ������ ������ ������ �۰ų� �����ϴ�.
 * Given a list of intervals, merge intersecting intervals.
 * 
 * ����)
 * Input: {{2,4}, {1,5}, {7,9}}
 * Output: {{1,5}, {7,9}}
 * Input: {{3,6}, {1,3}, {2,4}}
 * Output: {{1,6}}
 */
    public static void main(String args[] ) throws Exception {
        System.out.println("Hello World");
    }
    
    public static int[][] solution(int[][] input){
        int[][] result = {{}};
       
        Set<Integer> set = new HashSet<Integer>();
        
        for(int[] in : input){
            for(int i = in[0] ; i<=in[1] ; i++){
                set.add(i);
            }
        }
        
//        Collections.sort(set);
        
        Iterator<Integer> iter = set.iterator();
        int start = 0;
        int prev = 0;
        while(iter.hasNext()){
            int cur = iter.next();
            if(start == 0){
                start = cur;
                prev = cur;
            }else{
                if(cur - prev > 1){
                    int[] o = {start, prev};
                    result[result.length-1] = o;
                    start = cur;
                }
            }
        }
		return result;
        
    }
}