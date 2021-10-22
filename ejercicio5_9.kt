fun main(args: Array<String>) {

}
class Cuenta (var numCuenta : String,var saldo : Double  )
{

    fun RecibirAbono( bono : Double , cuenta : String){

       this.saldo=this.saldo+bono
    }
    fun RealizarPago( pago : Double ){
        this.saldo=this.saldo-pago
    }
}
//class Persona (var dni : String,  val cuentasBancarias : Array<Cuenta> = Array<Cuenta>(3, {i ->  Cuenta(i.toString(),0.0)}))
class Persona (var dni : String,  val cuentasBancarias : EmptyList<St)
{

}

