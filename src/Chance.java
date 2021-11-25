public class Chance extends Square {
	public Chance(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		if(player.getTotalWalk() % 2 == 0){
			Util.print(player, player.getName() + " is at Chance for the even number of times... Getting 500 money");
			player.getMoney().addMoney(500);
		}
		 else{
			Util.print(player, player.getName() + " is at Chance for the odd number of times... losing 500 money");
		    player.getMoney().substractMoney(500);
	}  
  }
}