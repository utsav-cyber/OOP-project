import java.util.Random;

public class FreeParking extends Square {
	public FreeParking(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		Random rand = new Random();
		Square square = board.ChangePlayerPosition(player, rand.nextInt(board.getTotalSquare()), false);
		displayInfo(player, square);
	}

	private void displayInfo(Player player, Square square) {
		Imp.display(player, player.getName() + " has go to vacation at " + square.getName());
	}
}
