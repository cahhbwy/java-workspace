package work5;

import java.awt.Color;

import edu.princeton.cs.introcs.Picture;

public class PhotoMagic {
	public static Picture transform(Picture picture, LFSR lfsr) {
		Picture pipe = picture;
		int[] cc = new int[3];
		int n;
		for (int x = 0; x < pipe.width(); x++) {
			for (int y = 0; y < pipe.height(); y++) {
				Color m = pipe.get(x, y);
				cc = new int[3];
				cc[0] = m.getRed();
				cc[1] = m.getGreen();
				cc[2] = m.getBlue();
				for (int k = 0; k < 3; k++) {
					n = lfsr.generate(8);
					cc[k] = cc[k] ^ n;
				}
				m = new Color(cc[0], cc[1], cc[2]);
				pipe.set(x, y, m);
			}
		}
		return pipe;
	}

	public static void main(String[] args) {
		LFSR h = new LFSR("01101000010100010000", 16);
		Picture pic = new Picture("src/work5/lfsr/Xpipe.png");
		Picture xpic = transform(pic, h);
		xpic.show();
	}

}
