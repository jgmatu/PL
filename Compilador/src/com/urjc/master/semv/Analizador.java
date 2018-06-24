package com.urjc.master.semv;

import com.urjc.master.semv.cup.parser;

@SuppressWarnings("deprecation")
public class Analizador {

	private static boolean debug = false;
	
	public static void main(String argv[]) {
		if (argv.length == 0) {
			System.out.println("Inserta nombre de archivo\n" + "( Usage : java Analizador <inputfile> )");
			return;
		}
		for (int i = 0; i < argv.length; i++) {
			AnalizadorLexico lexico = null;

			try {
				lexico = new AnalizadorLexico(new java.io.FileReader(argv[i]));
				parser sintactico = new parser(lexico);
				sintactico.parse();
			} catch (java.io.FileNotFoundException e) {
				System.out.println("Archivo \"" + argv[i] + "\" no encontrado.");
			} catch (java.io.IOException e) {
				System.out.println("Error durante la lectura del" + " archivo \"" + argv[i] + "\".");
				e.printStackTrace();
			} catch (Exception e) {
				if (debug) {
					e.printStackTrace();
				}
			}
		}

	}
}
