package chap10_4;

class ShareDate2 {
	public String szDate = "";
}

class ThreadDemo6 extends Thread {
	private ShareDate2 oShare;

	public ThreadDemo6() {
	}

	ThreadDemo6(String szName, ShareDate2 oShare) {
		super(szName);
		this.oShare = oShare;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			synchronized (oShare) {
				if (this.getName().equals("Thread1")) {
					oShare.szDate = "这是第1个线程";
					try {
						Thread.sleep((int) Math.random() * 50);
					} catch (InterruptedException e) {
					}
					System.out.println(this.getName() + ":" + oShare.szDate);
				} else if (this.getName().equals("Thread2")) {
					oShare.szDate = "这是第2个线程";
					try {
						Thread.sleep((int) Math.random() * 50);
					} catch (InterruptedException e) {
					}
					System.out.println(this.getName() + ":" + oShare.szDate);
				}
				oShare.notify();
				try {
					oShare.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

public class ThreadSynchronizedMain {

	public static void main(String[] args) {
		ShareDate2 oShare = new ShareDate2();
		ThreadDemo6 th1 = new ThreadDemo6("Thread1", oShare);
		ThreadDemo6 th2 = new ThreadDemo6("Thread2", oShare);
		th1.start();
		th2.start();
		while(true){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.activeCount());
			if(Thread.activeCount()<3){
				break;
			}
		}
//		System.exit(0);
	}

}
