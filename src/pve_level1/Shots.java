package pve_level1;

public class Shots {
	String name;
	int modifier;
	int runs;
	
	public Shots(String name, int modifier, int runs){
		this.name = name;
		this.modifier = modifier;
		this.runs = runs;
	}
	
	public String getName() {
		return name;
	}
	
	public int getModifier() {
		return modifier;
	}
	
	public int getRuns() {
		return runs;
	}
}
