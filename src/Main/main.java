package Main;

import java.io.IOException;
import java.util.ArrayList;

import LM_Data.LM_FileWrite;
import LM_Data.LM_URLParsing;

/**
 * 
 * @author Myeonguni
 * @since 16.09.30
 * 
 */
public class main {

	/** �ζ� ��÷��ȣ�� �Ľ��� url address **/
	final static String url = "http://nlotto.co.kr/lotto645Confirm.do?method=byWin&drwNo=";
	
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
