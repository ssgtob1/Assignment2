package diceGame;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DiceGame {

	public static void main(String[] args) {
		//Init Variables Needed For Tracking
		int maxScoreSingleDie = 0;
		int minScoreSingleDie = 0;
		int totRollsSingleDie = 0;
		int maxScoreDoubleDie = 0;
		int minScoreDoubleDie = 0;
		int totRollsDoubleDie = 0;
		//Using Example of RNG
		long seed = new Date().getTime();
		Random rnd = new Random(seed);
		//Loop through the game 100 times
		for (int i = 0; i < 100; i++){
			//keep track of total rolls in case loop is changed
			totRollsSingleDie = i + 1;
			//create new dice roll
			DiceRoll dr = new DiceRoll();
			//get results from the dice rolls
			int currentScore = dr.rollOneDie(rnd);
			//Calculate the min and max scores for all of the rolls
			if (minScoreSingleDie == 0 && currentScore != 0){
				minScoreSingleDie = currentScore;
			}else{
			if (minScoreSingleDie > currentScore){
				minScoreSingleDie = currentScore;
			}
			
				
			}
			if(maxScoreSingleDie < currentScore){
				maxScoreSingleDie = currentScore;
			}
						
		}
		//Two dice game using same methods as above 
		for (int i = 0; i < 100; i++){
			totRollsDoubleDie = i + 1;
			DiceRoll dr = new DiceRoll();
			int currentScore = dr.rollTwoDice();
			if (minScoreDoubleDie == 0 && currentScore != 0){
				minScoreDoubleDie = currentScore;
			}else{
			if (minScoreDoubleDie > currentScore){
				minScoreDoubleDie = currentScore;
			}
			
				
			}
			if(maxScoreDoubleDie < currentScore){
				maxScoreDoubleDie = currentScore;
			}
			
		}
		//Print results of both games
		System.out.printf("A single die was rolled %d times\n", totRollsSingleDie);
		System.out.printf("The maximum score was: %d\n", maxScoreSingleDie);
		System.out.printf("The minimum score was: %d\n", minScoreSingleDie);
		System.out.printf("Two dice were rolled %d times\n", totRollsDoubleDie);
		System.out.printf("The maximum score was: %d\n", maxScoreDoubleDie);
		System.out.printf("The minimum score was: %d\n", minScoreDoubleDie);
	}
	



}

class DiceRoll {
	
	
	
	
	//Roll one die game
	public int rollOneDie(Random rnd){
		int currentRoll;
		int total = 0;
		int x = 0;
		while (x != 1){
		currentRoll = rnd.nextInt(6) + 1;
		if (currentRoll == 1){
			x = 1;
		}
		else {
			total += currentRoll;
			
		}
	}
	
	return total;
	
	}
	//roll two dice game
	public int rollTwoDice(){
		int currentRollDie1 = 0;
		int currentRollDie2 = 0;
		int x = 0;
		int total  = 0;
		int dieCombined = 0;
		while (x!=1){
			currentRollDie1 = ThreadLocalRandom.current().nextInt(1, 6 + 1);
			currentRollDie2 = ThreadLocalRandom.current().nextInt(1, 6 + 1);
			dieCombined = currentRollDie1 + currentRollDie2;
			if (dieCombined == 7){
				return total;
			}
			else{
				total += dieCombined;
			}
			
		}
		return total;
		
		
	}
	

}

