package study.algo.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example6 {

	public static void main(String[] args) {

		System.out.println(solution(1, 1, 5, new String[] { "08:00", "08:01", "08:02", "08:03" }));
		System.out.println(solution(2, 10, 2, new String[] { "09:10", "09:09", "08:00" }));
		System.out.println(solution(2, 1, 2, new String[] { "09:00", "09:00", "09:00", "09:00" }));
		System.out.println(solution(1, 1, 5, new String[] { "00:01", "00:01", "00:01", "00:01", "00:01" }));
		System.out.println(solution(1, 1, 1, new String[] { "23:59" }));
		System.out.println(solution(10, 60, 45, new String[] { "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
				"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59" }));

	}

	// ???λ²μ€
	/*
	 * ????? 09:00λΆ??° μ΄? n? tλΆ? κ°κ²©?Όλ‘? ?­? ?μ°©νλ©?, ??? ????? μ΅λ? mλͺμ ?Ήκ°μ΄ ? ? ??€.
	 * 
	 * ?? ₯ : ??? ?΄? ?? n, ??? ?΄? κ°κ²© t, ? ???? ? ? ?? μ΅λ? ?¬λ£? ? m, ?¬λ£¨κ? ??κΈ°μ΄? ?μ°©ν? ?κ°μ λͺ¨μ? λ°°μ΄
	 * timetable 0 οΌ? n ?¦ 10 0 οΌ? t ?¦ 60 0 οΌ? m ?¦ 45 timetable?? μ΅μ κΈΈμ΄ 1?΄κ³? μ΅λ? κΈΈμ΄ 2000?Έ
	 * λ°°μ΄λ‘?, ?λ£? ?? ?¬λ£¨κ? ??κΈ°μ΄? ?μ°©ν? ?κ°μ΄ HH:MM ???Όλ‘? ?΄λ£¨μ΄? Έ ??€. ?¬λ£¨μ ?μ°? ?κ°? HH:MM?? 00:01??
	 * 23:59 ?¬?΄
	 * 
	 * μΆλ ₯ : μ½μ΄ λ¬΄μ¬? ???? ??κ³? ?¬λ¬΄μ€λ‘? κ°? ? ?? ? ?Ό ?¦?? ?μ°? ?κ°μ μΆλ ₯??€. ?μ°? ?κ°μ? HH:MM ???΄λ©?, 00:00??
	 * 23:59 ?¬?΄? κ°μ΄ ?  ? ??€.
	 */
	public static String solution(int n, int t, int m, String[] timetable) {
		String[] shuttle = new String[m];
		List shuttleList = new ArrayList();

		Arrays.sort(timetable);

		int cnt = 0;
		for (String crewtime : timetable) {
			if (crewtime.compareTo("09:00") > 0 && cnt < m) {
				shuttle[cnt] = crewtime;
			}
		}

		// μ²? μ°¨μ ??? κ²½μ°
		// μ€κ° μ°¨μ ??? κ²½μ°
		// λ§μ?λ§? μ°? ??? κ²½μ°

		return null;
	}

}