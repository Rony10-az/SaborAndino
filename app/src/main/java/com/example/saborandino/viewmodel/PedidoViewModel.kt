package com.example.saborandino.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.saborandino.data.model.ItemPedido
import com.example.saborandino.data.model.Plato

class PedidoViewModel : ViewModel() {

    private val _items = mutableStateListOf<ItemPedido>()
    val items: List<ItemPedido> = _items

    fun agregar(plato: Plato, cantidad: Int) {
        _items.add(ItemPedido(plato, cantidad))
    }

    fun total(): Double {
        return _items.sumOf { it.plato.precio * it.cantidad }
    }
}