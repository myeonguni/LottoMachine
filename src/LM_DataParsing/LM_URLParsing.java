package LM_DataParsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * 
 * @author Myeonguni
 * @since 17.02.05
 * 
 */
public class LM_URLParsing {
    public LM_URLParsing() {
    }
 
    /**
     * 
     * @param url 로또 당첨번호를 파싱할 공식 홈페이지 URL(http://www.nlotto.co.kr/gameResult.do?method=byWin&drwNo="회차")
     * @param start 추출할 당첨번호 시작회
     * @param end 추출할 당첨번호 마지막회
     * @return 로또 start~end회 당첨번호 데이터를 담은 ArrayList<String>
     * @throws IOException
     */
    public ArrayList<String> URLParsing(String url, int start, int end) throws IOException {
        String result = null, temp = null, line = null;
        String numbers[] = new String[7];
        ArrayList<String> list = new ArrayList<String>();
 
        /*
         * 1~734 회차에 따른 loop 진행(회차=변수 i값) 파싱하여 얻은 데이터에서 필요한 데이터(당첨번호)만 뽑아서
         * String 배열에 저장 : numbers[0,1,...,5] 위에서 저장한 String 배열을 각 회차별로 관리하기 위한
         * ArrayList객체에 저장
         */
        for (int i = start; i <= end; i++) {
            URL ParsingURL = new URL(url + i);
            BufferedReader bin = new BufferedReader(new InputStreamReader(ParsingURL.openStream(), "UTF-8"));
 
            while ((line = bin.readLine()) != null)
                result += line;
 
            result = result.substring(result.indexOf("<p class=\"number\">") + 19, result.length());
            for (int j = 0; j < 7; j++) {
                numbers[j] = result.substring(result.indexOf("alt=") + 5, result.indexOf("alt=") + 7).replaceAll("\"",
                        "");
                result = result.replaceFirst("alt=", "pass=");
            }
            list.add(numbers[0] + "," + numbers[1] + "," + numbers[2] + "," + numbers[3] + "," + numbers[4] + ","
                    + numbers[5] + "," + numbers[6]);
            bin.close();
            
            System.out.println(i + "회차 - " + list.get(i-1));
        }
        return list;
    }
}
