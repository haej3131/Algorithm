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

	// ��Ʈ����
	/*
	 * ������|���ʽ�|[�ɼ�]������ �̷���� ���ڿ� 3��Ʈ. ��) 1S2D*3T
	 * 
	 * ������ 0���� 10 ������ �����̴�. ���ʽ��� S, D, T �� �ϳ��̴�. �ɼ��� *�̳� # �� �ϳ��̸�, ���� ���� �ִ�.
	 * 
	 * ������ �Բ� Single(S), Double(D), Triple(T) ������ �����ϰ� �� ���� ��÷ �� �������� 1����, 2����, 3����
	 * (����^1 , ����^2 , ����^3 )���� ���ȴ�. �ɼ����� ��Ÿ��(*) , ������(#)�� �����ϸ� ��Ÿ��(*) ��÷ �� �ش� ������
	 * �ٷ� ���� ���� ������ �� 2��� �����. ������(#) ��÷ �� �ش� ������ ���̳ʽ��ȴ�. ��Ÿ��(*)�� ȿ���� �ٸ� ��Ÿ��(*)�� ȿ����
	 * ��ø�� �� �ִ�. �� ��� ��ø�� ��Ÿ��(*) ������ 4�谡 �ȴ�. (���� 4�� ����) ��Ÿ��(*)�� ȿ���� ������(#)�� ȿ���� ��ø��
	 * �� �ִ�. �� ��� ��ø�� ������(#)�� ������ -2�谡 �ȴ�. (���� 5�� ����)
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