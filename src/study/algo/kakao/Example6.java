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

	// ?…”??ë²„ìŠ¤
	/*
	 * ?…”???? 09:00ë¶??„° ì´? n?šŒ të¶? ê°„ê²©?œ¼ë¡? ?—­?— ?„ì°©í•˜ë©?, ?•˜?‚˜?˜ ?…”???—?Š” ìµœë? mëª…ì˜ ?Š¹ê°ì´ ?ƒˆ ?ˆ˜ ?ˆ?‹¤.
	 * 
	 * ?…? ¥ : ?…”?? ?š´?–‰ ?šŸ?ˆ˜ n, ?…”?? ?š´?–‰ ê°„ê²© t, ?•œ ?…”???— ?ƒˆ ?ˆ˜ ?ˆ?Š” ìµœë? ?¬ë£? ?ˆ˜ m, ?¬ë£¨ê? ??ê¸°ì—´?— ?„ì°©í•˜?Š” ?‹œê°ì„ ëª¨ì? ë°°ì—´
	 * timetable 0 ï¼? n ?‰¦ 10 0 ï¼? t ?‰¦ 60 0 ï¼? m ?‰¦ 45 timetable?? ìµœì†Œ ê¸¸ì´ 1?´ê³? ìµœë? ê¸¸ì´ 2000?¸
	 * ë°°ì—´ë¡?, ?•˜ë£? ?™?•ˆ ?¬ë£¨ê? ??ê¸°ì—´?— ?„ì°©í•˜?Š” ?‹œê°ì´ HH:MM ?˜•?‹?œ¼ë¡? ?´ë£¨ì–´? ¸ ?ˆ?‹¤. ?¬ë£¨ì˜ ?„ì°? ?‹œê°? HH:MM?? 00:01?—?„œ
	 * 23:59 ?‚¬?´
	 * 
	 * ì¶œë ¥ : ì½˜ì´ ë¬´ì‚¬?ˆ ?…”???„ ??ê³? ?‚¬ë¬´ì‹¤ë¡? ê°? ?ˆ˜ ?ˆ?Š” ? œ?¼ ?Š¦?? ?„ì°? ?‹œê°ì„ ì¶œë ¥?•œ?‹¤. ?„ì°? ?‹œê°ì? HH:MM ?˜•?‹?´ë©?, 00:00?—?„œ
	 * 23:59 ?‚¬?´?˜ ê°’ì´ ?  ?ˆ˜ ?ˆ?‹¤.
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

		// ì²? ì°¨ì— ???Š” ê²½ìš°
		// ì¤‘ê°„ ì°¨ì— ???Š” ê²½ìš°
		// ë§ˆì?ë§? ì°? ???Š” ê²½ìš°

		return null;
	}

}