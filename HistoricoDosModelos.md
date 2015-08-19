**O Problema é que o comando doc.getContent retorna todo o conteúdo da página inclusive o que tiver dentro de {{velocity}} {{/velocity}}. Se não tiver na api algo que retorne tudo menos o velocity, posso criar um componente que faz um parser e remove tudo de velocity**

Criei duas páginas. Uma com o comdd que chama o plugin da dsl e que o usuário entra com o modelo. A outra para visualizar o codigo gerado pela dsl.

#Descrição: voce escreve um modelo e clica em visualizar codigo.
#Prós: merge, histórico
#Contras: mando todo o conteúdo da página pro componente, logo vai também tudo que está dentro de {{velocity}}

Este código vai na página do Comdd:

---

plataforma golfe
robo omega

{{velocity}}

#set($modelo=$doc.getContent())

#set ($saida = $services.dsl.executeDsl2($modelo))


{{html}}
> 

&lt;form action=CodigoGerado&gt;



> 

&lt;input type="hidden" name='codigoGerado' value="$!saida" /&gt;


> 

&lt;input type="submit" value="Ver codigo gerado" /&gt;

 <br />

> 

&lt;/form&gt;


{{/html}}


{{/velocity}}


Este código vai ná pagina CodigoGerado:

---


{{velocity}}

#set ($codigoGerado = $request.getParameter('codigoGerado') )

$!codigoGerado

{{/velocity}}



Com isso temos histórico e merge de modelos