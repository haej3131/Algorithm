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

	// ìºì‹œ?„±?Š¥ì¸¡ì •
	/*
	 * 
	 * ìºì‹œ êµì²´ ?•Œê³ ë¦¬ì¦˜ì? LRU(Least Recently Used)ë¥? ?‚¬?š©?•œ?‹¤. cache hit?¼ ê²½ìš° ?‹¤?–‰?‹œê°„ì? 1?´?‹¤. cache
	 * miss?¼ ê²½ìš° ?‹¤?–‰?‹œê°„ì? 5?´?‹¤. ìºì‹œ ?¬ê¸?(cacheSize)?? ?„?‹œ?´ë¦? ë°°ì—´(cities)?„ ?…? ¥ë°›ëŠ”?‹¤. cacheSize?Š”
	 * ? •?ˆ˜?´ë©?, ë²”ìœ„?Š” 0 ?‰¦<=cacheSize ?‰¦ 30 ?´?‹¤. cities?Š” ?„?‹œ ?´ë¦„ìœ¼ë¡? ?´ë¤„ì§„ ë¬¸ì?—´ ë°°ì—´ë¡?, ìµœë? ?„?‹œ ?ˆ˜?Š”
	 * 100,000ê°œì´?‹¤. ê°? ?„?‹œ ?´ë¦„ì? ê³µë°±, ?ˆ«?, ?Š¹?ˆ˜ë¬¸ì ?“±?´ ?—†?Š” ?˜ë¬¸ìë¡? êµ¬ì„±?˜ë©?, ???†Œë¬¸ì êµ¬ë¶„?„ ?•˜ì§? ?•Š?Š”?‹¤. ?„?‹œ ?´ë¦„ì? ìµœë?
	 * 20?ë¡? ?´ë£¨ì–´? ¸ ?ˆ?‹¤.
	 */
	public static int chkExecuteTime(int cacheSize, String[] cities) {

		// ìºì‹œ ?—†?Š” ê²½ìš° ?ˆ˜?–‰?‹œê°? 5
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