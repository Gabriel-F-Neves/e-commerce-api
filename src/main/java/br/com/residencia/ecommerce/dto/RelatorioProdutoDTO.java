package br.com.residencia.ecommerce.dto;



public class RelatorioProdutoDTO {
	private Integer idProduto;
	private String nomeProduto;
	
	public RelatorioProdutoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RelatorioProdutoDTO(Integer idProduto, String nomeProduto) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
}
