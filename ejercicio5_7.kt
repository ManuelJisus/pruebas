fun main(args: Array<String>) {

    var coche1 = Coche("Morado", "BMW", "M3", 279, 4, "1209BMW")
    println(coche1)
    coche1.color = "Negro"
    println(coche1)
    var coche2 = Coche("Verde", "Aston Martin", "Veneno", 222, 5, "1234BHW")
    println(coche1)
    coche1.color = "Amarillo"
    println(coche1)
}

class Coche
    (
    var color: String,
    var marca: String,
    var modelo: String,
    var caballos: Int,
    var puertas: Int,
    var matricula: String
) {

    override fun toString(): String {
        return " color = $color, marca = $marca, modelo = $modelo, número de caballos = $caballos, puertas = $puertas, matricula = $matricula"

    }

}
