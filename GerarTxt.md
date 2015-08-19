# Introduction #

Gerar o código num txt ao invés de no terminal


# Details #

## Descrição do Problema ##
O ideal é que minha dsl gere um txt com o código gerado, já no formato do código alvo. Por ex, que como saída da minha dsl tenha um CodigoGerado.cpp, ao invés de ter CodigoGerado apresentado no terminal.

## Solução Possível ##
Comecei então a estudar algumas formas de se escrever em arquivo, usando FileWriter do java. A versão [r42](https://code.google.com/p/comdd/source/detail?r=42) tem o código do FileWriter dentro do MyDsl.g, e embora esteja compilando e executando, não entra na parte referente ao FileWriter, ou seja, na classe Writer2. Para entender melhor como funciona as formas de se gerar um arquivo eu eu havia comecei a estudar o HeadFirstJava, pg 314.

## Solução Usada ##
O William deu um toque de usar >. Então percebi que usando

david@linux-labes:~/comdd/ANTLR\_Codigos/jar$ java -jar dsl.jar > teste

a saída do terminal ia toda para teste, de forma que fica do jeito que preciso. Assim, a princípio, essa solução é o suficiente para meu problema. Caso no futuro, quando eu estiver trabalhando com os detalhes da dsl eu perceba que a **Solução Usada** não está me satisfazendo, eu volto ao estudo da **Solução Possível**.