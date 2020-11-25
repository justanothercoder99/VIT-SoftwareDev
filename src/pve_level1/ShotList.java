package pve_level1;

public class ShotList {
	static int totalShots = 10;
	static Shots shotList[] = new Shots[totalShots];
	
	public void populateShots() {
		shotList[0] = new Shots("Defend        ", 5, 0);
		shotList[1] = new Shots("Run           ", 7, 1);
		shotList[2] = new Shots("RunFast       ", 6, 2);
		shotList[3] = new Shots("Cover Drive   ", 7, 2);
		shotList[4] = new Shots("On Drive      ", 5, 2);
		shotList[5] = new Shots("Straight Drive", 6, 2);
		shotList[6] = new Shots("Square Cut    ", 7, 4);
		shotList[7] = new Shots("Pull          ", 8, 4);
		shotList[8] = new Shots("Hook          ", 7, 6);
		shotList[9] = new Shots("Helicopter    ", 8, 6);
	}
	
	public String getShotList(int bmod) {
		String ret = "";
		Probability p = new Probability();
		for(int i=0; i<totalShots-1; i++) {
			ret += shotList[i].getName() +"\t"+ shotList[i].getRuns() +"\t"+ 
					p.calculateProbability(bmod, shotList[i].getModifier());
			ret += "\n";
		}
		ret += shotList[totalShots-1].getName() +"\t"+ shotList[totalShots-1].getRuns() +"\t"+ 
				p.calculateProbability(bmod, shotList[totalShots-1].getModifier());
		return ret;
	}
	
	public Shots getShot(String name) {
		Shots s = null;
		for(int i=0; i<totalShots; i++) {
			if(shotList[i].getName().trim().equals(name)) {
				s = shotList[i];
			}
		}
		return s;
	}
}
