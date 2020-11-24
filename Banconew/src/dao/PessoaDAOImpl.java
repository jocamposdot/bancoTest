package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Pessoa;
import util.JdbcUtil;

public class PessoaDAOImpl implements PessoaDAO {

	Pessoa pessoa = new Pessoa();

	@Override
	public void inserir(Pessoa pessoa) {
		String sql = "INSERT INTO PESSOA (NOME, IDADE, SEXO, CPF, ID_ENDERECO, NUMERO_CONTA) VALUES (?, ?, ?, ?, ?, ?) ";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setInt(2, pessoa.getIdade());
			ps.setString(3, pessoa.getSexo());
			ps.setString(4, pessoa.getCpf());
			ps.setInt(5, pessoa.getId_endereco());
			ps.setInt(6, pessoa.getNumero_conta());
			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Pessoa pessoa) {
		String sql = "UPDATE PESSOA SET NOME=?, IDADE=?, SEXO=?, ID_ENDERECO=?, NUMERO_CONTA=? WHERE CPF=?";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, pessoa.getNome());
			ps.setInt(2, pessoa.getIdade());
			ps.setString(3, pessoa.getSexo());
			ps.setInt(4, pessoa.getId_endereco());
			ps.setInt(5, pessoa.getNumero_conta());
			ps.setString(6, pessoa.getCpf());

			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void remover(String cpf) {
		String sql = "DELETE FROM PESSOA WHERE CPF = ?";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, cpf);
			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Pessoa pesquisar(String cpf) {
		String sql = "SELECT * FROM PESSOA WHERE CPF = ?";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, cpf);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				pessoa.setCpf(res.getString("CPF"));
				pessoa.setSexo(res.getString("SEXO"));
				pessoa.setId_endereco(res.getInt("ID_ENDERECO"));
				pessoa.setIdade(res.getInt("IDADE"));
				pessoa.setNome(res.getString("NOME"));
				pessoa.setNumero_conta(res.getInt("NUMERO_CONTA"));
			}

			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pessoa;

	}

	@Override
	public List<Pessoa> listarTodos() {

		String sql = "SELECT * FROM PESSOA";

		List<Pessoa> listaPessoas = new ArrayList<>();

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setCpf(res.getString("CPF"));
				pessoa.setNome(res.getString("NOME"));
				pessoa.setIdade(res.getInt("IDADE"));
				pessoa.setSexo(res.getString("SEXO"));
				pessoa.setId_endereco(res.getInt("ID_ENDERECO"));
				pessoa.setNumero_conta(res.getInt("NUMERO_CONTA"));

				listaPessoas.add(pessoa);
			}

			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaPessoas;
	}

}
