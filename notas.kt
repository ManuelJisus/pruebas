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
        const val ev_Segunda = "1"
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
        
    
}

 data class Alumno(var ID: String, var nombre: String, var apellido1: String, var apellido2: String) {

}
