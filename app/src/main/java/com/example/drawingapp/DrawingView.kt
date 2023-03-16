package com.example.drawingapp

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class DrawingView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    // todas as variaveis nulas devem ser iniciadas para podermos usá-las
    //obejto da inner class CustomPath
    private var mDrawPath: CustomPath? = null

    //o que Bitmap faz? checar com crtl+B
    private var mCanvasBitmap: Bitmap? = null

    private var mDrawPaint: Paint? = null
    private var mCanvasPaint: Paint? = null

    private var mBrushSize: Float = 0.toFloat()
    private var color = Color.BLACK

    //
    private var canvas: Canvas? = null

    init {
        //chamar as variaveis ou criar um método para chamar todas, optamos pelo método
        setUpDrawing()
    }

    private fun setUpDrawing() {
        //chamar os objetos no método
        //mDrawPaint será nosso pincel?
        mDrawPaint = Paint()
        //color e mBrusSize são as únicas variáveis não nulas, por isso podemos chamar aqui diretamente
        mDrawPath = CustomPath(color, mBrushSize)
        //pelo fato de já termos chamado acima essa variável(mDrawPaint) sabemos que ela não está vazia, mas precisamos colocar !! para garantir que ela não estará nula
        //aqui defininimos que mDrawPaint receberá a cor
        mDrawPaint!!.color = color
        //aqui definimos que mDrawPaint receberá seu estilo, no caso é o STROKE que é uma linha, mas poderíamos escolher outro
        mDrawPaint!!.style = Paint.Style.STROKE
        //aqui definimos que o começo e o fim da linha do mDrawPaint terá formato arredondado
        mDrawPaint!!.strokeJoin = Paint.Join.ROUND
        //aqui definimos que a ponta da linha do mDrawPaint terá formato arredondado
        mDrawPaint!!.strokeCap = Paint.Cap.ROUND
        //mCanvasPaint será nossa tela de fundo? a tela onde vamos pintar?
        //ela terá uma flag (no caso a DITHER_FLAG) procurar sobre isso, no video informa que permite pintar em pontilhamento
        mCanvasPaint = Paint(Paint.DITHER_FLAG)
        //add o tamanho inicial/padrão do pincel
        mBrushSize = 20.toFloat()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        //aqui configuramos que a tela terá uma certa largura (w), altura (h) e terá acesso a uma certa quantidade de cores (definido pelo ARGB_8888)
        mCanvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        //então passamos nosso bitmap para o objeto canvas, como o bitmap está com valor nulo, temos que colocar !! para que o objeto canvas não aceite valor null
        canvas = Canvas(mCanvasBitmap!!)
    }

    //procurar sobre inner class
    internal inner class CustomPath(var color: Int, var brushThickness: Float) : Path() {

    }
}


// o play só aparece para funções chamadas main, que funciona como a mainactivity, se vc não tem ela
fun main() {
    // verifique nas abas inferiores a aba TO DO para ver o comentário da linha abaixo, é uma forma fácil de achar o que queremos
    // Vc pode definir o tipo da variável ou apenas dar um valor pra ela que o kotlin vai entender que tipo é.
    // Mas atenção: se vc escrever o valor sem seguir as regras o kotlin vai interpretar errado
    // (ex.: sempre coloque F no final do valor de um Float)
    //TODO: verify here all Variables, Datatypes, Operators

    //Variables
    varAndVal()

    //Datatypes
    numberTypes()
    booleanType()
    charAndStringType()

    //Operators
    arithmeticOperators() // são: +, - , * , / , %
    comparisonOperators() // são: == , != , < , > , <= , >=
    assignmentOperators() // são: += , -= , *= , /= , %=
    incrementAndDecrementOperators()  // são: ++ , --

    //Statements
    ifStatement()
    whenStatament()

}

