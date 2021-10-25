fun main(args: Array<String>) {
    var persona1 = Persona("434332")
    var cuenta1 = Cuenta("22334543", 0.0)
    var cuenta2 = Cuenta("22748433", 700.0)
    persona1.Añadircuenta(cuenta1)
    persona1.Añadircuenta(cuenta2)
    cuenta1.RecibirAbono(1100.0)
    cuenta2.RealizarPago(750.0)
    cuenta1.Moroso()
    cuenta2.Moroso()
    println(cuenta2)
    println(cuenta1)
}

class Cuenta(var numCuenta: String, var saldo: Double) {

    fun RecibirAbono(bono: Double) {

        this.saldo = this.saldo + bono
    }

    fun RealizarPago(pago: Double) {
        this.saldo = this.saldo - pago
    }

    fun Moroso() {
        if (saldo < 0)
            println("El cliente es un moroso!!!")
    }

    override fun toString(): String {
        return "saldo = $saldo, numero de cuenta = $numCuenta"
    }
}

//class Persona (var dni : String,  val cuentasBancarias : Array<Cuenta> = Array<Cuenta>(3, {i ->  Cuenta(i.toString(),0.0)}))
class Persona(var dni: String) {
    /* var cuentasBancarias: MutableList<Cuenta> = ArrayList(3)
     fun Añadircuenta(valor: Cuenta) {
         cuentasBancarias.add(valor)
     }*/
    var cuentasBancarias = arrayOfNulls<Cuenta>(3)
    fun Añadircuenta(valor: Cuenta) {
        if (cuentasBancarias[0] == null) {
            cuentasBancarias[0] = valor
        } else {
            if (cuentasBancarias[1] == null) {
                cuentasBancarias[1] = valor
            } else {
                if (cuentasBancarias[2] == null) {
                    cuentasBancarias[2] = valor
                }
            }
        }
    }
}
