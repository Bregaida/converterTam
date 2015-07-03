/**
 * 
 */
package br.com.tam.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Predicate;

import org.apache.commons.io.output.FileWriterWithEncoding;

/**
 * @author eduardobregaida
 *
 */
public class Converter {

	public static void main(String[] args) {
		URL url = null;
		Scanner in = null;
		FileWriterWithEncoding writer = null;
		try {

			url = new URL(
					"http://www.cgna.gov.br/rpl/Companhias/Cia_TAM_CS.txt");
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					url.openStream(), "UTF-8"));
			File arquivoNovo = new File("arquivoNovo.csv");

			writer = new FileWriterWithEncoding(arquivoNovo, "UTF-8");

			in = new Scanner(bf);
			in.useDelimiter("\\s{1,}");
			String cabecalho = "code,flightnum,depicao,arricao,route,aircraft,flightlevel,distance,deptime,arrtime,flighttime,notes,price,flighttype,daysofweek,enabled,";
			writer.write(cabecalho + "\"" + " week1" + "\"" + "," + "\""
					+ " week2" + "\"" + "," + "\"" + " week3" + "\"" + ","
					+ "\"" + " week4");
			writer.append("\n");
			while (in.hasNext()) {

				writer.write("\"");
				writer.write(in.next());
				writer.write("\"");
				writer.append(", ");
			}
			writer.append("\n"); //Melhorar a quebra de linha do inicio do
			// original sempre pula
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
