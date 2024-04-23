fun main() {
    var uc = UnidadeCurricular(nome = "Programção para Dispositivos Móveis",
                              professor = "Mauricio",
                              semestre = 5)
    println("${uc.nome}, ${uc.professor}, ${uc.semestre}")
}

class UnidadeCurricular( val professor: String, val semestre: Int = 1, val nome: String ){

    
    init{/*é um recurso das classes em kotlin, que você pode utilizar para executar
           algum bloco de código antes de inicializar a classe.*/
        println("Crindo um obj de unidade curricular!")
    }
    /* Não precisa de construtor no Kotlin.
     fun UnidadeCurricular(nome: String){
        this.nome = nome
    }*/   
}