package br.org.sigafrota.service;


import java.io.StringWriter;
import java.util.Date;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.HyphenStyle;
import org.simpleframework.xml.stream.Style;

import br.org.sigafrota.dao.TransmissaoDAO;
import br.org.sigafrota.entity.TransmissaoList;

public class TransmissaoService {

	public TransmissaoList consultarTransmissao(Integer veiculoId, Date dataInicial, Date dataFinal) {

		TransmissaoList transmissaoList = new TransmissaoList();
		TransmissaoDAO dao = new TransmissaoDAO();
		transmissaoList.setTransmissoes(dao.consultar(null));
		return transmissaoList;
	}

	public String consultarTransmissao() {

		TransmissaoList transmissaoList = new TransmissaoList();
		TransmissaoDAO dao = new TransmissaoDAO();
		transmissaoList.setTransmissoes(dao.consultar(null));

		Serializer serializer;
		Style style = new HyphenStyle();
		Format format = new Format(style);
		serializer = new Persister(format);
		//serializer = new Persister();

		StringWriter writer = new StringWriter();
		StringBuffer result = new StringBuffer("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>");

		try {
			serializer.write(transmissaoList, writer);
			result.append(writer.toString());
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result.toString();
	}

}
