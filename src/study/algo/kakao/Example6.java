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

	// ?��??버스
	/*
	 * ?��???? 09:00�??�� �? n?�� t�? 간격?���? ?��?�� ?��착하�?, ?��?��?�� ?��???��?�� 최�? m명의 ?��객이 ?�� ?�� ?��?��.
	 * 
	 * ?��?�� : ?��?? ?��?�� ?��?�� n, ?��?? ?��?�� 간격 t, ?�� ?��???�� ?�� ?�� ?��?�� 최�? ?���? ?�� m, ?��루�? ??기열?�� ?��착하?�� ?��각을 모�? 배열
	 * timetable 0 �? n ?�� 10 0 �? t ?�� 60 0 �? m ?�� 45 timetable?? 최소 길이 1?���? 최�? 길이 2000?��
	 * 배열�?, ?���? ?��?�� ?��루�? ??기열?�� ?��착하?�� ?��각이 HH:MM ?��?��?���? ?��루어?�� ?��?��. ?��루의 ?���? ?���? HH:MM?? 00:01?��?��
	 * 23:59 ?��?��
	 * 
	 * 출력 : 콘이 무사?�� ?��???�� ??�? ?��무실�? �? ?�� ?��?�� ?��?�� ?��?? ?���? ?��각을 출력?��?��. ?���? ?��각�? HH:MM ?��?��?���?, 00:00?��?��
	 * 23:59 ?��?��?�� 값이 ?�� ?�� ?��?��.
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

		// �? 차에 ???�� 경우
		// 중간 차에 ???�� 경우
		// 마�?�? �? ???�� 경우

		return null;
	}

}