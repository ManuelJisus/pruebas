fun main() {
    var modulo1 = Modulo(15)
    listOf(
        Alumno("01", "Manuel", "Ramirez", "Godoy"),
        Alumno("02","Jose Mari","Rodriguez","Perez")
    ).forEach{    modulo1.matricularAlumno(it)}


    println(modulo1.alumnos.toList())
}
class Modulo(var NumeroAlumnos: Int) {
    var alumnos = arrayOfNulls<Alumno>(NumeroAlumnos)
    var notasAlumnos = Array(4) { FloatArray(NumeroAlumnos) { -1.0F } }
    var alumnosMatriculados: Int = 0
    var evaluacion = 0
    companion object{
        const val EV_PRIMERA = "0"
        const val EV_SEGUNDA = "1"
        const val EV_TERCERA = "2"
        const val EV_FINAL = "3"
    }
    fun matricularAlumno(alumno: Alumno): Boolean {
//**
        if (alumnosMatriculados <= NumeroAlumnos) {
            var posicion = alumnos.indexOfFirst { it ==null }
            if (posicion != -1){
                // alumnos.set(posicion,alumno)
                alumnos [posicion]= alumno
                alumnosMatriculados ++
                return true
            }
        }
        return false
    }
    fun establecerNota(idAlumno:String, evaluacion:String, nota:Float): Boolean{
        if (evaluacion in Modulo.EV_PRIMERA..Modulo.EV_FINAL)
        {
            var posicion = alumnos.indexOfFirst { it?.ID == idAlumno }
            if (posicion != -1){
                // alumnos.set(posicion,alumno)
                notasAlumnos [evaluacion.toInt()] [posicion] = nota

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
        var EV3 =notasAlumnos[notasAlu][2]

        media = (EV1 + EV2 + EV3) / 3

        media = notasAlumnos[notasAlu][3]
    }
   fun numeroAprobados(evaluacion:String): Int{
       var aprobados=notasAlumnos [evaluacion.toInt()].count{it>=5}
       return aprobados
   }
    fun notaMasBaja(evaluacion:String): Float
}

data class Alumno(var ID: String, var nombre: String, var apellido1: String, var apellido2: String) {

}
