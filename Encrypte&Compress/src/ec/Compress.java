package ec;

import java.io.*;
import java.util.*;

import javax.swing.*;

public class Compress {
	String fileOpenName, fileTempName, fileSaveName;
	File fileOpen, fileTemp, fileSave;
	FileInputStream fisOpen, fisTemp;
	FileOutputStream fosTemp, fosSave;
	short codeNum;
	byte zero;
	int[] character;
	HuffmanTree[] HT;
	HuffmanCode[] HC;

	public Compress() {
		super();
		this.fileOpenName = null;
		this.fileTempName = null;
		this.fileSaveName = null;
		this.fileOpen = null;
		this.fileTemp = null;
		this.fileSave = null;
		this.fisOpen = null;
		this.fisTemp = null;
		this.fosTemp = null;
		this.fosSave = null;
		this.codeNum = 0;
		this.character = null;
		this.HT = null;
		this.HC = null;
	}

	class HuffmanTree {
		char c;
		int w;
		short parent;
		short lchild;
		short rchild;

		public HuffmanTree(char c, int w, short parent, short lchild, short rchild) {
			super();
			this.c = c;
			this.w = w;
			this.parent = parent;
			this.lchild = lchild;
			this.rchild = rchild;
		}
	}

	class HuffmanCode {
		char c;
		String code;

		public HuffmanCode(char c, String code) {
			this.c = c;
			this.code = code;
		}
	}

