# Como chamar minha DSl a partir da Xwiki #

## Como o sistema funciona: ##
  1. Insiro o modelo na xwiki
  1. Rodo o scrit de execução da dsl
  1. Restarto o servidor com a xwiki
  1. Vou até a página de código gerado

## Como o sistema deve funcionar ##
  1. Insiro o modelo na xwiki
  1. A partir da página que inseri o modelo devo chamar a dsl
  1. O servidor com a xwiki nao deve precisar ser restartado
  1. Há um link para a página com código gerado e outro link pra baixar o código

## Como fazer uma chamada a dsl? ##
  1. Usando servelets
  1. script em php -> solução indesejada
  1. Transformando minha dsl.jar em uma aplicação pra xwiki
  1. Usando webservices, stubs, triggers ...


## Andamento ##
Comecei estudando sobre servlets. Aí to gastando muito tempo estudando servlets e ainda acho que vou gastar mais um tempão criando um webservice. Talvez seja melhor transformar minha aplicação em uma app da xwiki. Porque assim eu nao tenho nem que criar um servlet e nem um webservice.

27/01/11
Acredito que posso introduzir toda minha aplicação java numa página JSP e com isso nao preciso nem de um servlet e nem de um webservice.

28/01/01
Nao estava conseguindo a partir do Servlet conectar ao banco. Daí bastava inserir o driver "postgresql-9.0-801.jdbc4" em: sftp://david@143.107.231.251/home/david/Xwiki/apache-tomcat-6.0.30/lib/

## Solução Aplicada ##
Usei um servlet simples pra fazer a dsl rodar. Necessário colocar os arquivos jar (driver do postgre e do antlr) na lib do apache. Seguir as instruções presentes na pasta "DSL na Wiki". Versão final:127