public class GoSquare extends Square {
	public GoSquare(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		Imp.display(player, player.getName() + " Will get Reward of 1000 money");
		player.getMoney().addMoney(1000);
	}
}
