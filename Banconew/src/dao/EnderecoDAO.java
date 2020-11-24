package dao;

import java.util.List;

import entidades.Endereco;

public interface EnderecoDAO {

	public void inserir(Endereco endereco);

	public void alterar(Endereco endereco);

	public void remover(int id_endereco);

	public Endereco pesquisar(int id_endereco);

	public List<Endereco> listarTodos();

}