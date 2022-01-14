package com.ejemplo.demo.service;

import java.util.List;
import java.util.Map;

import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.model.Usuario;

public interface ServicePedido {

	public Map<Producto, Integer> getall();
	public List<Pedido>findPedidoUsuario(Usuario usuario);
	public void addProducto(Integer[] listaCantidades);
	public void editarPedido(int id, Integer[] listaCantidades, String metodoEnvio, Usuario usuario);
	
}
