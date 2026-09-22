package Projeto.Loja.Mapper;

import Projeto.Loja.DTO.ClienteResponse;
import Projeto.Loja.DTO.PedidoRequest;
import Projeto.Loja.DTO.PedidoResponse;
import Projeto.Loja.Entity.Cliente;
import Projeto.Loja.Entity.Pedido;
import Projeto.Loja.Entity.Produto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PedidoMapper {

    public Pedido toEntity(PedidoRequest request , Cliente cliente) {

        return Pedido.builder()
                .cliente(cliente)
                .status(request.status())
                .dataPedido(LocalDateTime.now())
                .build();
    }

    public PedidoResponse toResponse (Pedido pedido) {

        ClienteResponse cliente = new ClienteResponse(
                pedido.getCliente().getId(),
                pedido.getCliente().getNome(),
                pedido.getCliente().getEmail(),
                pedido.getCliente().getTelefone()
        );

        return new PedidoResponse(
                pedido.getId(),
                cliente,
                pedido.getDataPedido(),
                pedido.getStatus()
        );
    }

    public void updateEntity(PedidoRequest request, Pedido pedido, Cliente cliente) {

        pedido.setCliente(cliente);
        pedido.setStatus(request.status());
    }
}
