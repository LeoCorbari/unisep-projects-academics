package br.edu.unisep.model.vo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="objetos")
public class ObjetoVO {

	@Id
	@Column(name="id_objeto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="id_categoria")
	private CategoriaVO idCategoria;
	
	@Column(name="ds_login")
	private String login;
	
	@Column(name="ds_nome")
	private String nome;
	
	@Column(name="ds_objeto")
	private String objeto;
	
	@Column(name="vl_objeto")
	private Double valor;
	
	@Column(name="dt_cadastro")
	private LocalDate dataCadastro;
	
	@Column(name="tp_status")
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CategoriaVO getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(CategoriaVO idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObjeto() {
		return objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
		
}
