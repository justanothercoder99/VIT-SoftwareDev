package pve_level1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Play {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties values = new Properties();
		FileInputStream ip = new FileInputStream("src//pve_level1//config.properties");
		values.load(ip);
		
		int score = 0;
		int last_run = 0;
		int overs = Integer.parseInt(values.getProperty("match.total.overs"));
		String shot = "";
		
		Probability p = new Probability();
		BallList bl = new BallList();
		ShotList sl = new ShotList();
		BowlerList b = new BowlerList();
		BatsmanList bll = new BatsmanList();
		
		b.populatebowlers();
		bl.populateBalls();
		sl.populateShots();
		bll.populatebatsmans();
		
		Bowlers[] bowlers = b.getRandomBowlingOrder(overs);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Select 2 batsmen");
		new BatsmanList().display();
		Batsman b1 = new BatsmanList().getBatsman(sc.nextLine());
		Batsman b2 = new BatsmanList().getBatsman(sc.nextLine());
		Batsman cur_bat = b1;
		
		DisplayBall db = new DisplayBall();
		
		for(int i=0; i<overs*6; i++) {
			Balls ball = bl.GetRandomBall();
			db.displayBall(score, last_run, ball, sl,bowlers[i/6], cur_bat);
			shot = sc.nextLine();
			Shots s = sl.getShot(shot);
			if(s == null) {
				System.out.println("Illegal shot! You missed!!");
				last_run = 0;
				System.out.println();
				System.out.println();
				continue;
			}
			last_run = p.calculateRuns(ball, s);
			if(last_run == 0) {
				System.out.println("You missed!");
			}
			else {
				System.out.println("You hit a "+last_run);
			}
			System.out.println();
			System.out.println();
			score += last_run;
			if(last_run%2 == 1 ^ (i+1)%6==0) {
				if(cur_bat == b1) {
					cur_bat = b2;
				}
				else {
					cur_bat = b1;
				}
			}
		}
		
		System.out.println("Your final score is "+score);
		
		sc.close();
	}

}
