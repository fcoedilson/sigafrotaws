package br.org.sigafrota.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import br.org.sigafrota.entity.Transmissao;

public class TransmissaoDAO {

	private Connection getConnection() {
		Connection conn = null;

		DataSource ds;
		try {
			ds = (DataSource) InitialContext.doLookup("java:comp/env/jdbc/sigafrotaws");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	private void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void close(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Transmissao> consultar(HashMap<String, Object> params) {

		List<Transmissao> result = new ArrayList<Transmissao>(0);

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Integer vid = 89;

		try {
			conn = getConnection();

			stmt = conn.prepareStatement("SELECT * FROM V_TRANSMISSAO T WHERE T.CODVEICULO = ? ");
			stmt.setInt(1, 89);

			rs = stmt.executeQuery();
			Transmissao transmissao;
			while (rs.next()) {
				transmissao = new Transmissao();
				transmissao.setVeiculoId(rs.getBigDecimal("VEICULO"));
				transmissao.setPonto(rs.getString("PONTO"));
				transmissao.setDistancia(rs.getBigDecimal("DISTANCIA"));
				transmissao.setDataTransmissao(new Date(rs.getTimestamp("DATATRANSMISSAO").getTime()));
				result.add(transmissao);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(conn);
		}

		return result;
	}

}
