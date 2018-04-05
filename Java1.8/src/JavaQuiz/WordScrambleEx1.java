package JavaQuiz;

import java.util.Arrays;

/*[문제1] 다음의 예제를 완성하시오.

getAnswer(String[] strArr)는 배열strArr의 요소중의 하나를 임의로 골라서 반환한다.(Math.random()사용)
getScrambledWord(String str)는 주어진 문자열 str의 각 문자의 순서를 뒤섞은 다음, 새로운 문자열로 반환한다.(Math.random()사용)
[출처] [Java1000제]Word Scramble 1 - 단어 맞추기 (남궁성의 코드초보스터디(자바 java, c언어, javascript, python) |작성자 남궁성*/

/*
 日本語の翻訳
[問題１]次の例題を完成してください。

getAnswer(String[] strArr)は配列strArrの要素の中で一つを任意で選んで変換する。(Math.random()使用)
getScrambledWord(String str)は与えられた文字列strの各文字の手順をかき混ぜったあと、新しい文字列に変換する。(Math.random()사용)

*/

public class WordScrambleEx1 {

	public static void main(String[] args) {
		String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW" };

		String answer = getAnswer(strArr);
		String question = getScrambledWord(answer);

		System.out.println("Question:" + question);
		System.out.println("Answer:" + answer);
	} // main

	public static String getAnswer(String[] strArr) {
		return strArr[(int)(Math.random() * strArr.length)];
	}

	public static String getScrambledWord(String str) {
		char[] questionArr = str.toCharArray();
		int questionSize = questionArr.length;
		for(int idx=0; idx<questionSize; idx++) {
			int random = (int)(Math.random()*questionSize);
			
			char tmp = questionArr[idx]; // tmp <- questionArr[0]
			questionArr[idx] = questionArr[random]; //questionArr[0] <- questionArr[任意の位置]
			questionArr[random] = tmp; //questionArr[任意の位置] <- tmp
			
		}
		return new String(questionArr); //文字を文字列に変更

	} // scramble(String str)

}

/*
 * [실행결과] 
 * Question:HEPO 
 * Answer:HOPE
 */

/*
 * [実行結果] 
 * Question:HEPO 
 * Answer:HOPE
 */