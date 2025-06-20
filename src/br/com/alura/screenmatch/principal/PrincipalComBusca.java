package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.Gson;

import br.com.alura.screenmatch.modelos.Titulo;

public class PrincipalComBusca {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Scanner leitura = new Scanner(System.in);
		System.out.println("Digite o nome do filme");
		
		var busca = leitura.nextLine();
		String endereco = "http://www.omdbapi.com/?t=" + busca + "&apikey=5e9b0ca8";
		
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(endereco))
		      .build();

		HttpResponse<String> response = client
				  .send(request, BodyHandlers.ofString());
		
		String json = response.body();
		System.out.println(json);
		
		Gson gson = new Gson();
		
		Titulo meuTitulo = gson.fromJson(json, Titulo.class);
		System.out.println(meuTitulo);
	}

}
	