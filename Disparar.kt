open class ArmaDeFuego(
    var nombre : String,
    var municion : Int,
    var municionARestar : Int,
    var tipoDeMunicion : String,
    var danio : Int ,

) {


    open fun dispara(): Int {
        municion -= municionARestar
        return municion

    }

    open fun recarga(recarga: Int): Int {
        municion += recarga
        return municion
    }


}

class Pistola(nombre: String,municion: Int, municionARestar: Int, tipoDeMunicion: String, danio: Int ) : ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio ) {

    override fun dispara(): Int {

        municion -= (municionARestar * 1)
        return municion
    }

    override fun toString(): String {
        return "El arma a disparado y le quedan $municion balas"
    }
}

class Rifle(nombre: String,municion: Int, municionARestar: Int, tipoDeMunicion: String, danio: Int ) : ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio ){

    override fun dispara(): Int {
        municion -= (municionARestar * 2)
        return municion
    }

    override fun toString(): String {
        return "El arma a disparado y le quedan $municion balas"
    }
}

class Bazooka(nombre: String,municion: Int, municionARestar: Int, tipoDeMunicion: String, danio: Int) : ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio) {

    override fun dispara(): Int {
        municion -= (municionARestar * 3)
        return municion
    }


    override fun toString(): String {
        return "El arma a disparado y le quedan $municion balas"
    }
}

fun main() {
    var revolver = Pistola("Revolver", 20, 1,"explosiva",25,)
    var ak = Rifle("AK47", 35, 1,"punta hueca",15)
    var langostinazo = Bazooka("burbarof",6,1,"explosiva",50)
    revolver.dispara()
    ak.dispara()
    langostinazo.dispara()
    println(revolver)
    println(ak)
    println(langostinazo)

}
