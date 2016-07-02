package ec;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Encryption {
	byte seed[];
	String FileOpenName, FileSaveName;
	File fileOpen, fileSave;
	FileInputStream fis;
	FileOutputStream fos;
	String password;

	public Encryption() {
		this.seed = null;
		this.FileOpenName = null;
		this.FileSaveName = null;
		this.fileOpen = null;
		this.fileSave = null;
		this.fis = null;
		this.fos = null;
		this.password = null;
	}

	public void generateSeed() {
		seed = new byte[64];
		long temp = 0;
		for (int i = 0; i < this.password.length(); i++) {
			temp = temp << (64 / this.password.length());
			temp += this.password.charAt(i);
		}
		int i = 0;
		while (temp > 0) {
			this.seed[63 - i] = (byte) (temp % 2);
			temp /= 2;
			i++;
		}
	}

	public void printSeed() {
		for (int i = 0; i < 64; i++) {
			System.out.print(this.seed[i]);
		}
		System.out.println();
	}

	public void nextSeed() {
		for (int i = 0; i < 60; i++) {
			this.seed[i] = this.seed[i + 4];
		}
		this.seed[60] = (byte) (this.seed[10] ^ this.seed[40]);
		this.seed[61] = (byte) (this.seed[20] ^ this.seed[47]);
		this.seed[62] = (byte) (this.seed[30] ^ this.seed[54]);
		this.seed[63] = (byte) (this.seed[40] ^ this.seed[61]);
	}

	public byte getByte() {
		return (byte) ((this.seed[3] << 7) + (this.seed[7] << 6) + (this.seed[13] << 5)
				+ (this.seed[29] << 4) + (this.seed[37] << 3) + (this.seed[43] << 2) + (this.seed[53] << 1) + (this.seed[61] << 0));
	}

	public boolean encrypt(boolean state) throws IOException {
		fos = new FileOutputStream(fileSave);
		this.generateSeed();
		int oldByte = 0;
		int newByte = 0;
		if (state) {
			fos.write(password.hashCode());
		} else {
			fis.skip(1);
		}
		while (fis.available() > 0) {
			try {
				oldByte = (byte) fis.read();
			} catch (IOException e) {
				break;
			}
			newByte = oldByte ^ this.getByte();
			try {
				fos.write(newByte);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "写入出错！");
				System.out.println("Something wrong occured while write");
				fos.close();
				fileSave.delete();
				return false;
			}
			this.nextSeed();
		}
		fis.close();
		fos.close();
		return true;
	}

	public boolean startIndependent() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入要打开的文件");
		FileOpenName = sc.next();
		fileOpen = new File(FileOpenName);
		try {
			fis = new FileInputStream(fileOpen);
		} catch (FileNotFoundException e) {
			System.out.println("Can't open file:" + FileOpenName);
			sc.close();
			return false;
		}
		System.out.println("输入保存的文件名");
		FileSaveName = sc.next();
		fileSave = new File(FileSaveName);
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
		System.out.println("输入操作选项：1.加密；2解密；other.退出");
		switch (sc.next()) {
			case "1":
				System.out.println("输入密码");
				password = sc.next();
				if (encrypt(true))
					System.out.println("加密成功！");
				else
					System.out.println("加密失败！");
				break;
			case "2":
				System.out.println("输入密码");
				password = sc.next();
				if (encrypt(false))
					System.out.println("解密成功！");
				else
					System.out.println("解密失败！");
				break;
			default:
				break;
		}
		sc.close();
		return true;
	}

	public boolean startDependent(String fileOpenName, String fileSaveName, boolean choice, String password)
			throws IOException {
		this.FileOpenName = fileOpenName;
		this.FileSaveName = fileSaveName;
		fileOpen = new File(this.FileOpenName);
		try {
			fis = new FileInputStream(fileOpen);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "打开文件失败" + this.FileOpenName);
			return false;
		}
		this.password = password;
		fileSave = new File(this.FileSaveName);
		if (choice) {
			return encrypt(true);
		} else {
			return encrypt(false);
		}
	}

	public static void main(String[] args) throws IOException {
		Encryption enc = new Encryption();
		enc.startIndependent();
	}

}
