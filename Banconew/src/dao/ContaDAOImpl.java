package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Conta;
import util.JdbcUtil;

public class ContaDAOImpl implements ContaDAO {

	Conta conta = new Conta();

	@Override
	public void inserir(Conta conta) {
		String sql = "INSERT INTO CONTA (NUMERO, SALDO, LIMITE, DONO) VALUES (?, ?, ?, ?)";
		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, conta.getNumero());
			ps.setInt(2, conta.getSaldo());
			ps.setInt(3, conta.getLimite());
			ps.setString(4, conta.getDono());
			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Conta conta) {
		String sql = "UPDATE CONTA SET SALDO=?, LIMITE=?, DONO=? WHERE NUMERO=?";
		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, conta.getSaldo());
			ps.setInt(2, conta.getLimite());
			ps.setString(3, conta.getDono());
			ps.setInt(4, conta.getNumero());
			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void remover(int numero) {
		String sql = "DELETE FROM CONTA WHERE NUMERO = ?";
		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, numero);
			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Conta pesquisar(int numero) {
		String sql = "SELECT * FROM CONTA WHERE NUMERO = ?";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, numero);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				conta.setNumero(res.getInt("NUMERO"));
				conta.setSaldo(res.getInt("SALDO"));
				conta.setLimite(res.getInt("LIMITE"));
				conta.setDono(res.getString("DONO"));

			}

			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conta;
	}

	@Override
	public List<Conta> listarTodos() {
		String sql = "SELECT * FROM CONTA";

		List<Conta> listaContas = new ArrayList<>();

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();

			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Conta conta = new Conta();
				conta.setNumero(res.getInt("NUMERO"));
				conta.setSaldo(res.getInt("SALDO"));
				conta.setLimite(res.getInt("LIMITE"));
				conta.setDono(res.getNString("DONO"));

				listaContas.add(conta);
			}
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaContas;
	}

}
