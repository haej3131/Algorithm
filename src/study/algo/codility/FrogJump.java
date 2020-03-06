package study.algo.codility;

public class FrogJump {

	public static void main(String[] args) {
		System.out.println(solution(10, 85, 30));
		System.out.println(solution(85, 85, 30));
		System.out.println(solution(10, 100, 30));

	}
	
	/*
	 * D만큼씩 점프했을 때 X -> Y+까지 필요한 횟수
	 * 
	 * The frog is currently located at position X and wants to get to a position
	 * greater than or equal to Y. The small frog always jumps a fixed distance, D.
	 * that, given three integers X, Y and D, returns the minimal number of jumps
	 * from position X to a position equal to or greater than Y.
	 */
	public static int solution(int X, int Y, int D) {
		int diff = Y-X;
//		if(0==diff) return 0;
		return 0 == diff % D? diff/D : diff/D + 1;
	}

}
