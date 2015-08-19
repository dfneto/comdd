# Passo 1 #

Ver como dois servidores de xwiki inserem num mesmo banco de dados
Apache 1: /home/david/comdd/apache-tomcat-7.0.14/bin
Apache 2: /home/david/segunda isntancia/apache-tomcat-7.0.14/bin



Links:

http://platform.xwiki.org/xwiki/bin/view/AdminGuide/DistributedEventClusterSetup

http://www.guj.com.br/java/124206-2-instancias-do-servidor-tomcat-na-mesma-maquina

http://javafree.uol.com.br/topic-2236-Como-utilizar-2-tomcats.html


# Passo 2 #
Fazer um: autosave e refresh automatico, mas para isso tenho que saber como a xwiki salva uma página
A página está salvando

**Como fazer um refresh da pagina automatico num tempo pequeno?**

Escrevi um componente que salva no banco e um codigo que chama esse componente:

{{velocity}}

##$doc.setContent("sucessssssssssoo")


##$doc.save()


#set($modelo=$doc.getContent())  ##--> pega todo o conteudo da pagina

#set ($saida = $services.save.save2($modelo) )  ##--> esse componente salva na pagina TesteEdicaoSimultanea



{{/velocity}}

# Passo 3 #
Na raça: salvar no banco de dados com um servlet e um webservice

# Details #
Document - Classe
doc - variável