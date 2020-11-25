package pve_level1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
