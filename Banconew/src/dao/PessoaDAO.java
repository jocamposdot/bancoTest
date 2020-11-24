package dao;

import java.util.List;

import entidades.Pessoa;

public interface PessoaDAO {

	public void inserir(Pessoa pessoa);

	public void alterar(Pessoa pessoa);

	public void remover(String cpf);

	public Pessoa pesquisar(String cpf);

	public List<Pessoa> listarTodos();

}