	private boolean creatCharacter() throws IOException {
		short b;
		codeNum = 0;
		character = new int[256];
		while (fisOpen.available() > 0) {
			try {
				b = (short) fisOpen.read();
				if (b == -1)
					break;
				if (character[b] == 0) {
					codeNum++;
				}
				character[b]++;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "读取错误");
				System.out.println("读取错误");
				return false;
			}
		}
		fisOpen.close();
		return true;
	}

	private boolean creatHuffmanTree() {
		HT = new HuffmanTree[2 * codeNum];
		short pos = 1;
		HT[0] = new HuffmanTree((char) 0, Integer.MAX_VALUE, (short) 0, (short) 0, (short) 0);
		for (short i = 0; i < 256; i++) {
			if (character[i] > 0) {
				HT[pos++] = new HuffmanTree((char) i, character[i], (short) 0, (short) 0, (short) 0);
			}
		}
		short smallA, smallB;
		while (pos < 2 * codeNum) {
			smallA = smallB = 0;
			for (short i = 1; i < pos; i++) {
				if (HT[i].parent == 0) {
					if (HT[smallA].w > HT[i].w) {
						smallB = smallA;
						smallA = i;
					} else if (HT[smallB].w > HT[i].w) {
						smallB = i;
					}
				}
			}
			HT[smallA].parent = HT[smallB].parent = pos;
			HT[pos++] = new HuffmanTree((char) 0, HT[smallA].w + HT[smallB].w, (short) 0, smallA, smallB);
		}
		return true;
	}

	private boolean creatHuffmanCode() {
		HC = new HuffmanCode[codeNum];
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < codeNum; i++) {
			short p = (short) (i + 1), np = HT[p].parent;
			while (np != 0) {
				if (HT[np].lchild == p) {
					sBuffer.insert(0, (char) 0);
				} else {
					sBuffer.insert(0, (char) 1);
				}
				p = np;
				np = HT[p].parent;
			}
			HC[i] = new HuffmanCode(HT[i + 1].c, sBuffer.toString());
			sBuffer.delete(0, sBuffer.length());
		}
		return true;
	}

	private boolean creatTempFile() throws IOException {
		fileTempName = fileOpenName.concat(".cprtmp");
		fileTemp = new File(fileTempName);
		try {
			fosTemp = new FileOutputStream(fileTemp);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "创建临时文件失败");
			System.out.println("创建临时文件失败！");
			return false;
		}
		fisOpen = new FileInputStream(fileOpen);
		int b;
		while (fisOpen.available() > 0) {
			b = fisOpen.read();
			for (short i = 0; i < codeNum; i++) {
				if (HC[i].c == b) {
					for (int j = 0; j < HC[i].code.length(); j++) {
						fosTemp.write(HC[i].code.charAt(j));
					}
				}
			}
		}
		fisOpen.close();
		fosTemp.close();
		return true;
	}

	private boolean creatCprFile() throws IOException {
		fisTemp = new FileInputStream(fileTemp);
		try {
			fileSave.createNewFile();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "创建新文件失败");
			System.out.println("Create new file failed!");
			System.exit(-1);
		}
		try {
			fosSave = new FileOutputStream(fileSave);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "创建写入流失败" + this.fileSaveName);
			System.out.println("Can't Save File:" + this.fileSaveName);
			System.exit(-1);
		}
		fosSave.write(codeNum >> 8);
		fosSave.write(codeNum);
		byte b = 0;
		zero = (byte) (8 - fileTemp.length() % 8);
		fosSave.write(zero);
		for (int i = 0; i < codeNum; i++) {
			fosSave.write(HT[i + 1].c);
			fosSave.write(HT[i + 1].w >>> 24);
			fosSave.write(HT[i + 1].w >>> 16);
			fosSave.write(HT[i + 1].w >>> 8);
			fosSave.write(HT[i + 1].w);
		}
		for (short i = (short) (7 - zero); i >= 0;) {
			b += (byte) (fisTemp.read() << (i--));
		}
		try {
			fosSave.write(b);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "写入新文件失败");
			System.out.println("Something wrong occured while write");
			try {
				fosSave.close();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "关闭新文件失败");
				System.out.println("Can't close file:" + this.fileSaveName);
			}
			fileSave.delete();
			System.exit(-1);
		}
		while (fisTemp.available() > 0) {
			b = 0;
			for (short i = 7; i >= 0; i--) {
				b += (byte) (fisTemp.read() << i);
			}
			try {
				fosSave.write(b);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "写入新文件失败");
				System.out.println("Something wrong occured while write");
				try {
					fosSave.close();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "关闭新文件失败");
					System.out.println("Can't close file:" + this.fileSaveName);
				}
				fileSave.delete();
				System.exit(-1);
			}
		}
		fisTemp.close();
		fosSave.close();
		fileTemp.delete();
		return true;
	}

	public boolean compress() throws IOException {
		if (creatCharacter())
			if (creatHuffmanTree())
				if (creatHuffmanCode())
					if (creatTempFile())
						return creatCprFile();
		return false;
	}

	private boolean reCreatCharacter() throws IOException {
		codeNum = (short) ((fisOpen.read() << 8) + (fisOpen.read()));
		zero = (byte) fisOpen.read();
		character = new int[256];
		int c;
		int wbyte;
		for (short i = 0; i < codeNum; i++) {
			c = fisOpen.read();
			for (short j = 3; j >= 0; j--) {
				wbyte = fisOpen.read();
				character[c] += (wbyte << (8 * j));
			}
		}
		return true;
	}

	private boolean reCreatTempFile() throws IOException {
		fileTempName = fileOpenName.concat(".tmpcpr");
		fileTemp = new File(fileTempName);
		try {
			fosTemp = new FileOutputStream(fileTemp);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "创建临时文件失败");
			System.out.println("创建临时文件失败！");
			return false;
		}
		int b;
		byte[] bt = new byte[8];
		while (fisOpen.available() > 0) {
			b = fisOpen.read();
			for (int i = 0; i < 8; i++) {
				bt[i] = (byte) ((b >> (7 - i)) % 2);
			}
			fosTemp.write(bt);
		}
		fisOpen.close();
		fosTemp.close();
		return true;
	}

	private boolean CreatDprFile() throws IOException {
		fisTemp = new FileInputStream(fileTemp);
		try {
			fileSave.createNewFile();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "创建新文件失败");
			System.out.println("Create new file failed!");
			System.exit(-1);
		}
		try {
			fosSave = new FileOutputStream(fileSave);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "创建写入流失败" + this.fileSaveName);
			System.out.println("Can't Save File:" + this.fileSaveName);
			System.exit(-1);
		}
		fisTemp.skip(zero);
		short p;
		write: while (fisTemp.available() > 0) {
			p = (short) (codeNum * 2 - 1);
			int bt;
			while (HT[p].lchild != 0 && HT[p].rchild != 0) {
				bt = fisTemp.read();
				if (bt < 0)
					break write;
				if (bt == 0)
					p = HT[p].lchild;
				else
					p = HT[p].rchild;
			}
			fosSave.write(HT[p].c);
		}
		fisTemp.close();
		fosSave.close();
		fileTemp.delete();
		return true;
	}

	public boolean decompress() throws IOException {
		if (reCreatCharacter())
			if (creatHuffmanTree())
				if (reCreatTempFile())
					return CreatDprFile();
		return false;
	}

	public boolean startIndependent() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入要打开的文件");
		fileOpenName = sc.next();
		fileOpen = new File(fileOpenName);
		try {
			fisOpen = new FileInputStream(fileOpen);
		} catch (FileNotFoundException e) {
			System.out.println("Can't Open File:" + this.fileOpenName);
			sc.close();
			return false;
		}
		System.out.println("输入保存的文件名");
		fileSaveName = sc.next();
		fileSave = new File(fileSaveName);
		if (fileSave.exists()) {
			System.out.println("Overwrite this file?");
			String s = sc.next();
			if (s.equals("y") || s.equals("Y") || s.equals("yes") || s.equals("YES")) {
				fileSave.delete();
			} else {
				System.out.println("Program terminated");
				sc.close();
				return false;
			}
		}
		System.out.println("输入操作选项：1.压缩；2.解压；other.退出");
		switch (sc.next()) {
			case "1":
				if (compress())
					System.out.println("压缩成功！");
				else
					System.out.println("压缩失败！");
				break;
			case "2":
				if (decompress())
					System.out.println("解压成功！");
				else
					System.out.println("解压失败！");
				break;
			default:
				break;
		}
		sc.close();
		return true;
	}

	public boolean startDependent(String fileOpenName, String fileSaveName, boolean choice)
			throws IOException {
		this.fileOpenName = fileOpenName;
		this.fileSaveName = fileSaveName;
		fileOpen = new File(fileOpenName);
		try {
			fisOpen = new FileInputStream(fileOpen);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "打开文件失败" + this.fileOpenName);
			return false;
		}
		fileSave = new File(this.fileSaveName);
		if (choice) {
			return compress();
		} else {
			return decompress();
		}
	}

	public static void main(String[] args) {
		Compress cpr = new Compress();
		try {
			cpr.startIndependent();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
