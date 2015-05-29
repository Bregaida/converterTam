package br.com.tam.converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Teste {

		public static void main(String[] args) {
			
			BufferedReader crunchifyBuffer = null;
			
			try {
				 URL url = null;
			        File file = new File("myFile.csv");
			        //Site com o TXT: http://www.cgna.gov.br/rpl/Companhias/Cia_TAM_CS.txt
			            url = new URL("http://www.cgna.gov.br/rpl/Companhias/Cia_TAM_CS.txt");
				String crunchifyLine;
				crunchifyBuffer = 
		                new BufferedReader(new InputStreamReader(url.openStream()));
				 
		         BufferedWriter out = new BufferedWriter(new FileWriter(file));
		 
		        String inputLine;
		 
				ArrayList<String> dados = new ArrayList<String>();
				// How to read file in java line by line?
				String cabecalho="code,flightnum,depicao,arricao,route,aircraft,flightlevel,distance,deptime,arrtime,flighttime,notes,price,flighttype,daysofweek,enabled,"+"' week1',' week2',' week3',' week4'";
				dados.add(cabecalho);
				while ((crunchifyLine = crunchifyBuffer.readLine()) != null) {
//					System.out.println("Raw CSV data: " + crunchifyLine);
//					System.out.println("Converted ArrayList data: " + crunchifyCSVtoArrayList(crunchifyLine) + "\n");
					dados.addAll(crunchifyCSVtoArrayList(crunchifyLine));
				}
				for (String string : dados) {
					System.out.println("Saída: "+ string);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (crunchifyBuffer != null) crunchifyBuffer.close();
				} catch (IOException crunchifyException) {
					crunchifyException.printStackTrace();
				}
			}
		}
		
		// Utility which converts CSV to ArrayList using Split Operation
		public static ArrayList<String> crunchifyCSVtoArrayList(String crunchifyCSV) {
			ArrayList<String> crunchifyResult = new ArrayList<String>();
			
			if (crunchifyCSV != null) {
				String[] splitData = crunchifyCSV.split("s/\t/,/g");
				for (int i = 0; i < splitData.length; i++) {
					if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
						crunchifyResult.add(splitData[i].trim());
					}
				}
			}
			
			return crunchifyResult;
		}
		

	}

