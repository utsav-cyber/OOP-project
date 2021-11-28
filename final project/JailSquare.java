public class JailSquare extends Square {
	public JailSquare(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		extracted(player);
		player.getMoney().substractMoney(500);
	}

	private void extracted(Player player) {
		Imp.display(player, player.getName() + " has been Jail and lost 500 money");
	}
}
