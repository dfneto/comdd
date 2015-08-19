# Introduction #

Para a dsl.jar acessar (ler e escrever) no banco da xwiki tenho duas opções: <br>
1- Acessando o banco diretamente; <br>
2- Através de uma api da xwiki.<br>
<br>
O passo 2 me exigiria um estudo desta api e provavelmente que eu transformasse minha dsl.jar em uma api da xwiki. Então optei pelo passo 1 que parece ser mais rápido. Assim, devo:<br>
<br>
1- Encontrar onde a xwiki armazena seus conteúdos criadas na página xwiki; <br>
2- Ler e escrever na tabela; <br>
3- Criar um programa com jdbc que acesse um banco qualquer; <br>
4- Fazer esse programa com jdbc acessar a tabela do banco da xwiki onde armazena os dados que desejo manipular; <br>
5- Inserir esse programa na minha dsl.jar; <br>
6- Deixar minha xwiki o mais simples possível.<br>
<br>
<h2>1.Encontrar onde a xwiki armazena seus conteúdos criadas na página xwiki</h2>
Comecei procurando o conteúdo com comandos em sql, mas tava muito difícil de encontrar, daí instalei o PgAdmin III (tinha tentando o PhpPostgreAdmin, mas precisava do apache então descartei essa opção).<br>
<br>
O William deu a dica de procurar pela estrutura da tabela, aquela que tiver o maior campo.<br>
<br>
Consegui encontrar onde a xwiki armazena minhas páginas criadas. É na tabela <b>xwikidoc</b>.<br>
<br>
<h2>2 Ler e escrever na tabela</h2>
Isso consegui facilmente usando o programa PgAdmin III<br>
<br>
<h2>3 Criar um programa com jdbc que acesse o banco da Xwiki</h2>

<b>3.1</b> Criar uma classe que acesse meu banco: <br>
<a href='http://www.mkyong.com/java/how-do-connect-to-postgresql-with-jdbc-driver-java/'>http://www.mkyong.com/java/how-do-connect-to-postgresql-with-jdbc-driver-java/</a> <br>
No terminal tenho que configurar o path: <br>
export CLASSPATH=$CLASSPATH:/home/david/JavaJDBC/postgresql-9.0-801.jdbc4.jar <br>
AcessoBanco.java lê (SELECT) e escreve (UPDATE) diretamente no banco exibindo no terminal.<br>
<br>
<b>3.2</b> Criar uma classe que leia do banco e escreva num txt:<br>
<br>
<b>3.3</b> Fazer a classe AcessoBancoEscritaTxt se comunicar com a minha dsl.jar:<br>
<br>
<b>3.4</b> AcessoBancoEscritaTxt deve virar: SelectBancoEscritaTxtUpdateBanco:<br>
<br>
Ou seja, preciso que a classe que se comunique com meu banco faça: <br>
<ol><li>Leia do banco (Modelo) -> Atividade da ClasseAuxiliar <br>
</li><li>Gere um txt com o Modelo lido -> Atividade da ClasseAuxiliar <br>
</li><li>Esse Modelo servirá de entrada para minha dsl.jar (TEST.java) que irá transformar em códigofonte.cpp -> Atividade da Classe Test <br>
</li><li>CódigoFonte.cpp deve ser inserido em uma tabela -> Atividade ClasseAuxiliar <br></li></ol>

Vamos chamar a classe Auxilar que irá ler do banco, gerar um txt e depois escrever no banco. E a classe Test é aquela que se comunica com a minha gramática MyDsl.g