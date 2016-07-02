package homework2;

import java.util.Scanner;

public class LinkList {
	int data;
	LinkList next;
	public LinkList() {
		this.data=0;
		this.next=null;
	}
	public LinkList(int[] arr){
		LinkList p=this;
		for(int i=0;i<arr.length;i++){
			p.next=new LinkList();
			p=p.next;
			p.data=arr[i];
		}
	}
	public void del(Scanner sc){
		if(this==null||this.next==null){
			System.out.println("链表为空");
			return;
		}			
		System.out.println("输入要删除的数字");
		LinkList p=this;
		int w=sc.nextInt();
		while(p.next!=null&&p.next.data!=w){
			p=p.next;
		}
		if(p.next==null){
			System.out.println("无此数据");
			return;
		}
		LinkList q=p.next;
		p.next=q.next;
		q.next=null;
	}
	public void ins(int n,int w){
		LinkList p=this;
		while(n-->0&&p.next!=null){
			p=p.next;
		}
		LinkList q=p.next;
		p.next=new LinkList();	
		p.next.data=w;
		p.next.next=q;
	}
	public void print(){
		LinkList p=this;
		while(p.next!=null){
			System.out.print(p.next.data+"  ");
			p=p.next;
		}
		System.out.println();
	}
	public static void menu(LinkList L){
		while(true){
			Scanner sc=new Scanner(System.in);
			System.out.println("选项:\n\t1:创建空链表\n\t2:根据数组创建链表\n\t3:删除数据域中值为w的节点\n\t4:在第n个节点后插入值为w的节点\n\tq:退出");
			switch (sc.next()) {
				case "1":L=new LinkList();break;
				case "2":{
					System.out.println("输入数组大小");
					int[] arr=new int[sc.nextInt()];
					System.out.println("输入数组数据");
					for(int i=0;i<arr.length;i++){
						arr[i]=sc.nextInt();
					}
					L=new LinkList(arr);
				}break;
				case "3":{
					L.del(sc);
				}break;
				case "4":{
					System.out.println("输入要插入的位置和数据");
					L.ins(sc.nextInt(),sc.nextInt());
				}break;
				case "q":System.exit(0);
				default:System.out.println("输入错误");break;
			}
			L.print();
		}
	}
	public static void main(String[] args) {
		LinkList L = new LinkList();
		menu(L);
	}

}
