import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//This class simulates an 8Ball called Bobby

public class Predictor {
	ArrayList<String> predictions;
	Random r;
	
	public Predictor(){
		predictions = new ArrayList<>();
		r = new Random();
		fillWithKnowledge();
	}
	
	public void fillWithKnowledge(){
		//There are 20 possible answers given by a magic 8-ball
		predictions.add("It is certain.");
		predictions.add("It is decidedly so.");
		predictions.add("Without a doubt.");
		predictions.add("Yes, definitely.");
		predictions.add("You may rely on it.");
		predictions.add("As I see it, yes.");
		predictions.add("Most likely.");
		predictions.add("Outlook good.");
		predictions.add("Yes.");
		predictions.add("Signs point to yes.");
		predictions.add("Reply hazy, try again.");
		predictions.add("Ask again later.");
		predictions.add("Better not tell you now.");
		predictions.add("Cannot predict now.");
		predictions.add("Concentrate and ask again.");
		predictions.add("Don't count on it.");
		predictions.add("My reply is no.");
		predictions.add("My sources say no.");
		predictions.add("Outlook not so good.");
		predictions.add("Very doubtful.");
	}
	
	public String shake(){
		r = new Random();
		int n = r.nextInt(20); //obtains a number between 0 and 19
		return predictions.get(n);
	}
	
	public int getIndex(String s){
		for(int i=0; i<predictions.size(); i++){
			if(s.equals(predictions.get(i))){
				return i;
			}
		}
		return (Integer) null;
	}
	
	public static void main(String[] args) throws InterruptedException{
		Predictor bobby = new Predictor(); //Bobby is born!
		Scanner scan = new Scanner(System.in);
		boolean qSeshOver = false;
		System.out.println("Hello! My name is Bobby the 8-ball. What's your name?");
		String name = scan.nextLine();
		System.out.println("Hello " + name + "! Very nice to meet you!");
		
		while(qSeshOver==false){
			System.out.println("Do you have a question for me today? Say yes or no.");
			String yesNo = scan.next();
			scan.nextLine();
			if (yesNo.equals("Yes") || yesNo.equals("yes")){
				System.out.println("What is your question? (Yes or no questions only, please!!!)");
				String q = scan.nextLine();
				System.out.println("Hmm, let me see...");
				TimeUnit.SECONDS.sleep(2);
				String ans = bobby.shake();
				int index = bobby.getIndex(ans);
				System.out.println(ans);
				if(index<=9){
					System.out.println("Good for you!");
				}else if(index>=10 && index<=14){
					System.out.println("Well, don't be discouraged, try again!");
				}else{
					System.out.println("Looks like you're shit outta luck.");
				}
			}else if(yesNo.equals("No") || yesNo.equals("no")){
				System.out.println("Ok, bye!");
				System.out.println("Have a nice day!");
				qSeshOver=true;
			}else{
				System.out.println("Could you repeat that? I couldn't understand what you said.");
			}		
		}	
	}
}
