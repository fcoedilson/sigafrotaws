package br.org.sigafrota.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="transmissao")
public class Transmissao {

	@Element(name="veiculo")
	private BigDecimal veiculoId;

	@Element(name="pontoMaisProximo",data=true)
	private String ponto;

	@Element(name="distanciaDoPonto")
	private BigDecimal distancia;

	@Element(name="dataHoraTransmissao")
	private Date dataTransmissao;

	public Transmissao() {}

	public BigDecimal getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(BigDecimal veiculoId) {
		this.veiculoId = veiculoId;
	}

	public String getPonto() {
		return ponto;
	}

	public void setPonto(String ponto) {
		this.ponto = ponto;
	}

	public BigDecimal getDistancia() {
		return distancia;
	}

	public void setDistancia(BigDecimal distancia) {
		this.distancia = distancia;
	}

	public Date getDataTransmissao() {
		return dataTransmissao;
	}

	public void setDataTransmissao(Date dataTransmissao) {
		this.dataTransmissao = dataTransmissao;
	}

}
