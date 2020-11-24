package view.controler;

import java.util.List;
import java.util.Scanner;

import dao.ContaDAO;
import dao.ContaDAOImpl;
import dao.EnderecoDAO;
import dao.EnderecoDAOImpl;
import dao.PessoaDAO;
import dao.PessoaDAOImpl;
import entidades.Conta;
import entidades.Endereco;
import entidades.Pessoa; 

public class Banco {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		PessoaDAO pessoaDAO = new PessoaDAOImpl();
		EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
		ContaDAO contaDAO = new ContaDAOImpl();

		Pessoa pessoaCreate = new Pessoa();
		Pessoa pessoaEdit = new Pessoa();

		Conta contaCreate = new Conta();
		Conta contaEdit = new Conta();
	
		Endereco enderecoCreate = new Endereco();
		Endereco enderecoEdit = new Endereco();

		// List<Pessoa> listaPessoa = pessoaDAO.listarTodos();

		boolean condicao = true;
		int opcao;

		do {
			System.out.println("**Baktura**");
			System.out.println("(1) Inserir Pessoa");
			System.out.println("(2) Alterar Pessoa");
			System.out.println("(3) Listar Pessoas");
			System.out.println("(4) Remover Pessoa");
			System.out.println("(5) Pesquisar Pessoa");

			System.out.println("(6) Inserir Conta");
			System.out.println("(7) Alterar Conta");
			System.out.println("(8) Listar Contas");
			System.out.println("(9) Remover Conta");
			System.out.println("(10) Pesquisar Conta");

			System.out.println("(11) Inserir Endereco");
			System.out.println("(12) Alterar Endereco");
			System.out.println("(13) Listar Enderecos");
			System.out.println("(14) Remover Endereco");
			System.out.println("(15) Pesquisar Endereco");

			System.out.println("(0) Sair");
			opcao = scan.nextInt();

			switch (opcao) {
			case (1):
				System.out.println("** Inserir pessoa **");
				System.out.println("Insira o nome: ");
				pessoaCreate.setNome(scan.next());
				System.out.println("Insira a idade: ");
				pessoaCreate.setIdade(scan.nextInt());
				System.out.println("Insira M para masculino ou F para feminino: ");
				pessoaCreate.setSexo(scan.next());
				System.out.println("Insira um CPF válido: ");
				pessoaCreate.setCpf(scan.next());
				System.out.println("Insira o ID do endereco desta pessoa: ");
				pessoaCreate.setId_endereco(scan.nextInt());
				System.out.println("Insira o número da conta desta pessoa: ");
				pessoaCreate.setNumero_conta(scan.nextInt());

				pessoaDAO.inserir(pessoaCreate);

				break;

			case (2):
				System.out.println("** Alterar pessoa **");
				System.out.println("Insira o nome: ");
				pessoaEdit.setNome(scan.next());
				System.out.println("Insira a idade: ");
				pessoaEdit.setIdade(scan.nextInt());
				System.out.println("Insira M para masculino ou F para feminino: ");
				pessoaEdit.setSexo(scan.next());
				System.out.println("Insira o ID do endereco desta pessoa: ");
				pessoaEdit.setId_endereco(scan.nextInt());
				System.out.println("Insira o número da conta desta pessoa: ");
				pessoaEdit.setNumero_conta(scan.nextInt());
				System.out.println("Insira o CPF da pessoa: ");
				pessoaEdit.setCpf(scan.next());

				pessoaDAO.alterar(pessoaEdit);

				break;

			case (3):
				System.out.println("** Lista de Pessoas **");
				List<Pessoa> listaPessoa = pessoaDAO.listarTodos();
				for (Pessoa p : listaPessoa) {
					System.out.println("Nome: " + p.getNome() + " | CPF: " + p.getCpf() + " | Idade: " + p.getIdade()
							+ " | Sexo: " + p.getSexo() + " | ID Endereço: " + p.getId_endereco() + " | Número Conta: "
							+ p.getNumero_conta());
				}
				break;

			case (4):
				System.out.println("** Remover Pessoas **");
				System.out.println("Insira o CPF da pessoa que deseja remover: ");
				pessoaDAO.remover(scan.next());
				break;

			case (5):
				System.out.println("** Pesquisar Pessoa **");
				System.out.println("Insira o CPF da pessoa que deseja pesquisar: ");
				Pessoa pesquisaP = pessoaDAO.pesquisar(scan.next());
				System.out.println("Nome: " + pesquisaP.getNome() + " | CPF: " + pesquisaP.getCpf() + " | Idade: "
						+ pesquisaP.getIdade() + " | Sexo: " + pesquisaP.getSexo() + " | ID Endereço: "
						+ pesquisaP.getId_endereco() + " | Número Conta: " + pesquisaP.getNumero_conta());

				break;
			case (6):
				System.out.println("**Inserir Conta");
				System.out.println("Insira o nome do dono da conta: ");
				contaCreate.setDono(scan.next());
				System.out.println("Insira o limite que a conta terá: ");
				contaCreate.setLimite(scan.nextInt());
				System.out.println("Insira o número da conta: ");
				contaCreate.setNumero(scan.nextInt());
				System.out.println("Sinira o saldo da conta: ");
				contaCreate.setSaldo(scan.nextInt());

				contaDAO.inserir(contaCreate);
				break;

			case (7):
				System.out.println("** Alterar Conta **");
				System.out.println("Insira o nome do dono da conta: ");
				contaEdit.setDono(scan.next());
				System.out.println("Insira o limite que a conta terá: ");
				contaEdit.setLimite(scan.nextInt());
				System.out.println("Insira o número da conta: ");
				contaEdit.setNumero(scan.nextInt());
				System.out.println("Sinira o saldo da conta: ");
				contaEdit.setSaldo(scan.nextInt());

				contaDAO.inserir(contaEdit);
				break;

			case (8):
				System.out.println("** Listar Contas");
				List<Conta> listaConta = contaDAO.listarTodos();
				for (Conta c : listaConta) {
					System.out.println("Dono: " + c.getDono() + " | Limite: " + c.getLimite() + " | Numero: "
							+ c.getNumero() + " | Saldo: " + c.getSaldo());
				}
				break;

			case (9):
				System.out.println("** Remover Contas **");
				System.out.println("Insira o número da conta que deseja remover: ");
				contaDAO.remover(scan.nextInt());

				break;

			case (10):
				System.out.println("** Pesquisar Conta **");
				System.out.println("Insira o número da conta que deseja pesquisar: ");
				Conta c1 = contaDAO.pesquisar(scan.nextInt());
				System.out.println("Dono: " + c1.getDono() + " | Limite: " + c1.getLimite() + " | Numero: "
						+ c1.getNumero() + " | Saldo: " + c1.getSaldo());

				break;

			case (11):
				System.out.println("**Inserir Endereco");
				System.out.println("Insira o nome da rua: ");
				enderecoCreate.setRua(scan.next());
				System.out.println("Insira o complemento: ");
				enderecoCreate.setComplemento(scan.next());
				System.out.println("Insira o ID: ");
				enderecoCreate.setId_endereco(scan.nextInt());
				System.out.println("Insira o número: ");
				enderecoCreate.setNumero(scan.nextInt());

				enderecoDAO.inserir(enderecoCreate);
				break;

			case (12):
				System.out.println("** Alterar Endereco **");
				System.out.println("Insira o nome da rua que deseja alterar : ");
				enderecoEdit.setRua(scan.next());
				System.out.println("Insira o complemento que deseja alterar: ");
				enderecoEdit.setComplemento(scan.next());
				System.out.println("Insira o ID que deseja alterar: ");
				enderecoEdit.setId_endereco(scan.nextInt());
				System.out.println("Insira o número que deseja alterar: ");
				enderecoEdit.setNumero(scan.nextInt());

				enderecoDAO.alterar(enderecoEdit);
				break;

			case (13):
				System.out.println("** Listar Enderecos");
				List<Endereco> listaEndereco = enderecoDAO.listarTodos();
				for (Endereco le : listaEndereco) {
					System.out.println("Rua: " + le.getRua() + " | Número: " + le.getNumero() + " | Complemento: "
							+ le.getComplemento() + " | ID: " + le.getId_endereco());
				}
				break;

			case (14):
				System.out.println("** Remover Endereco **");
				System.out.println("Insira o ID do endereço que deseja remover: ");
				contaDAO.remover(scan.nextInt());

				break;

			case (15):
				System.out.println("** Pesquisar Endereco **");
				System.out.println("Insira o ID do endereço que deseja pesquisar: ");
				Endereco ender = enderecoDAO.pesquisar(scan.nextInt());
				System.out.println("Rua: " + ender.getRua() + " | Número: " + ender.getNumero() + " | Complemento: "
						+ ender.getComplemento() + " | ID: " + ender.getId_endereco());

				break;

			default:
				System.out.println("** Obrigado por usar nosso Banco de Dados **");
				condicao = false;
				break;

			}

		} while (condicao == true);

	}

}
