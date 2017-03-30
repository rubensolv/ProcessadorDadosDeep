package principal;

import java.io.File;
import java.util.ArrayList;

import model.Estado;
import util.BuscadorArquivos;
import util.ProcessadorArquivos;

public class Main {

	public static void main(String[] args) {
		System.out.println("Iniciando varredura...");
		
		File diretorio = new File("/media/rubens/Dados/deepDados/pkg1");
		ArrayList<String> listaArquivos = new ArrayList<>();
		BuscadorArquivos.buscar(diretorio, "Deep_", listaArquivos);
		ProcessadorArquivos process = new ProcessadorArquivos();

		ArrayList<Estado> estados = new ArrayList<>();
		for (String nomeArq : listaArquivos) {
			estados = process.lerArquivoDeep(nomeArq);
			String tempEstado = "";
			for (Estado estado : estados) {
				tempEstado = estado.encodeEstado();
				if (tempEstado.length() > 4) {
					//process.gravarEstados(estado.totalUnidades(), tempEstado, "/media/rubens/Dados/deepDados/resumo");
					process.gravarEstadoCompleto(estado.encodeFullEstado(), "/media/rubens/Dados/deepDados/ResumoCompleto");
				}
			}
			System.out.println("Estados gravados para o arquivo" + nomeArq);
		}
		System.out.println("Concluído!");

	}

}
