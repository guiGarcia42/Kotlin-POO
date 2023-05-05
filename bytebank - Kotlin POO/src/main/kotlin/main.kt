// função
fun main() {
    println("Bem vindo ao Bytebank")

    // instanciando o objeto conta
    val contaAlex = Conta(titular = "Alex", numero = 1000) // opcional
    contaAlex.deposita(200.0)

    val contaFran = Conta("Fran", 1001)
    contaFran.deposita(300.0)

    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    println("depositando na conta do Alex")
    contaAlex.deposita(50.0)
    println(contaAlex.saldo)

    println("sacando na conta do Alex")
    contaAlex.saca(250.00)
    println(contaAlex.saldo)

    println("Transferencia da conta da Fran para o Alex")
    if(contaFran.transfere(100.0, contaAlex)){
        println("transferencia sucedida")
    } else {
        println("Falha na transferencia")
    }

    println(contaAlex.saldo)
    println(contaFran.saldo)

}

// podemos criar classes em arquivos separados, mas podemos criar dentro de funçÕes tambem se quiser
// o problema é que só poderemos usar o objeto dentro da função determinada
class Conta(var titular: String, val numero: Int) {
    // adicionando os valores direto no cabeçalho da classe funciona como um construtor
    // Dessa forma tambem podemos adiciona-las como variáveis da classe (properties)

    var saldo = 0.0
        // cada variável se chama property no Kotlin, elas ja vem com getters e setters padrões,
        // para sobreescreve-los fazemos assim
        private set (valor) { //privando o set apenas a classe pode usa-lo para alterar o valor
            field = valor // field é o valor da variável
        }

    //função para reutilizar o metodo
    fun deposita(valor: Double) {
        if (valor > 0)
            saldo += valor
    }

    fun saca(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        } else {
            println("Saldo insuficiente")
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.saldo += valor
            return true
        }
        return false
    }

}

fun testaCopiasEReferencias() {

    //Isso é uma cópia
    val numeroX = 10
    var numeroY = numeroX
    numeroY++ // quando alteramos o numeroY apenas se altera ele mesmo tendo vindo do numeroX

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    // Como é um objeto isso não é uma cópia, é uma referencia e ambos estão apontando para o mesmo objeto
    val contaJoao = Conta("João", 1002)
    var contaMaria = contaJoao
    contaMaria.titular = "Maria" // quando alteramos estamos mudando lá no objeto portando muda os dois

    println("titular conta joao: ${contaJoao.titular}")
    println("titular conta maria: ${contaMaria.titular}")
}

fun testaLacos() {

    // padrão de for decrescente, o i começa no 5 e vai até 1
    //for (i in 5 downTo 1)
    // podemos usar o step para pular de 2 em 2 por exemplo:
    //for (i in 1..6 step 2)
    // padrão de for crescente, o i começa no valor 1 e vai até o 5
    for (i in 1..5) {

        if (i == 4) {
            break // podemos usar o break para parar o loop
            continue // podemos usar o continue para PULAR a repetição
        }

        //variável que não pode mudar seu valor após ser definido (equivalente a final em java)
        val titular = "Alex $i"
        //podemos assinar o tipo da variavel assim
        val numeroConta: Int = 1000 + i
        //variável que pode mudar o valor, o kotlin obriga que inicialize
        var saldo = i + 10.0

        // Concatenação de string com string template
        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        testaCondicoes(saldo)
        println()


    }
}

fun testaCondicoes(saldo: Double) { // utiliza o : Double para indicar o tipo da variavel

//    if (saldo > 0.0) {
//        println("conta é positiva")
//    } else if (saldo == 0.0) {
//        println("conta é neutra")
//    } else {
//        println("conta é negativa")
//    }
    // podemos realizar da mesma forma com o when, que da condições e se uma for verdadeira ele executa
    when {
        // pode escrever uma ou mais linhas, para isso só abrir as chaves { }
        saldo > 0.0 -> println("conta é positiva")
        saldo == 0.0 -> println("conta é neutra")
        else -> println("conta é negativa")
    }
}

