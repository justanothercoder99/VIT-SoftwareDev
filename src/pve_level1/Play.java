package pve_level1;

import java.util.Scanner;

public class Play {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 0;
		int last_run = 0;
		int overs = 1;
		String shot = "";
		
		Probability p = new Probability();
		BallList bl = new BallList();
		ShotList sl = new ShotList();
		
		bl.populateBalls();
		sl.populateShots();
		
		Scanner sc = new Scanner(System.in);
		
		
		DisplayBall db = new DisplayBall();
		
		for(int i=0; i<overs*6; i++) {
			Balls b = db.displayBall(score, last_run);
			shot = sc.nextLine();
			Shots s = sl.getShot(shot);
			if(s == null) {
				System.out.println("Illegal shot! You missed!!");
				last_run = 0;
				continue;
			}
			last_run = p.calculateRuns(b, s);
			if(last_run == 0) {
				System.out.println("You missed!");
			}
			else {
				System.out.println("You hit a "+last_run);
			}
			score += last_run;
		}
		
		System.out.println("Your final score is "+score);
		
		sc.close();
	}

}
