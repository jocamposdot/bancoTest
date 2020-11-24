package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECO")
public class Endereco {

	@Id
	@Column(name = "ID_ENDERECO", nullable = false)
	private int id_endereco;

	@Column(name = "RUA", nullable = false)
	private String rua;

	@Column(name = "NUMERO", nullable = false)
	private int numero;

	@Column(name = "COMPLEMENTO", nullable = false)
	private String complemento;

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
