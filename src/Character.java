
public class Character {
	private final String character;
	
	public Character(char character)
	{
		this.character = new String(character + "");
	}
	
	/**
	 * Creates a new character object with the first 
	 * @param str
	 */
	public Character(String str)
	{
		character = str.substring(0, 1);
	}
	
	public Character toUpperCase()
	{
		return new Character(character.toUpperCase());
	}
	
	public Character toLowerCase()
	{
		return new Character(character.toLowerCase());
	}
	
	public boolean isUpperCase()
	{
		return character.toUpperCase().equals(character);
	}
	
	public boolean isLowerCase()
	{
		return character.toLowerCase().equals(character);
	}
	
	public String toString()
	{
		return character;
	}
	
	public boolean equals(Object other) {
		if(other == null){ return false; }
		if(other instanceof Character) {
			Character cha = (Character) other;
			return character.equals(cha.character);
		}
		if(other instanceof String) {
			return character.equals(other);
		}
		
		return false;
	}
}
