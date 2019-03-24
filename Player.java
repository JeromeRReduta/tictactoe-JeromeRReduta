/* Jerome Reduta

To do:
1) Create instance data - name, wins, losses
2) Make Constructor - input playerName
3) Make methods:
	getters and setters for: name, wins, losses
	toString()
	win()
	lose()
*/

public class Player {
	// INSTANCE DATA: name, wins, losses
	private String name;
	private int wins = 0;
	private int losses = 0;
	private int ties = 0;


	//CONSTRUCTOR
	public Player(String playerName)
	{
		name = playerName;
	}

	// METHODS
	// getName(), setName(), getWins(), getLosses(), toString(), etc
	
	// Adds a win to Player
	public void win()
	{
		wins += 1;
	}

	// Adds a loss to player
	public void lose()
	{
		losses += 1;
	}

	public void tie()
	{
		ties += 1;
	}

	// Getters and setters
	/* Changeable:
			Name
			Wins
			Losses
			Ties
		Not changeable:
			N/A
	*/

	public String getName()
	{
		return name;
	}

	public void setName(String playerName)
	{
		name = playerName;
	}

	public int getWins()
	{
		return wins;
	}

	// Note: Wins and losses cannot be negative
	public void setWins(int inputWins)
	{
		if (inputWins >= 0) {
			wins = inputWins;
		} 
	}

	public int getLosses()
	{
		return losses;
	}

	public void setLosses(int inputLosses)
	{
		if (inputLosses >= 0) {
			losses = inputLosses;
		}
	}

	public int getTies()
	{
		return ties;
	}

	public void setTies(int inputTies)
	{
		if (inputTies >= 0) {
			ties = inputTies;
		}
	}

	public String toString()
	{
		return "Player " + name + " - W/L/T: " + wins + "/" + losses + "/" + ties;
	}

	// Demo
	/*public static void main(String[] args)
	{
		Player a = new Player("A");
		System.out.println(a);
		a.setLosses(2);
		System.out.println(a);
		a.setLosses(-1);
		a.win();
		a.lose();
		System.out.println(a);
	} */
}
