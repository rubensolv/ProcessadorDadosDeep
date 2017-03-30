package model;

import java.math.BigDecimal;
import java.util.ArrayList;


public class Estado {
	private int round, numUnitsAly, numUnitsEnemy, qtdUnitsPerArmy;
	private BigDecimal LTD2, tempoEx;
	private String TipoAlgoritm;
	private ArrayList<Unit> unidades;
	private ArrayList<String> actions;
	
	public Estado(){
		unidades = new ArrayList<>();
		actions = new ArrayList<>();
		qtdUnitsPerArmy = 50;
	}
	
	public String encodeEstado(){
		String retorno = "";
		try{
		retorno += Integer.toString(round).concat(";");
		retorno += Integer.toString(numUnitsAly).concat(";");
		retorno += Integer.toString(numUnitsEnemy).concat(";");
		for(Unit un : unidades){
			retorno += un.getString().concat(";");
		}
		
		retorno += LTD2.toString();
		}catch (Exception e) {
			return retorno = "";
		}
		return retorno;
	}
	
	public String encodeFullEstado(){
		String retorno = "";
		try{
		//retorno += Integer.toString(round).concat(";");
		retorno += Integer.toString(numUnitsAly).concat(";");
		retorno += Integer.toString(numUnitsEnemy).concat(";");
		//organiza os dados das unidades do player 0
		ArrayList<Unit> unitsTemp = obterUnitsPlay0();
		for (Unit unit : unitsTemp) {
			retorno += unit.getString().concat(";");
		}
		for (int i = 0; i < ( qtdUnitsPerArmy - unitsTemp.size()); i++) {
			retorno += Unit.getBlankUnit(0);			
		}
		
		//organiza os dados das unidades do player 1
		unitsTemp = obterUnitsPlay1();
		for (Unit unit : unitsTemp) {
			retorno += unit.getString().concat(";");
		}
		for (int i = 0; i < ( qtdUnitsPerArmy - unitsTemp.size()); i++) {
			retorno += Unit.getBlankUnit(1);			
		}
		
		
		retorno += LTD2.toString();
		}catch (Exception e) {
			return retorno = "";
		}
		return retorno;
	}
	
	public ArrayList<Unit> obterUnitsPlay0(){
		ArrayList<Unit> unitP0 = new ArrayList<>();
		for (Unit unit : this.unidades) {
			if(unit.getIdPlayer()==0){
				unitP0.add(unit);
			}
		}
		return unitP0;
	}
	
	public ArrayList<Unit> obterUnitsPlay1(){
		ArrayList<Unit> unitP1 = new ArrayList<>();
		for (Unit unit : this.unidades) {
			if(unit.getIdPlayer()==1){
				unitP1.add(unit);
			}
		}
		return unitP1;
	}
	
	public int totalUnidades(){
		return numUnitsAly + numUnitsEnemy;
	}
	
	public void addUnit(Unit un){	
		this.unidades.add(un);
	}
	public void addAction(String action){
		this.actions.add(action);
	}
	
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public int getNumUnitsAly() {
		return numUnitsAly;
	}
	public void setNumUnitsAly(int numUnitsAly) {
		this.numUnitsAly = numUnitsAly;
	}
	public int getNumUnitsEnemy() {
		return numUnitsEnemy;
	}
	public void setNumUnitsEnemy(int numUnitsEnemy) {
		this.numUnitsEnemy = numUnitsEnemy;
	}
	public BigDecimal getLTD2() {
		return LTD2;
	}
	public void setLTD2(BigDecimal lTD2) {
		LTD2 = lTD2;
	}
	public BigDecimal getTempoEx() {
		return tempoEx;
	}
	public void setTempoEx(BigDecimal tempoEx) {
		this.tempoEx = tempoEx;
	}
	public String getTipoAlgoritm() {
		return TipoAlgoritm;
	}
	public void setTipoAlgoritm(String tipoAlgoritm) {
		TipoAlgoritm = tipoAlgoritm;
	}
	public ArrayList<Unit> getUnidades() {
		return unidades;
	}
	public void setUnidades(ArrayList<Unit> unidades) {
		this.unidades = unidades;
	}
	public ArrayList<String> getActions() {
		return actions;
	}
	public void setActions(ArrayList<String> actions) {
		this.actions = actions;
	}
	
}
