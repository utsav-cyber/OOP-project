public class SpecialSquare extends Square {
	public SpecialSquare(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		Util.print(player, player.getName() + " To stay at this special place pay the rent of 1000");
		player.getMoney().substractMoney(1000);
	}
}
