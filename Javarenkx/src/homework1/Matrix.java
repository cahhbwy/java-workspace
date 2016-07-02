package homework1;

import java.util.Scanner;

public class Matrix {
	static Scanner sc=new Scanner(System.in);

	int size;			//矩阵的长度
	FenShu[][] fs;		//矩阵的每一个数值，以分数存储
	
	public Matrix(int size,FenShu fs[][]){	//new方法，需要size和矩阵具体数值
		this.size=size;
		if(size<=0){		//size<0的情况
			System.out.println("size must be 1,2,3...");
			System.exit(0);
		}
		this.fs=new FenShu[size][size];
		//给矩阵赋值
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
	
	public FenShu det(){	//求行列式的值，递归算法
		if(this.size==1){	//递归结束条件
			return this.fs[0][0];
		}else{
			Matrix zimx[]=new Matrix[this.size];	//余子式
			FenShu refs=new FenShu();	//从a00到a0k的代数余子式的值乘以a0i的结果
			FenShu refst=new FenShu();	//a0k的代数余子式的值
			for(int k=0;k<this.size;k++){	//a0k的代数余子式
				FenShu fs[][]=null;
				zimx[k]=new Matrix(this.size-1,fs);	//存储a0k的余子式
				for(int i=1;i<this.size;i++){	//建立余子式
					for(int j=0;j<this.size;j++){
						if(j<k){
							zimx[k].fs[i-1][j]=new FenShu(this.fs[i][j]);
						}else if(j>k){
							zimx[k].fs[i-1][j-1]=new FenShu(this.fs[i][j]);
						}
					}
				}
				FenShu.mul(zimx[k].det(), this.fs[0][k], refst);	//得到a0j*a0j的余子式的值
				refst.fz*=(k%2==0?1:-1);		//得到a0j*a0j的代数余子式的值
				FenShu.add(refs, refst, refs);	//把a0j*a0j的代数余子式的值加到结果中
			}
			return refs;
		}
	}
	
	public Matrix inv(){		//求矩阵的逆，利用公式A的逆矩阵=A的伴随矩阵/det(A)
		FenShu det=new FenShu(this.det());	//计算行列式的值
		if(det.fz==0){						//判断是否可逆
			System.out.println("行列式为0，不可逆");
			System.exit(0);
		}
		Matrix invmx=new Matrix(this.size, null);		//逆矩阵
		invmx.fs=new FenShu[this.size][this.size];		//逆矩阵里的数值
		Matrix bsmx=new Matrix(this.size-1, null);		//临时矩阵，用于计算代数余子式
		bsmx.fs=new FenShu[this.size-1][this.size-1];
		for(int i=0;i<this.size;i++){
			for(int j=0;j<this.size;j++){
				//针对aij求代数余子式的行列式的值Aij*
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
				FenShu temp=new FenShu(bsmx.det());		//求Mij*
				temp.fz*=((i+j)%2==0?1:-1);				//求Aij*
				invmx.fs[i][j]=new FenShu();			//存储逆矩阵的ij元素
				FenShu.dpt(temp, det, invmx.fs[i][j]);	//得到Aij*/detM
			}
		}
		return invmx;
	}
	
	public void print(){	//打印矩阵
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
			//新建矩阵
			System.out.println("输入行列式的长度");
			int size=sc.nextInt();
			System.out.println("输入行列式");
			FenShu[][] fs=new FenShu[size][size];
			for(int i=0;i<size;i++){
				for(int j=0;j<size;j++){
					fs[i][j]=new FenShu(sc.nextInt(),1);
				}
			}
			Matrix mx=new Matrix(size, fs);
			System.out.println("行列式输入完毕");
			//选择操作（功能后续开发中）
			cal:while(true){
				System.out.println("输入操作");
				System.out.println("1.求行列式的值");
				System.out.println("2.求行列式的逆");
				System.out.println("3.查看行列式");
				System.out.println("4.重新输入行列式");
				System.out.println("q.退出");
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
class FenShu{	//分数的存储
	int fz,fm;	//分子，分母
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
	public int gcd(int a,int b){	//辗转相除法求ab的最大公约数
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
	public void yuefen(){	//对分数约分
		int c=gcd(this.fm,this.fz);
		this.fz/=c;
		this.fm/=c;
		this.fz=(this.fm<0?-this.fz:this.fz);
		this.fm=(this.fz!=0?(this.fm<0?-this.fm:this.fm):1);
	}
	public static void add(FenShu a,FenShu b,FenShu c){		//加法
		c.fz=a.fz*b.fm+b.fz*a.fm;
		c.fm=a.fm*b.fm;
		c.yuefen();
	}
	public static void rdc(FenShu a,FenShu b,FenShu c){		//减法
		FenShu.add(a, new FenShu(-b.fz, b.fm), c);
	}
	public static void mul(FenShu a,FenShu b,FenShu c){		//乘法
		c.fz=a.fz*b.fz;
		c.fm=a.fm*b.fm;
		c.yuefen();
	}
	public static void dpt(FenShu a,FenShu b,FenShu c){		//除法
		FenShu.mul(a, new FenShu(b.fm,b.fz), c);
	}
	
	public void print(){	//打印分数
		if(this.fz==0){
			System.out.print("0");
		}else if(this.fm==1){
			System.out.print(fz);
		}else{
			System.out.print(fz+"/"+fm);
		}
	}
}