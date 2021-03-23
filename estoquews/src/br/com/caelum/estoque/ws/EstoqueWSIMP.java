package br.com.caelum.estoque.ws;

import java.util.Arrays;

import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ListaItens;

@WebService(endpointInterface="br.com.caelum.estoque.ws.EstoqueWSI", serviceName="EstoqueWSI")
public class EstoqueWSIMP implements EstoqueWSI {

	@Override
	public ListaItens todosOsItens(Filtros filtros) {
		System.out.println("Chamando todos os Itens");

		ListaItens listaItens = new ListaItens();
		listaItens.itens = Arrays.asList(geraItem());
		return listaItens;
	}

	// método auxiliar
	private Item geraItem() {
		Item item = new Item();
		item.setCodigo("MEA");
		item.setNome("MEAN");
		item.setQuantidade(5);
		item.setTipo("Livro");
		return item;
	}
}
