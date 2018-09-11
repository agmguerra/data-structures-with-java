public class Room extends MapSite {

	public int roomNumber;
	public Wall[] sides;
	public MapSite[] mapsites;
	
	
	public Room() {
		sides = new Wall[10];
	}
	
	public Wall getSide(int num) {
		return sides[num];
	}

	public void setSide(int num, Wall wall) {
		sides[num] = wall;
	}
}
