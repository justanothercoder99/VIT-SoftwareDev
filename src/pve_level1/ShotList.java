package pve_level1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ShotList {
	static int totalShots;
	static Shots shotList[];
	static Properties values = new Properties();
	
	public void populateShots() throws IOException {
		FileInputStream ip = new FileInputStream("src//pve_level1//config.properties");
		values.load(ip);
		String[] shotsval = values.getProperty("ShotList").split("; ");
		totalShots = shotsval.length;
		shotList = new Shots[totalShots];
		for(int i=0; i<totalShots; i++) {
			String[] shotname = shotsval[i].split(",");
			
			int name_len = shotname[0].length();
			for(int j=0; j<15-name_len; j++) {
				shotname[0]+=" ";
			}
			
			Shots temp = new Shots(shotname[0], Integer.parseInt(shotname[1]), Integer.parseInt(shotname[2]));
			shotList[i] = temp;
		}
	}
	
	public String getShotList(Balls ball) throws IOException {
		String ret = "";
		Probability p = new Probability();
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
