package model;

public class Unit implements Comparable<Unit> {
	private String tipo, player;
	private int id, x, y, life, idPlayer;
	
	public Unit(){
		
	}
	
	public int getIdPlayer() {
		return idPlayer;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
		this.idPlayer = Integer.valueOf(player.replaceAll("P", ""));
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public String getString(){
		String retorno = player.concat(";");
		retorno += Integer.toString(id).concat(";") + tipo.concat(";") + Integer.toString(life).concat(";");
		retorno = retorno.concat(Integer.toString(x)).concat(";").concat(Integer.toString(y));
		
		return retorno;
	}
	
	
	public void leDadosUnidade(String dados){
		//System.out.println(dados);
		String[] split = dados.trim().split(" ");
		setPlayer(split[0]);
		setId(Integer.valueOf(split[1]));
		setLife(Integer.valueOf(split[2]));
		setTipo(split[6]);
		String xy = split[4]+split[5];
		
		split = xy.split(",");
		setX(Integer.valueOf(split[0].replace("(", "").trim()));
		setY(Integer.valueOf(split[1].replace(")", "").trim()));
		
		
	}
	
	public void print(){
		System.out.println(getString());
	}
	@Override
	public int compareTo(Unit outraUnidade) {
		if(this.idPlayer < outraUnidade.idPlayer){
			return -1;
		}
		if(this.idPlayer > outraUnidade.idPlayer){
			return 1;
		}
		return 0;
	}
	
	public void changePlayer(){
		if(this.idPlayer == 0){
			this.idPlayer = 1;
		}else{
			this.idPlayer = 0;
		}
	}
}
