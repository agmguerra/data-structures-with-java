import java.util.LinkedList;
import java.util.Queue;

public class EventAvailableCapacity {

	protected Queue<Integer> ticketsRequests;
	protected int availableCapacity;
	
	public EventAvailableCapacity(int maxCapacity) {
		this.ticketsRequests = new LinkedList<Integer>();
		this.availableCapacity = maxCapacity;
	}
	
	public void addTicketsRequests(int numPeople) {
		ticketsRequests.add(numPeople);
	}
	
	public int processUntilNoCapacity() {
		int numRequestsProcessed = 0;
		while (!ticketsRequests.isEmpty()) {
			int remainAfterRequests = (availableCapacity - ticketsRequests.peek());
			if (remainAfterRequests < 0) {
				return numRequestsProcessed;
			}
			availableCapacity -= ticketsRequests.remove();
			numRequestsProcessed++;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
