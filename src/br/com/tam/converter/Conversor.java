/**
 * 
 */
package br.com.tam.converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

import org.apache.commons.io.output.FileWriterWithEncoding;

/**
 * @author eduardobregaida
 *
 */
public class Conversor {

	public static void leitor(BufferedReader bf) throws IOException {
		BufferedReader buffRead = bf;
		BufferedWriter buffWrite = new BufferedWriter(
				new FileWriterWithEncoding("arquivoTAM.csv", "UTF8"));
		String linha = "";
		String cabecalho = "code,flightnum,depicao,arricao,route,aircraft,flightlevel,distance,deptime,arrtime,flighttime,notes,price,flighttype,daysofweek,enabled,";
		buffWrite.write(cabecalho + "\"" + " week1" + "\"" + "," + "\""
				+ " week2" + "\"" + "," + "\"" + " week3" + "\"" + "," + "\""
				+ " week4");
		buffWrite.write("\n");
		while (true) {
			if (linha != null) {

				if (!linha.contains("Planos")) {
					if (!linha.contains("Ident")) {
						if (!linha.contains("CIA:")) {
							if (!linha.contains("-")) {
								if (!linha.contains("VALIDO")) {
									if (!linha.contains("DESDE")) {
										if (!linha.isEmpty()) {
											if (!linha.contains("\n")) {
												// buffWrite.append("\"");
												// buffWrite.append(linha.replace(" ",
												// ",")+ "\n");
												// buffWrite.append("\"");
												// buffWrite.append(", ");
												String[] a = linha
														.split("[,.] *| +");
												// linha = linha.replace("\t",
												// ",");
												buffWrite.append(Arrays
														.toString(a).replace("[", "").replace("]", ""));
												System.out.println(linha);
											}
										}
									}
								}

							}
						}

					}

				}

			} else
				break;
			linha = buffRead.readLine();
		}
		System.out.println("Operação Realizada com Sucesso");
		buffRead.close();
		buffWrite.close();
	}

	public static void main(String args[]) throws IOException {
		URL url = null;
		url = new URL("http://www.cgna.gov.br/rpl/Companhias/Cia_TAM_CS.txt");
		BufferedReader bf = new BufferedReader(new InputStreamReader(
				url.openStream(), "UTF8"));
		leitor(bf);
	}

}
