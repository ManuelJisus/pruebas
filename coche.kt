fun main(args: Array<String>) {
    var f1 = Coche2("Audi", "5434RRV", "A3", "rojo", 240, 5, 230, 90, 6, 100.0, 1.2)
    var f2 = Coche2("BMW", "3622JKL", "M·", "morado", 350, 4, 320, 70, 5, 100.0, 1.1)
    f1.encendercoche()
    f1.iniciarcoche()
    f1.acelerarcoche()
    f1.incrementaMarcha()
    f1.decrementaMarcha()
    f1.acelerarcoche()
    f1.frenar()
    f1.acelerarcoche()
    f2.acelerarcoche()
    f2.acelerarcoche()
    println(f1)
    f2.encendercoche()
    f2.iniciarcoche()
    f2.acelerarcoche()
    f2.incrementaMarcha()
    f2.decrementaMarcha()
    f2.acelerarcoche()
    f2.frenar()
    f2.acelerarcoche()
    f2.acelerarcoche()
    f2.acelerarcoche()
    f2.acelerarcoche()
    f2.acelerarcoche()
    println(f2)
    println("${Coche2.comparaCoches(f1,f2)}")


    1.rangeTo(10).forEach(f2.acelerarcoche)

}

class Coche2(marca: String) {
    var marca = ""
    var modelo: String = ""
    var velocidadMax = 0
    var color = "blank"
    var matricula = ""
    var puertas = 0
    var caballos = 0
    var tanque = 0
    var marchaActual = 0
    var gasolina = 0.0
    var incrementoMarcha =   1
    var decrementoMarcha =   1
    var velocidad = 0
    var variacionVelocidad = 5
    var factorGasto = 0.0
    var marchas = 0


    constructor(
        marca: String, matricula: String, modelo: String, color: String, velocidadMax: Int,
        puertas: Int, caballos: Int, tanque: Int, marchas: Int, gasolina: Double, factorgasto: Double
    ) : this(marca) {
        this.marca = marca
        this.modelo = modelo
        this.velocidadMax = velocidadMax
        this.color = color
        this.matricula = matricula
        this.puertas = puertas
        this.caballos = caballos
        this.tanque = tanque
        this.marchas = marchas
        this.gasolina = gasolina
        this.factorGasto = factorgasto
    }

    /* init {
         require(velocidadMax > 50 && velocidadMax < 250) { "La velocidad introducida no esta entre 50 y 250." }
         require(marca.trim().length > 0) { "Argumento nombre inválido." }
     }
 */
    var encendido: Boolean = false
    fun encendercoche(): Boolean {
        if (marchaActual == 0 && gasolina > 0 && encendido == false) {
            encendido = true

        }
        return encendido
    }

    fun apagarcoche() {
        encendido = false
        marchaActual = 0

    }

    fun iniciarcoche(): Int {
        if (encendido == true) {
            marchaActual = 1
            acelerarcoche()
        }
        return marchaActual
    }

    fun gasto(): Double {
        when (marchaActual) {
            1 -> gasolina = gasolina - 5 * factorGasto
            2 -> gasolina = gasolina - 4 * factorGasto
            3 -> gasolina = gasolina - 4 * factorGasto
            4 -> gasolina = gasolina - 5 * factorGasto
            5 -> gasolina = gasolina - 1 * factorGasto


        }
        return gasolina
    }

    fun acelerarcoche(): Double {

        
            velocidad = velocidad + variacionVelocidad
            gasto()
        try {
            gasolina>0
        }catch (e: NumberFormatException) { println(" enchufale la manguera perro")}
        
        try {
            velocidad<velocidadMax
        }catch (e: NumberFormatException) { println(" Has reventao el coche mamon!!!")}
        return gasolina
    }

    fun cambiaMarcha(marcha: Int): Int {
        if (marcha > 0 && marcha <= marchas) {
            marchaActual = marcha
        } else {
            println("no se puede cambiar de marcha pues no cumple los requesitos")
        }
        return marchaActual
    }

    fun incrementaMarcha() {
        marchaActual = marchaActual + incrementoMarcha
    }

    fun decrementaMarcha() {
        marchaActual = marchaActual - decrementoMarcha
    }

    fun frenar(): Int {

        if (velocidad > 0) {
            velocidad = velocidad - variacionVelocidad
        } else {
            println("el coche esta sin velocidad")
        }
        return velocidad
    }

    fun parar(): Boolean {

        while (velocidad > 0) {
            frenar()
        }
        marchaActual = 0
        return true
    }
    

    override fun toString(): String {
        return " LA GASOLINA ES $gasolina LA MARCHA ACTUAL ES $marchaActual la velocidad es $velocidad"
    }

    companion object {
        fun comparaCoches( f1 : Coche2, f2 : Coche2): Boolean {
            if (f1.velocidad > f2.velocidad){
                return true
            }
            return false
            try {
                f1.velocidad != f2.velocidad
            }catch (e: NumberFormatException) { false}
        }
    }
    
}
