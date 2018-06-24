package com.urjc.master.semv.includes;

import java.util.List;

import com.urjc.master.semv.AnalizadorLexico;
import com.urjc.master.semv.ambito.Ambito;
import com.urjc.master.semv.commands.Function;
import com.urjc.master.semv.cup.include;

@SuppressWarnings("deprecation")
public class Include {

	private File file;
	private boolean debug = false;
	
	public Include (File file) {
		this.file = file;
	}

	public void include(Ambito ambito) {
		AnalizadorLexico lexico = null;
				
		try {	
			lexico = new AnalizadorLexico(new java.io.FileReader(file.getName()));
			include sintactico = new include(lexico);
			sintactico.parse();

			List<Function> functions = sintactico.functions();
			for (Function function : functions) {
				ambito.insertar(function);
			}			
		} catch (java.io.FileNotFoundException e) {
			System.err.println("Archivo de cabecera \"" + file.getName() + "\" no encontrado." + System.getProperty("user.dir"));
		} catch (java.io.IOException e) {
			System.err.println("Error durante la lectura del" + " archivo de cabecerra \"" + file.getName() + "\".");
		} catch (Exception e) {
			if (debug) {
				e.printStackTrace();				
			}
		}
	}

}
