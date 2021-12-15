import kotlin.random.Random


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

        if (municion > 0)  municion -= (municionARestar * 1)

        return municion
    }

    override fun toString(): String {
        if (municion > 0) {
            return "El $nombre ha disparado y le quedan $municion balas"
        }
        else {
            return "El $nombre no ha disparado porque le quedan $municion balas"
        }
    }
}

class Rifle(nombre: String,municion: Int, municionARestar: Int, tipoDeMunicion: String, danio: Int ) : ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio ){

    override fun dispara(): Int {
        if (municion > 0)  municion -= (municionARestar * 2)

        return municion
    }

    override fun toString(): String {
        if (municion > 0) {
            return "El $nombre ha disparado y le quedan $municion balas"
        }
        else {
            return "El $nombre no ha disparado porque le quedan $municion balas"
        }
    }
}

class Bazooka(nombre: String,municion: Int, municionARestar: Int, tipoDeMunicion: String, danio: Int) : ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio) {

    override fun dispara(): Int {
        if (municion > 0)  municion -= (municionARestar * 3)

        return municion
    }


    override fun toString(): String {
        if (municion > 0) {
            return "El $nombre ha disparado y le quedan $municion balas"
        }
        else {
            return "El $nombre no ha disparado porque le quedan $municion balas"
        }
    }
}

fun main() {
    var revolver = Pistola("Revolver", 20, 1,"explosiva",25,)
    var ak = Rifle("AK47", 35, 1,"punta hueca",15)
    var langostinazo = Bazooka("burbarof",6,1,"explosiva",50)
    var cont = 1

    var armas = mutableListOf<ArmaDeFuego>(revolver, ak, langostinazo)
    var mapadearmas = mapOf(1 to armas.get((0..2).random()), 2 to armas.get((0..2).random()), 3 to armas.get((0..2).random()), 4 to armas.get((0..2).random()), 5 to armas.get((0..2).random()), 6 to armas.get((0..2).random()) )
    var valorDelDisparo = mapadearmas.get(cont)


    while (cont <= 6){
        mapadearmas.get(cont)?.dispara()
        println(mapadearmas.get(cont))
        cont += 1

    }
}
