package homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GuessWord {

	public static void main(String[] args) {
		Scanner sc;
		//ʹ���ļ����뵥�ʣ���ѡ��java�ؼ�����Ϊ���ʿ�
		try {
			sc = new Scanner(new File("src/guessWord.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			sc = null;
		}
		int num = 0;
		//���뵥�ʲ�����
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
		//�����ȡһ����������Ϸ
		int k = (int) (Math.random() * num);
		wd[k].printWord();
		int step=0;
		//��������
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

	String st;	//����
	char ch[];	//ÿ����ĸ
	boolean state;	//�Ƿ���е�״̬
	int length;	//ʣ����ĸ����

	public Word(String st) {	//new����
		this.st = st;
		ch = new char[st.length()];
		for (int i = 0; i < st.length(); i++) {
			ch[i] = '_';
		}
		state = false;
		length = st.length();
	}

	public void guess(char gc) {	//��������
		if (gc == '0') {	//�������ʾ
			//���ѡȡһ��û�б��³�����ĸ
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
			char c = st.charAt(m);	//cΪ��Ҫ��ʾ����ĸ
			for (int i = 0; i < st.length(); i++) {
				if (ch[i] != c && st.charAt(i) == c) {
					ch[i] = c;
					length--;
				}
			}
		} else {	//������ʾ
			for (int i = 0; i < st.length(); i++) {
				if (ch[i] != gc && st.charAt(i) == gc) {	//���в��������ĸ֮ǰû���³�
					ch[i] = gc;
					length--;
				}
			}
		}
		if (length == 0)	//ʣ����ĸΪ0����ʾȫ������
			state = true;
	}

	public void printWord() {	//��ӡ����
		for (char c : ch) {
			System.out.print(c);
		}
		System.out.println();
	}
}