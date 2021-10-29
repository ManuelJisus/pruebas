fun main(args: Array<String>) {
    println("introduce la hora")
   var hora
try {
     hora = readLine()
    while (hora == null)
        println("hora incorrecta intro")
}
   
    var horaEntera = try {
        hora?.toInt() ?: 0
    } catch (_: Exception) {
        0
    }
      


    println("introduce los minutos")
    var minutos = readLine()
    var minutosEntera = try {
        minutos?.toInt() ?: 0
    } catch (_: Exception) {
        0
    }
    println("introduce los segundos")
    var segundos = readLine()
    var segundosEntera = try {
        segundos?.toInt() ?: 0
    } catch (_: Exception) {
        0
    }
    while (segundosEntera >= 60){
        segundosEntera -= 60
        minutosEntera += 1
    }
    while (minutosEntera>=60){
        minutosEntera -= 60
        horaEntera  += 1
    }
    if (minutosEntera == 0 && segundosEntera == 0) {
        var tiempo1 = Tiempo(horaEntera)
        println(tiempo1)
    }
    if (segundosEntera == 0) {
        var tiempo2 = Tiempo(horaEntera, minutosEntera)
        println(tiempo2)
    } else {
        var tiempo3 = Tiempo(horaEntera, minutosEntera, segundosEntera)
        println(tiempo3)
    }


}

class Tiempo(var hora: Int, var minutos: Int = 0, var segundos: Int = 0) {

    override fun toString(): String {
        return "$hora H , $minutos Min, $segundos Seg"
    }



}
