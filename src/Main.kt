// Classe para representar um Aluno
data class Aluno(val nome: String, val email: String)

// Classe para representar um Conteúdo Educacional
data class ConteudoEducacional(val nome: String, val duracao: Int) // duração em horas

// Classe para representar uma Formação
class Formacao(val nome: String, val nivel: String, val conteudos: List<ConteudoEducacional>) {
    private val alunosMatriculados = mutableListOf<Aluno>()

    // Método para matricular um aluno
    fun matricular(aluno: Aluno) {
        if (!alunosMatriculados.contains(aluno)) {
            alunosMatriculados.add(aluno)
            println("Aluno, ${aluno.nome} matriculado com sucesso na formação $nome!")
        } else {
            println("Aluno, ${aluno.nome} já está matriculado na formação $nome.")
            println()
        }
    }

    // Método para listar alunos matriculados
    fun listarAlunos() {
        println("Alunos matriculados na formação $nome:")
        alunosMatriculados.forEach { println("- ${it.nome} (${it.email})") }
        val aluno3 = Aluno("Carlos Oliveira", "carlos@email.com")
    }

    // Método para calcular a duração total da formação
    fun duracaoTotal(): Int {
        return conteudos.sumOf { it.duracao }
    }

    // Método para exibir informações da formação
    fun exibirInformacoes() {
        println("""
            |----------------------------------------------------------------------------------------------------
            |Formação: $nome
            |Nível: $nivel
            |Duração Total: ${duracaoTotal()} horas
            |Conteúdos:
        """.trimMargin())
        conteudos.forEach { println("- ${it.nome} (${it.duracao}h)") }
        println()
    }
}

fun main() {
    // Criando conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 10)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 15)
    val conteudo3 = ConteudoEducacional("Desenvolvimento Android", 20)

    // Criando uma formação
    val formacaoKotlin = Formacao(
        "Desenvolvedor Kotlin Backend",
        "Intermediário",
        listOf(conteudo1, conteudo2, conteudo3)
    )

    // Exibindo informações da formação
    formacaoKotlin.exibirInformacoes()

    // Criando alunos
    val aluno1 = Aluno("João Silva", "joao@email.com")
    val aluno2 = Aluno("Maria Santos", "maria@email.com")

    // Matriculando alunos
    formacaoKotlin.matricular(aluno1)
    formacaoKotlin.matricular(aluno2)
    formacaoKotlin.matricular(aluno1) // Tentativa de matrícula duplicada

    // Listando alunos matriculados
    formacaoKotlin.listarAlunos()
}