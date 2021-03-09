package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;

@WebService
public class EstoqueWS {
	ItemDao dao = new ItemDao();

	public List<Item> getItens() {
		System.out.println("EstoqueWS::getItens()");
		return dao.todosItens();
	}

}
