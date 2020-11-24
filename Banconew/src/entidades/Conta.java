package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTA")
public class Conta {

	@Id
	@Column(name = "NUMERO", nullable = false)
	private int numero;

	@Column(name = "SALDO", nullable = false)
	private int saldo;

	@Column(name = "LIMITE", nullable = false)
	private int limite;

	@Column(name = "DONO", nullable = false)
	private String dono;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

}
