package pve_level1;

public class BatsmanList {
	static int totalBatsman = 3;
	static Batsman batsmanList[];
	
	public void populatebatsmans() {
		batsmanList = new Batsman[totalBatsman];
		batsmanList[0] = new Batsman("Sachin",true);
		batsmanList[1] = new Batsman("Rohit",false);
		batsmanList[2] = new Batsman("Virat",true);
	}
	
	public void display() {
		for(int i=0; i<totalBatsman; i++){
			String trait = "Passive";
			if(batsmanList[i].trait) {
				trait = "Aggressive";
			}
			System.out.println(batsmanList[i].name +"\t" +trait);	
		}
	}
	
	public Batsman getBatsman(String name) {
		Batsman b = null;
		for(int i=0; i<totalBatsman; i++){
			if(batsmanList[i].name.equals(name)) {
				b = batsmanList[i];
				break;
			}
		}
		return b;
	}
	
	/*public Batsman[] getRandomBattingOrder(int overs) {
		Random rand = new Random();
		Batsman[] order = new Batsman[overs];
		int last_batsman = -1;
		for(int i = 0;i<overs;) {
			int curr_batsman = rand.nextInt(totalBatsman);
			if(curr_batsman == last_batsman)
			{
				continue;
			}
			order[i] = batsmanList[curr_batsman];
			last_batsman = curr_batsman;
			i++;
		}
		
		return order;
	}*/
}
