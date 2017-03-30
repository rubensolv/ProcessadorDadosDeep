package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

import model.Estado;
import model.Unit;

public class ProcessadorArquivos {

	
	
	public ArrayList<Estado> lerArquivoDeep(String nomeArq){

		ArrayList<Estado> estados = new ArrayList<>();
		
		try {
			FileReader arq = new FileReader(nomeArq);
			BufferedReader learArq = new BufferedReader(arq);

			String linha  = learArq.readLine();
			Estado estado = new Estado();
			while (linha != null) {
				if (linha.contains("Round =")) {
					estado = new Estado();
					estados.add(estado);
					estado.setRound(Integer.valueOf(linha.substring(9)));
				}
				if (linha.contains("Número de Unidades =")) {
					estado.setNumUnitsAly(Integer.valueOf(linha.substring(22)));
				}
				if (linha.contains("Número de Unidades Inimigas =")) {
					estado.setNumUnitsEnemy(Integer.valueOf(linha.substring(31)));
				}
				if (linha.contains("LTD2 =")) {
					estado.setLTD2(new BigDecimal(linha.substring(8)));
				}
				if (linha.contains("Tempo de Execução =")) {
					estado.setTempoEx(new BigDecimal(linha.substring(21)));
				}
				if (linha.contains("Tipo de Algoritmo Utilizado =")) {
					estado.setTipoAlgoritm(linha.substring(31));
				}
				if (linha.contains("Protoss_Zealot") || linha.contains("Protoss_Dragoon")) {
					if(linha.contains("P1") || linha.contains("P0")){
						Unit unTemp = new Unit();
						unTemp.leDadosUnidade(linha);
						estado.addUnit(unTemp);
					}
				}
				if(linha.contains("MOVE") || linha.contains("ATTACK") || linha.contains("RELOAD")){
					linha = linha.replace("  ",";");
					linha = linha.replace(" ",";");
					linha = linha.replace(",",";");
					estado.addAction(linha);
				}

				linha = learArq.readLine();
				
			}
			
			arq.close();

		} catch (Exception e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			System.out.println(e.toString());
		}
		
		return estados;
	}
	
	
	public void gravarEstados(int qtdUnidades, String linha, String caminho){
		FileWriter arq;
		try {
			arq = new FileWriter(caminho.concat("/datasetUnit"+qtdUnidades), true);
			PrintWriter gravarArq = new PrintWriter(arq);
			
			gravarArq.println(linha);
			
			gravarArq.flush();
			gravarArq.close();
			arq.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void gravarEstadoCompleto(String linha, String caminho){
		FileWriter arq;
		try {
			arq = new FileWriter(caminho.concat("/datasetFull"), true);
			PrintWriter gravarArq = new PrintWriter(arq);
			
			gravarArq.println(linha);
			
			gravarArq.flush();
			gravarArq.close();
			arq.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


