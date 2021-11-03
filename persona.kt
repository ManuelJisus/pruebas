fun main() {

}
class Personas (   var nombre : String = "",   var edad: Int = 0,   var sexo: String = "H"){
    var DNI : String
    var peso : Int
    var altura : Int

    init {
        DNI = ""
        altura = 0
        peso = 0


    }
    constructor(DNI : String ): this(nombre, edad, sexo) {

    }


}
