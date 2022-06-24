import java.awt.Point;
import java.util.ArrayList;

public class Connection {
	
	private static ArrayList<Connection> connections;
	
	private Node n0, n1;
	private Character color;
	private Point center;
	
	/**
	 * Pu
	 * @param n1
	 * @param color
	 * @return
	 */
	public static boolean pushConnection(Node n1, Character color) {
		if (connections == null) {
			connections = new ArrayList<Connection>();
		}
		if (n1 == null) {
			return false;
		}
		Connection old = connections.get(connections.size() - 1);
		Connection connection = new Connection(old.n1, n1, color);
		for(Connection con : connections) {
			if(connection.conflictsWith(con)) {
				return false;
			}
		}
		connections.add(connection);
		return true;
	}
	
	/**
	 * Checks if the given node can be pushed onto the 
	 * @param n1 the node to check
	 * @return true if it can be pushed false if it can't
	 */
	public static boolean pushConnection(Node n1) {
		if(connections == null) {
			connections = new ArrayList<Connection>();
		}
		if(n1 == null) {
			return false;
		}
		if(connections.size() == 0) {
			//Node.originNodes;
		}
		return false;
	}
	
	public static Connection pop() {
		connections.remove(connections.size() - 1);
		return connections.get(connections.size() - 1);
	}
	
	private Connection(Node n0, Node n1, Character color) {
		this.n0 = n0;
		this.n1 = n1;
		this.color = color;
		center = new Point();
		center.x = (n0.x() + n1.x())/2;
		center.y = (n0.x() + n1.x())/2;
	}
	
	public Character color()
	{
		return color;
	}
	
	public boolean conflictsWith(Connection other) {
		return this.center.equals(other.center);
	}
}
