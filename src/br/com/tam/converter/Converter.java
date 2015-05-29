/**
 * 
 */
package br.com.tam.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

/**
 * @author eduardobregaida
 *
 */
public class Converter {

	public static void main(String[] args) {
		URL url = null;
		Scanner in = null;
		FileWriter writer = null;
		try {

			url = new URL(
					"http://www.cgna.gov.br/rpl/Companhias/Cia_TAM_CS.txt");
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					url.openStream()));
			File arquivoNovo = new File("arquivoNovo.csv");

			writer = new FileWriter(arquivoNovo);

			in = new Scanner(bf);
			in.useDelimiter("\\s{1,}");
			String cabecalho = "code,flightnum,depicao,arricao,route,aircraft,flightlevel,distance,deptime,arrtime,flighttime,notes,price,flighttype,daysofweek,enabled,";
			writer.write(cabecalho + "\"" + " week1" + "\"" + "," + "\""
					+ " week2" + "\"" + "," + "\"" + " week3" + "\"" + ","
					+ "\"" + " week4");
			writer.append("\n");
			while (in.hasNext()) {
				writer.write("\"");
				writer.write(in.next());//replace para remover o cabeçalho original?
				/*
		                                  	  Planos de Vôo Repetitivos
                                               Classificação: Ident Anv 
 
CIA: TAM                                    INÍCIO DE VALIDADE: 28mai2015                                       PAG.: 1
-----------------------------------------------------------------------------------------------------------------------------------------
   VALIDO VALIDO DIAS OP  IDENT  TIPO   ADEP     VEL   FL  ROTA                                DEST         OBSERVACOES
   DESDE   ATE   STQQSSD   ANV     TURB     EOBT                                                   EET
-----------------------------------------------------------------------------------------------------------------------------------------
				 */
				writer.write("\"");
				writer.append(", ");
				
			}
			writer.append("\n"); //Melhorar a quebra de linha do inicio do original sempre pula
			in.close();
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Operação Finalizada");

		}
	}
}
