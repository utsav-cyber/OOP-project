public class Chance extends Square {
	public Chance(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		if(player.getTotalWalk() % 2 == 0){
			extracted(player);
			player.getMoney().addMoney(500);
		}
		 else{
			Imp.display(player, player.getName() + " is at Chance for the odd number of times... losing 500 money");
		    player.getMoney().substractMoney(500);
	}  
  }

	private void extracted(Player player) {
		Imp.display(player, player.getName() + " is at Chance for the even number of times... Getting 500 money");
	}
}