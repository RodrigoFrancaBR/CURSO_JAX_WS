package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaWebService {
	public static void main(String[] args) {
		EstoqueWSIMP service = new EstoqueWSIMP();
		String url = "http://localhost:8080/estoquewsi";
		System.out.println("Service rodando " + url + "?wsdl");
		Endpoint.publish(url, service);
		/*EstoqueWS service = new EstoqueWS();
		String url = "http://localhost:8080/estoquews";
		System.out.println("Service rodando " + url + "?wsdl");
		Endpoint.publish(url, service);*/
		/*
		RelatorioService service = new RelatorioService();
		String url = "http://localhost:8080/relatoriows";
		System.out.println("Service rodando " + url + "?wsdl");
		Endpoint.publish(url, service);
	*/	
	}
}
