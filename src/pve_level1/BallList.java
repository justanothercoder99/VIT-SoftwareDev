package pve_level1;

import java.util.Random;

public class BallList {
	static int totalBalls = 6;
	static Balls ballList[] = new Balls[totalBalls];
	
	Random rand = new Random();
	
	public void populateBalls() {
		ballList[0] = new Balls("Full toss", 4);
		ballList[1] = new Balls("Yorker", 3);
		ballList[2] = new Balls("Out-swinger", 3);
		ballList[3] = new Balls("In-Swinger", 2);
		ballList[4] = new Balls("Bouncer", 4);
		ballList[5] = new Balls("Slower Ball", 2);
	}
	
	public Balls GetRandomBall(){
		int max = ballList.length-1;
		int min = 0;
		int ball = rand.nextInt((max - min) + 1) + min;
		
		return ballList[ball];
	}
}
