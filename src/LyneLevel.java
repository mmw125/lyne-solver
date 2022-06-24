import java.awt.Point;
import java.util.ArrayList;

public class LyneLevel 
{	
	public LyneLevel(ArrayList<String> list) {
		for(int y = 0; y < list.size(); y++) {
			int count = 0;
			for(int x = 0; x < list.get(y).length(); x++) {
				System.out.println("Created new node at " + count + ", " + y);
				new Node(new Character(list.get(y).charAt(x)), new Point(count * 2, y * 2));
				count++;
			}
		}
	}
	
	public void generateSolution() {
		Node currentNode = Node.getOriginNodes().get(0);
	}
	
	/**
	 * Runs trrough all of the different possible connections
	 */
	public void testNewConnections(Node currentNode, Character currentColor){
		//Check if its at the end
		if(currentNode.type() == NodeType.END) {
			if (validLine(currentColor)) {
				//Change current node and current color to the next 
			} else {
				
			}
		}
		
		tryState(currentNode, currentNode.up(), currentColor);
		tryState(currentNode, currentNode.upLeft(), currentColor);
		tryState(currentNode, currentNode.left(), currentColor);
		tryState(currentNode, currentNode.downLeft(), currentColor);
		tryState(currentNode, currentNode.down(), currentColor);
		tryState(currentNode, currentNode.downRight(), currentColor);
		tryState(currentNode, currentNode.right(), currentColor);
		tryState(currentNode, currentNode.upRight(), currentColor);
	}
	
	/**
	 * Tests if the line for the given color uses all of the colored blocks for the color 
	 * @param currentColor the color to check for
	 * @return true if it is valid
	 */
	public boolean validLine(Character currentColor)
	{
		return false;
	}
	
	public boolean validSolution()
	{
		return false;
	}
	
	public void tryState(Node currentNode, Node node, Character color)
	{
		//Check if the new node can be placed in the line
		if(node.type() == NodeType.END) {
			if (validLine(color)) {
				
			}
		}
				
		if (!Connection.pushConnection(node, color)) {

		}
	}
}
