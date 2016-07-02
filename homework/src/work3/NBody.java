package work3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdAudio;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

class planet {
	double m;
	double x;
	double y;
	double vx;
	double vy;
	double fx;
	double fy;
	String name;

	public planet(double hx, double hy, double hvx, double hvy, double hm,
			String hname) {
		x = hx;
		y = hy;
		vx = hvx;
		vy = hvy;
		m = hm;
		name = hname;
	}
}

public class NBody {
	static double G = 6.67e-11;
	private static Scanner reader;

	public static void main(String[] args) {
		StdAudio.play("src/work3/nbody/2001.mid");
		StdDraw.setCanvasSize(512, 512);
		double time = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);

		try {
			reader = new Scanner(new File("src/work3/nbody/planets.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int num = reader.nextInt();
		planet[] star = new planet[num];

		double R = reader.nextDouble();
		StdDraw.setScale(0.0 - R, R);
		StdDraw.picture(0.0, 0.0, "src/work3/nbody/starfield.jpg");

		for (int i = 0; i < num; i++) {
			star[i] = new planet(reader.nextDouble(), reader.nextDouble(),
					reader.nextDouble(), reader.nextDouble(),
					reader.nextDouble(), reader.next());
		}
		for (int i = 0; i < num; i++)
			StdDraw.picture(star[i].x, star[i].y, "src/work3/nbody/"
					+ star[i].name);

		double r2, r, f;
		for (double t = 0.0; t < time; t += dt) {
			for (int i = 0; i < num; i++) {
				star[i].fx = star[i].fy = 0.0;
			}
			for (int i = 0; i < num - 1; i++) {
				for (int j = i + 1; j < num; j++) {
					r2 = (star[i].x - star[j].x) * (star[i].x - star[j].x)
							+ (star[i].y - star[j].y) * (star[i].y - star[j].y);
					f = G * star[i].m * star[j].m / r2;
					r = Math.sqrt(r2);
					star[i].fx += f * (star[j].x - star[i].x) / r;
					star[i].fy += f * (star[j].y - star[i].y) / r;
					star[j].fx += (0 - star[i].fx);
					star[j].fy += (0 - star[i].fy);
				}
			}
			StdDraw.show(10);
			StdDraw.picture(0.0, 0.0, "src/work3/nbody/starfield.jpg");
			for (int i = 0; i < num; i++) {

				star[i].vx += star[i].fx * dt / star[i].m;
				star[i].vy += star[i].fy * dt / star[i].m;
				star[i].x += star[i].vx * dt;
				star[i].y += star[i].vy * dt;
				StdDraw.picture(star[i].x, star[i].y, "src/work3/nbody/"
						+ star[i].name);
			}
		}
		StdOut.println(num);
		StdOut.printf("%8.2e\n", R);
		for (int i = 0; i < num; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
					star[i].x, star[i].y, star[i].vx, star[i].vy, star[i].m,
					star[i].name);
		}

	}
}