fun varAndVal() {
    // VARIÁVEIS
    //Quero que o valor mude com o tempo
    //var = valor pode ser substituido, reassigned
    // var = mutable variable
    var yourName = "Keanu Reeves"
    yourName = "Pretty"
    println("VARIÁVEIS")
    println("Hello " + yourName)

    //Quero que o valor seja o mesmo sempre
    // val = valor não pode ser substituido, é sempre o inicialmente setado
    // val = immutable variable
    val hisName = "Rodrigo Hilbert"
    // então não é possível dar um novo valor para a variável como : hisName = "Pretty"
    println("Hello " + hisName)
}

fun numberTypes() {
    println("DATATYPES")

    // TIPOS NUMÉRICOS

    // Tipos INTEIROS (Integer Types)
    // Byte (8 bits), Short (16 bits), Int (32 bits), Long (64 bits)
    // teste colocar um numero a mais em cada linha e ele vai reclamar
    // Long geralmente são usados em coisas como numero de cartão de crédito, docs, etc
    // vc pode usar underscore _ no Long ou Int para tornar os números mais legíveis
    val nByte: Byte = 13
    val nShort: Short = 125
    val nInt: Int = 123123123
    val nLong: Long = 2_039_812_309_487_120_390

    // Tipos FLUTUANTES (Floating Point Types)
    // Float (32 bits), Double (64 bits)
    // 1- Para ter um Float coloque o F no final, senão o kotlin pensa que é um double,
    // ao setar como float vc economiza espaço de memória e garante um processamento mais rápido.
    // 2- verifique o tipo nFloatFalse, vc verá que é na verdade um Double, pq não tem o F no final
    // 3- tire o F do nFloat para ver o kotlin reclamar pois vc definiu como float, mas não colocou o F no final
    val nFloatFalse = 10.55
    val nFloatTrue = 10.55F
    val nFloat: Float = 10.55F
    val nDouble: Double = 3.112233445566778

    val name = "Otacílio Rocha"
    // type Int (aloca 32 bits de memória)
    var age = 51
    println("Eu sou " + name + " e tenho " + age + " anos")
}

fun booleanType() {

    // BOOLEAN TYPES representa valores lógicos TRUE ou FALSE (verdadeiro ou falso)

    var isSunny: Boolean = true
    isSunny = false

    var isRaining = false
    isRaining = true

    println("Está chovendo? Resposta: " + isSunny)

}

fun charAndStringType() {

    //CHARACTERES TYPE
    // Para termos um char ele deve ser cercado por apóstrofes ''
    // Porém um char só pode conter 1 caracter dentro dos apóstrofes (coloque mais de um e ele irá reclamar),
    // se vc deseja mais terá que usar o tipo String.

    // tipo letra -> é tipo Char quando a letra é cercada por apóstrofes e não aspas
    val letterChar = 'A'
    // tipo dígito -> é tipo Char quando o dígito é cercada por apóstrofes e não aspas
    val digitChar = '1'
    // qualquer símbolo ou outra caracter pode ser um char, desde que cercado por apóstrofes
    val symbolChar = '$'

    // STRING TYPE
    // É uma conexão feita com vários Char, que são cercados por aspas " "

    val name = "Maria"
    val priceString = "R$ 50,00"

    // para acessar cada letra ou caracter da string vc aponta que posição que ela ocupa
    // (que sempre começa a contar pela posição ZERO no Kotlin),
    // não se esqueça de contar a posição do espaço entre as palavras da String tb.
    val myString = "Hello World"
    val firstCharInMyString = myString[0]
    println("O primeiro caracter de Hello World é " + firstCharInMyString)

    // para acessar a última letra vc deve saber o quão longa (length) a string é (quantos caracteres ela tem)
    // e subtrair uma posição"
    val lastCharInMyString = myString[myString.length - 1]
    println("O último caracter de Hello World é " + lastCharInMyString)

    // STRING CONTATENATION
    // Concatenar uma String é juntar uma String à outra através da soma:
    val theName = "Otacílio Rocha"
    println("Eu sou " + theName)

    //STRING TEMPLATE ou STRING INTERPOLATION
    // se vc colocar o mouse sobrea linha 108 print acima,
    // irá aparecer a sugestão de tornar a concatenação em um template
    // o template insere a informação na String, substituindo "$" pela String desejada
    val anName = "Otacílio Rocha"
    println("Eu sou $anName")

    //vc pode setar a variável, ou um atributo da variável,
    // neste ultimo caso coloque a info entre {} para não dar erro,
    // assim o kotlin lê como uma única declaração
    val personName = "Rosa"
    println("Meu nome é $personName e ele tem ${personName.length} letras")

}

