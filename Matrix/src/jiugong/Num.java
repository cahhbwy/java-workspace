package jiugong;

import java.awt.Color;

import javax.swing.JOptionPane;

public class Num {
	class Node {
		int i;
		int x, y;
		int xuhao;
		Color c;

		Node(int i, int xuhao) {
			this.i = i;
			this.x = xuhao % size;
			this.y = xuhao / size;
			c = Color.BLUE;
		}
	}

	int size;
	static Node[] n;
	static Node blank;
	int step;
	int next;
	public Num(int size) {
		this.size = size;
		n = new Node[size * size - 1];
		blank = new Node(size * size, size * size - 1);
		step = 0;
		next=1;
	}

	public void start() {
		if (size >= 15)
			StdDraw.setCanvasSize(size * 35, size * 35);
		StdDraw.setXscale(-0.5, size - 0.5);
		StdDraw.setYscale(size - 0.5, -0.5);
		int[] xu = new int[size * size - 1];
		for (int i = 0; i < size * size - 1; i++)
			xu[i] = i;
		for (int i = 0; i < size * size / 4 * 2; i++) {
			int p, q;
			p = (int) (Math.random() * size * size - 1);
			q = (int) (Math.random() * size * size - 1);
			int temp;
			if (p != q) {
				temp = xu[p];
				xu[p] = xu[q];
				xu[q] = temp;
			} else
				i--;
		}
		for (int i = 0; i < size * size - 1; i++) {
			n[i] = new Node(i + 1, xu[i]);
		}
	}

	public void draw(int k) {
		StdDraw.clear();
		for (int i = 0; i < size * size - 1; i++) {
			if (i != k) {
				if (n[i].i == n[i].x + n[i].y * size + 1)
					n[i].c = Color.RED;
				else
					n[i].c = Color.blue;
			}
			else{
				n[i].c = Color.yellow;
			}
			StdDraw.setPenColor(n[i].c);
			StdDraw.filledSquare(n[i].x, n[i].y, 0.5);
			StdDraw.setPenColor(Color.orange);
			StdDraw.square(n[i].x, n[i].y, 0.5);
			StdDraw.setPenColor(Color.BLACK);
			StdDraw.text(n[i].x, n[i].y, "" + n[i].i);
		}
		StdDraw.show(20);
	}

	public void move(int i) {
		switch (i) {
		case 8:
			if (blank.y != size - 1) {
				for (int j = 0; j < size * size - 1; j++) {
					if (n[j].x == blank.x && n[j].y == blank.y + 1) {
						n[j].y--;
						blank.y++;
						step++;
						return;
					}
				}
			}
			return;
		case 2:
			if (blank.y != 0) {
				for (int j = 0; j < size * size - 1; j++) {
					if (n[j].x == blank.x && n[j].y == blank.y - 1) {
						n[j].y++;
						blank.y--;
						step++;
						return;
					}
				}
			}
			return;
		case 4:
			if (blank.x != size - 1) {
				for (int j = 0; j < size * size - 1; j++) {
					if (n[j].y == blank.y && n[j].x == blank.x + 1) {
						n[j].x--;
						blank.x++;
						step++;
						return;
					}
				}
			}
			return;
		case 6:
			if (blank.x != 0) {
				for (int j = 0; j < size * size - 1; j++) {
					if (n[j].y == blank.y && n[j].x == blank.x - 1) {
						n[j].x++;
						blank.x--;
						step++;
						return;
					}
				}
			}
			return;
		default:
			return;
		}
	}

