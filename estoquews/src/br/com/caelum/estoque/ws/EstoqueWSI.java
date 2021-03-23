package br.com.caelum.estoque.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.ListaItens;

@WebService(name = "EstoqueWSI")
public interface EstoqueWSI {
	
	  @WebMethod(operationName = "TodosOsItens")	    
	    @WebResult(name = "itens", targetNamespace = "")
	    public ListaItens todosOsItens(
	        @WebParam(name = "filtros") Filtros filtros
	    );

}
