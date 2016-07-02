package chap9;
@SuppressWarnings("serial")
class IllegalScoreException extends Exception{
	IllegalScoreException(){
		
	}
	IllegalScoreException(String msg){
		//调用父类的构造方法
		super(msg);
	}
}
public class Score {

	public static void main(String[] args) {
		try{
			String level=null;
			level=scoreLevel(90);
			System.out.println("90分的成绩等级为："+level);
			level=scoreLevel(120);
			System.out.println("120分的成绩等级为："+level);
			
		}
		catch(IllegalScoreException e){
			e.printStackTrace();
		}
	}
	static String scoreLevel(int score)throws IllegalScoreException{
		if(score>=85&&score<=100)
			return "A";
		else if(score>=75&&score<85)
			return "B";
		else if(score>=60&&score<75)
			return "C";
		else if(score<60&&score>=0)
			return "D";
		else
			throw new IllegalScoreException("非法的分数");
	}
}
