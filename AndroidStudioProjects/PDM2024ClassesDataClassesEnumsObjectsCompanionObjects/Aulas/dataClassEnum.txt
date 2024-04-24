fun main() {
    var uc = UnidadeCurricular(nome = "Programção para Dispositivos Móveis",
                              professor = "Mauricio",
                              semestre = 5,
                              formato = Formato.EAD)
    println(uc.toString())
    uc = uc.copy(//faz copia do obj
    	professor = "Mauricio Begnini")//altera somente o atibuto professor 
    println(uc.toString())
}
//Com o data class vc tem mais opções como utilizar toString() por exemplo
data class UnidadeCurricular( val professor: String, val semestre: Int = 1, val nome: String, val formato: Formato){

}

enum class Formato{
    Pratica, Teorica, EAD
}