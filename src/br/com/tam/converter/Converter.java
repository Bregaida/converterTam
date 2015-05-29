/**
 * 
 */
package br.com.tam.converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author eduardobregaida
 *
 */
public class Converter {

    public void getPage(URL url, File file) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(url.openStream()));
 
         BufferedWriter out = new BufferedWriter(new FileWriter(file));
 
        String inputLine;
 
        while ((inputLine = in.readLine()) != null) {
            // Imprime página no console
            System.out.println(inputLine);
            // Grava pagina no arquivo
            out.write(inputLine);
            out.newLine();
        }
 
        in.close();
        out.flush();
        out.close();
    }
 
    public static void main(String[] args) {
        URL url = null;
        File file = new File("myFile.csv");
        try {
            url = new URL("http://www.cgna.gov.br/rpl/Companhias/Cia_TAM_CS.txt");
            new Converter().getPage(url, file);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
