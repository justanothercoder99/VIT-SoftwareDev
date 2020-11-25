package pve_level1;

public class Balls {
	String name;
	int modifier;
	
	public Balls(String name, int modifier){
		this.name = name;
		this.modifier = modifier;
	}
	
	public String getName(){
		return name;
	}
	
	public int getModifier() {
		return modifier;
	}
	
}
