import java.util.*;

public class TicTacToeDriver {

	public static Player[] makePlayers(Scanner scan, Random rng) {
		Player[] players = new Player[2];

		int choice = rng.nextInt(2);

		System.out.println("Who is player 1?");
		players[choice] = new Player(scan.nextLine());

		System.out.println("Who is player 2?");
		players[1-choice] = new Player(scan.nextLine());

		System.out.println(players[0].getName() + " goes 1st.\n" + players[1].getName() + " goes 2nd.");

		return players;
	}

	public static int playGame(Scanner scan, TicTacToe board, Player[] players) {

		int loop = 0;
		int count = 0;
		while (loop == 0) {
			count = count%2;

			System.out.println("TURN " + board.getTurnNum() + ":");
			System.out.println(players)

			System.out.println(players[count].getName() + "'s")

			for (int index = 0; index < 2; index++) {
				System.out.println(players[index].getName() + "'s turn:");
				System.out.println(board + "\n");
				System.out.println("Enter row #: ");
				int rowNum = scan.nextInt();

				System.out.println("Enter column #: ");
				int colNum = scan.nextInt();

				board.changeBoard(index + 1, rowNum - 1, colNum - 1);

				loop = board.checkForEnd(index + 1);

				if (loop != 0) {
					break;
				}

				// The for loop is screwing this up - p2 can win, and it'll
				// be recorded b/c it's @ end of for loop
				// But if p1 wins, then loops to p2, and if p2 hasn't won
				// loop get reset to 0
				System.out.println(loop);
			}
			}

			board.endMessage(players, loop);

			
	
		return 1;

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random rng = new Random();

		TicTacToe board = new TicTacToe();

		Player[] players = makePlayers(scan, rng);

		playGame(scan, board, players);

		

	}
}