package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.usuario.AutorizacaoException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
public class EstoqueWS {

	ItemDao dao = new ItemDao();

	/*
	 * @WebMethod(operationName="todosOsItens")
	 * 
	 * @WebResult(name="item") public ListaItens getItens() {
	 * System.out.println("EstoqueWS::getItens()"); ArrayList<Item> todosItens =
	 * dao.todosItens(); ListaItens listaItens = new ListaItens(todosItens);
	 * return listaItens; }
	 */

	@WebMethod(operationName = "todosOsItens")
	@ResponseWrapper(localName = "itens")
	@WebResult(name = "item")
	// @RequestWrapper(localName = "listaitens")
	public List<Item> getItens(@WebParam(name = "filtros") Filtros filtros) {
		System.out.println("EstoqueWS::getItens(Filtros filtros)");
		System.out.println(filtros);
		List<Filtro> lista = filtros.getLista();
		return dao.todosItens(lista);
	}

	@WebMethod(operationName = "cadastrarItem")
	@WebResult(name = "item")
	public Item cadastrarItem(
			@WebParam(name = "tokenUsuario", header = true) TokenUsuario tokenUsuario,
			@WebParam(name = "item") Item item) throws AutorizacaoException {
		
		System.out.println("EstoqueWS::cadastrarItem(Item item)");
		System.out.println("item: " + item);
		System.out.println("Token: " + tokenUsuario);
		
		boolean valido = new TokenDao().ehValido(tokenUsuario);
		if (!valido){
			throw new AutorizacaoException("Token falhou");
		}
		
		new ItemValidador(item).validate();
		
		this.dao.cadastrar(item);
		
		
		
		return item;
	}

}
