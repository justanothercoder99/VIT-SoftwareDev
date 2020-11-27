package pve_level1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class BallList {
	static int totalBalls = 6;
	static Balls ballList[] = new Balls[totalBalls];
	static Properties values = new Properties();
	
	Random rand = new Random();
	
	public void populateBalls() throws IOException {
		FileInputStream ip = new FileInputStream("src//pve_level1//config.properties");
		values.load(ip);
		String[] ballsval = values.getProperty("BallList").split("; ");
		totalBalls = ballsval.length;
		ballList = new Balls[totalBalls];
		for(int i=0; i<totalBalls; i++) {
			String[] ballname = ballsval[i].split(",");
			
			Balls temp = new Balls(ballname[0], Integer.parseInt(ballname[1]));
			ballList[i] = temp;
		}
	}
	
	public double getupdatedModifier(Balls ball,boolean trait){
		double bmod = ball.getModifier();
		if(trait && (ball.name.equals("Fulltoss") ||  ball.name.equals("Yorker")||ball.name.equals("In-Swinger")))
			bmod = bmod*1.2;
		if(!trait && (ball.name.equals("Bouncer") ||  ball.name.equals("Out-Swinger")))
			bmod = bmod*1.2;
		return bmod;
	}
	
	public Balls GetRandomBall(){
		int max = ballList.length-1;
		int min = 0;
		int ball = rand.nextInt((max - min) + 1) + min;
		
		return ballList[ball];
	}
}
