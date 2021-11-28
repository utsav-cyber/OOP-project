public class Imp
 {
	public static void display(Player player, String msg) {
		System.out.println("[Turn " + (player.getTotalWalk() + 1) + "] [" + player.getPosition() + "] [$" + player.getMoney().getMoney() + "] " + msg);
	}
}
