package jiugong;

public class Game implements Runnable{
	int size;
	boolean control;
	
	public Game(int size,boolean control){
		this.size=size;
		this.control=control;
	}

	public void run() {
		Num num = new Num(size);
		num.start();
		num.draw(-1);
		if (control) {
			while (true) {
				char c = 'p';
				if (StdDraw.hasNextKeyTyped()) {
					c = StdDraw.nextKeyTyped();
					switch (c) {
					case 'w': case '8': num.move(8); break;
					case 'a': case '4': num.move(4); break;
					case 's': case '5': num.move(2); break;
					case 'd': case '6': num.move(6); break;
					case ' ': num.search(); break;
					case 'h': num.auto();break;
					default: num.move(5); break;
					}
					num.draw(-1);
				}
				if (num.win()) {
					break;
				}
			}
		} else {
			while (true) {
				char c = 'p';
				if (StdDraw.hasNextKeyTyped()) {
					c = StdDraw.nextKeyTyped();
					switch (c) {
					case 'w': case '8': num.move(2); break;
					case 'a': case '4': num.move(6); break;
					case 's': case '5': num.move(8); break;
					case 'd': case '6': num.move(4); break;
					case ' ': num.search(); break;
					case 'h': num.auto();break;
					default: num.move(5); break;
					}
					num.draw(-1);
					if (num.win()) {
						break;
					}
				}
			}
		}
		StdDraw.show(500);
		StdDraw.text((size - 1.0) / 2, -0.5, "YOU WIN!!!  "
				+ num.step + " step");
		StdDraw.show();
		MatrixGuide.matrixGuide.frameend.setVisible(true);
	}

}
