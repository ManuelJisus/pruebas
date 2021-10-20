fun main(args: Array<String>) {
    println("introduce la hora")
    var hora = readLine()
    if (hora)
    var horaEntera = try { hora?.toInt()?:0} catch (_:Exception){0}
    println("introduce los minutos")
    var minutos = readLine()
    var minutosEntera = try { minutos?.toInt()?:0} catch (_:Exception){0}
    println("introduce los segundos")
    var segundos = readLine()
    var segundosEntera = try { segundos?.toInt()?:0} catch (_:Exception){0}
    var tiempo1 = Tiempo(horaEntera)
    var tiempo2 = Tiempo(horaEntera, minutosEntera)
    var tiempo3 = Tiempo(horaEntera, minutosEntera, 8)



}
class Tiempo (var hora : Int, var minutos : Int = 0, var segundos : Int = 0)
{

    override fun toString(): String {
        return "$hora H , $minutos Min, $segundos Seg"
    }
}
