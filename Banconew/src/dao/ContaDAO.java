package dao;

import java.util.List;

import entidades.Conta;

public interface ContaDAO {

	public void inserir(Conta conta);

	public void alterar(Conta conta);

	public void remover(int numero);

	public Conta pesquisar(int numero);

	public List<Conta> listarTodos();

}
