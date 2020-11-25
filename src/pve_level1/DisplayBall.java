package pve_level1;

public class DisplayBall {
	
	public Balls displayBall(int curr_score, int last_run) {
		
		BallList bl = new BallList();
		Balls ball = bl.GetRandomBall();
		ShotList sl = new ShotList();
		
		System.out.println("Current Score is \t" +curr_score);
		System.out.println("Runs on last ball\t" +last_run);
		System.out.println("Current ball     \t" +ball.getName());
		
		System.out.println("------------------------------");
		
		System.out.println("Possible Shots:   \n");
		System.out.println(sl.getShotList(ball.getModifier()));
		
		System.out.println("------------------------------");
		System.out.println("Choose a shot");
		return ball;
	}
}
