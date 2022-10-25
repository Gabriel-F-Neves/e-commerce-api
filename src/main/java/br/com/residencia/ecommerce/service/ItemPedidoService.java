package br.com.residencia.ecommerce.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.ecommerce.dto.RelatorioItemPedidoDTO;
import br.com.residencia.ecommerce.dto.RelatorioProdutoDTO;
import br.com.residencia.ecommerce.entity.ItemPedido;
import br.com.residencia.ecommerce.repository.ItemPedidoRepository;
import br.com.residencia.ecommerce.repository.PedidoRepository;
import br.com.residencia.ecommerce.repository.ProdutoRepository;

@Service
public class ItemPedidoService {
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<ItemPedido> getAllItemPedidos(){
		return itemPedidoRepository.findAll();
	}
	
	public ItemPedido getItemPedidoById(Integer id) {
		//return itemPedidoRepository.findById(id).orElse(null);
		return itemPedidoRepository.findById(id).get();
	}
	
	public ItemPedido saveItemPedido(ItemPedido itemPedido) {
		itemPedido.setPedido(pedidoRepository.findById(itemPedido.getPedido().getIdPedido()).orElse(null));
		itemPedido.setProduto (produtoRepository.findById(itemPedido.getProduto().getIdProduto()).orElse(null));
		
		return itemPedidoRepository.save(itemPedido);
	}
	
	
	public ItemPedido updateItemPedido(ItemPedido itemPedido, Integer id) {
		ItemPedido itemPedidoExistenteNoBanco = getItemPedidoById(id);
		
		
		if(itemPedidoExistenteNoBanco!= null) {
		itemPedidoExistenteNoBanco.setIdItemPedido(itemPedidoExistenteNoBanco.getIdItemPedido());
		itemPedidoExistenteNoBanco.setQuantidade(itemPedido.getQuantidade());
		itemPedidoExistenteNoBanco.setPrecoVenda(itemPedido.getPrecoVenda());
		itemPedidoExistenteNoBanco.setPercentualDesconto(itemPedido.getPercentualDesconto());
		itemPedidoExistenteNoBanco.setValorBruto(itemPedido.getValorBruto());
		itemPedidoExistenteNoBanco.setValorLiquido(itemPedido.getValorLiquido());
		//itemPedidoExistenteNoBanco.setPedido(itemItemPedido.getPedido());
		//itemPedidoExistenteNoBanco.setProduto(itemItemPedido.getProduto());
		}
		return itemPedidoRepository.save(itemPedidoExistenteNoBanco);	
		
	}
	
	public ItemPedido deleteItemPedido(Integer id) {
		itemPedidoRepository.deleteById(id);
		return getItemPedidoById(id);
	}
	
	public ItemPedido toEntidadeRelatorio(RelatorioItemPedidoDTO relatorioItemPedidoDTO) {
		ItemPedido itemPedido = new ItemPedido();
		
		itemPedido.setIdItemPedido(relatorioItemPedidoDTO.getIdItemPedido());
		itemPedido.setQuantidade(relatorioItemPedidoDTO.getQuantidade());
		itemPedido.setPrecoVenda(relatorioItemPedidoDTO.getPrecoVenda());
		itemPedido.setPercentualDesconto(relatorioItemPedidoDTO.getPercentualDesconto());	
		itemPedido.setValorBruto(relatorioItemPedidoDTO.getValorBruto());
		itemPedido.setValorLiquido(relatorioItemPedidoDTO.getValorLiquido());
		
		return itemPedido;
	}
	
	public RelatorioItemPedidoDTO toDTORelatorio(ItemPedido itemPedido) {
		RelatorioItemPedidoDTO itemPedidoDTO = new RelatorioItemPedidoDTO();
		RelatorioProdutoDTO produtoDTO = new RelatorioProdutoDTO();
			
		itemPedidoDTO.setIdItemPedido(itemPedido.getIdItemPedido());
		itemPedidoDTO.setQuantidade(itemPedido.getQuantidade());
		itemPedidoDTO.setPrecoVenda(itemPedido.getPrecoVenda());
		itemPedidoDTO.setPercentualDesconto(itemPedido.getPercentualDesconto());
		itemPedidoDTO.setValorBruto(itemPedido.getValorBruto());
		itemPedidoDTO.setValorLiquido(itemPedido.getValorLiquido());
		produtoDTO.setNomeProduto(itemPedido.getProduto().getNome());
		produtoDTO.setIdProduto(itemPedido.getProduto().getIdProduto());
		itemPedidoDTO.setProduto(produtoDTO);
		
		return itemPedidoDTO;
	}
}
