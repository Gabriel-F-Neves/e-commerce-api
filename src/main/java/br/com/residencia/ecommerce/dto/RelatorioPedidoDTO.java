package br.com.residencia.ecommerce.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class RelatorioPedidoDTO {
	private Integer idPedidoDTO;
	private Instant datapedido;
	private BigDecimal valorTotal;
	private List<RelatorioItemPedidoDTO> listaItemPedidoDTO;
	
	public RelatorioPedidoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RelatorioPedidoDTO(Integer idPedidoDTO, Instant datapedido, BigDecimal valorTotal) {
		super();
		this.idPedidoDTO = idPedidoDTO;
		this.datapedido = datapedido;
		this.valorTotal = valorTotal;
	}

	public Integer getIdPedidoDTO() {
		return idPedidoDTO;
	}

	public void setIdPedidoDTO(Integer idPedidoDTO) {
		this.idPedidoDTO = idPedidoDTO;
	}

	public Instant getDatapedido() {
		return datapedido;
	}

	public void setDatapedido(Instant datapedido) {
		this.datapedido = datapedido;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<RelatorioItemPedidoDTO> getListaItemPedidoDTO() {
		return listaItemPedidoDTO;
	}

	public void setListaItemPedidoDTO(List<RelatorioItemPedidoDTO> listaItemPedidoDTO) {
		this.listaItemPedidoDTO = listaItemPedidoDTO;
	}
}
