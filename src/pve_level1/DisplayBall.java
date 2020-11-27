package pve_level1;

import java.io.IOException;

public class DisplayBall {
	
	public void displayBall(int curr_score, int last_run, Balls ball, ShotList sl,Bowlers b, Batsman b1) throws IOException {
				
		System.out.println("Current Score is \t" +curr_score);
		System.out.println("Runs on last ball\t" +last_run);
		System.out.println("Current batsman  \t" +b1.name);
		System.out.println("Current ball     \t" +ball.getName());
		System.out.println("Current bowler   \t" +b.name);
		
		System.out.println("------------------------------");
		
		System.out.println("Possible Shots:   \n");
		System.out.println(sl.getShotList(ball,b, b1));
		
		System.out.println("------------------------------");
		System.out.println("Choose a shot");
	}
}
