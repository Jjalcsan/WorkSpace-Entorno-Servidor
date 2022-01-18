package com.ejemplo.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.model.Usuario;

@Primary
@Service("serviceusuariodb")
public class ServiceUsuarioDB implements ServiceUsuario{

	@Override
	public boolean existeUsuario(String nick, String contra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Usuario> getAllUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getByNick(String nick) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPedido(Usuario usuario, Map<Producto, Integer> productos, String metodoEnvio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pedido> getAllPedidos(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido getPedidoById(int id, Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delPedido(Pedido pedido, Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

}