fun arithmeticOperators() {
    // OPERADORES ARITMÉTICOS
    // são: +, - , * , / , %
    println("OPERADORES")
    //abaixo: cria variável mutável e armazena nela o valor 8 (obtido pela soma 5+3)
    var result = 5 + 3
    // *= devem estar juntos, grudados para o kotlin entender
    // que queremos uma multiplicação por 2 do valor atual da variavel result,
    // ou seja, result *= 2 é o mesmo que result = result * 2
    // (aqui escrevemos o operador no formato de operador de atribuição)
    // aqui temos então 8*2 = 16
    result *= 2
    // aqui temos uma divisão 16/2 = 8
    result = result / 2
    //abaixo temos  8 - 2 = 6
    result -= 2
    //abaixo temos  6 + 3 = 9
    result += 3
    //abaixo conseguimos pegar o resto/sobra de uma divisão : 9/2 = 4  porém o resto é 9 - 8 = 1
    result = 9 % 2
    var a = 4
    var b = 2
    // o resto da divisão abaixo é zero, 4 - 4 = 0
    result = a % b
    a = 5
    b = 3
    // a divisão abaixo tem valor Um (1), pois as variaveis a e b são do tipo Int (inteiro)
    //  sendo assim o valor 5/3 = 1,6666 só ocorre se a e b fossem Floats ou Doubles
    result = a / b
    //abaixo vamos fazer o resultado com doubles:
    var c = 5.0
    var d = 3.0
    val resultDouble = c / d
    // agora, se quisermos usar as variáveis anteriores teremos que forçar o resultado ser Int
    // usando .toInt (pois a variável result é do tipo Int e só recebe valores Int)
    // note também que a e b aqui são de tipos diferentes, e por isso também não seria possível a divisão
    //retire o .toInt para ver esse erro
    c = 5.0
    b = 3
    result = (c / b).toInt()
    println("Resultado = " + result)
    println("Resultado com Double = " + resultDouble)
}

fun comparisonOperators() {
    // OPERADORES DE COMPARAÇÃO
    // são: == , != , < , > , <= , >=

    // o operador == compara uma variável a outra, se elas são iguais
    // Aqui funciona como uma pergunta: 5 é igual a 3?
    // Ele devolve um Boolean
    val isEqual = 5 == 3
    val anotherIsEqual = 5 == 5
    println("5 é igual a 3? Resposta: $isEqual")
    println("5 é igual a 5? Resposta: $anotherIsEqual")

    // o operador != compara uma variável a outra, se elas são diferentes
    // Aqui funciona como uma pergunta: 50 é diferente de 30?
    // Ele devolve um Boolean
    val isNotEqual = 50 != 30
    val anotherIsNotEqual = 50 != 50
    println("50 é diferente de 30? Resposta: $isNotEqual")
    println("50 é diferente de 50? Resposta: $anotherIsNotEqual")

    // operador < compara uma variável a outra, se a primeira é menor que a segunda
    // <  Lower/Lesser than
    // Ele devolve um Boolean
    println("5 é menor que 3? Resposta: ${5 < 3}")
    println("-5 é menor que 3? Resposta: ${-5 < 3}")

    // operador > compara uma variável a outra, se a primeira é maior que a segunda
    // >  Greater than
    // Ele devolve um Boolean
    println("5 é maior que 3? Resposta: ${5 > 3}")

    // operador <= compara uma variável a outra, se a primeira é menor ou igual que a segunda
    // <=  Lower/Lesser or iqual than
    // Ele devolve um Boolean
    println("5 é menor ou igual que 5? Resposta: ${5 <= 5}")
    println("-5 é menor que 5? Resposta: ${-5 <= 5}")

    // operador >= compara uma variável a outra, se a primeira é maior ou igual que a segunda
    // >=  Greater than or iqual than
    // Ele devolve um Boolean
    println("6 é maior ou igual que 5? Resposta: ${6 >= 5}")
    println("-5 é maior ou igual que -3? Resposta: ${-5 >= -3}")
}

