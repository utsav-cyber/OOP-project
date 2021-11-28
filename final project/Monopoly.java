import java.util.Scanner;

public class Monopoly {
	Dice diceValue = new Dice();
	Board board;
	
	public Monopoly(int totalPlayer) {
		board = new Board(totalPlayer);
	}
	public static void main(String[] args) {
		System.out.println("\tMonopoly\n");
		Scanner scanner = new Scanner(System.in);
		int totalPlayer = 0;
		while (totalPlayer < 2 || totalPlayer > 8) {
			try {
				System.out.println("Enter the number of Players?");
				System.out.print("Players (2 - 8): ");
				totalPlayer = scanner.nextInt();
			}
			catch(Exception e) {
				System.err.println("Error: Number too large.");
				continue;
			}
			if(totalPlayer > 8) {
				System.err.println("Error: Invalid player count.");
			}
		}
		scanner.close();
		Monopoly game = new Monopoly(totalPlayer);
		game.startGame();
	}
	
	public void startGame() {
		System.out.println("Here the Game begins!");
		System.out.println("======");
		while (!GameOver() && !board.Alreadywon()){
			if(!board.getCurrentPlayer().bankRupt()){
				int face = board.getCurrentPlayer().tossDie(diceValue);
				board.ChangePlayerPosition(board.getCurrentPlayer(), face);
			}
			board.nextTurn();
		}
		System.out.println("=====");
		if(board.Alreadywon()){
			System.out.println(board.getWinner().getName() + " has won because all other players became bankrupt!");
		}else{
			System.out.println(board.RichestPlayer().getName() + "has won by accumulating the most money!");
		}
		System.out.println("Game over!");
	}
	
	public boolean GameOver() {
		for(Player player:board.getPlayers()){
			if(player.getTotalWalk() < 20){ return false; }
		}
		return true;
	}
}
