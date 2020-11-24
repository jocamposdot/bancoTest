package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Endereco;
import util.JdbcUtil;

public class EnderecoDAOImpl implements EnderecoDAO {

	Endereco endereco = new Endereco();

	@Override
	public void inserir(Endereco endereco) {
		String sql = "INSERT INTO ENDERECO (RUA, NUMERO, COMPLEMENTO) VALUES (?, ?, ?)";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, endereco.getRua());
			ps.setInt(2, endereco.getNumero());
			ps.setString(3, endereco.getComplemento());
			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Endereco endereco) {
		String sql = "UPDADE ENDERECO SET RUA=?, NUMERO=?, COMPLEMENTO=? WHERE ID_ENDERECO=?";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, endereco.getRua());
			ps.setInt(2, endereco.getNumero());
			ps.setString(3, endereco.getComplemento());
			ps.setInt(4, endereco.getId_endereco());
			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Override
	public void remover(int id_endereco) {
		String sql = "DELETE FROM ENDERECO WHERE ID_ENDERECO = ?";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setInt(1, id_endereco);
			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Endereco pesquisar(int id_endereco) {
		String sql = "SELECT * FROM ENDERECO WHERE ID_ENDERECO = ?";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id_endereco);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				endereco.setId_endereco(res.getInt("ID_ENDERECO"));
				endereco.setRua(res.getString("RUA"));
				endereco.setNumero(res.getInt("NUMERO"));
				endereco.setComplemento(res.getString("COMPLEMENTO"));

			}

			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return endereco;
	}

	@Override
	public List<Endereco> listarTodos() {

		String sql = "SELECT * FROM ENDERECO";

		List<Endereco> listaEnderecos = new ArrayList<>();

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Endereco endereco = new Endereco();
				endereco.setRua(res.getString("RUA"));
				endereco.setNumero(res.getInt("NUMERO"));
				endereco.setComplemento(res.getString("COMPLEMENTO"));
				endereco.setId_endereco(res.getInt("ID_ENDERECO"));

				listaEnderecos.add(endereco);
			}
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaEnderecos;
	}

}
