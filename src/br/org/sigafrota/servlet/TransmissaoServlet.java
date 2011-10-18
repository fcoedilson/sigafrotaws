package br.org.sigafrota.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.sigafrota.service.TransmissaoService;

public class TransmissaoServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		execute(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		execute(req, resp);
	}

	public void execute(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {

		TransmissaoService service = new TransmissaoService();
		String result = service.consultarTransmissao();

		resp.setContentType("text/xml");
		resp.setContentLength(result.length());
		resp.setCharacterEncoding("ISO-8859-1");

		OutputStream out = resp.getOutputStream();

		out.write(result.getBytes());
		out.flush();
		out.close();
	}

}
