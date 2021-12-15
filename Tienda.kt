fun main() {

}

data class Tienda(val nombre: String, val clientes: List<Clientes>) {
    //4.2.1
    //Método para obtener un conjunto de todos los clientes.
    fun obtenerConjuntoDeClientes(): Set<Clientes> = clientes.toSet()

    //4.2.2
    //un conjunto de las ciudades de donde son los clientes, puedes hacer uso de map
    fun obtenerCiudadesDeClientes(): Set<Ciudad> = clientes.map { it.ciudad }.toSet()

    //Lista de los clientes que viven en una determinada ciudad determinada
    fun obtenerClientesPor(ciudad: Ciudad): List<Clientes> = clientes.filter { it.ciudad == ciudad }

    //4.2.3
    //Método que devuelve true si todos los clientes son de una determinada ciudad
    fun checkTodosClientesSonDe(ciudad: Ciudad): Boolean = clientes.all { it.ciudad == ciudad }

    //Método que devuelve true si al menos un cliente es de una determinada ciudad
    fun hayClientesDe(ciudad: Ciudad): Boolean = clientes.any { it.ciudad == ciudad }

    //Método que devuelve el número de cliente de una determinada ciudad
    fun cuentaClientesDe(ciudad: Ciudad): Int = clientes.count { it.ciudad == ciudad }

    //Método que devuelve un cliente que vive en una ciudad dada o nulo si no hay ninguno
    fun encuentraClienteDe(ciudad: Ciudad): Clientes? = clientes.find { it.ciudad == ciudad }

    //4.2.4
    //Implementa un método para que devuelva una lista de clientes, ordenadas descendientemente por el número de pedidos que ellos han realizado.
    fun Tienda.obtenerClientesOrdenadosPorPedidos(): List<Clientes> = clientes.sortedByDescending { it.pedidos.count() }

    //4.2.5
    //Implementa un método para que devuelva una lista de clientes que tiene más pedidos sin entregar que entregados
    fun obtenerClientesConPedidosSinEngregar(): Set<Clientes> =
        clientes.partition { it.pedidos.count { it.estaEntregado } < it.pedidos.count { !it.estaEntregado } }.second.toSet()
    //Los productos que fueron pedidos por al menos un cliente.
    fun Tienda.obtenerProductosPedidos(): Set<Producto> = clientes.flatMap { it.pedidos }.flatMap { it.productos }

}

data class Clientes(val nombre: String, val ciudad: Ciudad, val pedidos: List<Pedido>) {
    override fun toString() = "$nombre from ${ciudad.nombre}"

    //Los productos pedidos por un cliente, pudiendo usar flatmap
    fun obtenerProductosPedidos(): List<Producto> = pedidos.flatMap { it.productos }
}

data class Pedido(val productos: List<Producto>, val estaEntregado: Boolean)

data class Producto(val nombre: String, val precio: Double) {
    override fun toString() = "'$nombre' for $precio"
}

data class Ciudad(val nombre: String) {
    override fun toString() = nombre
}
