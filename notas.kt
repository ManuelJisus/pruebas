import kotlin.random.Random

fun main() {
    var modulo1 = Modulo(15)
    listOf(
        Alumno("1", "Manuel", "Ramirez", "Godoy"),
        Alumno("2", "Jose Mari", "Rodriguez", "Perez"),
        Alumno("3", "Ezequiel", "Elustondo", "Peperoni"),
        Alumno("4", "Furnildo", "Achanca", "Palmaz"),
        Alumno("5", "Esteban", "Co", "Negro"),
        Alumno("6", "Fujin", "Fustafa", "Formin"),
        Alumno("7", "Fulgencio", "Pastill", "Urrutia"),
        Alumno("8", "Pastran", "Bolivar", "Busil"),
        Alumno("9", "Lorsan", "Ruswll", "Nonander"),
        Alumno("10", "Petersan", "Puresa", "Gunsale")
    ).forEach { modulo1.matricularAlumno(it) }

    for (i in 0..modulo1.notasAlumnos[0].size - 1) {
        modulo1.establecerNota("$i", Modulo.EV_PRIMERA, Random.nextFloat() * 10.0f)

    }
    for (i in 0..modulo1.notasAlumnos[1].size - 1) {
        modulo1.establecerNota("$i", Modulo.EV_SEGUNDA, Random.nextFloat() * 10.0f)

    }
    for (i in 0..modulo1.notasAlumnos[2].size - 1) {
        modulo1.establecerNota("$i", Modulo.EV_TERCERA, Random.nextFloat() * 10.0f)

    }

    println(modulo1.listaNotas(Modulo.EV_PRIMERA))
    println(modulo1.listaNotas(Modulo.EV_SEGUNDA))
    println(modulo1.hayAlumnosAprobados(Modulo.EV_PRIMERA))
    println(modulo1.hayAlumnosAprobados(Modulo.EV_SEGUNDA))
    println("La nota mas alta es "+modulo1.notaMasAlta(Modulo.EV_PRIMERA))
    println("La nota mas baja es "+modulo1.notaMasBaja(Modulo.EV_PRIMERA))
    println("La nota media de la evaluacion es" + modulo1.notaMedia(Modulo.EV_PRIMERA))
    println("La nota media de la evaluacion es" + modulo1.notaMedia(Modulo.EV_SEGUNDA))


}

class Modulo(var NumeroAlumnos: Int) {
    var alumnos = arrayOfNulls<Alumno>(NumeroAlumnos)
    var notasAlumnos = Array(4) { FloatArray(NumeroAlumnos) { -1.0F } }
    var alumnosMatriculados: Int = 0
    var evaluacion = 0

    companion object {
        const val EV_PRIMERA = "0"
        const val EV_SEGUNDA = "1"
        const val EV_TERCERA = "2"
        const val EV_FINAL = "3"
    }

    fun matricularAlumno(alumno: Alumno): Boolean {
//**
        if (alumnosMatriculados <= NumeroAlumnos) {
            var posicion = alumnos.indexOfFirst { it == null }
            if (posicion != -1) {
                // alumnos.set(posicion,alumno)
                alumnos[posicion] = alumno
                alumnosMatriculados++
                return true
            }
        }
        return false
    }

    fun establecerNota(idAlumno: String, evaluacion: String, nota: Float): Boolean {
        if (evaluacion in Modulo.EV_PRIMERA..Modulo.EV_FINAL) {
            var posicion = alumnos.indexOfFirst { it?.ID == idAlumno }
            if (posicion != -1) {
                // alumnos.set(posicion,alumno)
                notasAlumnos[evaluacion.toInt()][posicion] = nota

                return true
            }
            return true
        }


        return false
    }

    fun calcularEvaluacionFinal(idAlumno: String) {
        var notasAlu = alumnos.indexOfFirst { it?.ID == idAlumno }
        var media = 0.0f
        var EV1 = notasAlumnos[notasAlu][0]
        var EV2 = notasAlumnos[notasAlu][1]
        var EV3 = notasAlumnos[notasAlu][2]

        media = (EV1 + EV2 + EV3) / 3
        notasAlumnos[3][notasAlu] = media

    }

    fun numeroAprobados(evaluacion: String = "3"): Int {
        var aprobados = notasAlumnos[evaluacion.toInt()].count { it >= 5 }
        return aprobados
    }

    fun notaMasBaja(evaluacion: String = "3"): Float? {
        var notamin = notasAlumnos[evaluacion.toInt()].filter { it >= 0f }.minByOrNull { it }
        return notamin
    }

    fun notaMasAlta(evaluacion: String = "3"): Float? {
        var notamax = notasAlumnos[evaluacion.toInt()].maxByOrNull { it }
        return notamax
    }

    fun notaMedia(evaluacion: String = "3"): Float {
        var notamedia = notasAlumnos[evaluacion.toInt()].average().toFloat()
        return notamedia
    }

    fun hayAlumnosConDiez(evaluacion: String = "3"): Boolean {
        var alu10 = notasAlumnos[evaluacion.toInt()].find { it >= 10.0F }
        if (alu10 == null) {
            return false
        }
        return true
    }

    fun hayAlumnosAprobados(evaluacion: String): Boolean {
        var aluapro = notasAlumnos[evaluacion.toInt()].find { it >= 5.0F }
        if (aluapro == null) {
            return false
        }
        return true
    }

    fun primeraNotaNoAprobada(evaluacion: String): Float? {
        var primsus = notasAlumnos[evaluacion.toInt()].find { it < 5 }?.toFloat()
        return primsus
    }

    fun listaNotas(evaluacion: String): Pair<List<Alumno?>, List<Float>> {

        var evaluacion = evaluacion.toInt()

        var pair = Pair(alumnos.filter { it != null }, notasAlumnos[evaluacion].filter { it != -1.0f })
        return pair
    }

    fun listaNotasOrdenados(evaluacion: String): Pair<List<Alumno?>, List<Float>> {

        var alumnos = alumnos.filter { it != null }
        var notas = notasAlumnos[evaluacion.toInt()].filter { it != -1.0f }.sorted()

        var lista = Pair(alumnos, notas)
        return lista
    }

}

data class Alumno(var ID: String, var nombre: String, var apellido1: String, var apellido2: String) {

}
