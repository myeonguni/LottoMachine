package LM_Data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Myeonguni
 * @since 16.09.30
 * 
 */
public class LM_FileWrite {
	
	public LM_FileWrite() {
		
	}

    /**
     * 
     * @param list 추출한 로또 당첨번호 데이터를 담은 ArrayList<String>
     * @throws IOException
     * 추출한 로또 당첨번호 데이터를 기반으로 1~5등, 꽝 데이터를 추출하여 파일쓰기를 진행함
     */
	public static void FileWrite(ArrayList<String> list) throws IOException {
		/* 추출한 로또 당첨번호 셋에 따른 loop 진행 */
        for (int l = 1; l <= list.size(); l++) {
        	/* 파일출력을 위한 BufferedWriter 객체 : 각 회차별(리스트 1셋 당 1회차시)*/
            BufferedWriter br = new BufferedWriter(new FileWriter("D:\\lottoData\\LottoMachineLearningDataSet" + l + ".csv"));
            String numbers[] = list.get(l-1).split(",");
            int[] numbers2 = new int[numbers.length];
            for (int i = 0; i < numbers2.length; i++) numbers2[i] = Integer.parseInt(numbers[i]);
            /*
             * 당첨번호 및 꽝번호 셋 추출하기
             * 실제 로또 번호셋과 동일하게 중복 되는 번호를 제외한 loop 돌리기(6중)
             * 총 8,145,060건의 데이터 셋 추출
             * numbers2[] 에는 실제 당첨번호6개+보너스번호1개가 담겨져있음.
             * numbers3[] 에는 아래 작성된 알고리즘을 통해 추출한 번호6개가 담겨져있음
             * 각 데이터 셋의 등수 판별은 compare 함수 사용(하단 compare() 코드 참고)
             */
            for (int l1 = 1; l1 < 46; l1++) {
                for (int l2 = 1; l2 < 46; l2++) {
                    if (l1 == l2) break;
                    for (int l3 = 1; l3 < 46; l3++) {
                        if (l1 == l3 || l2 == l3) break;
                        for (int l4 = 1; l4 < 46; l4++) {
                            if (l1 == l4 || l2 == l4 || l3 == l4) break;
                            for (int l5 = 1; l5 < 46; l5++) {
                                if (l1 == l5 || l2 == l5 || l3 == l5 || l4 == l5) break;
                                for (int l6 = 1; l6 < 46; l6++) {
                                    if (l1 == l6 || l2 == l6 || l3 == l6 || l4 == l6 || l5 == l6) {
                                        break;
                                    } else {
                                        int numbers3[] = { l1, l2, l3, l4, l5, l6 };
                                        Arrays.sort(numbers3);
                                        switch (compare(numbers2, numbers3)) {
                                        case 6: /* 1등일 경우(당첨번호6개 일치) */
                                            br.write(l + "," + numbers3[0] + "," + numbers3[1] + "," + numbers3[2] + "," + numbers3[3] + "," + numbers3[4] + "," + numbers3[5] + ",1\n");
                                            break;
                                        case 5: /* 2등일 경우(당첨번호5개+보너스번호 일치) */
                                            if (numbers2[6]==numbers3[0] || numbers2[6]==numbers3[1] || numbers2[6]==numbers3[2] || numbers2[6]==numbers3[3] || numbers2[6]==numbers3[4] || numbers2[6]==numbers3[5]) {
                                                br.write(l + "," + numbers3[0] + "," + numbers3[1] + "," + numbers3[2] + "," + numbers3[3] + "," + numbers3[4] + "," + numbers3[5] + ",2\n");
                                            } else { /* 3등일 경우(당첨번호5개 일치) */
                                                br.write(l + "," + numbers3[0] + "," + numbers3[1] + "," + numbers3[2] + "," + numbers3[3] + "," + numbers3[4] + "," + numbers3[5] + ",3\n");
                                            } break;
                                        case 4: /* 4등일 경우(당첨번호4개 일치) */
                                            br.write(l + "," + numbers3[0] + "," + numbers3[1] + "," + numbers3[2] + "," + numbers3[3] + "," + numbers3[4] + "," + numbers3[5] + ",4\n");
                                            break;
                                        case 3: /* 5등일 경우(당첨번호3개 일치) */
                                            br.write(l + "," + numbers3[0] + "," + numbers3[1] + "," + numbers3[2] + "," + numbers3[3] + "," + numbers3[4] + "," + numbers3[5] + ",5\n");
                                            break;
                                        default: /* 꽝일 경우(당첨번호4개 이상 불일치) */
                                            br.write((l + 1) + "," + numbers3[0] + "," + numbers3[1] + "," + numbers3[2] + "," + numbers3[3] + "," + numbers3[4] + "," + numbers3[5] + ",6\n");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            br.flush();
            br.close();
        }
    }
	
	/**
	 * 등수 뽑아내는 함수
	 * 배열(당첨번호 셋) : 배열(추출 데이터 셋)을 비교하여 당첨 등수 분별
	 * 반환 값 : 일치 번호를 카운스한 수(정수)
	 */
    static int compare(int arr[], int arr2[]) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr[i] == arr2[j])
                    count++;
            }
        }
        return count;
    }
}
