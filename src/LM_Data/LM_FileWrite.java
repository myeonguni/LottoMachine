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
     * @param list ������ �ζ� ��÷��ȣ �����͸� ���� ArrayList<String>
     * @throws IOException
     * ������ �ζ� ��÷��ȣ �����͸� ������� 1~5��, �� �����͸� �����Ͽ� ���Ͼ��⸦ ������
     */
	public static void FileWrite(ArrayList<String> list) throws IOException {
		/* ������ �ζ� ��÷��ȣ �¿� ���� loop ���� */
        for (int l = 1; l <= list.size(); l++) {
        	/* ��������� ���� BufferedWriter ��ü : �� ȸ����(����Ʈ 1�� �� 1ȸ����)*/
            BufferedWriter br = new BufferedWriter(new FileWriter("D:\\lottoData\\LottoMachineLearningDataSet" + l + ".csv"));
            String numbers[] = list.get(l-1).split(",");
            int[] numbers2 = new int[numbers.length];
            for (int i = 0; i < numbers2.length; i++) numbers2[i] = Integer.parseInt(numbers[i]);
            /*
             * ��÷��ȣ �� �ι�ȣ �� �����ϱ�
             * ���� �ζ� ��ȣ�°� �����ϰ� �ߺ� �Ǵ� ��ȣ�� ������ loop ������(6��)
             * �� 8,145,060���� ������ �� ����
             * numbers2[] ���� ���� ��÷��ȣ6��+���ʽ���ȣ1���� ���������.
             * numbers3[] ���� �Ʒ� �ۼ��� �˰����� ���� ������ ��ȣ6���� ���������
             * �� ������ ���� ��� �Ǻ��� compare �Լ� ���(�ϴ� compare() �ڵ� ����)
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
                                        case 6: /* 1���� ���(��÷��ȣ6�� ��ġ) */
                                            br.write(l + "," + numbers3[0] + "," + numbers3[1] + "," + numbers3[2] + "," + numbers3[3] + "," + numbers3[4] + "," + numbers3[5] + ",1\n");
                                            break;
                                        case 5: /* 2���� ���(��÷��ȣ5��+���ʽ���ȣ ��ġ) */
                                            if (numbers2[6]==numbers3[0] || numbers2[6]==numbers3[1] || numbers2[6]==numbers3[2] || numbers2[6]==numbers3[3] || numbers2[6]==numbers3[4] || numbers2[6]==numbers3[5]) {
                                                br.write(l + "," + numbers3[0] + "," + numbers3[1] + "," + numbers3[2] + "," + numbers3[3] + "," + numbers3[4] + "," + numbers3[5] + ",2\n");
                                            } else { /* 3���� ���(��÷��ȣ5�� ��ġ) */
                                                br.write(l + "," + numbers3[0] + "," + numbers3[1] + "," + numbers3[2] + "," + numbers3[3] + "," + numbers3[4] + "," + numbers3[5] + ",3\n");
                                            } break;
                                        case 4: /* 4���� ���(��÷��ȣ4�� ��ġ) */
                                            br.write(l + "," + numbers3[0] + "," + numbers3[1] + "," + numbers3[2] + "," + numbers3[3] + "," + numbers3[4] + "," + numbers3[5] + ",4\n");
                                            break;
                                        case 3: /* 5���� ���(��÷��ȣ3�� ��ġ) */
                                            br.write(l + "," + numbers3[0] + "," + numbers3[1] + "," + numbers3[2] + "," + numbers3[3] + "," + numbers3[4] + "," + numbers3[5] + ",5\n");
                                            break;
                                        default: /* ���� ���(��÷��ȣ4�� �̻� ����ġ) */
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
	 * ��� �̾Ƴ��� �Լ�
	 * �迭(��÷��ȣ ��) : �迭(���� ������ ��)�� ���Ͽ� ��÷ ��� �к�
	 * ��ȯ �� : ��ġ ��ȣ�� ī��� ��(����)
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