	public void search() {
		int i;
		try {
			i = Integer.parseInt(JOptionPane.showInputDialog("Ҫ���ҵ�����", next)) - 1;
			draw(i);
			JOptionPane.showMessageDialog(null, "�������");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "��ʽ����");
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "���ݴ���");
		}
	}

	public boolean win() {
		for (int j = 0; j < size * size - 1; j++) {
			if (n[j].i != n[j].x + n[j].y * size + 1){
				next=n[j].i;
				return false;
			}
		}
		return true;
	}

	public void auto() {
		if(size>=3){
			int h=0,l=0,k=0,i;
			//blank��λ
			while(blank.y<size-1){
				move(8);draw(-1);StdDraw.show(1);
			}
			while(blank.x<size-1){
				move(4);draw(-1);StdDraw.show(1);
			}
			while(k<size-3){
				for (l=k;l<size;l++) {
					i=k*size+l;
					char c = ' ';
					if (StdDraw.hasNextKeyTyped()) {
						c = StdDraw.nextKeyTyped();
						if(c=='h')
							return;
					}
					while(n[i].x!=l||n[i].y!=k){
						if(n[i].x!=l){//n[i]��l��ͬ
							if(n[i].x>l){//n[i]��l�ұ�
								while(blank.x>n[i].x-1){
									move(6);draw(i);StdDraw.show(1);
								}
								while(blank.y>n[i].y){
									move(2);draw(i);StdDraw.show(1);
								}//blank�Ƶ�n[i]���
								if(blank.y==size-1){//n[i]�ڵ���-->n[i]�������ڶ���
									move(2);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
								}//blank�Ƶ�n[i]���
								move(4);draw(i);StdDraw.show(1);//blank�Ƶ�n[i]�Ҳ�
								while(n[i].x>l){//n[i]�����ƶ���l
									move(8);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
								}//blank�Ƶ�n[i]�Ҳ�
							}
							if(n[i].x<l){//n[i]��l���
								while(blank.x>n[i].x+1){
									move(6);draw(i);StdDraw.show(1);
								}
								while(blank.y>n[i].y){
									move(2);draw(i);StdDraw.show(1);
								}//blank�Ƶ�n[i]�Ҳ�
								if(blank.y==size-1){//n[i]�ڵ���-->n[i]�������ڶ���
									move(2);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
								}//blank�Ƶ�n[i]�Ҳ�
								move(6);draw(i);StdDraw.show(1);
								while(n[i].x<l){//n[i]�����ƶ���l
									move(8);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
								}//blank����n[i]���
							}//�����ƶ�����
						}
						else if(n[i].y!=size-1){//n[i]��l��ͬ��n[i]�������һ��
							if(n[i].x==size-1){//lΪ���ұ�
								move(6);draw(i);StdDraw.show(1);//blank����n[i]���
							}
							else{
								while(blank.x>n[i].x+1){
									move(6);draw(i);StdDraw.show(1);
								}//blank����n[i]�Ҳ�
							}
							while(blank.y>n[i].y){//ʹblank��n[i]ͬ��
								move(2);draw(i);StdDraw.show(1);
							}
						}
						else{//n[i]�����һ��
							while(blank.x>n[i].x+1){
								move(6);draw(i);StdDraw.show(1);//blank����n[i]�Ҳ�
							}
						}
						//�����ƶ�
						if(n[i].y!=k){//n[i]��h����ͬ
							if(l==size-1){//l���һ�У�blank�����
								move(6);draw(i);StdDraw.show(1);//blank����һ��
								while(blank.y>k){
									move(2);draw(i);StdDraw.show(1);//blank���Ƶ�h
								}
								while(blank.x<l){//blank���Ƶ�ͷ
									move(4);draw(i);StdDraw.show(1);
								}
								while(blank.y<n[i].y){//blank���Ƶ�n[i]����
									move(8);draw(i);StdDraw.show(1);
								}
								move(6);draw(i);StdDraw.show(1);//blank����һ��
								move(2);draw(i);StdDraw.show(1);//blank����һ��blank��n[i]���
								while(n[i].y>k){
									move(2);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
								}//n[i]���Ƶ�h��blank��n[i]���
								move(6);draw(i);StdDraw.show(1);//blank����һ��
								move(8);draw(i);StdDraw.show(1);//blank����һ����ɸ���
							}
							else{
								if(blank.x<n[i].x){//blank��n[i]���
									move(8);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
								}//blank�Ƶ�n[i]�Ҳ�
								while(n[i].y>k){//n[i]���Ƶ�h
									move(2);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
								}
							}
						}
					}
					//blank��λ
					if((i+1)%size!=0){
						while(blank.x<size-1&&blank.x<n[i+1].x+1){
							move(4);draw(i+1);StdDraw.show(1);
						}
						while(blank.y<size-1&&blank.y<n[i+1].y+1){
							move(8);draw(i+1);StdDraw.show(1);
						}
					}
					else{
						while(blank.x<size-1&&blank.x<n[(k+1)*size+k].x+1){
							move(4);draw((k+1)*size+k);StdDraw.show(1);
						}
						while(blank.y<size-1&&blank.y<n[(k+1)*size+k].y+1){
							move(8);draw((k+1)*size+k);StdDraw.show(1);
						}
					}
				}
				for (h=k;h<size;h++) {
					i=h*size+k;
					char c = ' ';
					if (StdDraw.hasNextKeyTyped()) {
						c = StdDraw.nextKeyTyped();
						if(c=='h')
							return;
					}
					while(n[i].y!=h||n[i].x!=k){
						if(n[i].y!=h){//n[i]��h����ͬ
							if(n[i].y>h){//n[i]��h�±�
								while(blank.y>n[i].y-1){
									move(2);draw(i);StdDraw.show(1);
								}
								while(blank.x>n[i].x){
									move(6);draw(i);StdDraw.show(1);
								}//blank�Ƶ�n[i]�ϲ�
								if(blank.x==size-1){//n[i]�ڵ���-->n[i]�������ڶ���
									move(6);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
								}//blank�Ƶ�n[i]�ϲ�
								move(8);draw(i);StdDraw.show(1);//blank�Ƶ�n[i]�²�
								while(n[i].y>h){//n[i]�����ƶ���h
									move(4);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
								}//blank�Ƶ�n[i]�²�
							}
							if(n[i].y<h){//n[i]��h�ϱ�
								while(blank.y>n[i].y+1){
									move(2);draw(i);StdDraw.show(1);
								}
								while(blank.x>n[i].x){
									move(6);draw(i);StdDraw.show(1);
								}//blank�Ƶ�n[i]�²�
								if(blank.x==size-1){//n[i]�ڵ���-->n[i]�������ڶ���
									move(6);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
								}//blank�Ƶ�n[i]�²�
								move(2);draw(i);StdDraw.show(1);
								while(n[i].y<h){//n[i]�����ƶ���h
									move(4);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
								}//blank����n[i]�ϲ�
							}//�����ƶ�����
						}
						else if(n[i].x!=size-1){//n[i]��h��ͬ��n[i]�������һ��
							if(n[i].y==size-1){//hΪ���±�
								move(2);draw(i);StdDraw.show(1);//blank����n[i]�ϲ�
							}
							else{
								while(blank.y>n[i].y+1){
									move(2);draw(i);StdDraw.show(1);
								}//blank����n[i]�²�
							}
							while(blank.x>n[i].x){//ʹblank��n[i]ͬ��
								move(6);draw(i);StdDraw.show(1);
							}
						}
						else{//n[i]�����һ��
							while(blank.y>n[i].y+1){
								move(2);draw(i);StdDraw.show(1);//blank����n[i]�²�
							}
						}
						//�����ƶ�
						if(n[i].x!=k){//n[i]��l����ͬ
							if(h==size-1){//h���һ�У�blank���ϲ�
								move(2);draw(i);StdDraw.show(1);//blank����һ��
								while(blank.x>k){
									move(6);draw(i);StdDraw.show(1);//blank���Ƶ�l
								}
								while(blank.y<h){//blank���Ƶ�ͷ
									move(8);draw(i);StdDraw.show(1);
								}
								while(blank.x<n[i].x){//blank���Ƶ�n[i]����
									move(4);draw(i);StdDraw.show(1);
								}
								move(2);draw(i);StdDraw.show(1);//blank����һ��
								move(6);draw(i);StdDraw.show(1);//blank����һ��blank��n[i]�ϲ�
								while(n[i].x>k){
									move(6);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
								}//n[i]���Ƶ�l��blank��n[i]�ϲ�
								move(2);draw(i);StdDraw.show(1);//blank����һ��
								move(4);draw(i);StdDraw.show(1);//blank����һ����ɸ���
							}
							else{
								if(blank.y<n[i].y){//blank��n[i]�ϲ�
									move(4);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
								}//blank�Ƶ�n[i]�²�
								while(n[i].x>k){//n[i]���Ƶ�l
									move(6);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
								}
							}
						}
					}
					//blank��λ
					if(i/size<size-1){
						while(blank.y<size-1&&blank.y<n[i+size].y+1){
							move(8);draw(i+size);StdDraw.show(1);
						}
						while(blank.x<size-1&&blank.x<n[i+size].x+1){
							move(4);draw(i+size);StdDraw.show(1);
						}
					}
					else{
						while(blank.y<size-1&&blank.y<n[(k+1)*size+k+1].y+1){
							move(8);draw((k+1)*size+k+1);StdDraw.show(1);
						}
						while(blank.x<size-1&&blank.x<n[(k+1)*size+k+1].x+1){
							move(4);draw((k+1)*size+k+1);StdDraw.show(1);
						}
					}
				}
				k++;
			}
			//3*3
			for (l=k;l<size;l++) {//��һ��
				i=k*size+l;
				char c = ' ';
				if (StdDraw.hasNextKeyTyped()) {
					c = StdDraw.nextKeyTyped();
					if(c=='h')
						return;
				}
				while(n[i].x!=l||n[i].y!=k){
					if(n[i].x!=l){//n[i]��l����ͬ
						if(n[i].x>l){//n[i]��l�ұ�
							while(blank.x>n[i].x-1){
								move(6);draw(i);StdDraw.show(1);
							}
							while(blank.y>n[i].y){
								move(2);draw(i);StdDraw.show(1);
							}//blank�Ƶ�n[i]���
							if(blank.y==size-1){//n[i]�ڵ���-->n[i]�������ڶ���
								move(2);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
								move(8);draw(i);StdDraw.show(1);
								move(6);draw(i);StdDraw.show(1);
								move(2);draw(i);StdDraw.show(1);
							}//blank�Ƶ�n[i]���
							move(4);draw(i);StdDraw.show(1);//blank�Ƶ�n[i]�Ҳ�
							while(n[i].x>l){//n[i]�����ƶ���l
								move(8);draw(i);StdDraw.show(1);
								move(6);draw(i);StdDraw.show(1);
								move(6);draw(i);StdDraw.show(1);
								move(2);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
							}//blank�Ƶ�n[i]�Ҳ�
						}
						if(n[i].x<l){//n[i]��l���
							while(blank.x>n[i].x+1){
								move(6);draw(i);StdDraw.show(1);
							}
							while(blank.y>n[i].y){
								move(2);draw(i);StdDraw.show(1);
							}//blank�Ƶ�n[i]�Ҳ�
							if(blank.y==size-1){//n[i]�ڵ���-->n[i]�������ڶ���
								move(2);draw(i);StdDraw.show(1);
								move(6);draw(i);StdDraw.show(1);
								move(8);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
								move(2);draw(i);StdDraw.show(1);
							}//blank�Ƶ�n[i]�Ҳ�
							move(6);draw(i);StdDraw.show(1);
							while(n[i].x<l){//n[i]�����ƶ���l
								move(8);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
								move(2);draw(i);StdDraw.show(1);
								move(6);draw(i);StdDraw.show(1);
							}//blank����n[i]���
						}//�����ƶ�����
					}
					else if(n[i].y!=size-1){//n[i]��l��ͬ��n[i]�������һ��
						if(n[i].x==size-1){//lΪ���ұ�
							move(6);draw(i);StdDraw.show(1);//blank����n[i]���
						}
						else{
							while(blank.x>n[i].x+1){
								move(6);draw(i);StdDraw.show(1);
							}//blank����n[i]�Ҳ�
						}
						while(blank.y>n[i].y){//ʹblank��n[i]ͬ��
							move(2);draw(i);StdDraw.show(1);
						}
					}
					else{//n[i]�����һ��
						while(blank.x>n[i].x+1){
							move(6);draw(i);StdDraw.show(1);//blank����n[i]�Ҳ�
						}
					}
					//�����ƶ�
					if(n[i].y!=k){//n[i]��h����ͬ
						if(l==size-1){//l���һ�У�blank�����
							move(6);draw(i);StdDraw.show(1);//blank����һ��
							while(blank.y>k){
								move(2);draw(i);StdDraw.show(1);//blank���Ƶ�h
							}
							while(blank.x<l){//blank���Ƶ�ͷ
								move(4);draw(i);StdDraw.show(1);
							}
							while(blank.y<n[i].y){//blank���Ƶ�n[i]����
								move(8);draw(i);StdDraw.show(1);
							}
							move(6);draw(i);StdDraw.show(1);//blank����һ��
							move(2);draw(i);StdDraw.show(1);//blank����һ��blank��n[i]���
							while(n[i].y>k){
								move(2);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
								move(8);draw(i);StdDraw.show(1);
								move(6);draw(i);StdDraw.show(1);
								move(2);draw(i);StdDraw.show(1);
							}//n[i]���Ƶ�h��blank��n[i]���
							move(6);draw(i);StdDraw.show(1);//blank����һ��
							move(8);draw(i);StdDraw.show(1);//blank����һ����ɸ���
						}
						else{
							if(blank.x<n[i].x){//blank��n[i]���
								move(8);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
								move(2);draw(i);StdDraw.show(1);
							}//blank�Ƶ�n[i]�Ҳ�
							while(n[i].y>k){//n[i]���Ƶ�h
								move(2);draw(i);StdDraw.show(1);
								move(6);draw(i);StdDraw.show(1);
								move(8);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
								move(2);draw(i);StdDraw.show(1);
							}
						}
					}
				}
				//blank��λ
				while(blank.x<size-1){
					move(4);draw(i);StdDraw.show(1);
				}
				while(blank.y<size-1){
					move(8);draw(i);StdDraw.show(1);
				}
			}//��һ���ź�
			i=(k+1)*size+k;
			char c = ' ';
			if (StdDraw.hasNextKeyTyped()) {
				c = StdDraw.nextKeyTyped();
				if(c=='h')
					return;
			}
			while(n[i].y!=k+1||n[i].x!=k){
				if(n[i].y==k+1){
					if(n[i].x==k+1){
						move(6);draw(i);StdDraw.show(1);
						move(6);draw(i);StdDraw.show(1);
						move(2);draw(i);StdDraw.show(1);
						move(4);draw(i);StdDraw.show(1);
						move(4);draw(i);StdDraw.show(1);
						move(8);draw(i);StdDraw.show(1);
					}
					if(n[i].x==k+2){
						move(6);draw(i);StdDraw.show(1);
						move(2);draw(i);StdDraw.show(1);
						move(4);draw(i);StdDraw.show(1);
						move(8);draw(i);StdDraw.show(1);
					}	
				}
				if(n[i].y==k+2){
					if(n[i].x==k){
						move(2);draw(i);StdDraw.show(1);
						move(6);draw(i);StdDraw.show(1);
						move(6);draw(i);StdDraw.show(1);
						move(8);draw(i);StdDraw.show(1);
						move(4);draw(i);StdDraw.show(1);
						move(4);draw(i);StdDraw.show(1);
					}
					if(n[i].x==k+1){
						move(2);draw(i);StdDraw.show(1);
						move(6);draw(i);StdDraw.show(1);
						move(8);draw(i);StdDraw.show(1);
						move(4);draw(i);StdDraw.show(1);
					}
				}
			}
			i=(k+2)*size+k;
			c = ' ';
			if (StdDraw.hasNextKeyTyped()) {
				c = StdDraw.nextKeyTyped();
				if(c=='h')
					return;
			}
			while(n[i].x!=k||n[i].y!=k+2){
				if(n[i].x==k+1&&n[i].y==k+1){
					move(6);draw(i);StdDraw.show(1);
					move(2);draw(i);StdDraw.show(1);
					move(4);draw(i);StdDraw.show(1);
					move(8);draw(i);StdDraw.show(1);
				}
				if(n[i].x==k+2&&n[i].y==k+1){
					move(2);draw(i);StdDraw.show(1);
					move(6);draw(i);StdDraw.show(1);
					move(8);draw(i);StdDraw.show(1);
					move(4);draw(i);StdDraw.show(1);
				}
				if(n[i].x==k+1&&n[i].y==k+2){
					move(6);draw(i);StdDraw.show(1);
					move(6);draw(i);StdDraw.show(1);
					move(2);draw(i);StdDraw.show(1);
					move(4);draw(i);StdDraw.show(1);
					move(8);draw(i);StdDraw.show(1);
					move(4);draw(i);StdDraw.show(1);
					move(2);draw(i);StdDraw.show(1);
					move(6);draw(i);StdDraw.show(1);
					move(6);draw(i);StdDraw.show(1);
					move(8);draw(i);StdDraw.show(1);
					move(4);draw(i);StdDraw.show(1);
					move(4);draw(i);StdDraw.show(1);
				}
			}
			i=(k+1)*size+k+1;
			c = ' ';
			if (StdDraw.hasNextKeyTyped()) {
				c = StdDraw.nextKeyTyped();
				if(c=='h')
					return;
			}
			while(n[i].x!=k+1||n[i].y!=k+1){
				if(n[i].x==k+2&&n[i].y==k+1){
					move(6);draw(i);StdDraw.show(1);
					move(2);draw(i);StdDraw.show(1);
					move(4);draw(i);StdDraw.show(1);
					move(8);draw(i);StdDraw.show(1);
				}
				if(n[i].x==k+1&&n[i].y==k+2){
					move(2);draw(i);StdDraw.show(1);
					move(6);draw(i);StdDraw.show(1);
					move(8);draw(i);StdDraw.show(1);
					move(4);draw(i);StdDraw.show(1);
				}
			}
		}
		else{
			char c = ' ';
			if (StdDraw.hasNextKeyTyped()) {
				c = StdDraw.nextKeyTyped();
				if(c=='h')
					return;
			}
			move(4);draw(-1);StdDraw.show(1);
			move(8);draw(-1);StdDraw.show(1);
			while(n[0].x!=0||n[0].y!=0){
				if(n[0].x==1&&n[0].y==0){
					move(6);draw(-1);StdDraw.show(1);
					move(2);draw(-1);StdDraw.show(1);
					move(4);draw(-1);StdDraw.show(1);
					move(8);draw(-1);StdDraw.show(1);
				}
				if(n[0].x==0&&n[0].y==1){
					move(2);draw(-1);StdDraw.show(1);
					move(6);draw(-1);StdDraw.show(1);
					move(8);draw(-1);StdDraw.show(1);
					move(4);draw(-1);StdDraw.show(1);
				}
			}
		}
		return;
	}
}
