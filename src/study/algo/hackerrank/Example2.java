package study.algo.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Result {

    /*
     * Complete the 'betterCompression' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String betterCompression(String s) {
        char[] cArr = s.toCharArray();
        Map<String, Integer> map = new TreeMap<String, Integer>();
        String alph = null;
        String cnt = null;
        for(int i=0;i<cArr.length;i++){
            char c = cArr[i];
            if(c >= '0' || c <='9'){
                cnt += String.valueOf(c);
            }else{
                String cur = String.valueOf(c);
                if(map.containsKey(alph)){
                    int prevCnt = map.get(alph);
                    map.put(alph,  prevCnt + Integer.parseInt(cnt));
                }else{
                    map.put(alph, Integer.parseInt(cnt));
                }
                alph = cur;
            }
        }
        if(map.containsKey(alph)){
            int prevCnt = map.get(alph);
            map.put(alph,  prevCnt + Integer.parseInt(cnt));
        }else{
            map.put(alph, Integer.parseInt(cnt));
        }
        
        String result = "";
        Set<String> keyset = map.keySet();
        for(String ks : keyset){
            result += ks + String.valueOf(map.get(ks));
        }
        
        return result;

    }

}

public class Example2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.betterCompression(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
