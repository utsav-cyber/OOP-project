import java.util.Random;


public class Dice {

public int getdiceValue() {
		Random rand = new Random();
		int diceValue = 1+rand.nextInt(6);
	return diceValue;
	}
}

// public class Dice extends Thread{

// 	int diceValue;
// 	public Dice(int i){
// 		this.i = i; 
// 	}
	
// 	public void run(){
// 		try{
// 			System.out.println(diceValue);
// 		}
// 		catch (Exception e)
// 		{System.out.println("Exception ");
// 	}
// 	}
	
// 	public class test{
// 		public static void main(String[] args){
// 		 Dice[] die = new Dice[6];
// 		 Arrylist<integer> list = new Arraylist<integer>();
// 		 for( int k =1 ; k <= 6 ; k++){
// 			 list.add(k);
// 		 }
// 		 Collection.shuffle.list ;
// 		 }
// 		 for( int j =1 ; j <= 6 ; j++){
// 			 die[j] = new Dice(list.get(j);
// 			 die[j].start();
// 		 }
// 		}
// 	}

//Sir, we tried to get dice output using multithreading and stop it after implementing one thread 
// everytime but we were unable to use return datatype while using multithreading. Also running 
// each player on different thread seems illogical as player get their turn in a structured manner rather than random manner.
	
	

