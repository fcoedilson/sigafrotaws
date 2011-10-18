package br.org.sigafrota.entity;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="transmissoes")
public class TransmissaoList {

	@ElementList(inline=true)
	private List<Transmissao> transmissoes;

	public TransmissaoList() {
		transmissoes = new ArrayList<Transmissao>(0);
	}

	public List<Transmissao> getTransmissoes() {
		return transmissoes;
	}

	public void setTransmissoes(List<Transmissao> transmissoes) {
		this.transmissoes = transmissoes;
	}

}
