import org.jetbrains.annotations.Nullable;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
	private static Map<Point, Node> nodes;
	private static Map<Character, Node> originNodes;

	public static List<Node> getOriginNodes() {
		return new ArrayList<>(originNodes.values());
	}

	public static @Nullable Node nodeAt(Point pt) {
		if(nodes == null) {
			return null;
		}
		return nodes.getOrDefault(pt, null);
	}
	
	private Character color;
	private int connectors;
	private final Point pt;
	private NodeType type;
	
	public Node(Character color, Point pt) {
		this.pt = pt;
		if(nodes == null) {
			nodes = new HashMap<>();
			originNodes = new HashMap<>();
		}
		if(color.equals(new Character("2")) || color.equals(new Character("3"))) {
			type = NodeType.COLORLESS_NODE;
			this.color = new Character(' ');
			connectors = Integer.parseInt(color.toString());
		}
		if(color.isUpperCase()) {
			this.color = color.toLowerCase();
			if (originNodes.containsKey(this.color)) {
				connectors = 1;
				type = NodeType.END;
			} else {
				connectors = 0;
				type = NodeType.START;
				originNodes.put(this.color, this);
			}
		} else {
			connectors = 1;
			this.color = color;
			type = NodeType.NODE;
		}
		nodes.put(pt, this);
	}	
	
	public int connectors() {
		return connectors;
	}
	
	public boolean compatiableWith(Character character) {
		if(character.equals(color) || character.equals(new Character(" "))) {
			return true;
		}
		return false;
	}
	
	public Character color() {
		return color;
	}
	
	public int x() {
		return pt.x;
	}
	
	public int y() {
		return pt.y;
	}
	
	public NodeType type() {
		return type;
	}
	
	public Node upLeft() {
		return nodeAt(new Point(pt.x-1, pt.y-1));
	}
	
	public Node upRight() {
		return nodeAt(new Point(pt.x+1, pt.y-1));
	}
	
	public Node downLeft() {
		return nodeAt(new Point(pt.x-1, pt.y-1));
	}
	
	public Node downRight() {
		return nodeAt(new Point(pt.x+1, pt.y-1));
	}
	
	public Node down() {
		return nodeAt(new Point(pt.x, pt.y+1));
	}
	
	public Node up() {
		return nodeAt(new Point(pt.x, pt.y-1));
	}
	
	public Node left() {
		return nodeAt(new Point(pt.x-1, pt.y));
	}
	
	public Node right() {
		return nodeAt(new Point(pt.x+1, pt.y));
	}
}
