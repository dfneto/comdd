package com.acme.internal;

import com.acme.Save;
import org.xwiki.component.annotation.Component;


import org.antlr.runtime.*;
import java.io.*;


@Component
public class DefaultSave implements Save {
   public String saveModelo(String modeloDaXwiki){
     try{
	System.out.println("@@ Iniciando ....");
	Auxiliar aux = new Auxiliar();
	aux.estabelecerConexaoComBanco();
	aux.escritaNoBanco(modeloDaXwiki);
	aux.encerrarConexao();

	return "Sucesso";

	}catch(Exception e){ return "Falhou :("; }
   }
}

