package br.com.residencia.ecommerce.dto;

import java.math.BigDecimal;

public class RelatorioItemPedidoDTO {
	private Integer idItemPedido;
	private Integer quantidade;
	private BigDecimal precoVenda;
	private Integer percentualDesconto;
	private BigDecimal valorBruto;	
	private BigDecimal valorLiquido;
	private RelatorioProdutoDTO produto;
	
	public RelatorioItemPedidoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RelatorioItemPedidoDTO(Integer idItemPedido, Integer quantidade, BigDecimal precoVenda,
			Integer percentualDesconto, BigDecimal valorBruto, BigDecimal valorLiquido) {
		super();
		this.idItemPedido = idItemPedido;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
		this.percentualDesconto = percentualDesconto;
		this.valorBruto = valorBruto;
		this.valorLiquido = valorLiquido;
	}

	public Integer getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Integer getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Integer percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public BigDecimal getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}

	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(BigDecimal valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public RelatorioProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(RelatorioProdutoDTO produto) {
		this.produto = produto;
	}
}
