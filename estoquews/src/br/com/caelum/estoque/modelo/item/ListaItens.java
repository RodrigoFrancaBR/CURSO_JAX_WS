package br.com.caelum.estoque.modelo.item;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
// informa par ao jaxb que o acesso é pelos campos e nao pelos métodos
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaItens {
	
	@XmlElement(name="item")
	public List<Item> itens;

	public ListaItens(List<Item> itens) {
		this.itens = itens;
	}
	
	public ListaItens() {	
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
}
