package pve_level1;

import java.util.*;

public class Probability {
	Random rand = new Random();
	
	public double calculateProbability(double ballMod, double shotMod) {
		return (((shotMod-ballMod) * 100)/shotMod);
	}
	
	public int calculateRuns(Balls ball, Shots shot) {
		int runs = (int) calculateProbability(ball.getModifier(), shot.getModifier());
		int success = rand.nextInt(100 + 1);
		if(success <= runs) {
			return shot.getRuns();
		}
		else {
			return 0;
		}
	}
}