fun assignmentOperators() {
    //OPERADORES DE ATRIBUIÇÃO
    // são: += , -= , *= , /= , %=
    // é uma forma mais curta de se escrever a expressão
    //da própria variável recebendo/guardando o valor calculado

    var myNumber = 5
    // aqui temos 5 + 5 = 10
    myNumber = myNumber + 5
    // aqui temos 10 + 5 = 15
    myNumber += 5
    // aqui temos 15 - 10 = 5
    myNumber -= 10
    // aqui temos 5 * 2 = 10
    myNumber *= 2
    // aqui temos 10 / 2 = 5
    myNumber /= 2
    // aqui temos o resto da divisão 5-4 = 2
    myNumber /= 4
    println("o valor de myNumber é $myNumber")

}

fun incrementAndDecrementOperators() {
    // OPERADORES DE INCREMENTO E DECREMENTO
    // são: ++ , --

    // o operador ++ precisa estar grudado à variável e adiciona o valor 1 à variável
    //porém se vc coloca em uma TEMPLATE de String, então ela pode fazer a adição antes ou depois da variável
    // no caso de adicão depois e dps vc chamar a variável dnv com adição antes, então ela acumula as somas e soma 2
    var myNumberInc = 8
    myNumberInc = myNumberInc + 1
    myNumberInc++
    println("o valor de myNumberInc com increase é $myNumberInc")
    println("o valor de myNumberInc com increase antes da variável é ${++myNumberInc}, pois a adição ocorre antes da variável")
    println("o valor de myNumberInc com increase depois da variável também é ${myNumberInc++}, pois a adição ocorre dps da variável")
    println("e se soma à próxima vez que vc chama a variável na linha de baixo")
    println("o valor de myNumberInc com increase antes da variável é ${++myNumberInc}, pois a adição ocorre também antes da variável")

    // o operador -- precisa estar grudado à variável e subtrai o valor 1 da variável
    //porém se vc coloca em uma TEMPLATE de String, então ela pode fazer a subtração antes ou depois da variável
    // no caso de subtração depois e dps vc chamar a variável dnv com subtração antes, então ela acumula as subtrações e subtrai 2
    var myNumberDec = 8
    myNumberDec = myNumberDec - 1
    myNumberDec--
    println("o valor de myNumberInc com decrease é $myNumberDec")
    println("o valor de myNumberInc com decrease antes da variável é ${--myNumberDec}, pois a subtração ocorre antes da variável")
    println("o valor de myNumberInc com decrease depois da variável também é ${myNumberDec--}, pois a subtração ocorre dps da variável")
    println("e se soma à próxima vez que vc chama a variável na linha de baixo")
    println("o valor de myNumberInc com decrease antes da variável é ${--myNumberDec}, pois a subtração ocorre também antes da variável")
}

