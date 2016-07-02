package homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GuessWord {

	public static void main(String[] args) {
		Scanner sc;
		//使用文件载入单词，我选用java关键字作为单词库
		try {
			sc = new Scanner(new File("src/guessWord.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			sc = null;
		}
		int num = 0;
		//读入单词并计数
		while (sc.hasNextLine()) {
			num++;
			sc.nextLine();
		}
		Word[] wd = new Word[num];
		try {
			sc = new Scanner(new File("src/guessWord.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			sc = null;
		}
		for (int i = 0; i < num; i++) {
			wd[i] = new Word(sc.nextLine());
		}
		//随机抽取一个单词做游戏
		int k = (int) (Math.random() * num);
		wd[k].printWord();
		int step=0;
		//猜数环节
		while (!wd[k].state) {
			sc = new Scanner(System.in);
			String st = sc.next();
			wd[k].guess(st.charAt(st.length() - 1));
			wd[k].printWord();
			step++;
		}
		System.out.println("You Win!!!Used "+step+" steps.");
	}

}

class Word {

	String st;	//单词
	char ch[];	//每个字母
	boolean state;	//是否猜中的状态
	int length;	//剩余字母数量

	public Word(String st) {	//new方法
		this.st = st;
		ch = new char[st.length()];
		for (int i = 0; i < st.length(); i++) {
			ch[i] = '_';
		}
		state = false;
		length = st.length();
	}

	public void guess(char gc) {	//猜数过程
		if (gc == '0') {	//如果是提示
			//随机选取一个没有被猜出的字母
			int r = (int) (Math.random() * length);
			int m = 0;
			while (r > 0) {
				if (ch[m] == '_') {
					r--;
				}
				m++;
			}
			while (ch[m] != '_') {
				m++;
			}
			char c = st.charAt(m);	//c为将要提示的字母
			for (int i = 0; i < st.length(); i++) {
				if (ch[i] != c && st.charAt(i) == c) {
					ch[i] = c;
					length--;
				}
			}
		} else {	//不是提示
			for (int i = 0; i < st.length(); i++) {
				if (ch[i] != gc && st.charAt(i) == gc) {	//猜中并且这个字母之前没被猜出
					ch[i] = gc;
					length--;
				}
			}
		}
		if (length == 0)	//剩余字母为0，表示全部猜完
			state = true;
	}

	public void printWord() {	//打印单词
		for (char c : ch) {
			System.out.print(c);
		}
		System.out.println();
	}
}