public class CommunityChest extends Square {
	public CommunityChest(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		if(player.getTotalWalk() % 2 == 0){
			Imp.display(player, player.getName() + " is at CommunityChest for the even number of times... losing 500 money");
			player.getMoney().substractMoney(500);
		}
		 else{
			Imp.display(player, player.getName() + " is at CommunityChest for the odd number of times... gaining 500 money");
			player.getMoney().addMoney(500);
	}  
  }
}