fun ifStatement() {
    // INSTRUÇÕES IF
    //Statement If
    println("INSTRUÇÕES IF")

    // if funciona verificando sempre se a condição dentro dos seus parenteses é TRUE
    // se a condição for FALSE então ele desce para a próxima condição até chegar à ultima condição que é o else
    var isRaining = true
    if (isRaining) {
        println("Está chovendo")
    } else {
        println("Não está chovendo")
    }

    // temos duas crianças com diferentes altura em cm:
    var heightChild1 = 150
    var heightChild2 = 139

    //use if para verificar uma comparação entre variáveis
    // se a criança 1 for mais alta se que criança 2, printe a frase "A criança 1 é mais alta",
    // se for da mesma altura printe "As duas crianças tem a mesma altura"
    // senão, printe "A criança 1 é mais baixa"

    if (heightChild1 > heightChild2) {
        //se heightChild1 > heightChild2 for TRUE print a frase abaixo:
        println("A criança 1 é mais alta")
        // se for FALSE desça pra próxima condição
    } else if (heightChild1 == heightChild2) {
        //se heightChild1 == heightChild2 for TRUE print a frase abaixo:
        println("As duas crianças tem a mesma altura")
        // se for FALSE desça pra próxima condição
    } else {
        // se nenhuma das opções acima for TRUE, então print a frase abaixo:
        println("A criança 1 é mais baixa")
    }

    //vc pode usar as condições do if para comparar variáveis com valores diretos de datatypes e colocar essa análise numa variável
    // amusement park rides = brinquedos de parque de diversão
    // no IF cada condição dos if's são verificadas, se elas forem verdadeiras é feito o que aquele if pede,
    // se forem falsas ela avança até o próximo
    // para evitar if's encadeados use When, pois tantos if's afetam a performance
    if (heightChild1 <= 120) {
        //se a criança tiver altura igual ou menor que 120 cm ela só pode ir no carrosel
        println("A criança 1 só pode ir no Carrosel")
    } else if (heightChild1 <= 120) {
        println("A criança 1 pode ir no Brinquedo de Escalar")
    } else if (heightChild1 <= 140) {
        println("A criança 1 pode ir no Carrinho de Bate Bate")
    } else {
        println("A criança 1 pode ir na Montanha Russa")
    }


    var age = 35

    if (age >= 21) {
        // se a sua idade é maior ou igual a 21 anos vc pode:
        println("You may drink now in the US")
    } else if (age >= 18) {
        // se a sua idade é maior ou igual a 18 anos vc pode:
        println("You may vote now in the US")
    } else if (age >= 16) {
        // se a sua idade é maior ou igual a 16 anos vc pode:
        println("You may drive now in the US")
    } else {
        // se a sua idade não é maior que nenhuma das opções acima então:
        println("You are too young")
    }

    // vc tb pode usar if para comparar com strings:

    var name = "Denis"

    if (name == "Denis") {
        println("Welcome Denis")
    } else {
        println("Who are you?")
    }

}

fun whenStatament() {

    // o valor do when pode ser int ou string, etc
    //procure um valor

    var season = 3

    when (season) {
        1 -> println("Spring")
        2 -> println("Summer")
        3 -> {
            println("Fall")
            println("Autumn")
        }
        4 -> println("Winter")
        else -> println("Invalid season")
    }

    // ou procure uma faixa de valores, um range, usando o "in" e ".."

    var month = 3

    when (month) {
        in 3..5 -> println("Spring")
        in 6..8 -> println("Summer")
        in 9..11 -> println("Fall")
        12, 1, 2 -> println("Winter")
        else -> println("Invalid season")
    }

    // o exemplo acima no IF Statment de if encadeado, sem if, usando when

    var age = 17
    when (age) {
        in 21..150 -> println("You may drink now in the US")
        in 18..20 -> println("You may vote now in the US")
        16,17 -> println("You may drive now in the US")
        else -> println("You are too young")
    }

    // vc pode fazer o mesmo que acima mas excluindo o range que vc não quer usando a negação do in

    when (age) {
        //se a pessoa não está na faixa de 0 a 20 (ou seja, abaixo de 0 e acima de 20)
        !in 0..20 -> println("You may drink now in the US")
        in 18..20 -> println("You may vote now in the US")
        16,17 -> println("You may drive now in the US")
        else -> println("You are too young")
    }

    //Any é usado para qualquer tipo de valor, podendo ser string, int, double, boolean, etc
    // aqui podemos criar um programa pra saber qual é o tipo da variável
    var x: Any = 13.43

    when(x){
        is Int -> println("$x is an Int")
        is Double -> println("$x is a Double")
        is String -> println("$x is a String")
        else -> println("$x is none of the above")

    }


}



