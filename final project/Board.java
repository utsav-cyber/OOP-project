import java.util.Random;

public class Board {
	int currentTurn = 0;
	int Allplayers = 0;
	Player[] players;
	Square[] squares = new Square[40];
	String[] locationNames = new String[] { "Mumbai", "Cape", "Town", "Banglore", "Chennai", "Jaipur", "Kolkata", "Chennai", "Cochin", "TamilNadu" };
	
	public Board(int Allplayers) {
		players = new Player[Allplayers];
		this.Allplayers = Allplayers;
		for(int i = 0;i < players.length;i++){
			players[i] = new Player(i, "Player " + (i + 1));
		}
		Random rand = new Random();
		for(int i = 0;i < squares.length;i++){
			if(i == 0){
				squares[i] = new GoSquare("GO");
			}else if(i == 10){
				squares[i] = new JailSquare("Jail");
			}else if(i == 20){
				squares[i] = new FreeParking("Vacation");
			}else if(i == 30){
				squares[i] = new GoToJailSquare("Go to Jail");
		    }else if(i == 7 || i == 33){
				squares[i] = new Chance("Welcome to chance");
		    }
			else if(i == 14 || i == 28){
				squares[i] = new CommunityChest("Welcome to Community Chest");
		    }
			else if(i == 5 || i == 15 || i == 25 || i == 35){
				squares[i] = new SpecialSquare("Welcome to Special Square");
		    }
			else{
				squares[i] = new HouseSquare(locationNames[rand.nextInt(locationNames.length)] + " " + locationNames[rand.nextInt(locationNames.length)], 400 + rand.nextInt(300));
			}
		}
	}
	
	public Square ChangePlayerPosition(Player player, int diceValue) {
		return ChangePlayerPosition(player, diceValue, true);
	}
	
	public Square ChangePlayerPosition(Player player, int diceValue, boolean count) {
		if(player.bankRupt()){ return squares[player.getPosition()]; }
		int newPosition = normalizePosition(player.getPosition() + diceValue);
		player.setPosition(newPosition);
		Imp.display(player, player.getName() + " goes to " + squares[player.getPosition()].getName());
		squares[newPosition].doAction(player, this);
		if(player.getMoney().bankRupt()){
			Imp.display(player, player.getName() + " PLayer is bankrupt !");
			boolean brokeout = true;
			player.setBrokeOut(brokeout);
		}else{
			if(count){
				player.nextTurn();
			}
		}
		return squares[newPosition];
	}
	
	public boolean Alreadywon() {
		int ingame = 0;
		for(Player player:players){
			if(!player.bankRupt()){
				ingame++;
			}
		}
		return ingame <= 1;
	}
	
	public Player RichestPlayer() {
		Player richestPlayer = null;
		for(Player player:players){
			if(richestPlayer == null || richestPlayer.getMoney().getMoney() < player.getMoney().getMoney()){
				richestPlayer = player;
			}
		}
		return richestPlayer;
	}

	public Player getWinner() {
		if(!Alreadywon())
		{ return null; }
		for(Player player:players){
			if(!player.bankRupt())
			{ 
				return player;
			}
		}
		return null;
	}
	
	public Player getCurrentPlayer() {
		return players[currentTurn];
	}
	
	public int normalizePosition(int position) {
		return position % squares.length;
	}
	
	public void nextTurn() {
		if(++currentTurn >= players.length){
			currentTurn = 0;
		}
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public int getTotalSquare() {
		return squares.length;
	}
	
	public Player getPlayer(int id) {
		return players[id];
	}
	
	
}
