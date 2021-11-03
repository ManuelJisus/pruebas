fun main() {

}

class Personas(var nombre: String = "", var edad: Int = 0, var sexo: String = "H") {
    var DNI: String
    var peso: Double
    var altura: Double

    init {
        DNI = ""
        altura = 0.0
        peso = 0.0


    }

    constructor(DNI: String, altura: Double, peso: Double, nombre: String, edad: Int, sexo: String) : this(
        nombre,
        edad,
        sexo
    ) {

        this.DNI = DNI
        this.peso = peso
        this.altura = altura
    }


}
