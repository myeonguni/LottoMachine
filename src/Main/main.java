package Main;

import java.io.IOException;
import java.util.ArrayList;

import LM_DataParsing.LM_FileWrite;
import LM_DataParsing.LM_URLParsing;

/**
 * 
 * @author Myeonguni
 * @since 17.02.05
 * 
 */
public class main {

	/** �ζ� ��÷��ȣ�� �Ľ��� url address **/
	final static String url = "http://www.nlotto.co.kr/gameResult.do?method=byWin&drwNo=";
	
	/** ������ �ζ� ��÷��ȣ ���� ȸ�� **/
	final static int start = 1;
			
	/** ������ �ζ� ��÷��ȣ ������ ȸ�� **/
	final static int end = 5;
	
	public static void main(String args[]) throws IOException{
		
		/** �ζ� ��÷��ȣ�� �Ľ��Ͽ� �����͸� �����ϴ� ��ü **/
		LM_URLParsing URLParsing = new LM_URLParsing();
		
		/** ������ �ζ� ��÷��ȣ ���� ���� ���� ArrayList ��ü **/
		ArrayList<String> LuckyNumber = new ArrayList<String>();
		
		/** �ζ� ��÷��ȣ�� ������� ���� 1~5��,�ο� �ش��ϴ� ��ȣ�� �����Ͽ� ��������ϴ� ��ü **/
		LM_FileWrite FileWrite = new LM_FileWrite();
		
		
		/* �ζ� ��÷��ȣ �� ���� : ��÷��ȣ ���Ĺ�ȣ URL, ���� ��÷ȸ��, ������ ��÷ȸ�� */
		LuckyNumber = URLParsing.URLParsing(url, start, end);
		
		/* �ζ� ��÷��ȣ �����ͼ� ���� ���� */
		FileWrite.FileWrite(LuckyNumber); 
		
	}
	
}
