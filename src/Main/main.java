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

	/** 로또 당첨번호를 파싱할 url address **/
	final static String url = "http://nlotto.co.kr/lotto645Confirm.do?method=byWin&drwNo=";
	
	/** 추출할 로또 당첨번호 시작 회차 **/
	final static int start = 1;
			
	/** 추출할 로또 당첨번호 마지막 회차 **/
	final static int end = 5;
	
	public static void main(String args[]) throws IOException{
		
		/** 로또 당첨번호를 파싱하여 데이터를 수집하는 객체 **/
		LM_URLParsing URLParsing = new LM_URLParsing();
		
		/** 수집된 로또 당첨번호 리턴 값을 담을 ArrayList 객체 **/
		ArrayList<String> LuckyNumber = new ArrayList<String>();
		
		/** 로또 당첨번호를 기반으로 실제 1~5등,꽝에 해당하는 번호를 추출하여 파일출력하는 객체 **/
		LM_FileWrite FileWrite = new LM_FileWrite();
		
		
		/* 로또 당첨번호 값 셋팅 : 당첨번호 공식번호 URL, 시작 당첨회차, 마지막 당첨회차 */
		LuckyNumber = URLParsing.URLParsing(url, start, end);
		
		/* 로또 당첨번호 데이터셋 파일 셋팅 */
		FileWrite.FileWrite(LuckyNumber); 
		
	}
	
}
