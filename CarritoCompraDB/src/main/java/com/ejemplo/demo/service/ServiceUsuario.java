package com.ejemplo.demo.service;

import java.util.List;
import java.util.Map;

import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.model.Usuario;

public interface ServiceUsuario {
	
	public boolean existeUsuario(String nick, String contra);
	public List<Usuario> getAllUsuarios();
	public Usuario getByNick(String nick);
	public void addPedido(Usuario usuario, Map<Producto, Integer> productos, String metodoEnvio);
	public List<Pedido> getAllPedidos(Usuario usuario);
	public Pedido getPedidoById(int id, Usuario usuario);
	public void delPedido(Pedido pedido, Usuario usuario);

}
