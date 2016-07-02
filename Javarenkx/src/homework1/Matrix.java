package homework1;

import java.util.Scanner;

public class Matrix {
	static Scanner sc=new Scanner(System.in);

	int size;			//����ĳ���
	FenShu[][] fs;		//�����ÿһ����ֵ���Է����洢
	
	public Matrix(int size,FenShu fs[][]){	//new��������Ҫsize�;��������ֵ
		this.size=size;
		if(size<=0){		//size<0�����
			System.out.println("size must be 1,2,3...");
			System.exit(0);
		}
		this.fs=new FenShu[size][size];
		//������ֵ
		if(fs==null){
			for(int i=0;i<size;i++){
				for(int j=0;j<size;j++){
					this.fs[i][j]=new FenShu();
				}
			}
		}else{
			for(int i=0;i<size;i++){
				for(int j=0;j<size;j++){
					this.fs[i][j]=new FenShu(fs[i][j]);
				}
			}
		}
	}
	
	public FenShu det(){	//������ʽ��ֵ���ݹ��㷨
		if(this.size==1){	//�ݹ��������
			return this.fs[0][0];
		}else{
			Matrix zimx[]=new Matrix[this.size];	//����ʽ
			FenShu refs=new FenShu();	//��a00��a0k�Ĵ�������ʽ��ֵ����a0i�Ľ��
			FenShu refst=new FenShu();	//a0k�Ĵ�������ʽ��ֵ
			for(int k=0;k<this.size;k++){	//a0k�Ĵ�������ʽ
				FenShu fs[][]=null;
				zimx[k]=new Matrix(this.size-1,fs);	//�洢a0k������ʽ
				for(int i=1;i<this.size;i++){	//��������ʽ
					for(int j=0;j<this.size;j++){
						if(j<k){
							zimx[k].fs[i-1][j]=new FenShu(this.fs[i][j]);
						}else if(j>k){
							zimx[k].fs[i-1][j-1]=new FenShu(this.fs[i][j]);
						}
					}
				}
				FenShu.mul(zimx[k].det(), this.fs[0][k], refst);	//�õ�a0j*a0j������ʽ��ֵ
				refst.fz*=(k%2==0?1:-1);		//�õ�a0j*a0j�Ĵ�������ʽ��ֵ
				FenShu.add(refs, refst, refs);	//��a0j*a0j�Ĵ�������ʽ��ֵ�ӵ������
			}
			return refs;
		}
	}
	
	public Matrix inv(){		//�������棬���ù�ʽA�������=A�İ������/det(A)
		FenShu det=new FenShu(this.det());	//��������ʽ��ֵ
		if(det.fz==0){						//�ж��Ƿ����
			System.out.println("����ʽΪ0��������");
			System.exit(0);
		}
		Matrix invmx=new Matrix(this.size, null);		//�����
		invmx.fs=new FenShu[this.size][this.size];		//����������ֵ
		Matrix bsmx=new Matrix(this.size-1, null);		//��ʱ�������ڼ����������ʽ
		bsmx.fs=new FenShu[this.size-1][this.size-1];
		for(int i=0;i<this.size;i++){
			for(int j=0;j<this.size;j++){
				//���aij���������ʽ������ʽ��ֵAij*
				for(int m=0;m<this.size;m++){
					for(int n=0;n<this.size;n++){
						if(m<j){
							if(n<i){
								bsmx.fs[m][n]=new FenShu(this.fs[m][n]);
							}else if (n>i) {
								bsmx.fs[m][n-1]=new FenShu(this.fs[m][n]);
							}
						}else if (m>j) {
							if(n<i){
								bsmx.fs[m-1][n]=new FenShu(this.fs[m][n]);
							}else if (n>i) {
								bsmx.fs[m-1][n-1]=new FenShu(this.fs[m][n]);
							}
						}
					}
				}
				FenShu temp=new FenShu(bsmx.det());		//��Mij*
				temp.fz*=((i+j)%2==0?1:-1);				//��Aij*
				invmx.fs[i][j]=new FenShu();			//�洢������ijԪ��
				FenShu.dpt(temp, det, invmx.fs[i][j]);	//�õ�Aij*/detM
			}
		}
		return invmx;
	}
	
	public void print(){	//��ӡ����
		for(int i=0;i<this.size;i++){
			for(int j=0;j<this.size;j++){
				this.fs[i][j].print();
				System.out.print("\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		while(true){
			//�½�����
			System.out.println("��������ʽ�ĳ���");
			int size=sc.nextInt();
			System.out.println("��������ʽ");
			FenShu[][] fs=new FenShu[size][size];
			for(int i=0;i<size;i++){
				for(int j=0;j<size;j++){
					fs[i][j]=new FenShu(sc.nextInt(),1);
				}
			}
			Matrix mx=new Matrix(size, fs);
			System.out.println("����ʽ�������");
			//ѡ����������ܺ��������У�
			cal:while(true){
				System.out.println("�������");
				System.out.println("1.������ʽ��ֵ");
				System.out.println("2.������ʽ����");
				System.out.println("3.�鿴����ʽ");
				System.out.println("4.������������ʽ");
				System.out.println("q.�˳�");
				String st=sc.next();
				switch (st.charAt(st.length()-1)) {
				case '1':mx.det().print();System.out.println();break;
				case '2':mx.inv().print();break;
				case '3':mx.print();
				case 'r':break cal;
				case 'q':System.exit(0);
				default:break;
				}
			}
		}
	}

}
class FenShu{	//�����Ĵ洢
	int fz,fm;	//���ӣ���ĸ
	public FenShu(){
		this.fz=0;
		this.fm=1;
	}
	public FenShu(int fz,int fm){
		this.fz=fz;
		this.fm=fm;
	}
	public FenShu(FenShu fs){
		this.fz=fs.fz;
		this.fm=fs.fm;
	}
	public int gcd(int a,int b){	//շת�������ab�����Լ��
		if(a*b==0){
			return 1;
		}else {
			int c;
			if(a<b){
				c=a;
				a=b;
				b=c;
			}
			while(a%b!=0){
				c=a%b;
				a=b;
				b=c;
			}
			return b;
		}
	}
	public void yuefen(){	//�Է���Լ��
		int c=gcd(this.fm,this.fz);
		this.fz/=c;
		this.fm/=c;
		this.fz=(this.fm<0?-this.fz:this.fz);
		this.fm=(this.fz!=0?(this.fm<0?-this.fm:this.fm):1);
	}
	public static void add(FenShu a,FenShu b,FenShu c){		//�ӷ�
		c.fz=a.fz*b.fm+b.fz*a.fm;
		c.fm=a.fm*b.fm;
		c.yuefen();
	}
	public static void rdc(FenShu a,FenShu b,FenShu c){		//����
		FenShu.add(a, new FenShu(-b.fz, b.fm), c);
	}
	public static void mul(FenShu a,FenShu b,FenShu c){		//�˷�
		c.fz=a.fz*b.fz;
		c.fm=a.fm*b.fm;
		c.yuefen();
	}
	public static void dpt(FenShu a,FenShu b,FenShu c){		//����
		FenShu.mul(a, new FenShu(b.fm,b.fz), c);
	}
	
	public void print(){	//��ӡ����
		if(this.fz==0){
			System.out.print("0");
		}else if(this.fm==1){
			System.out.print(fz);
		}else{
			System.out.print(fz+"/"+fm);
		}
	}
}