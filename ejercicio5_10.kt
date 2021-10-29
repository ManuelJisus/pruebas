fun main() {
    var miConjunto = ConjuntoLibros()
    var miLibro1 = Libro("Harry Potter 1", "J.K.R", 145, 8)
    var miLibro2 = Libro("Crepusculo", "Stephenie Meyer", 250, 7)

    miConjunto.añadirLibro(miLibro1)
    println(miConjunto)
}

class Libro(
    var titulo: String,
    var autor: String,
    var numPag: Int,
    var calificacion: Int

) {

    fun modificarCalificacion(calificacion: Int) {
        this.calificacion = calificacion

    }

    override fun toString(): String {
        return "$titulo, $autor, $numPag, $calificacion"
    }
}


class ConjuntoLibros() {
    var libros: MutableList<Libro> = ArrayList(4)

    fun añadirLibro(valor: Libro) {
        libros.add(valor)
    }



    override fun toString(): String {
        return "${libros}"
    }


}
