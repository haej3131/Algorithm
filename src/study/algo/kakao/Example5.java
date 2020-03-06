package study.algo.kakao;

import java.util.LinkedHashMap;
import java.util.Map;

public class Example5 {

	public static void main(String[] args) {

		System.out.println(chkExecuteTime(3, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju",
				"Pangyo", "Seoul", "NewYork", "LA" }));
		System.out.println(chkExecuteTime(3,
				new String[] { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" }));
		System.out.println(chkExecuteTime(2, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco",
				"Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome" }));
		System.out.println(chkExecuteTime(5, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco",
				"Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome" }));
		System.out.println(chkExecuteTime(2, new String[] { "Jeju", "Pangyo", "NewYork", "newyork" }));
		System.out.println(chkExecuteTime(0, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA" }));

	}

	// 캐시?��?��측정
	/*
	 * 
	 * 캐시 교체 ?��고리즘�? LRU(Least Recently Used)�? ?��?��?��?��. cache hit?�� 경우 ?��?��?��간�? 1?��?��. cache
	 * miss?�� 경우 ?��?��?��간�? 5?��?��. 캐시 ?���?(cacheSize)?? ?��?��?���? 배열(cities)?�� ?��?��받는?��. cacheSize?��
	 * ?��?��?���?, 범위?�� 0 ?��<=cacheSize ?�� 30 ?��?��. cities?�� ?��?�� ?��름으�? ?��뤄진 문자?�� 배열�?, 최�? ?��?�� ?��?��
	 * 100,000개이?��. �? ?��?�� ?��름�? 공백, ?��?��, ?��?��문자 ?��?�� ?��?�� ?��문자�? 구성?���?, ???��문자 구분?�� ?���? ?��?��?��. ?��?�� ?��름�? 최�?
	 * 20?���? ?��루어?�� ?��?��.
	 */
	public static int chkExecuteTime(int cacheSize, String[] cities) {

		// 캐시 ?��?�� 경우 ?��?��?���? 5
		if (cacheSize == 0) {
			return cities.length * 5;
		}

		int executeTime = 0;
		Map lruMap = new LinkedHashMap(cacheSize) {
			/**
			* 
			*/
			private static final long serialVersionUID = 2476204207882900718L;

			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry eldest) {
				return cacheSize > 0 ? size() > cacheSize : false;
			}

		};

		for (String city : cities) {
			if (lruMap.containsKey(city.toUpperCase())) {
				executeTime += 1;
			} else {
				executeTime += 5;
				lruMap.put(city.toUpperCase(), 1);
			}
		}

		return executeTime;
	}

}