package chuross.hateblo.jp;

import java.io.*;

public class Bowling {
	
	//�X�^�e�B�b�N�ϐ����`
	//private static int total = 0;
	
	public static void main(String[] args) {
		
		//�ϐ����`
		
		
		//1�t���[�����ɉ�
		for(int i = 1; i <= 10; i++) {
			System.out.println(i + "�t���[���̌��ʂ��͂��ĉ������B");

			//��͎�t
			try {
				inputArray();
			}catch(IOException e) {
				System.out.println(e + "�ŃG���[���N���Ă��܂�");
			}
			
			
			//�_���v�Z
			//System.out.println(Integer.parseInt(point));
			
		}
		
	}
	
	//��͎�t
	public static String[] inputArray() throws IOException {
		//��͎�t�̃C���X�^���X���쐬
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//��͂����������擾����
		String line = reader.readLine();//��͂��擾���ĕϐ��Ɋi�[
		String inputArray[] = line.split(" ");//������𕪊����Ĕz��Ɋi�[
		
		if(inputArray.length != 2) {
			System.out.println("�꓊�ڂƓ񓊖ڂ𔼊p�X�y�[�X�œ�͂��Ă�������");
			inputArray();
		}
		
		return inputArray;
	}
	
}
