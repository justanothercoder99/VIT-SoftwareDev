package pve_level1;

import java.util.Random;

public class BowlerList {
	static int totalBowlers = 3;
	static Bowlers bowlerList[];
	
	public void populatebowlers() {
		bowlerList = new Bowlers[totalBowlers];
		bowlerList[0] = new Bowlers("Zaheer",true);
		bowlerList[1] = new Bowlers("Jadeja",false);
		bowlerList[2] = new Bowlers("Ashwin",true);
	}
	
	public Bowlers[] getRandomBowlingOrder(int overs) {
		Random rand = new Random();
		Bowlers[] order = new Bowlers[overs];
		int last_bowler = -1;
		for(int i = 0;i<overs;) {
			int curr_bowler = rand.nextInt(totalBowlers);
			if(curr_bowler == last_bowler)
			{
				continue;
			}
			order[i] = bowlerList[curr_bowler];
			last_bowler = curr_bowler;
			i++;
		}
		
		return order;
	}
}
