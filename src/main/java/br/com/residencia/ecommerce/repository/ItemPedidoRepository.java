package br.com.residencia.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.ecommerce.entity.ItemPedido;
import br.com.residencia.ecommerce.entity.Pedido;

public interface ItemPedidoRepository extends  JpaRepository<ItemPedido,Integer> {
	public List<ItemPedido> findByPedido (Pedido pedido);
}
