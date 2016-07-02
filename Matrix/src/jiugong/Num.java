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
			i = Integer.parseInt(JOptionPane.showInputDialog("要查找的数字", next)) - 1;
			draw(i);
			JOptionPane.showMessageDialog(null, "查找完毕");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "格式错误");
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "数据错误");
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
			//blank归位
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
						if(n[i].x!=l){//n[i]与l相同
							if(n[i].x>l){//n[i]在l右边
								while(blank.x>n[i].x-1){
									move(6);draw(i);StdDraw.show(1);
								}
								while(blank.y>n[i].y){
									move(2);draw(i);StdDraw.show(1);
								}//blank移到n[i]左侧
								if(blank.y==size-1){//n[i]在底行-->n[i]到倒数第二行
									move(2);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
								}//blank移到n[i]左侧
								move(4);draw(i);StdDraw.show(1);//blank移到n[i]右侧
								while(n[i].x>l){//n[i]向左移动到l
									move(8);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
								}//blank移到n[i]右侧
							}
							if(n[i].x<l){//n[i]在l左边
								while(blank.x>n[i].x+1){
									move(6);draw(i);StdDraw.show(1);
								}
								while(blank.y>n[i].y){
									move(2);draw(i);StdDraw.show(1);
								}//blank移到n[i]右侧
								if(blank.y==size-1){//n[i]在底行-->n[i]到倒数第二行
									move(2);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
								}//blank移到n[i]右侧
								move(6);draw(i);StdDraw.show(1);
								while(n[i].x<l){//n[i]向右移动到l
									move(8);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
								}//blank置于n[i]左侧
							}//横向移动结束
						}
						else if(n[i].y!=size-1){//n[i]与l相同且n[i]不在最后一行
							if(n[i].x==size-1){//l为最右边
								move(6);draw(i);StdDraw.show(1);//blank置于n[i]左侧
							}
							else{
								while(blank.x>n[i].x+1){
									move(6);draw(i);StdDraw.show(1);
								}//blank置于n[i]右侧
							}
							while(blank.y>n[i].y){//使blank与n[i]同行
								move(2);draw(i);StdDraw.show(1);
							}
						}
						else{//n[i]在最后一行
							while(blank.x>n[i].x+1){
								move(6);draw(i);StdDraw.show(1);//blank置于n[i]右侧
							}
						}
						//纵向移动
						if(n[i].y!=k){//n[i]与h不相同
							if(l==size-1){//l最后一列，blank在左侧
								move(6);draw(i);StdDraw.show(1);//blank左移一格
								while(blank.y>k){
									move(2);draw(i);StdDraw.show(1);//blank上移到h
								}
								while(blank.x<l){//blank右移到头
									move(4);draw(i);StdDraw.show(1);
								}
								while(blank.y<n[i].y){//blank下移到n[i]下面
									move(8);draw(i);StdDraw.show(1);
								}
								move(6);draw(i);StdDraw.show(1);//blank左移一格
								move(2);draw(i);StdDraw.show(1);//blank上移一格，blank在n[i]左侧
								while(n[i].y>k){
									move(2);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
								}//n[i]上移到h，blank在n[i]左侧
								move(6);draw(i);StdDraw.show(1);//blank左移一格
								move(8);draw(i);StdDraw.show(1);//blank下移一格，完成改行
							}
							else{
								if(blank.x<n[i].x){//blank在n[i]左侧
									move(8);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
								}//blank移到n[i]右侧
								while(n[i].y>k){//n[i]上移到h
									move(2);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
								}
							}
						}
					}
					//blank归位
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
						if(n[i].y!=h){//n[i]与h不相同
							if(n[i].y>h){//n[i]在h下边
								while(blank.y>n[i].y-1){
									move(2);draw(i);StdDraw.show(1);
								}
								while(blank.x>n[i].x){
									move(6);draw(i);StdDraw.show(1);
								}//blank移到n[i]上侧
								if(blank.x==size-1){//n[i]在底列-->n[i]到倒数第二列
									move(6);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
								}//blank移到n[i]上侧
								move(8);draw(i);StdDraw.show(1);//blank移到n[i]下侧
								while(n[i].y>h){//n[i]向上移动到h
									move(4);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
								}//blank移到n[i]下侧
							}
							if(n[i].y<h){//n[i]在h上边
								while(blank.y>n[i].y+1){
									move(2);draw(i);StdDraw.show(1);
								}
								while(blank.x>n[i].x){
									move(6);draw(i);StdDraw.show(1);
								}//blank移到n[i]下侧
								if(blank.x==size-1){//n[i]在底列-->n[i]到倒数第二列
									move(6);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
								}//blank移到n[i]下侧
								move(2);draw(i);StdDraw.show(1);
								while(n[i].y<h){//n[i]向下移动到h
									move(4);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
								}//blank置于n[i]上侧
							}//纵向移动结束
						}
						else if(n[i].x!=size-1){//n[i]与h相同且n[i]不在最后一列
							if(n[i].y==size-1){//h为最下边
								move(2);draw(i);StdDraw.show(1);//blank置于n[i]上侧
							}
							else{
								while(blank.y>n[i].y+1){
									move(2);draw(i);StdDraw.show(1);
								}//blank置于n[i]下侧
							}
							while(blank.x>n[i].x){//使blank与n[i]同列
								move(6);draw(i);StdDraw.show(1);
							}
						}
						else{//n[i]在最后一列
							while(blank.y>n[i].y+1){
								move(2);draw(i);StdDraw.show(1);//blank置于n[i]下侧
							}
						}
						//纵向移动
						if(n[i].x!=k){//n[i]与l不相同
							if(h==size-1){//h最后一行，blank在上侧
								move(2);draw(i);StdDraw.show(1);//blank上移一格
								while(blank.x>k){
									move(6);draw(i);StdDraw.show(1);//blank左移到l
								}
								while(blank.y<h){//blank下移到头
									move(8);draw(i);StdDraw.show(1);
								}
								while(blank.x<n[i].x){//blank右移到n[i]右面
									move(4);draw(i);StdDraw.show(1);
								}
								move(2);draw(i);StdDraw.show(1);//blank上移一格
								move(6);draw(i);StdDraw.show(1);//blank左移一格，blank在n[i]上侧
								while(n[i].x>k){
									move(6);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
								}//n[i]左移到l，blank在n[i]上侧
								move(2);draw(i);StdDraw.show(1);//blank上移一格
								move(4);draw(i);StdDraw.show(1);//blank右移一格，完成改列
							}
							else{
								if(blank.y<n[i].y){//blank在n[i]上侧
									move(4);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
								}//blank移到n[i]下侧
								while(n[i].x>k){//n[i]左移到l
									move(6);draw(i);StdDraw.show(1);
									move(2);draw(i);StdDraw.show(1);
									move(4);draw(i);StdDraw.show(1);
									move(8);draw(i);StdDraw.show(1);
									move(6);draw(i);StdDraw.show(1);
								}
							}
						}
					}
					//blank归位
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
			for (l=k;l<size;l++) {//第一行
				i=k*size+l;
				char c = ' ';
				if (StdDraw.hasNextKeyTyped()) {
					c = StdDraw.nextKeyTyped();
					if(c=='h')
						return;
				}
				while(n[i].x!=l||n[i].y!=k){
					if(n[i].x!=l){//n[i]与l不相同
						if(n[i].x>l){//n[i]在l右边
							while(blank.x>n[i].x-1){
								move(6);draw(i);StdDraw.show(1);
							}
							while(blank.y>n[i].y){
								move(2);draw(i);StdDraw.show(1);
							}//blank移到n[i]左侧
							if(blank.y==size-1){//n[i]在底行-->n[i]到倒数第二行
								move(2);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
								move(8);draw(i);StdDraw.show(1);
								move(6);draw(i);StdDraw.show(1);
								move(2);draw(i);StdDraw.show(1);
							}//blank移到n[i]左侧
							move(4);draw(i);StdDraw.show(1);//blank移到n[i]右侧
							while(n[i].x>l){//n[i]向左移动到l
								move(8);draw(i);StdDraw.show(1);
								move(6);draw(i);StdDraw.show(1);
								move(6);draw(i);StdDraw.show(1);
								move(2);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
							}//blank移到n[i]右侧
						}
						if(n[i].x<l){//n[i]在l左边
							while(blank.x>n[i].x+1){
								move(6);draw(i);StdDraw.show(1);
							}
							while(blank.y>n[i].y){
								move(2);draw(i);StdDraw.show(1);
							}//blank移到n[i]右侧
							if(blank.y==size-1){//n[i]在底行-->n[i]到倒数第二行
								move(2);draw(i);StdDraw.show(1);
								move(6);draw(i);StdDraw.show(1);
								move(8);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
								move(2);draw(i);StdDraw.show(1);
							}//blank移到n[i]右侧
							move(6);draw(i);StdDraw.show(1);
							while(n[i].x<l){//n[i]向右移动到l
								move(8);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
								move(2);draw(i);StdDraw.show(1);
								move(6);draw(i);StdDraw.show(1);
							}//blank置于n[i]左侧
						}//横向移动结束
					}
					else if(n[i].y!=size-1){//n[i]与l相同且n[i]不在最后一行
						if(n[i].x==size-1){//l为最右边
							move(6);draw(i);StdDraw.show(1);//blank置于n[i]左侧
						}
						else{
							while(blank.x>n[i].x+1){
								move(6);draw(i);StdDraw.show(1);
							}//blank置于n[i]右侧
						}
						while(blank.y>n[i].y){//使blank与n[i]同行
							move(2);draw(i);StdDraw.show(1);
						}
					}
					else{//n[i]在最后一行
						while(blank.x>n[i].x+1){
							move(6);draw(i);StdDraw.show(1);//blank置于n[i]右侧
						}
					}
					//纵向移动
					if(n[i].y!=k){//n[i]与h不相同
						if(l==size-1){//l最后一列，blank在左侧
							move(6);draw(i);StdDraw.show(1);//blank左移一格
							while(blank.y>k){
								move(2);draw(i);StdDraw.show(1);//blank上移到h
							}
							while(blank.x<l){//blank右移到头
								move(4);draw(i);StdDraw.show(1);
							}
							while(blank.y<n[i].y){//blank下移到n[i]下面
								move(8);draw(i);StdDraw.show(1);
							}
							move(6);draw(i);StdDraw.show(1);//blank左移一格
							move(2);draw(i);StdDraw.show(1);//blank上移一格，blank在n[i]左侧
							while(n[i].y>k){
								move(2);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
								move(8);draw(i);StdDraw.show(1);
								move(6);draw(i);StdDraw.show(1);
								move(2);draw(i);StdDraw.show(1);
							}//n[i]上移到h，blank在n[i]左侧
							move(6);draw(i);StdDraw.show(1);//blank左移一格
							move(8);draw(i);StdDraw.show(1);//blank下移一格，完成改行
						}
						else{
							if(blank.x<n[i].x){//blank在n[i]左侧
								move(8);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
								move(2);draw(i);StdDraw.show(1);
							}//blank移到n[i]右侧
							while(n[i].y>k){//n[i]上移到h
								move(2);draw(i);StdDraw.show(1);
								move(6);draw(i);StdDraw.show(1);
								move(8);draw(i);StdDraw.show(1);
								move(4);draw(i);StdDraw.show(1);
								move(2);draw(i);StdDraw.show(1);
							}
						}
					}
				}
				//blank归位
				while(blank.x<size-1){
					move(4);draw(i);StdDraw.show(1);
				}
				while(blank.y<size-1){
					move(8);draw(i);StdDraw.show(1);
				}
			}//第一行排好
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
