# Solução #

Onde antes era:

ANTLRInputStream input = new ANTLRInputStream(System.in);

Agora é:

ANTLRFileStream input = new ANTLRFileStream("./Modelo/Modelo");

Ainda a pasta Modelo deve estar no mesmo diretório que a dsl para funcionar. Ou seja, tenho que ter 3 arquivos juntos: dsl.jar , Modelo , antlr-3.0
