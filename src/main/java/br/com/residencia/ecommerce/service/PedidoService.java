package br.com.residencia.ecommerce.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.ecommerce.dto.RelatorioItemPedidoDTO;
import br.com.residencia.ecommerce.dto.RelatorioPedidoDTO;
import br.com.residencia.ecommerce.entity.ItemPedido;
import br.com.residencia.ecommerce.entity.Pedido;
import br.com.residencia.ecommerce.repository.ItemPedidoRepository;
import br.com.residencia.ecommerce.repository.PedidoRepository;



@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	ItemPedidoService itemPedidoService;
	
	@Autowired
	EmailService emailService;
	
	public List<Pedido> getAllPedidos(){
		return pedidoRepository.findAll();
	}
	
	public Pedido getPedidoById(Integer id) {
		//return pedidoRepository.findById(id).orElse(null);
		return pedidoRepository.findById(id).get();
	}
	
	public Pedido savePedido(Pedido pedido) {
		emailService.sendEmail("g5serratec2022@gmail.com", "Teste de envio de email", "Pedido concluido.");
		return pedidoRepository.save(pedido);
	}
	
	
	public Pedido updatePedido(Pedido pedido, Integer id) {
		Pedido pedidoExistenteNoBanco = getPedidoById(id);

		
		if(pedidoExistenteNoBanco!= null) {
		pedidoExistenteNoBanco.setIdPedido(pedidoExistenteNoBanco.getIdPedido());
		pedidoExistenteNoBanco.setDataPedido(pedido.getDataPedido());
		pedidoExistenteNoBanco.setDataEntrega(pedido.getDataEntrega());
		pedidoExistenteNoBanco.setDataEnvio(pedido.getDataEnvio());
		pedidoExistenteNoBanco.setStatus(pedido.getStatus());
		pedidoExistenteNoBanco.setValorTotal(pedido.getValorTotal());
		pedidoExistenteNoBanco.setCliente(pedido.getCliente());
		}
		return pedidoRepository.save(pedidoExistenteNoBanco);	
		
	}
	
	public Pedido deletePedido(Integer id) {
		pedidoRepository.deleteById(id);
		return getPedidoById(id);
	}
	
	public Pedido toEntidadeRelatorio(RelatorioPedidoDTO relatorioPedidoDTO) {
		Pedido pedido = new Pedido();
		
		pedido.setIdPedido(relatorioPedidoDTO.getIdPedidoDTO());
		pedido.setDataPedido(relatorioPedidoDTO.getDatapedido());
		pedido.setValorTotal(relatorioPedidoDTO.getValorTotal());		
		
		return pedido;
	}
	
	public RelatorioPedidoDTO toDTORelatorio(Pedido pedido) {
		RelatorioPedidoDTO pedidoDTO = new RelatorioPedidoDTO();
			
		pedidoDTO.setIdPedidoDTO(pedido.getIdPedido());
		pedidoDTO.setDatapedido(pedido.getDataPedido());
		pedidoDTO.setValorTotal(pedido.getValorTotal());

		
		return pedidoDTO;
	}
	
	public List<RelatorioPedidoDTO> getAllPedido_ItemPedidoDTO(){
		List<Pedido> listaPedido = pedidoRepository.findAll();
		List<RelatorioPedidoDTO> listaPedidoDTO = new ArrayList<>();
		
		for(Pedido pedido : listaPedido) {
			pedido.setValorTotal(BigDecimal.ZERO);
			
			List<ItemPedido> listaItemPedido = new ArrayList<>();
			List<RelatorioItemPedidoDTO> listaItemPedidoDTO = new ArrayList<>();
			
			listaItemPedido = itemPedidoRepository.findByPedido(pedido);
			
			for(ItemPedido itemPedido : listaItemPedido) {
				Double valor = itemPedido.getQuantidade()*itemPedido.getProduto().getValorUnitario().doubleValue();
				pedido.setValorTotal(pedido.getValorTotal().add(BigDecimal.valueOf(valor)));
				RelatorioItemPedidoDTO itemPedidoDTO = itemPedidoService.toDTORelatorio(itemPedido);
				listaItemPedidoDTO.add(itemPedidoDTO);
			}
			RelatorioPedidoDTO pedidoDTO = toDTORelatorio(pedido);
			pedidoDTO.setListaItemPedidoDTO(listaItemPedidoDTO);
			listaPedidoDTO.add(pedidoDTO);
		}
		
		return listaPedidoDTO;
	}
}
