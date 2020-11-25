package pve_level1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ShotList {
	static int totalShots = 10;
	static Shots shotList[] = new Shots[totalShots];
	Properties values = new Properties();
	
	public void populateShots() {
		shotList[0] = new Shots("Defend        ", 5, 0);
		shotList[1] = new Shots("Run           ", 7, 1);
		shotList[2] = new Shots("Run Fast      ", 6, 2);
		shotList[3] = new Shots("Cover Drive   ", 7, 2);
		shotList[4] = new Shots("On Drive      ", 5, 2);
		shotList[5] = new Shots("Straight Drive", 6, 2);
		shotList[6] = new Shots("Square Cut    ", 7, 4);
		shotList[7] = new Shots("Pull          ", 8, 4);
		shotList[8] = new Shots("Hook          ", 7, 6);
		shotList[9] = new Shots("Helicopter    ", 8, 6);
	}
	
	public String getShotList(Balls ball) throws IOException {
		String ret = "";
		Probability p = new Probability();
		Properties values = new Properties();
		FileInputStream ip = new FileInputStream("src//pve_level1//config.properties");
		values.load(ip);
		String[] shotsval = values.getProperty(ball.getName()).split(", ");
		Shots[] s = new Shots[shotsval.length];
		for(int i = 0;i<shotsval.length;i++){
			s[i] = getShot(shotsval[i]);
			
		}
		for(int i=0; i<s.length-1; i++) {
			ret += s[i].getName() +"\t"+ s[i].getRuns() +"\t"+ 
					p.calculateProbability(ball.getModifier(), s[i].getModifier());
			ret += "\n";
		}
		ret += s[s.length-1].getName() +"\t"+ s[s.length-1].getRuns() +"\t"+ 
				p.calculateProbability(ball.getModifier(), s[s.length-1].getModifier());
		return ret;
	}
	
	public Shots getShot(String name) {
		Shots s = null;
		for(int i=0; i<totalShots; i++) {
			if(shotList[i].getName().trim().equals(name)) {
				s = shotList[i];
				break;
				
			}
			
		}
		return s;
	}
}
