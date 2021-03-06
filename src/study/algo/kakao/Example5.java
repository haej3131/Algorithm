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

	// μΊμ?±?₯μΈ‘μ 
	/*
	 * 
	 * μΊμ κ΅μ²΄ ?κ³ λ¦¬μ¦μ? LRU(Least Recently Used)λ₯? ?¬?©??€. cache hit?Ό κ²½μ° ?€??κ°μ? 1?΄?€. cache
	 * miss?Ό κ²½μ° ?€??κ°μ? 5?΄?€. μΊμ ?¬κΈ?(cacheSize)?? ???΄λ¦? λ°°μ΄(cities)? ?? ₯λ°λ?€. cacheSize?
	 * ? ??΄λ©?, λ²μ? 0 ?¦<=cacheSize ?¦ 30 ?΄?€. cities? ?? ?΄λ¦μΌλ‘? ?΄λ€μ§ λ¬Έμ?΄ λ°°μ΄λ‘?, μ΅λ? ?? ??
	 * 100,000κ°μ΄?€. κ°? ?? ?΄λ¦μ? κ³΅λ°±, ?«?, ?Ή?λ¬Έμ ?±?΄ ?? ?λ¬Έμλ‘? κ΅¬μ±?λ©?, ???λ¬Έμ κ΅¬λΆ? ?μ§? ???€. ?? ?΄λ¦μ? μ΅λ?
	 * 20?λ‘? ?΄λ£¨μ΄? Έ ??€.
	 */
	public static int chkExecuteTime(int cacheSize, String[] cities) {

		// μΊμ ?? κ²½μ° ???κ°? 5
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