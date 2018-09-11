
public class Maze {

	public Room[] rooms;
	
	public Maze() {
		rooms = new Room[10];
	}

	public void addRoom(Room room) {
		int ind = rooms.length + 1;
		rooms[ind] = room;
	}
	
}
