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
     * @param url �ζ� ��÷��ȣ�� �Ľ��� ���� Ȩ������ URL(http://www.nlotto.co.kr/gameResult.do?method=byWin&drwNo="ȸ��")
     * @param start ������ ��÷��ȣ ����ȸ
     * @param end ������ ��÷��ȣ ������ȸ
     * @return �ζ� start~endȸ ��÷��ȣ �����͸� ���� ArrayList<String>
     * @throws IOException
     */
    public ArrayList<String> URLParsing(String url, int start, int end) throws IOException {
        String result = null, temp = null, line = null;
        String numbers[] = new String[7];
        ArrayList<String> list = new ArrayList<String>();
 
        /*
         * 1~734 ȸ���� ���� loop ����(ȸ��=���� i��) �Ľ��Ͽ� ���� �����Ϳ��� �ʿ��� ������(��÷��ȣ)�� �̾Ƽ�
         * String �迭�� ���� : numbers[0,1,...,5] ������ ������ String �迭�� �� ȸ������ �����ϱ� ����
         * ArrayList��ü�� ����
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
            
            System.out.println(i + "ȸ�� - " + list.get(i-1));
        }
        return list;
    }
}
