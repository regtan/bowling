package chuross.hateblo.jp;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class BowlingTest {

	@Test
	public void 入力バリデーション() throws Exception {
		Bowling bowling = new Bowling();
		
		//配列チェック
		String[] inputArray = new String[]{"1", "2"};
		assertThat(bowling.checkInput(inputArray, 3), is(true));
		inputArray = new String[]{"1", "2", "8"};
		assertThat(bowling.checkInput(inputArray, 3), is(false));
		inputArray = new String[]{"1", "2", "8"};
		assertThat(bowling.checkInput(inputArray, 10), is(true));
		
		
		//checkInputテスト
		inputArray = new String[] {"あ", "い"};
		assertFalse(bowling.checkInput(inputArray, 3));
		inputArray = new String[] {"2", "5"};
		assertTrue(bowling.checkInput(inputArray, 3));
		inputArray = new String[] {"2", "8", "3"};
		assertFalse(bowling.checkInput(inputArray, 3));
		
		
		//checkInputLengthテスト
		inputArray = new String[] {"2", "9"};
		assertFalse(bowling.checkInputLength(inputArray, inputArray.length, 3));
		inputArray = new String[] {"7", "3"};
		assertTrue(bowling.checkInputLength(inputArray, inputArray.length, 3));
		inputArray = new String[] {"10", "13", "10"};
		assertFalse(bowling.checkInputLength(inputArray, inputArray.length, 3));
		
		
		
		
	}
	
	
}
