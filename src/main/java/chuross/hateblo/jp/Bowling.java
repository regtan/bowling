package chuross.hateblo.jp;

import java.io.*;
//import java.util.ArrayList;

public class Bowling {
	
	//初期値を設定
	private static int total = 0;	
	private static int[][]pointArray = new int[10][20];
	
	
	//実行時の処理
	public static void main(String[] args) {		
		
		//10フレーム回す
		for(int i = 1; i <= 10;) {
			
			for(int j = 1; j < i; j++) {
				if(i > 1) {
					System.out.print(j + "フレーム目の結果：");
					for(int k = 0; k < 2; k++) {
						System.out.print("|" + pointArray[ j ][ k ] + "|");
					}
					System.out.print("合計：" + total + "|");
					System.out.println("");
				}
			}
			System.out.println(i + "フレーム目の結果を書いてください");
			
			//入力受付
			Bowling bowling = new Bowling();
			try {
				bowling.inputArray(i);
				i++;
			}catch(Exception e) {
				System.out.println("エラー" + e);
				System.out.println("もう一度入力してください。");
			}
		}
		
	}
	
	
	//入力受付メソッド
	public String[] inputArray(int frame){
		
		//コンソール入力を受け付ける
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//入力された文字列を読み込む
		String line = null;
		try {
			line = reader.readLine();//文字列読み込み		
		}catch(IOException e) {}
		
		String returnArray[] = line.split(" ");//文字列を分割する
					
		
		//入力された内容を確認
		if(!checkInput(returnArray, frame)) {
			throw new IllegalArgumentException("入力された内容が間違っている可能性があります。");
		}
		
		return returnArray;
	}

	
	//入力された情報が正しいかどうか
	public Boolean checkInput(String[] inputArray,int frame) {
		
		//配列の数が規定通りに作られているか
		if((frame != 10 && inputArray.length == 2)  ||  (frame == 10  && inputArray.length >= 2 && inputArray.length <= 3)) {
			
			//数字が入力されているか、数値は１０以下かのチェック
			if(checkInputLength(inputArray, inputArray.length, frame)) {
				return true;
			}
			
		}
		return false;
		
	}
	
	
	//渡された配列の数だけ細かい条件で入力内容をチェック
	public boolean checkInputLength(String[] inputArray, int size, int frame) {
		//変数を定義
		int flag = 0;
		int point[] = new int[ size ];
		int sum = 0;
		
		for(int i = 0; i < size; i++) {
			if(inputArray[ i ].matches("[0-9]") || inputArray[ i ].equals("10")) {
				flag++;
				point[ i ] = Integer.parseInt( inputArray[ i ] );
			}
			
			sum += point[ i ];
			pointArray[ frame - 1 ][ i ] = point[ i ];
		}
				
		if( (size == 2 && (flag == size && sum <= 10)) || (size == 3 && (flag == size && sum <= 30)) ) {
			total += sum;			
			return true;
		}
		
		return false;
	}
	
	
	//前のフレームがスペア、ストライクだった時に前のスコアに点数を加算する。
	public void plusPreScore(int frame) {
	}
	
	
}
