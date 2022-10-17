package com.atos.atospet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ENDERECO")
public class Endereco  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@Id
	@SequenceGenerator(name = "enderecoSeq", sequenceName = "endereco_seq", initialValue = 1,allocationSize=1)
	@GeneratedValue(generator = "enderecoSeq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "rua")
	private String rua;
	@Column(name = "casa")
	private String casa;
	@Column(name = "cidade")
	private String cidade;
	
	@OneToOne
	@JoinColumn(name = "cod_cliente", referencedColumnName = "id")
	private Cliente cliente;
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCasa() {
		return casa;
	}
	public void setCasa(String casa) {
		this.casa = casa;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "{ id:"+ id
		+", rua:"+ rua
		+", casa:"+ casa
		+", cidade:"+ cidade+"}";
	}
	
}
