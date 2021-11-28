public class GoToJailSquare extends Square {
	public GoToJailSquare(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		Imp.display(player, player.getName() + " has go to Jail");
		board.ChangePlayerPosition(player, -board.getTotalSquare() / 2, false);
	}
}
