package study.algo.kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Example4 {

	public static void main(String[] args) {

		System.out.println(dartgame("1S2D*3T")); // 37 1^1 * 2 + 2^2 * 2 + 3^3
		System.out.println(dartgame("1D2S#10S")); // 9
		System.out.println(dartgame("1D2S0T")); // 3
		System.out.println(dartgame("1S*2T*3S")); // 23
		System.out.println(dartgame("1D#2S*3S")); // 5
		System.out.println(dartgame("1T2D3D#")); // -4
		System.out.println(dartgame("1D2S3T*")); // 59

	}

	// 다트게임
	/*
	 * “점수|보너스|[옵션]”으로 이루어진 문자열 3세트. 예) 1S2D*3T
	 * 
	 * 점수는 0에서 10 사이의 정수이다. 보너스는 S, D, T 중 하나이다. 옵선은 *이나 # 중 하나이며, 없을 수도 있다.
	 * 
	 * 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱
	 * (점수^1 , 점수^2 , 점수^3 )으로 계산된다. 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와
	 * 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다. 스타상(*)의 효과는 다른 스타상(*)의 효과와
	 * 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고) 스타상(*)의 효과는 아차상(#)의 효과와 중첩될
	 * 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
	 * 
	 * 
	 */
	public static int dartgame(String dartResult) {
		String newDart = dartResult.replaceAll("S", "S,").replaceAll("D", "D,").replaceAll("T", "T,");
		newDart = newDart.replaceAll(",\\*", "*,").replaceAll(",#", "#,");
		List<Dart> dartlist = getDartList(newDart.split(","));
		return getScore(dartlist);
	}

	private static int getScore(List<Dart> dartlist) {
		int result = 0;
		for (Dart d : dartlist) {
			int temp = 0;
			if ("S".equals(d.getBonus())) {
				temp += d.getScore();
			} else if ("D".equals(d.getBonus())) {
				temp += (Math.pow(d.getScore(), 2));
			} else if ("T".equals(d.getBonus())) {
				temp += (Math.pow(d.getScore(), 3));
			}

			if ("*".equals(d.getOption())) {
				temp *= 2;
			} else if ("#".equals(d.getOption())) {
				temp *= (-1);
			}
			result += (temp * calcPrevStar(d.getPrev(), 1));
		}
		return result;
	}

	private static int calcPrevStar(Dart dart, int val) {
		if ("*".equals(dart.getOption())) {
			return 2 * calcPrevStar(dart.getPrev(), val);
		} else {
			return val;
		}
	}

	private static List<Dart> getDartList(String[] darts) {
		List<Dart> dartlist = new ArrayList<Dart>();
		Dart next = new Dart();
		for (int i = darts.length - 1; i >= 0; i--) {
			String d = darts[i];
			String delim = "";
			if (d.contains("S")) {
				delim = "S";
			} else if (d.contains("D")) {
				delim = "D";
			} else if (d.contains("T")) {
				delim = "T";
			} else {
				return null;
			}
			StringTokenizer st = new StringTokenizer(d, delim, true);

			Dart dart = new Dart();
			dart.setScore(Integer.parseInt(st.nextToken()));
			dart.setBonus(st.nextToken());
			if (st.hasMoreTokens()) {
				dart.setOption(st.nextToken());
			}
			dart.setPrev(next);
			next = dart;
			dartlist.add(dart);
		}
		return dartlist;
	}

}

class Dart {
	private int score;
	private String bonus;
	private String option;
	private Dart prev;

	public Dart() {
	}

	public Dart(int score, String bonus) {
		this.score = score;
		this.bonus = bonus;
	}

	public Dart(int score, String bonus, String option) {
		this.score = score;
		this.bonus = bonus;
		this.option = option;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public Dart getPrev() {
		return prev;
	}

	public void setPrev(Dart prev) {
		this.prev = prev;
	}

}