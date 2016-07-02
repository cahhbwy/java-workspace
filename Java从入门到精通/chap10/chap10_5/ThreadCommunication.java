package chap10_5;

class Pruducer extends Thread{
	Queue q;
	Pruducer(Queue q){
		this.q=q;
	}
	public void run(){
		for(int i=1;i<5;i++){
			q.put(i);
		}
	}
}
class Consumer extends Thread{
	Queue q;
	Consumer(Queue q){
		this.q=q;
	}
	public void run(){
		while(true){
			q.get();
		}
	}
}
class Queue{
	int value=0;
	boolean isEmpty=true;
	public synchronized void put(int v){
		if(!isEmpty){
			try{
				System.out.println("生产者等待");
				wait();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		value+=v;
		isEmpty=false;
		System.out.println("生产者共生产数量："+v);
		notify();
	}
	public synchronized int get(){
		if(isEmpty){
			try{
				System.out.println("消费者等待");
				wait();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		value--;
		if(value<1){
			isEmpty=true;
		}
		System.out.println("消费者消费一个，剩余："+value);
		notify();
		return value;
	}
}
public class ThreadCommunication{
	public static void main(String[] args){
		Queue q=new Queue();
		Pruducer p=new Pruducer(q);
		Consumer c=new Consumer(q);
		c.start();
		p.start();
	}
}